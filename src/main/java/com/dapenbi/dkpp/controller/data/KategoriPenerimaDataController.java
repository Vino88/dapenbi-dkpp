package com.dapenbi.dkpp.controller.data;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriPenerimaDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.KategoriPenerima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class KategoriPenerimaDataController {
    @Autowired
    KategoriPenerimaDao kategoriPenerimaDao;

    @RequestMapping(PathPrefix.DATA + PathPrefix.KATEGORI_PENERIMA)
    public List<Select2Default> index(Pageable pageable, @RequestParam(name = "q", required = false) String q) {
        Iterable<KategoriPenerima> it = kategoriPenerimaDao.findAll(new String[] {"namaKategoriPenerima"}, "%" + q + "%", pageable);
        if(q == null){
            it = kategoriPenerimaDao.findAll();
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            listSelect2.add(new Select2Default( String.valueOf(k.getId()), k.getNamaKategoriPenerima()));
        });


        return listSelect2;
    }

    @RequestMapping(PathPrefix.DATA + PathPrefix.KATEGORI_PENERIMA + "/get-detail")
    public KategoriPenerima getDetail(String id){
        KategoriPenerima kp = kategoriPenerimaDao.findFirstById(Long.valueOf(id));
        return kp;
    }

}
