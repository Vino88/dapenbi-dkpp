package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.PembayaranMpDao;
import com.dapenbi.dkpp.dao.PembayaranMpDetailMpsDao;
import com.dapenbi.dkpp.dto.PembayaranMpDetailMpsDto;
import com.dapenbi.dkpp.dto.PembayaranMpDto;
import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PEMBAYARAN_MPS_BULANAN_DETAIL)
public class PembayaranMpDetailMpApiController {

    PembayaranMpDao pembayaranMpDao;
    PembayaranMpDetailMpsDao pembayaranMpDetailMpsDao;

    @Autowired
    public PembayaranMpDetailMpApiController(PembayaranMpDao pembayaranMpDao, PembayaranMpDetailMpsDao pembayaranMpDetailMpsDao){
        this.pembayaranMpDao = pembayaranMpDao;
        this.pembayaranMpDetailMpsDao = pembayaranMpDetailMpsDao;
    }

//    @GetMapping("/{idPembayaran}")
//    public Page<PembayaranMpDetailMpsDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam,@PathVariable String idPembayaran) {
//        PembayaranMp pembayaranMp = pembayaranMpDao.findById(Long.valueOf(idPembayaran));
//        Page<PembayaranMpDetailMps> uIt = (Page<PembayaranMpDetailMps>) pembayaranMpDetailMpsDao.findAllByIdPembayaran(new String[] {"nip","namaPeserta"}, "%" + searchParam + "%", pageRequest,pembayaranMp);
//        Page<PembayaranMpDetailMpsDto> result = uIt.map(u -> {
//            PembayaranMpDetailMpsDto dto = u.toDto();
//            return dto;
//        });
//
//        return result;
//    }
    @GetMapping("/{idPembayaran}")
        public Page<PembayaranMpDetailMpsDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam,@PathVariable Long idPembayaran) {
            PembayaranMp pembayaranMp = pembayaranMpDao.findById(Long.valueOf(idPembayaran));
            Page<PembayaranMpDetailMps> uIt = (Page<PembayaranMpDetailMps>) pembayaranMpDetailMpsDao.findAllByIdPembayaranWithSearch(idPembayaran,"%" + searchParam + "%", pageRequest);
            Page<PembayaranMpDetailMpsDto> result = uIt.map(u -> {
                PembayaranMpDetailMpsDto dto = u.toDto();
                if (u.getIdPembayaran() !=null) dto.setIdPembayaran(u.getIdPembayaran().toDto());
                if (u.getIdKantorBayar() !=null) dto.setIdKantorBayar(u.getIdKantorBayar().toDto());
                if (u.getIdKategoriPensiun() !=null) dto.setIdKategoriPensiun(u.getIdKategoriPensiun().toDto());
                if (u.getIdJenisMps() !=null) dto.setIdJenisMps(u.getIdJenisMps().toDto());
                if (u.getIdFaktorFpr() !=null) dto.setIdFaktorFpr(u.getIdFaktorFpr().toDto());
                if (u.getIdFaktorFs() !=null){ dto.setIdFaktorFs(u.getIdFaktorFs().toDto());}else {dto.setIdFaktorFs(null);}
                if (u.getIdGolongan() !=  null) dto.setIdGolongan(u.getIdGolongan().toDto());
                if (u.getIdKategoriPenerimaMp() !=null) dto.setIdKategoriPenerimaMp(u.getIdKategoriPenerimaMp().toDto());
                if (u.getIdStatusBayar() !=null) dto.setIdStatusBayar(u.getIdStatusBayar().toDto());
                if (u.getIdUsiaBayar() != null) dto.setIdUsiaBayar(u.getIdUsiaBayar().toDto());
                if (u.getIdSuskel() !=null) dto.setIdSuskel(u.getIdSuskel().toDto());

                return dto;
            });

            return result;
        }

}
