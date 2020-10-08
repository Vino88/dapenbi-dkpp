package com.dapenbi.dkpp.controller.data;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriPenerimaDao;
import com.dapenbi.dkpp.dao.MPensiunNfDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.model.MPensiunNf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MasterPensiunNfDataController {

    @Autowired
    MPensiunNfDao mPensiunNfDao;

    @RequestMapping(PathPrefix.DATA + PathPrefix.PENERIMA_MP_NF)
    public List<Select2Default> index(Pageable pageable, @RequestParam(name = "q", required = false) String q) {
        Iterable<MPensiunNf> it = mPensiunNfDao.findAll(new String[] {"namaPeserta"}, "%" + q + "%", pageable);
        if(q == null){
            it = mPensiunNfDao.findAll();
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            listSelect2.add(new Select2Default( String.valueOf(k.getNip()), k.getNamaPeserta()));
        });


        return listSelect2;
    }

}
