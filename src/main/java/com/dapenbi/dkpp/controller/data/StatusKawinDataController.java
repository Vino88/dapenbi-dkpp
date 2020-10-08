package com.dapenbi.dkpp.controller.data;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.StatusKawinDao;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.model.StatusKawin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatusKawinDataController {
    @Autowired
    StatusKawinDao statusKawinDao;

    @RequestMapping(PathPrefix.DATA + PathPrefix.STATUS_KAWIN)
    public List<Select2Default> index(Pageable pageable, @RequestParam(name = "q", required = false) String q) {
        Iterable<StatusKawin> it = statusKawinDao.findAll(new String[] {"statusKawin"}, "%" + q + "%", pageable);
        if(q == null){
            it = statusKawinDao.findAll();
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            listSelect2.add(new Select2Default( String.valueOf(k.getId()), k.getStatusKawin()));
        });


        return listSelect2;
    }

    @RequestMapping(PathPrefix.DATA + PathPrefix.STATUS_KAWIN + "/get-detail")
    public StatusKawin getDetail(String id){
        StatusKawin sk = statusKawinDao.findFirstById(Long.valueOf(id));
        return sk;
    }
}
