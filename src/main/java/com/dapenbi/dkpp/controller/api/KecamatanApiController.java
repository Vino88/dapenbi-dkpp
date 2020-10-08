package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KecamatanDao;
import com.dapenbi.dkpp.dao.KotaDao;
import com.dapenbi.dkpp.dto.KecamatanDto;
import com.dapenbi.dkpp.form.KecamatanFormDto;
import com.dapenbi.dkpp.model.Kecamatan;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KECAMATAN)
public class KecamatanApiController extends DropdownApiController {

    KotaDao kotaDao;

    @Autowired
    public KecamatanApiController(KecamatanDao kecamatanDao, KotaDao kotaDao) {
        super(kecamatanDao);
        this.kotaDao = kotaDao;
    }

    @GetMapping
    public Page<KecamatanDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        KecamatanDao kecamatanDao = (KecamatanDao) this.baseDao;

        Page<Kecamatan> pIt = (Page<Kecamatan>) kecamatanDao.findAll(new String[]{"namaKecamatan"}, "%" + searchParam + "%", pageRequest);
        Page<KecamatanDto> kecamatanDto = pIt.map(p->{
            KecamatanDto dto = p.toDto();
            if(p.getKota() !=null)dto.setKota(p.getKota().toDto());
            return dto;
        });
        return kecamatanDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKecamatan(@ModelAttribute KecamatanFormDto kecamatanFormDto){
        KecamatanDao kecamatanDao = (KecamatanDao) this.baseDao;

        Kecamatan kecamatan = new Kecamatan();
        kecamatan.setNamaKecamatan(kecamatanFormDto.getNamaKecamatan());
        kecamatan.setKota(kotaDao.findById(kecamatanFormDto.getIdkota()));
        kecamatan.setUserStamp(DkppUserStamp.postModeUserStamp());
        KecamatanDto dto = kecamatanDao.save(kecamatan).toDto();
        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKecamatan(@ModelAttribute KecamatanFormDto kecamatanFormDto){
        KecamatanDao kecamatanDao = (KecamatanDao) this.baseDao;

        Kecamatan kecamatan = kecamatanDao.findById(kecamatanFormDto.getId());
        kecamatan.setNamaKecamatan(kecamatanFormDto.getNamaKecamatan());
        kecamatan.setKota(kotaDao.findById(kecamatanFormDto.getIdkota()));
        kecamatan.setActive(kecamatanFormDto.getActive() !=null && kecamatanFormDto.getActive().size() > 0);
        kecamatan.setUserStamp(DkppUserStamp.putModeUserStamp());
        KecamatanDto dto = kecamatanDao.save(kecamatan).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }
}
