package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MutasiLebihBayarDao;
import com.dapenbi.dkpp.dao.MutasiLebihBayarDetailDao;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.MutasiLebihBayarFormDto;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.KurangBayarDetailDto;
import com.dapenbi.dkpp.dto.KurangBayarDto;
import com.dapenbi.dkpp.dto.LebihBayarDto;
import com.dapenbi.dkpp.model.KurangBayar;
import com.dapenbi.dkpp.model.KurangBayarDetail;
import com.dapenbi.dkpp.model.LebihBayar;
import com.dapenbi.dkpp.model.LebihBayarDetail;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import com.dapenbi.dkpp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_LEBIH_BAYAR)
public class MutasiLebihBayarApiController {

    @Autowired
    MutasiLebihBayarDao lebihBayarDao;

    @Autowired
    private SetupParameterDao setupParameterDao;

    @Autowired
    MutasiLebihBayarDetailDao lebihBayarDetailDao;

    @GetMapping
    public Page<LebihBayarDto> index(Pageable pageRequest,@RequestParam(name = "searchParam", required = false) String searchParam) {

        String periode = setupParameterDao.findByBukaPeriode().getPeriode();
        Page<LebihBayar> uIt = lebihBayarDao.findAllByPeriodeMutasi(periode, pageRequest);
//        Page<LebihBayar> uIt = (Page<LebihBayar>) lebihBayarDao.findAll(new String[]{"nip"},"%"+ searchParam +"%",pageRequest);
        Page<LebihBayarDto> result = uIt.map(u -> {
            LebihBayarDto dto = u.toDto();
            if (u.getKantorBayar() != null) dto.setKantorBayar(u.getKantorBayar().toDto());
            if (u.getKategoriPenerima() != null) dto.setKategoriPenerima(u.getKategoriPenerima().toDto());
            if (u.getKategoriCatatan() != null) dto.setKategoriCatatan(u.getKategoriCatatan().toDto());
            if (u.getStatusValidasi() != null) dto.setStatusValidasi(u.getStatusValidasi().toDto());
            return dto;
        });

        return result;

    }

    @GetMapping
    @RequestMapping(value = "/search", produces = "application/json")
    public ResponseEntity<ResponseUtil> detailLebihBayar(Pageable pagerequest, @RequestParam(name = "nip", required = false) String nip, @RequestParam(name = "periode", required = false) String periode){
        Iterable<LebihBayarDetail> uIt = lebihBayarDetailDao.findByNipAndPeriode(nip, periode);

        List<LebihBayarDetailDto> data = new ArrayList<>();
        for (Iterator iterator = uIt.iterator(); iterator.hasNext();){
            LebihBayarDetail entity = (LebihBayarDetail) iterator.next();
            LebihBayarDetailDto detail = entity.toDto();
            detail.setKantorBayar(entity.getKantorBayar().toDto());
            detail.setKategoriPenerima(entity.getKategoriPenerima().toDto());
            detail.setKategoriCatatan(entity.getKategoriCatatan().toDto());
            detail.setStatusValidasi(entity.getStatusValidasi().toDto());
            detail.setMutasi(entity.getMutasi().toDto());
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

    @PutMapping
    public ResponseEntity<MessageUtil>processupdate(@ModelAttribute MutasiLebihBayarFormDto formDto){

        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        Map result = lebihBayarDao.processMutasiLebihBayar(role.getId()
                ,formDto.getCompName()
                ,formDto.getUserName()
                ,formDto.getNip()
                ,formDto.getPeriodeLebihBayar()
                ,formDto.getLebihBayarMp()
                ,formDto.getJenisPengembalian()
                ,formDto.getJenisAngsuran()
                ,formDto.getTenor()
                ,(formDto.getNominalAngsuran() == null)?0:Double.valueOf(formDto.getNominalAngsuran())
                ,formDto.getPeriodeMulaiBayar()
                ,formDto.getIdKategoriCatatan()
                ,formDto.getKeterangan()
                ,formDto.getIdValidasi()
                ,formDto.getNamaValidasi());

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }



}
