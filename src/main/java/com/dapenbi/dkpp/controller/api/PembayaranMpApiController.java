package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.PembayaranMpDao;
import com.dapenbi.dkpp.dao.PembayaranMpDetailMpDao;
import com.dapenbi.dkpp.dto.PembayaranMpDetailMpDto;
import com.dapenbi.dkpp.dto.PembayaranMpDto;
import com.dapenbi.dkpp.form.CuspPembayaranPlainDto;
import com.dapenbi.dkpp.form.CuspPembayaranSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranSendToPtrPlainDto;
import com.dapenbi.dkpp.form.CuspPembayaranSendToPtrSPDto;
import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMp;
import com.dapenbi.dkpp.repository.PembayaranMpDetailMpRepository;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PEMBAYARAN_MP_BULANAN)
public class PembayaranMpApiController {

    PembayaranMpDao pembayaranMpDao;
    PembayaranMpDetailMpDao pembayaranMpDetailMpDao;

    @Autowired
    public PembayaranMpApiController(PembayaranMpDao pembayaranMpDao, PembayaranMpDetailMpDao pembayaranMpDetailMpDao){
        this.pembayaranMpDao = pembayaranMpDao;
        this.pembayaranMpDetailMpDao = pembayaranMpDetailMpDao;
    }

    @GetMapping
    public Page<PembayaranMpDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<PembayaranMp> uIt = (Page<PembayaranMp>) pembayaranMpDao.findAll(new String[] {"periodePembayaran"}, "%" + searchParam + "%", pageRequest);

        Page<PembayaranMpDto> pembayaranMpDto = uIt.map(u -> {
            PembayaranMpDto dto = u.toDto();

            return dto;
        });

        return pembayaranMpDto;
    }

    @GetMapping("/detail/{idPembayaran}")
    public Page<PembayaranMpDetailMpDto>indexDetailMp(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam, @PathVariable Long idPembayaran){
        PembayaranMp pembayaranMp = pembayaranMpDao.findById(Long.valueOf(idPembayaran));
        Page<PembayaranMpDetailMp> uIt = (Page<PembayaranMpDetailMp>) pembayaranMpDetailMpDao.findAllByIdPembayaranSearch(idPembayaran,"%" + searchParam + "%",pageRequest);
        Page<PembayaranMpDetailMpDto> result = uIt.map(u->{
            PembayaranMpDetailMpDto dto = u.toDto();
            if (u.getIdKantorBayar() !=null) dto.setIdKantorBayar(u.getIdKantorBayar().toDto());
            if (u.getIdPembayaran() !=null) dto.setIdPembayaran(u.getIdPembayaran().toDto());
            if (u.getIdKategoriPensiun() !=null) dto.setIdKategoriPensiun(u.getIdKategoriPensiun().toDto());
            if (u.getIdGolongan()!= null) dto.setIdGolongan(u.getIdGolongan().toDto());
            if (u.getIdUsiaBayar() != null) dto.setIdUsiaBayar(u.getIdUsiaBayar().toDto());
            if (u.getIdStatusBayar() !=null) dto.setIdStatusBayar(u.getIdStatusBayar().toDto());
            if (u.getNamaKategoriPenerimaMp() != null) dto.setIdKategoriPenerimaMp(u.getIdKategoriPenerimaMp().toDto());
            if (u.getIdSuskel() != null) dto.setIdSuskel(u.getIdSuskel().toDto());
            if (u.getIdFaktorFpr() != null) dto.setIdFaktorFpr(u.getIdFaktorFpr().toDto());
            if (u.getIdFaktorFs() !=null) dto.setIdFaktorFs(u.getIdFaktorFs().toDto());
            return dto;
        });
        return result;
    }

    @PostMapping("/sp-pembayaran")
    public ResponseEntity<MessageUtil>spPembayaran(@ModelAttribute CuspPembayaranPlainDto plainDto){
        CuspPembayaranSPDto spDto = new CuspPembayaranSPDto();
        spDto.fromPlainText(plainDto);
        Map result = pembayaranMpDao.processCuspPembayaran(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")||result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }


    @PostMapping("/send-to-ptr")
    public ResponseEntity<MessageUtil>spSendPtr(@ModelAttribute CuspPembayaranSendToPtrPlainDto plainDto){
        CuspPembayaranSendToPtrSPDto spDto = new CuspPembayaranSendToPtrSPDto();
        spDto.fromPlainText(plainDto);
        Map result = pembayaranMpDao.processCuspPembayaranSentToPtr(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1") || result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }


}
