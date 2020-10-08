package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ReportDataBerkalaManajemenDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.ReportDataBerkalaManajemenDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.CuspReportDataBerkalaManajemenFormDto;
import com.dapenbi.dkpp.model.ReportDataBerkalaManajemen;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PENGOLAHAN_PIHAK_KETIGA)
public class PengolahanDataBerkalaPihakKetigaApiController  {

    private ReportDataBerkalaManajemenDao reportDataBerkalaManajemenDao;

    public PengolahanDataBerkalaPihakKetigaApiController(ReportDataBerkalaManajemenDao reportDataBerkalaManajemenDao){
        this.reportDataBerkalaManajemenDao = reportDataBerkalaManajemenDao;
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
