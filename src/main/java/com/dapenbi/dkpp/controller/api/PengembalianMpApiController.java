package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.PengembalianMpDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.PengembalianMpDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.CuspMutasiPengembalianMpPlainDto;
import com.dapenbi.dkpp.form.CuspMutasiPengembalianMpSPDto;
import com.dapenbi.dkpp.model.PengembalianMp;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PENGEMBALIAN_MP)
public class PengembalianMpApiController {

    private PengembalianMpDao pengembalianMpDao;

    @Autowired
    public PengembalianMpApiController(PengembalianMpDao pengembalianMpDao){
        this.pengembalianMpDao = pengembalianMpDao;
    }

    @GetMapping
    public Page<PengembalianMpDto>index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<PengembalianMp> uIt = (Page<PengembalianMp>) pengembalianMpDao.findAll(new String[] {"nip.nip","namaPeserta"},"%"+ searchParam +"%",pageRequest);
        Page<PengembalianMpDto> result = uIt.map(u->{
            PengembalianMpDto dto = u.toDto();
            if (u.getIdValidasi() !=null) dto.setIdValidasi(u.getIdValidasi().toDto());
            if (u.getIdKategoriCatatan() !=null) dto.setIdKategoriCatatan(u.getIdKategoriCatatan().toDto());
            if (u.getNip() !=null) dto.setNip(u.getNip().toDto());
            return dto;
        });
        return result;
    }

    @PostMapping("/create")
    public ResponseEntity<MessageUtil>spCreate(@ModelAttribute CuspMutasiPengembalianMpPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspMutasiPengembalianMpSPDto spDto = new CuspMutasiPengembalianMpSPDto();
        spDto.setParRoleId(role.getId());
        spDto.setParIdValidasi(Long.valueOf(1));
        spDto.setParNamaValidasi("Belum Validasi");
        spDto.fromPlainText(plainDto);
        Map result = pengembalianMpDao.processCuspMutasiPengembalianMp(spDto);

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

    @PostMapping("/update")
    public ResponseEntity<MessageUtil>spUpdate(@ModelAttribute CuspMutasiPengembalianMpPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspMutasiPengembalianMpSPDto spDto = new CuspMutasiPengembalianMpSPDto();
        spDto.setParRoleId(role.getId());
        spDto.fromPlainText(plainDto);
        Map result = pengembalianMpDao.processCuspMutasiPengembalianMp(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }
}
