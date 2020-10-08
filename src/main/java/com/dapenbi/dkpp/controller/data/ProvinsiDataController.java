package com.dapenbi.dkpp.controller.data;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.Provinsi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(PathPrefix.DATA + PathPrefix.PROVINSI)
public class ProvinsiDataController {
    @Autowired
    ProvinsiDao provinsiDao;

    @GetMapping
    public List<Select2Default> index() {

        Iterable<Provinsi> it = provinsiDao.findAll();
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            listSelect2.add(new Select2Default( String.valueOf(k.getId()), k.getNamaProvinsi()));
        });


        return listSelect2;
    }

}
