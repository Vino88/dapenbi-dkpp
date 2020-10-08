package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.PmbyUangPmbnDetDao;
import com.dapenbi.dkpp.dao.PmbyUangPmbnHDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.PmbyUangPmbnDetDto;
import com.dapenbi.dkpp.dto.PmbyUangPmbnHDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.PmbyUangPmbnDet;
import com.dapenbi.dkpp.model.PmbyUangPmbnH;
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
@RequestMapping(PathPrefix.API + PathPrefix.PEMBAYARAN_UANG_PEMBINAAN)
public class PembayaranUangPembinaanApiController {

    PmbyUangPmbnHDao pmbyUangPmbnHDao;
    PmbyUangPmbnDetDao pmbyUangPmbnDetDao;

    @Autowired
    public PembayaranUangPembinaanApiController(PmbyUangPmbnHDao pmbyUangPmbnHDao, PmbyUangPmbnDetDao pmbyUangPmbnDetDao){
        this.pmbyUangPmbnHDao = pmbyUangPmbnHDao;
        this.pmbyUangPmbnDetDao = pmbyUangPmbnDetDao;
    }

    @GetMapping
    public Page<PmbyUangPmbnHDto>index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<PmbyUangPmbnH> uIt = (Page<PmbyUangPmbnH>) pmbyUangPmbnHDao.findAll(new String[]{"periodeBayar"},"%"+searchParam+"%",pageRequest);

        Page<PmbyUangPmbnHDto> result = uIt.map(u->{
            PmbyUangPmbnHDto dto = u.toDto();
            if (u.getIdValidasi() !=null) dto.setIdValidasi(u.getIdValidasi().toDto());
            return dto;
        });
        return result;
    }



    @GetMapping("/pmby-pembinaan-detail/{idUangPembinaanH}")
    public Page<PmbyUangPmbnDetDto>detail(Pageable pagerequest, @RequestParam(name = "searchParam", required = false) String searchParam, @PathVariable Long idUangPembinaanH){
        Page<PmbyUangPmbnDet> uIt = (Page<PmbyUangPmbnDet>) pmbyUangPmbnDetDao.findAllByIdUangPembinaanH(idUangPembinaanH,"%" + searchParam + "%",pagerequest);
        Page<PmbyUangPmbnDetDto> result = uIt.map(u->{
            PmbyUangPmbnDetDto dto = u.toDto();
            return dto;
        });
         return result;
    }


    @PostMapping("/create")
    public ResponseEntity<MessageUtil>spCreate(@ModelAttribute CuspPmbyUangPembinaanHeadPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPmbyUangPembinaanHeadSPDto spDto = new CuspPmbyUangPembinaanHeadSPDto();
        spDto.setParRoleId(role.getId());
        spDto.setParIdValidasi(Long.valueOf(1));
        spDto.setParNamaValidasi("Belum Validasi");
        spDto.fromPlainText(plainDto);
        Map result = pmbyUangPmbnHDao.processCuspPmbyUangPembinaan(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/update")
    public ResponseEntity<MessageUtil>spUpdate(@ModelAttribute CuspPmbyUangPembinaanHeadPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPmbyUangPembinaanHeadSPDto spDto = new CuspPmbyUangPembinaanHeadSPDto();
        spDto.setParRoleId(role.getId());
        spDto.fromPlainText(plainDto);
            Map result = pmbyUangPmbnHDao.processCuspPmbyUangPembinaan(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/delete-detail")
    public ResponseEntity<MessageUtil>spHapusDetail(@ModelAttribute CuspPmbyUangPembinaanDetPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        String ParAction = "D";
        CuspPmbyUangPembinaanDetSpDto spDto = new CuspPmbyUangPembinaanDetSpDto();
        spDto.setParRoleId(role.getId());
        spDto.setParAction(ParAction);
        spDto.fromPlainText(plainDto);
        Map result = pmbyUangPmbnDetDao.processCuspPmbyUangPembinaanD(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/add-detail")
    public ResponseEntity<MessageUtil>spAddDetail(@ModelAttribute CuspPmbyUangPembinaanDetPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        String ParAction = "C";
        CuspPmbyUangPembinaanDetSpDto spDto = new CuspPmbyUangPembinaanDetSpDto();
        spDto.setParRoleId(role.getId());
        spDto.setParAction(ParAction);
        spDto.fromPlainText(plainDto);
        Map result = pmbyUangPmbnDetDao.processCuspPmbyUangPembinaanD(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/send-ptr")
    public ResponseEntity<MessageUtil>spSendPtr(@ModelAttribute CuspPmbyUangPmbnPtrPlainDto plainDto){
        CuspPmbyUangPmbnPtrSPDto spDto = new CuspPmbyUangPmbnPtrSPDto();
        spDto.fromPlainText(plainDto);
        Map result = pmbyUangPmbnDetDao.processCuspPmbyUangPmbnPtr(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }
}
