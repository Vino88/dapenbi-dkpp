package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.CekMutasiDao;
import com.dapenbi.dkpp.dao.MPensiunDao;
import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.MPensiun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.CEKMUTASI)
public class CekMutasiApiController{

    CekMutasiDao cekMutasiDao;

    @Autowired
    public CekMutasiApiController(CekMutasiDao cekMutasiDao) {
        this.cekMutasiDao = cekMutasiDao;
    }

    @GetMapping("/is-exist/{nip}")
    public String isExist(@PathVariable(name = "nip") String nip ){
        String message = cekMutasiDao.isExist(nip);

        return message;
    }

}
