package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ProyeksiPembayaranPensiunBaruDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunBaruDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunBaruPlainDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunBaruSPDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunLama;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunLamaPlainDto;
import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunBaru;
import com.dapenbi.dkpp.repository.ProyeksiPembayaranPensiunBaruRepository;
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
@RequestMapping(PathPrefix.API+PathPrefix.PEMBAYARAN+PathPrefix.PROYEKSIPEMBAYARANPENSIUNBARU)
public class ProyeksiPembayaranPensiunBaruApiController {

    private ProyeksiPembayaranPensiunBaruDao proyeksiPembayaranPensiunBaruDao;

    @Autowired
    public ProyeksiPembayaranPensiunBaruApiController(ProyeksiPembayaranPensiunBaruDao proyeksiPembayaranPensiunBaruDao){
        this.proyeksiPembayaranPensiunBaruDao = proyeksiPembayaranPensiunBaruDao;
    }

    @GetMapping
    public Page<ProyeksiPembayaranPensiunBaruDto> index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<ProyeksiPembayaranPensiunBaru> uIt = (Page<ProyeksiPembayaranPensiunBaru>) proyeksiPembayaranPensiunBaruDao.findAll(new String[] {"tahunProyeksi","nip","namaPeserta"},"%"+searchParam+"%",pageRequest);
        Page<ProyeksiPembayaranPensiunBaruDto> result = uIt.map(u->{
            ProyeksiPembayaranPensiunBaruDto dto = u.toDto();
            if(u.getIdProyeksi()!=null) dto.setIdProyeksi(u.getIdProyeksi().toDto());
            if(u.getIdGolongan()!=null) dto.setIdGolongan(u.getIdGolongan().toDto());
            if(u.getIdFaktorFpr()!=null) dto.setIdFaktorFpr(u.getIdFaktorFpr().toDto());
            if(u.getIdFaktorFs()!=null) dto.setIdFaktorFs(u.getIdFaktorFs().toDto());
            if(u.getIdStatusKawin()!=null) dto.setIdStatusKawin(u.getIdStatusKawin().toDto());
            if(u.getIdJenisMps()!=null) dto.setIdJenisMps(u.getIdJenisMps().toDto());
            return dto;
        });
        return result;

    }

    @PostMapping("/proses-pensiun-baru")
    public ResponseEntity<MessageUtil> prosesProyeksiPensLama(@ModelAttribute CuspProyeksiPembayaranPensiunBaruPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspProyeksiPembayaranPensiunBaruSPDto spDto = new CuspProyeksiPembayaranPensiunBaruSPDto();
        spDto.fromPlainText(plainDto);
        Map result = proyeksiPembayaranPensiunBaruDao.processCuspProyeksiPensiunBaru(spDto);

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
