package com.dapenbi.dkpp.controller.data;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KantorBayarDao;
import com.dapenbi.dkpp.dao.KategoriMutasiDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.KantorBayar;
import com.dapenbi.dkpp.model.KategoriMutasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PathPrefix.DATA + PathPrefix.KANTOR_BAYAR)
public class KantorBayarDataController {

    @Autowired
    KantorBayarDao kantorBayarDao;

    @GetMapping
    public List<Select2Default> index(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q){
        Iterable<KantorBayar> it = kantorBayarDao.findAllKantorBayar("%"+ q +"%", pageable);
        if(q == null){
            it = kantorBayarDao.findByOrderAsc("%"+ q +"%", pageable);
        }
        List<Select2Default> list = new ArrayList<>();
        it.forEach((k) -> {
            list.add(new Select2Default(String.valueOf(k.getId()), k.getNamaKantorBayar()));
        });

        return list;
    }
}
