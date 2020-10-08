package com.dapenbi.dkpp.controller.data;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.FaktorFsDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.FaktorFs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(PathPrefix.DATA + PathPrefix.FAKTOR_FS)
public class FaktorFsDataController {
    @Autowired
    FaktorFsDao faktorFsDao;

    @GetMapping
    public List<Select2Default> index() {

        Iterable<FaktorFs> it = faktorFsDao.findAll();
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            listSelect2.add(new Select2Default( String.valueOf(k.getId()), k.getNamaFaktorFs()));
        });

        return listSelect2;
    }

}
