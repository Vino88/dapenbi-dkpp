package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KenaikanMpDao;
import com.dapenbi.dkpp.dao.MutasiKenaikanMpDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.KenaikanMpDto;
import com.dapenbi.dkpp.dto.MutasiKenaikanMpDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.KenaikanMp;
import com.dapenbi.dkpp.model.MutasiKenaikanMp;
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
@RequestMapping(PathPrefix.API + PathPrefix.KENAIKAN_BERDASARKAN_KEPUTUSAN)
public class KenaikanMpApiController {

    private KenaikanMpDao kenaikanMpDao;
    private MutasiKenaikanMpDao mutasiKenaikanMpDao;

    @Autowired
    public KenaikanMpApiController(KenaikanMpDao kenaikanMpDao, MutasiKenaikanMpDao mutasiKenaikanMpDao){
        this.kenaikanMpDao = kenaikanMpDao;
        this.mutasiKenaikanMpDao = mutasiKenaikanMpDao;
    }

    @GetMapping
    public Page<KenaikanMpDto>index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false)String searchParam){
        Page<KenaikanMp> uIt = (Page<KenaikanMp>) kenaikanMpDao.findAll(new String[] {"namaJenisKenaikanMp"},"%"+ searchParam +"%",pageRequest);
        Page<KenaikanMpDto> result = uIt.map(u->{
            KenaikanMpDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @GetMapping("/kenaikan-mutasi")
    public Page<MutasiKenaikanMpDto>indexKenaikan(Pageable pageRequest,@RequestParam(name = "searchParam",required = false) String searchParam){
        Page<MutasiKenaikanMp> uIt = (Page<MutasiKenaikanMp>) mutasiKenaikanMpDao.findAll(new String[] {"nip"},"%"+searchParam+"%",pageRequest);
        Page<MutasiKenaikanMpDto> result = uIt.map(u->{
            MutasiKenaikanMpDto dto = u.toDto();

            if (u.getIdKenaikanMp()!=null) dto.setIdKenaikanMp(u.getIdKenaikanMp().toDto());
            if (u.getIdKategoriPenerimaMp()!=null) dto.setIdKategoriPenerimaMp(u.getIdKategoriPenerimaMp().toDto());
            if (u.getIdValidasi()!=null) dto.setIdValidasi(u.getIdValidasi().toDto());
            if (u.getIdKategoriCatatan()!=null) dto.setIdKategoriCatatan(u.getIdKategoriCatatan().toDto());
            if (u.getIdKantorBayar()!=null) dto.setIdKantorBayar(u.getIdKantorBayar().toDto());
            if (u.getIdKategoriPensiun()!=null) dto.setIdKategoriPensiun(u.getIdKategoriPensiun().toDto());
            if (u.getIdJenisMps()!=null) dto.setIdJenisMps(u.getIdJenisMps().toDto());


            return dto;
        });
        return result;
    }


    @PostMapping("/create")
    public ResponseEntity<MessageUtil> spCreate(@ModelAttribute CuspKenaikanMpPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspKenaikanMpSPDto spDto = new CuspKenaikanMpSPDto();
        spDto.fromPlainText(plainDto);
        Map result = kenaikanMpDao.processCuspKenaikanMp(spDto);

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

    @PostMapping("/proses")
    public ResponseEntity<MessageUtil> spProsesMutasiKenaikanMp(@ModelAttribute CuspMutasiKenaikanMpPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspMutasiKenaikanMpSPDto spDto = new CuspMutasiKenaikanMpSPDto();
        spDto.setParRoleId(role.getId());
        spDto.fromPlainText(plainDto);
        Map result = mutasiKenaikanMpDao.processCuspMutasiKenaikanMp(spDto);

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

    @PostMapping("/spkenaikanmp-validasi")
    public ResponseEntity<MessageUtil> spKenaikanMpValidasi(@ModelAttribute CuspKenaikanMpValidPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspKenaikanMpValidSPDto spDto = new CuspKenaikanMpValidSPDto();
        spDto.fromPlainText(plainDto);
        Map result = mutasiKenaikanMpDao.processCuspMutasiKenaikanMpValid(spDto);

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



}
