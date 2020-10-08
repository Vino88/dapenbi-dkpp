package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.dao.ViewModel.MutasiOtomatis25MP80ViewModelDao;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiOtomatis25MP80ViewModelDto;
import com.dapenbi.dkpp.form.CuspMutasiOtomAnak25MP80FormDto;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25MP80ViewModel;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class MutasiPenerimaAnakTab1ApiController extends MutasiPenerimaAnakApiController {
    private MutasiOtomatis25MP80ViewModelDao mutasiOtomatis25MP80ViewModelDao;

    @Autowired
    public MutasiPenerimaAnakTab1ApiController(MutasiOtomatis25MP80ViewModelDao mutasiOtomatis25MP80ViewModelDao){
        this.mutasiOtomatis25MP80ViewModelDao = mutasiOtomatis25MP80ViewModelDao;
    }

    @GetMapping("/list-mutasi-otomatis-25mp80")
    public Page<MutasiOtomatis25MP80ViewModelDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiOtomatis25MP80ViewModel> uIt = (Page<MutasiOtomatis25MP80ViewModel>) mutasiOtomatis25MP80ViewModelDao.findAll(new String[]{"periodeMutasi", "namaKategoriMutasi"},"%" + searchParam + "%", pageRequest);
        Page<MutasiOtomatis25MP80ViewModelDto> result = uIt.map(u -> {
            MutasiOtomatis25MP80ViewModelDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @PostMapping("/data-mutasi-otomatis-25mp80")
    public ResponseEntity<MessageUtil> addMutasiOtomatis25MP80(@ModelAttribute CuspMutasiOtomAnak25MP80FormDto dto) {
        dto.setParTglMutasi(new Date());
        dto.setCompName(DkppUserStamp.getCompName());
        dto.setUserName(DkppUserStamp.getUserName());
        Map result = this.mutasiOtomatis25MP80ViewModelDao.processMutasiOtomatis25MP80(dto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", dto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), dto);
            httpStatus = HttpStatus.CONFLICT;
        }

        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }
}
