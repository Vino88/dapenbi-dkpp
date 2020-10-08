package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SentToPtrDao;
import com.dapenbi.dkpp.dao.SentToPtrNfDao;
import com.dapenbi.dkpp.dto.SentToPtrDto;
import com.dapenbi.dkpp.dto.SentToPtrNfDto;
import com.dapenbi.dkpp.model.SentToPtr;
import com.dapenbi.dkpp.model.SentToPtrNf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.SENT_TO_PTR)
public class SentApiController {

    private SentToPtrDao sentToPtrDao;

    private SentToPtrNfDao sentToPtrNfDao;

    @Autowired
    public SentApiController(SentToPtrDao sentToPtrDao, SentToPtrNfDao sentToPtrNfDao){
        this.sentToPtrDao = sentToPtrDao;
        this.sentToPtrNfDao = sentToPtrNfDao;
    }

    @GetMapping("/sent-to-ptr")
    public Page<SentToPtrDto> viewSentToPtr(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<SentToPtr> uIt = (Page<SentToPtr>) sentToPtrDao.findAll(new String[] {"periodeTransaksi"}, "%" + searchParam + "%", pageRequest);
        Page<SentToPtrDto> SentToPtrDto = uIt.map(u -> {
            SentToPtrDto dto = u.toDto();

            return dto;
        });
        return SentToPtrDto;
    }

    @GetMapping("/sent-to-ptr-nf")
    public Page<SentToPtrNfDto> viewSentToPtrNf(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<SentToPtrNf> uIt = (Page<SentToPtrNf>) sentToPtrNfDao.findAll(new String[] {"periodeTransaksi"}, "%" + searchParam + "%", pageRequest);
        Page<SentToPtrNfDto> SentToPtrNfDto = uIt.map(u -> {
            SentToPtrNfDto dto = u.toDto();

            return dto;
        });
        return SentToPtrNfDto;
    }
}
