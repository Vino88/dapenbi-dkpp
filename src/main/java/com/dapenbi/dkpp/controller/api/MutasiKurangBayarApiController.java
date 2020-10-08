package com.dapenbi.dkpp.controller.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dapenbi.dkpp.dao.SetupParameterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MutasiKurangBayarDao;
import com.dapenbi.dkpp.dao.MutasiKurangBayarDetailDao;
import com.dapenbi.dkpp.dto.KurangBayarDetailDto;
import com.dapenbi.dkpp.dto.KurangBayarDto;
import com.dapenbi.dkpp.model.KurangBayar;
import com.dapenbi.dkpp.model.KurangBayarDetail;
import com.dapenbi.dkpp.util.ResponseUtil;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_KURANG_BAYAR)
public class MutasiKurangBayarApiController {

	@Autowired
	MutasiKurangBayarDao kurangBayarDao;
	
	@Autowired
    MutasiKurangBayarDetailDao kurangBayarDetailDao;

	@Autowired
	SetupParameterDao setupParameterDao;

	@GetMapping
	public Page<KurangBayarDto> index(Pageable pageRequest,
			@RequestParam(name = "searchParam", required = false) String searchParam) {
		String periode = setupParameterDao.findByBukaPeriode().getPeriode();
		//Page<KurangBayar> uIt = (Page<KurangBayar>) kurangBayarDao.findAll(new String[] { "nip","periodeMutasi","namaPeserta","namaPesertaMP","saldoAkhirKurangBayar" }, "%" + searchParam + "%", pageRequest);
		Page<KurangBayar> uIt = kurangBayarDao.findAllByPeriodeMutasi(periode, pageRequest);
		Page<KurangBayarDto> result = uIt.map(u -> {
			KurangBayarDto dto = u.toDto();
            if (u.getKantorBayar() != null) dto.setKantorBayar(u.getKantorBayar().toDto());
            if (u.getKategoriPenerima() != null) dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            //if (u.getKurangBayarDetail() != null) dto.setKurangBayarDetail(u.getKurangBayarDetail().toDto());
            return dto;
        });
		
		return result;
		
	}
	
	@GetMapping
    @RequestMapping(value="/search", produces="application/json")
    public ResponseEntity<ResponseUtil> lihatDetail(Pageable pageRequest, @RequestParam(name = "nip", required = false) String nip, @RequestParam(name = "periode", required = false) String periode) {
		Iterable<KurangBayarDetail> uIt = kurangBayarDetailDao.findByNipAndPeriode(nip, periode);

		List<KurangBayarDetailDto> data = new ArrayList<KurangBayarDetailDto>();
		for (Iterator iterator = uIt.iterator(); iterator.hasNext();) {
			KurangBayarDetail entity = (KurangBayarDetail) iterator.next();
			KurangBayarDetailDto detail = entity.toDto();
			detail.setKantorBayar(entity.getKantorBayar().toDto());
			detail.setKategoriPenerima(entity.getKategoriPenerima().toDto());
			detail.setKategoriCatatan(entity.getKategoriCatatan().toDto());
			detail.setMutasiPensiun(entity.getMutasi().toDto());
			data.add(detail);
		}
		
		ResponseUtil response = null;
		if(data != null && data.size() > 0) {
			response = new ResponseUtil(true, data, "Data ditemukan");
		}else {
			response = new ResponseUtil(false, "Data tidak ditemukan");
		}
		
		return new ResponseEntity<ResponseUtil>(response, HttpStatus.OK);
    }
}
