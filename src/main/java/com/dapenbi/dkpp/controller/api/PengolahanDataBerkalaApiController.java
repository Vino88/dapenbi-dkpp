package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.PengolahanDataBerkalaDao;
import com.dapenbi.dkpp.dao.PengolahanDataBerkalaOjkDao;
import com.dapenbi.dkpp.dao.ReportDataBerkalaManajemenDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaFormDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaManajemenFormDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaOjkFormDto;
import com.dapenbi.dkpp.model.PengolahanDataBerkala;
import com.dapenbi.dkpp.model.PengolahanDataBerkalaOJK;
import com.dapenbi.dkpp.model.ReportDataBerkalaManajemen;
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
@RequestMapping(PathPrefix.API + PathPrefix.PENGOLAHAN_DATA_BERKALA)
public class PengolahanDataBerkalaApiController {


    private PengolahanDataBerkalaDao pengolahanDataBerkalaDao;
    private PengolahanDataBerkalaOjkDao pengolahanDataBerkalaOjkDao;
    private ReportDataBerkalaManajemenDao reportDataBerkalaManajemenDao;


    private SetupParameterDao setupParameterDao;

    @Autowired
    public PengolahanDataBerkalaApiController(PengolahanDataBerkalaDao pengolahanDataBerkalaDao, PengolahanDataBerkalaOjkDao pengolahanDataBerkalaOjkDao, ReportDataBerkalaManajemenDao reportDataBerkalaManajemenDao, SetupParameterDao setupParameterDao){
        this.pengolahanDataBerkalaDao = pengolahanDataBerkalaDao;
        this.pengolahanDataBerkalaOjkDao = pengolahanDataBerkalaOjkDao;
        this.reportDataBerkalaManajemenDao = reportDataBerkalaManajemenDao;
        this.setupParameterDao = setupParameterDao;
    }

    @GetMapping
    public Page<PengolahanDataBerkalaDto> index(Pageable pageRequest){
        Page<PengolahanDataBerkala> uIt = (Page<PengolahanDataBerkala>) pengolahanDataBerkalaDao.findAll(pageRequest);
        Page<PengolahanDataBerkalaDto> result = uIt.map(u->{
            PengolahanDataBerkalaDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @PostMapping("/generate")
    public ResponseEntity<MessageUtil> process(@ModelAttribute CuspReportDataBerkalaFormDto plainDto, PengolahanDataBerkalaDto pengolahanDataBerkalaDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspReportDataBerkalaFormDto spDto = new CuspReportDataBerkalaFormDto();
        spDto.fromPlainText(plainDto);
        Map result = pengolahanDataBerkalaDao.cuspReportDataBerkala(spDto);

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

    @GetMapping("/ojk")
    public Page<PengolahanDataBerkalaOjkDto> ojk(Pageable pageRequest){
        Page<PengolahanDataBerkalaOJK> uIt = (Page<PengolahanDataBerkalaOJK>) pengolahanDataBerkalaOjkDao.findAll(pageRequest);
        Page<PengolahanDataBerkalaOjkDto> result = uIt.map(u->{
            PengolahanDataBerkalaOjkDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @PostMapping("/generate-ojk")
    public ResponseEntity<MessageUtil> generateOjk(@ModelAttribute CuspReportDataBerkalaOjkFormDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspReportDataBerkalaOjkFormDto spDto = new CuspReportDataBerkalaOjkFormDto();
        spDto.fromPlainText(plainDto);
        Map result = pengolahanDataBerkalaOjkDao.CuspReportDataBerkalaOjk(spDto);

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

    @GetMapping("/manajemen")
    public Page<ReportDataBerkalaManajemenDto> manajemen(Pageable pageRequest){
        Page<ReportDataBerkalaManajemen> uIt = (Page<ReportDataBerkalaManajemen>) reportDataBerkalaManajemenDao.findAll(pageRequest);
        Page<ReportDataBerkalaManajemenDto> result = uIt.map(u->{
            ReportDataBerkalaManajemenDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @PostMapping("/report-manajemen")
    public ResponseEntity<MessageUtil> generateReportManajemen(@ModelAttribute CuspReportDataBerkalaManajemenFormDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspReportDataBerkalaManajemenFormDto spDto = new CuspReportDataBerkalaManajemenFormDto();
        spDto.fromPlainText(plainDto);
        Map result = reportDataBerkalaManajemenDao.cuspReportManajemen(spDto);

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