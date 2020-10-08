package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KecamatanDao;
import com.dapenbi.dkpp.dao.KelurahanDao;
import com.dapenbi.dkpp.dto.KecamatanDto;
import com.dapenbi.dkpp.dto.KelurahanDto;
import com.dapenbi.dkpp.dto.KotaDto;
import com.dapenbi.dkpp.dto.ProvinsiDto;
import com.dapenbi.dkpp.form.KelurahanFormDto;
import com.dapenbi.dkpp.model.Kecamatan;
import com.dapenbi.dkpp.model.Kelurahan;
import com.dapenbi.dkpp.model.Kota;
import com.dapenbi.dkpp.model.Provinsi;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KELURAHAN)
public class KelurahanApiController extends DropdownApiController {

    KecamatanDao kecamatanDao;

    @Autowired
    public KelurahanApiController(KelurahanDao kelurahanDao, KecamatanDao kecamatanDao)  {
        super(kelurahanDao);
        this.kecamatanDao = kecamatanDao;
    }

    @GetMapping
    public Page<KelurahanDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        KelurahanDao kelurahanDao = (KelurahanDao) this.baseDao;

        Page<Kelurahan> pIt = (Page<Kelurahan>) kelurahanDao.findAll(new String[]{"namaKelurahan"}, "%" + searchParam + "%", pageRequest);
        Page<KelurahanDto> kelurahanDto = pIt.map(k -> {
            KelurahanDto dto = k.toDto();
            Kecamatan kecamatan = k.getKecamatan();
            Kota kota = kecamatan.getKota();
            Provinsi provinsi = kota.getProvinsi();
            KecamatanDto kecamatanDto = kecamatan.toDto();
            KotaDto kotaDto = kota.toDto();
            ProvinsiDto provinsiDto = provinsi.toDto();

            kotaDto.setProvinsi(provinsiDto);
            kecamatanDto.setKota(kotaDto);
            dto.setKecamatan(kecamatanDto);

            return dto;
        });
        return kelurahanDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKelurahan(@ModelAttribute KelurahanFormDto kelurahanFormDto) {
        KelurahanDao kelurahanDao = (KelurahanDao) this.baseDao;

        Kelurahan kelurahan = new Kelurahan();
        kelurahan.setNamaKelurahan(kelurahanFormDto.getNamaKelurahan());
        kelurahan.setKecamatan(kecamatanDao.findById(kelurahanFormDto.getIdKecamatan()));
        kelurahan.setUserStamp(DkppUserStamp.postModeUserStamp());
        KelurahanDto dto = kelurahanDao.save(kelurahan).toDto();
        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKelurahan(@ModelAttribute KelurahanFormDto kelurahanFormDto) {
        KelurahanDao kelurahanDao = (KelurahanDao) this.baseDao;

        Kelurahan kelurahan = kelurahanDao.findById(kelurahanFormDto.getId());

        kelurahan.setNamaKelurahan(kelurahanFormDto.getNamaKelurahan());
        kelurahan.setActive(kelurahanFormDto.getActive() !=null && kelurahanFormDto.getActive().size() > 0);
        kelurahan.setKecamatan(kecamatanDao.findById(kelurahanFormDto.getIdKecamatan()));
        kelurahan.setUserStamp(DkppUserStamp.putModeUserStamp());
        KelurahanDto dto = kelurahanDao.save(kelurahan).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
