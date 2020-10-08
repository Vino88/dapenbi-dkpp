package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.PmbyPiutangDao;
import com.dapenbi.dkpp.dto.PmbyPiutangDto;
import com.dapenbi.dkpp.model.PmbyPiutang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PMBY_PIUTANG)
public class PmbyPiutangApiController {

    private PmbyPiutangDao pmbyPiutangDao;

    @Autowired
    public PmbyPiutangApiController(PmbyPiutangDao pmbyPiutangDao){
        this.pmbyPiutangDao = pmbyPiutangDao;
    }

    @GetMapping
    public Page<PmbyPiutangDto> index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<PmbyPiutang> uIt = (Page<PmbyPiutang>) pmbyPiutangDao.findAll(new String[] {"nip","namaPeserta"},"%"+searchParam+"%",pageRequest);
        Page<PmbyPiutangDto> result = uIt.map(u->{
            PmbyPiutangDto dto = u.toDto();
            if (u.getIdKantorBayar()!=null) dto.setIdKantorBayar(u.getIdKantorBayar().toDto());
            if (u.getIdValidasi()!=null) dto.setIdValidasi(u.getIdValidasi().toDto());
            return dto;
        });
        return result;

    }
}
