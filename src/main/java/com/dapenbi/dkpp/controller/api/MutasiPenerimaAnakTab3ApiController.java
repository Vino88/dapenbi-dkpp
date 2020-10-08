package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.dao.MutasiPenerimaAnakTab3Dao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiOtomatisBulan13ViewDto;
import com.dapenbi.dkpp.form.MutasiOtomatisAnakBulan13FormDto;
import com.dapenbi.dkpp.form.MutasiOtomatisAnakBulan13PlainTextFormDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatisBulan13ViewModel;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MutasiPenerimaAnakTab3ApiController extends MutasiPenerimaAnakApiController {

    @Autowired
    MutasiPenerimaAnakTab3Dao mutasiPenerimaAnakTab3Dao;

    @GetMapping("/data-mutasi-otomatis-janda-duda-anak-bulan-13")
    public Page<MutasiOtomatisBulan13ViewDto> gridTab3(Pageable pageRequest, @RequestParam(name = "searchParam",required = false)String searchParam){

        Page<MutasiOtomatisBulan13ViewModel> uIt = (Page<MutasiOtomatisBulan13ViewModel>) mutasiPenerimaAnakTab3Dao.findAll(new String[]{"nip"},"%"+ searchParam +"%", pageRequest);
        Page<MutasiOtomatisBulan13ViewDto> result = uIt.map(u -> {
            MutasiOtomatisBulan13ViewDto dto = u.toDto();
            return dto;
        });

        return result;
    }


    @GetMapping("/data-mutasi-otomatis-janda-duda-anak-bulan-13/belum-validasi")
    public Page<MutasiOtomatisBulan13ViewDto> gridTab3BelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam",required = false)String searchParam){

        Page<MutasiOtomatisBulan13ViewModel> uIt = (Page<MutasiOtomatisBulan13ViewModel>) mutasiPenerimaAnakTab3Dao.findAllViewBelumValidasi("%"+ searchParam +"%", pageRequest);
        Page<MutasiOtomatisBulan13ViewDto> result = uIt.map(u -> {
            MutasiOtomatisBulan13ViewDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @PutMapping("/mutasi-otomatis-anak-sp")
    public ResponseEntity<MessageUtil>updateMuasiOtomatisAnak(@ModelAttribute MutasiOtomatisAnakBulan13PlainTextFormDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        MutasiOtomatisAnakBulan13FormDto spDto = new MutasiOtomatisAnakBulan13FormDto();
        spDto.fromPlainText(plainDto);
        spDto.setParRoleId(role.getId());
        Map result = mutasiPenerimaAnakTab3Dao.spMutasiOtomatisanak(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }
}
