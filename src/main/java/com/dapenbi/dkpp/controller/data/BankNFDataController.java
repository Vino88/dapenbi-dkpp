package com.dapenbi.dkpp.controller.data;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.BankDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.BankNF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(PathPrefix.DATA + PathPrefix.BANK_NF)
public class BankNFDataController {
    @Autowired
    BankDao bankDao;

    @GetMapping
    public List<Select2Default> index(Pageable pageable, @RequestParam(name = "q", required = false) String q) {
        Iterable<BankNF> it = bankDao.findAll(new String[] {"namaBankNF"}, "%" + q + "%", pageable);
        if(q == null){
            it = bankDao.findAll();
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            listSelect2.add(new Select2Default( String.valueOf(k.getId()), k.getNamaBankNF()));
        });

        return listSelect2;
    }

}
