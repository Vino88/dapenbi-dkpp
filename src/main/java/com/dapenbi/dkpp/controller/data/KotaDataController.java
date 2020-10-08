package com.dapenbi.dkpp.controller.data;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KotaDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.Kota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(PathPrefix.DATA + PathPrefix.KOTA)
public class KotaDataController {
    @Autowired
    KotaDao kotaDao;

    @GetMapping
    public List<Select2Default> index() {

        Iterable<Kota> it = kotaDao.findAll();
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            listSelect2.add(new Select2Default( String.valueOf(k.getId()), k.getNamaKota()));
        });


        return listSelect2;
    }

}
