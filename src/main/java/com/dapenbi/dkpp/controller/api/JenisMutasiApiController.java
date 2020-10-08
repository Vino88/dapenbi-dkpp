package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.JenisMutasiDao;
import com.dapenbi.dkpp.dto.JenisMutasiDto;
import com.dapenbi.dkpp.form.JenisMutasiFormDto;
import com.dapenbi.dkpp.model.JenisMutasi;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.JENISMUTASI)
public class JenisMutasiApiController {

    @Autowired
    JenisMutasiDao jenisMutasiDao;

    @GetMapping
    public Page<JenisMutasiDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<JenisMutasi> pIt = (Page<JenisMutasi>) jenisMutasiDao.findAll(new String[]{"kodeMutasi","namaMutasi"}, "%" + searchParam + "%", pageRequest);

        Page<JenisMutasiDto> mutasiDto = pIt.map(p ->p.toDto() );
        return mutasiDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addJenisMutasi(@ModelAttribute JenisMutasiFormDto jenisMutasiFormDto){
        JenisMutasi jenisMutasi = new JenisMutasi();
        jenisMutasi.setKodeMutasi(jenisMutasiFormDto.getKodemutasi());
        jenisMutasi.setNamaMutasi(jenisMutasiFormDto.getNamamutasi());
        JenisMutasiDto dto = jenisMutasiDao.save(jenisMutasi).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateJenisMutasi(@ModelAttribute JenisMutasiFormDto jenisMutasiFormDto){
        JenisMutasi jenisMutasi = jenisMutasiDao.findByKode(jenisMutasiFormDto.getKodemutasi());

        jenisMutasi.setNamaMutasi(jenisMutasiFormDto.getNamamutasi());
        jenisMutasi.setActive(jenisMutasiFormDto.getActive() !=null && jenisMutasiFormDto.getActive().size() > 0);
        JenisMutasiDto dto = jenisMutasiDao.save(jenisMutasi).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }
}
