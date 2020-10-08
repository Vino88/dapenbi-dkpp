package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ProyeksiDao;
import com.dapenbi.dkpp.dto.HerRegistrasiDto;
import com.dapenbi.dkpp.dto.ProyeksiDto;
import com.dapenbi.dkpp.form.CuspPmbyUangPembinaanHeadPlainDto;
import com.dapenbi.dkpp.model.HerRegistrasi;
import com.dapenbi.dkpp.model.Proyeksi;
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
@RequestMapping(PathPrefix.API + PathPrefix.PEMBAYARAN + PathPrefix.PROYEKSI_PEMBAYARAN_MP)
public class ProyeksiPembayaranMpApiController {

    @Autowired
    ProyeksiDao proyeksiDao;

    @GetMapping
    public Page<ProyeksiDto> index(Pageable pageRequest,
                                   @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<Proyeksi> uIt = (Page<Proyeksi>) proyeksiDao.findAll(new String[] { "awalTahunProyeksi" }, "%" + searchParam + "%", pageRequest);
        Page<ProyeksiDto> result = uIt.map(u -> {
            ProyeksiDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @PostMapping("/master")
    public ResponseEntity<MessageUtil> executeSP(String parCompName, String parUserName, Long parIdProyeksi, Date parTglInput, Long parJmlThnProyeksi, String parBatasGolIIV, String parBatasGolVII, Long parJmlSimulasi, Long parIdJenisKenaikanMp, Long parPersentaseKenaikanMp1, Long parPersentaseKenaikanMp2, Long parPersentaseKenaikanMp3, Long parMinimalKenaikanMp1, Long parMinimalKenaikanMp2, Long parMinimalKenaikanMp3, Long parPersentaseKenaikanPhdp, Long parPersentaseKenaikanPhdp2, Long parPersentaseKenaikanPhdp3, Character parAction, String parUserStamp){
        String compName = DkppUserStamp.getCompName();
        String userName = DkppUserStamp.getUserName();
        Map result = proyeksiDao.processMasterProyeksi(compName,userName,parIdProyeksi,parTglInput,parJmlThnProyeksi,parBatasGolIIV,parBatasGolVII,parJmlSimulasi,parIdJenisKenaikanMp,parPersentaseKenaikanMp1,parPersentaseKenaikanMp2,parPersentaseKenaikanMp3,parMinimalKenaikanMp1,parMinimalKenaikanMp2,parMinimalKenaikanMp3,parPersentaseKenaikanPhdp,parPersentaseKenaikanPhdp2,parPersentaseKenaikanPhdp3,parAction,parUserStamp);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1") || result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/master/entry")
    public ProyeksiDto entry(Pageable pageRequest,
                                   @RequestParam(name = "searchParam", required = false) String searchParam,
                                   @RequestParam(name = "id", required = false) Long id) {
        Proyeksi uIt = proyeksiDao.findById(id);
        ProyeksiDto result = uIt.toDto();

        return result;
    }

    @PostMapping("/pens-baru")
    public ResponseEntity<MessageUtil> executeSPProyeksiPensBaru(String parCompName, String parUserName, String parTahunProyeksi, Character parUntukProyeksi, String parUserStamp){
        String compName = DkppUserStamp.getCompName();
        String userName = DkppUserStamp.getUserName();
        Map result = proyeksiDao.processProyeksiPensiunBaru(compName,userName,parTahunProyeksi,parUntukProyeksi,parUserStamp);
        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1") || result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }
}

