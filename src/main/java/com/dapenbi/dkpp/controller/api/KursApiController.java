package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriMutasiDao;
import com.dapenbi.dkpp.dao.KursDao;
import com.dapenbi.dkpp.dto.KategoriMutasiDto;
import com.dapenbi.dkpp.dto.KursDto;
import com.dapenbi.dkpp.form.KategoriMutasiFormDto;
import com.dapenbi.dkpp.form.KursFormDto;
import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.model.Kurs;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KURS)
public class KursApiController {

    @Autowired
    KursDao kursDao;

    @GetMapping
    public Page<KursDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<Kurs> pIt = (Page<Kurs>) kursDao.findAll(new String[]{"periodeMutasi"}, "%" + searchParam + "%", pageRequest);

        Page<KursDto> kursDto = pIt.map(p ->p.toDto() );
        return kursDto;
    }

    @GetMapping("/check-kurs-by-periode/{periodeMutasi}")
    public ResponseEntity<MessageUtil> checkKurs(@PathVariable String periodeMutasi){
        MessageUtil msg;
        Kurs kurs = this.kursDao.findFirstByPeriodeMutasi(periodeMutasi);
        if(kurs != null){
            msg = new MessageUtil("failed", "Sudah ada data kurs pada periode " + periodeMutasi);
        } else {
            msg = new MessageUtil("success", "OK");
        }

        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<MessageUtil> addKurs(@ModelAttribute KursFormDto kursFormDto){
        Kurs kurs = new Kurs();
        kurs.setPeriodeMutasi(kursFormDto.getPeriodeMutasi());
        kurs.setKursEuro(kursFormDto.getKursEuro());
        kurs.setKursRupiah(kursFormDto.getKursRupiah());
        kurs.setUserStamp(DkppUserStamp.postModeUserStamp());
        KursDto dto = kursDao.save(kurs).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateKurs(@ModelAttribute KursFormDto kursFormDto){
        Kurs kurs = kursDao.findFirstByPeriodeMutasi(kursFormDto.getPeriodeMutasi());
        kurs.setKursEuro(kursFormDto.getKursEuro());
        kurs.setKursRupiah(kursFormDto.getKursRupiah());
        kurs.setActive(kursFormDto.getActive() !=null && kursFormDto.getActive().size() > 0);
        kurs.setUserStamp(DkppUserStamp.putModeUserStamp());
        KursDto dto = kursDao.save(kurs).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }
}
