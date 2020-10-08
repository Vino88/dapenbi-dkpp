package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ProyeksiPembayaranPensiunLamaDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunBaruDto;
import com.dapenbi.dkpp.dto.ProyeksiPembayaranPensiunLamaDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.CuspProsesPiutangBulananSPFormDto;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunLama;
import com.dapenbi.dkpp.form.CuspProyeksiPembayaranPensiunLamaPlainDto;
import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunBaru;
import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunLama;
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
@RequestMapping(PathPrefix.API+PathPrefix.PEMBAYARAN+PathPrefix.PROYEKSIPEMBAYARANPENSIUNLAMA)
public class ProyeksiPembayaranPensiunLamaApiController {

    private ProyeksiPembayaranPensiunLamaDao proyeksiPembayaranPensiunLamaDao;

    @Autowired
    public ProyeksiPembayaranPensiunLamaApiController(ProyeksiPembayaranPensiunLamaDao proyeksiPembayaranPensiunLamaDao){
        this.proyeksiPembayaranPensiunLamaDao = proyeksiPembayaranPensiunLamaDao;

    }

    @GetMapping
    public Page<ProyeksiPembayaranPensiunLamaDto> index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<ProyeksiPembayaranPensiunLama> uIt = (Page<ProyeksiPembayaranPensiunLama>) proyeksiPembayaranPensiunLamaDao.findAllTanpaParam( "%"+searchParam+"%",pageRequest);
        Page<ProyeksiPembayaranPensiunLamaDto> result = uIt.map(u->{
            ProyeksiPembayaranPensiunLamaDto dto = u.toDto();
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

    @PostMapping("/proses-pensiun-lama")
    public ResponseEntity<MessageUtil>prosesProyeksiPensLama(@ModelAttribute CuspProyeksiPembayaranPensiunLamaPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspProyeksiPembayaranPensiunLama spDto = new CuspProyeksiPembayaranPensiunLama();
        spDto.fromPlainText(plainDto);
        Map result = proyeksiPembayaranPensiunLamaDao.processCuspProyeksiPensiunLama(spDto);

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
