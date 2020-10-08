package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dao.PmbyAngsuranLebihBayarDetDao;
import com.dapenbi.dkpp.dao.PmbyAngsuranLebihBayarHeadDao;
import com.dapenbi.dkpp.dao.impl.PmbyAngsuranLebihBayarDetDaoImpl;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarDetDto;
import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarHeadDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.PmbyAngsuranLebihBayarHeadFormDto;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarDet;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarHead;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import com.dapenbi.dkpp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PEMBAYARAN_ANGSURAN_HEAD)
public class PmbyAngsuranLebihBayarHeadApiController {

    @Autowired
    PmbyAngsuranLebihBayarHeadDao pmbyAngsuranLebihBayarHeadDao;

    @Autowired
    PmbyAngsuranLebihBayarDetDao pmbyAngsuranLebihBayarDetDao;

    @GetMapping
    Page<PmbyAngsuranLebihBayarHeadDto>index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<PmbyAngsuranLebihBayarHead> uIt = (Page<PmbyAngsuranLebihBayarHead>) pmbyAngsuranLebihBayarHeadDao.findAll(new String[] { "periodeMutasi","nip" }, "%" + searchParam + "%", pageRequest);
        Page<PmbyAngsuranLebihBayarHeadDto> result = uIt.map(u -> {
            PmbyAngsuranLebihBayarHeadDto dto = u.toDto();
            if (u.getKantorBayar() != null) dto.setKantorBayar(u.getKantorBayar().toDto());
            return dto;
        });
        return result;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> process(@ModelAttribute PmbyAngsuranLebihBayarHeadFormDto formDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        Map result = pmbyAngsuranLebihBayarHeadDao.processPmbyLebihBayar(role.getId()
                ,formDto.getCompName()
                ,formDto.getUserName()
                ,formDto.getPeriodeLebihBayar()
        );

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

    @GetMapping("/detail")
    public ResponseEntity<ResponseUtil> detailAngsuranLebihBayar(Pageable pagerequest, @RequestParam(name = "id", required = false) Long id){
        PmbyAngsuranLebihBayarHead pmbyAngsuranLebihBayarHead = this.pmbyAngsuranLebihBayarHeadDao.findById(id);
        Iterable<PmbyAngsuranLebihBayarDet> uIt = pmbyAngsuranLebihBayarDetDao.findAllByPmbyAngsuranLebihBayarHead(pmbyAngsuranLebihBayarHead);

        List<PmbyAngsuranLebihBayarDetDto> data = new ArrayList<>();
        for (Iterator iterator = uIt.iterator(); iterator.hasNext();){
            PmbyAngsuranLebihBayarDet entity = (PmbyAngsuranLebihBayarDet) iterator.next();
            PmbyAngsuranLebihBayarDetDto detail = entity.toDto();
            detail.setAngsuranLebihBayar(entity.getAngsuranLebihBayar().toDto());
            detail.setPmbyAngsuranLebihBayarHead(entity.getPmbyAngsuranLebihBayarHead().toDto());
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
