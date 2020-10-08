package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriPenerimaDao;
import com.dapenbi.dkpp.dto.KategoriPenerimaDto;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.KategoriPenerimaFormDto;
import com.dapenbi.dkpp.model.KategoriPenerima;
import com.dapenbi.dkpp.model.MPensiun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KATEGORI_PENERIMA)
public class KategoriPenerimaApiController extends DropdownApiController {

    @Autowired
    public KategoriPenerimaApiController (KategoriPenerimaDao kategoriPenerimaDao) {
        super(kategoriPenerimaDao);
    }


    @GetMapping
    public Page<KategoriPenerimaDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        KategoriPenerimaDao kategoriPenerimaDao = (KategoriPenerimaDao) this.baseDao;

        Page<KategoriPenerima> aIt = (Page<KategoriPenerima>) kategoriPenerimaDao.findAll(new String[] {"namaKategoriPenerima", "statusKategoriPenerima"}, "%" + searchParam + "%", pageRequest);

        Page<KategoriPenerimaDto> kategoriPenerimaDto = aIt.map(u -> u.toDto());

        return kategoriPenerimaDto;
    }

    @GetMapping(PathPrefix.LIST)
    public List<Select2Default> listPeserta(@SortDefault(sort={"urutan"}, direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(name = "searchParam", required = false) String q) {
        KategoriPenerimaDao kategoriPenerimaDao = (KategoriPenerimaDao) this.baseDao;
        Iterable<KategoriPenerima> it = kategoriPenerimaDao.findAll(new String[] {"namaKategoriPenerima", "statusKategoriPenerima"}, "%" + q + "%", pageable);
        if(q == null){
            Sort sort = new Sort(Sort.Direction.ASC,"urutan");
            it = kategoriPenerimaDao.findAll(sort);
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            KategoriPenerimaDto kategoriPenerimaDto = k.toDto();
            listSelect2.add(new Select2Default(String.valueOf(k.getId()), k.getNamaKategoriPenerima(), kategoriPenerimaDto));
        });
        return listSelect2;
    }

    @PostMapping
    public KategoriPenerimaDto addKategoriPenerima(@ModelAttribute KategoriPenerimaFormDto kategoriPenerimaFormDto) {
        KategoriPenerimaDao kategoriPenerimaDao = (KategoriPenerimaDao) this.baseDao;

        KategoriPenerima kategoriPenerima = new KategoriPenerima();
        kategoriPenerima.setNamaKategoriPenerima(kategoriPenerimaFormDto.getNamaKategoriPenerima());
        kategoriPenerima.setStatusKategoriPenerima(kategoriPenerimaFormDto.getStatusKategoriPenerima());
        kategoriPenerima.setUrutan(kategoriPenerimaFormDto.getUrutan());
        kategoriPenerima.setActive(kategoriPenerimaFormDto.getActive() != null && kategoriPenerimaFormDto.getActive().size() > 0);
        return kategoriPenerimaDao.save(kategoriPenerima).toDto();
    }

    @PutMapping
    public KategoriPenerimaDto updateKategoriPenerima(@ModelAttribute KategoriPenerimaFormDto kategoriPenerimaFormDto) {
        KategoriPenerimaDao kategoriPenerimaDao = (KategoriPenerimaDao) this.baseDao;

        KategoriPenerima kategoriPenerima = kategoriPenerimaDao.findById(kategoriPenerimaFormDto.getId());
        kategoriPenerima.setNamaKategoriPenerima(kategoriPenerimaFormDto.getNamaKategoriPenerima());
        kategoriPenerima.setStatusKategoriPenerima(kategoriPenerimaFormDto.getStatusKategoriPenerima());
        kategoriPenerima.setUrutan(kategoriPenerimaFormDto.getUrutan());
        kategoriPenerima.setActive(kategoriPenerimaFormDto.getActive() != null && kategoriPenerimaFormDto.getActive().size() > 0);

        return kategoriPenerimaDao.save(kategoriPenerima).toDto();
    }

}
