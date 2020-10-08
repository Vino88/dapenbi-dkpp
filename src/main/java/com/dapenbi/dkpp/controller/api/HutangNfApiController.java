package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.HUTANG_NF)
public class HutangNfApiController extends DropdownApiController{
    HutangNfDao hutangNfDao;

    @Autowired
    public HutangNfApiController(HutangNfDao hutangNfDao){
        super(hutangNfDao);
        this.hutangNfDao = hutangNfDao;
    }

    @GetMapping
    public Page<HutangNfDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<HutangNF> uIt = (Page<HutangNF>)  hutangNfDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<HutangNfDto> hutangNfDtos = uIt.map(u -> {
            HutangNfDto dto = u.toDto();
            return dto;
        });

        return hutangNfDtos;
    }



}
