package com.dapenbi.dkpp.controller.data;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.FaktorFPRDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.FaktorFPR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PathPrefix.DATA + PathPrefix.FAKTORFPR)
public class FaktorFprDataController {

    @Autowired
    FaktorFPRDao faktorFPRDao;

    @GetMapping
    public List<Select2Default> index(){
        Iterable<FaktorFPR> it = faktorFPRDao.findAll();
        List<Select2Default> list = new ArrayList<>();
        it.forEach((k)->{
            list.add(new Select2Default(String.valueOf(k.getId()),k.getNamafaktor()));
        });

        return list;
    }

}
