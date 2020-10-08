package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dao.KategoriMutasiDao;
import com.dapenbi.dkpp.dto.KategoriCatatanDto;
import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.KategoriCatatanFormDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KATEGORICATATAN)
public class KategoriCatatanApiController extends DropdownApiController {

    private KategoriMutasiDao kategoriMutasiDao;

    @Autowired
    private KategoriCatatanDao kategoriCatatanDao;

    @Autowired
    public KategoriCatatanApiController(KategoriCatatanDao kategoriCatatanDao, KategoriMutasiDao kategoriMutasiDao) {
        super(kategoriCatatanDao);
        this.kategoriMutasiDao = kategoriMutasiDao;
    }

    @GetMapping
    public Page<KategoriCatatanDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        KategoriCatatanDao kategoriCatatanDao = (KategoriCatatanDao) this.baseDao;

        Page<KategoriCatatan> uIt = (Page<KategoriCatatan>) kategoriCatatanDao.findAll(new String[] {"namaKategoriCatatan"}, "%" + searchParam + "%", pageRequest);

        return uIt.map(u -> {
            KategoriCatatanDto dto = u.toDto();
            if (u.getKategoriMutasi() != null) dto.setKategoriMutasi(u.getKategoriMutasi().toDto());
            return dto;
        });
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKategoriCatatan(@ModelAttribute KategoriCatatanFormDto kategoriCatatanFormDto) {
        KategoriCatatan kategoriCatatan = new KategoriCatatan();

        if (getKategoriCatatanDto(kategoriCatatanFormDto, kategoriCatatan) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Ditambahkan"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Ditambahkan"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKategoriCatatan(@ModelAttribute KategoriCatatanFormDto kategoriCatatanFormDto) {
        KategoriCatatanDao kategoriCatatanDao = (KategoriCatatanDao) this.baseDao;

        KategoriCatatan kategoriCatatan = kategoriCatatanDao.findById(kategoriCatatanFormDto.getId());

        if (getKategoriCatatanDto(kategoriCatatanFormDto, kategoriCatatan) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Dirubah"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Dirubah"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private KategoriCatatanDto getKategoriCatatanDto(KategoriCatatanFormDto kategoriCatatanFormDto, KategoriCatatan kategoriCatatan) {
        KategoriCatatanDao kategoriCatatanDao = (KategoriCatatanDao) this.baseDao;

        kategoriCatatan.setId(kategoriCatatanFormDto.getId());
        kategoriCatatan.setNamaKategoriCatatan(kategoriCatatanFormDto.getNamaKategoriCatatan());
        kategoriCatatan.setKategoriMutasi(kategoriMutasiDao.findById(kategoriCatatanFormDto.getKategoriMutasi()));
        kategoriCatatan.setActive(kategoriCatatanFormDto.getActive() != null && kategoriCatatanFormDto.getActive().size() > 0);
        kategoriCatatan.setUserStamp(DkppUserStamp.postModeUserStamp());
        return kategoriCatatanDao.save(kategoriCatatan).toDto();
    }

    @GetMapping(PathPrefix.DATA+PathPrefix.KATEGORICATATAN+"/{idKategoriMutasi}")
    public List<Select2Default> listPeserta(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q, @PathVariable("idKategoriMutasi") String idKategoriMutasi) {
        KategoriMutasi kategoriMutasi = kategoriMutasiDao.findById(idKategoriMutasi);
        Iterable<KategoriCatatan> it = kategoriCatatanDao.findAllByKategoriMutasi(kategoriMutasi, "%"+ q + "%" , pageable);

        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            KategoriCatatanDto kategoriCatatanDto = k.toDto();
            if (k.getKategoriMutasi() != null) { kategoriCatatanDto.setKategoriMutasi(k.getKategoriMutasi().toDto()); }
            listSelect2.add(new Select2Default(String.valueOf(k.getId()), k.getId() + "-" + k.getNamaKategoriCatatan(), kategoriCatatanDto));
        });
        return listSelect2;
    }
}
