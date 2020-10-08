package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AgamaDao;
import com.dapenbi.dkpp.dto.AgamaDto;
import com.dapenbi.dkpp.form.AgamaFormDto;
import com.dapenbi.dkpp.model.Agama;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.AGAMA)
public class AgamanApiController extends DropdownApiController {

    @Autowired
    public AgamanApiController(AgamaDao agamaDao) {
        super(agamaDao);
    }

    @GetMapping
    public Page<AgamaDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        AgamaDao agamaDao = (AgamaDao) super.baseDao;

        Page<Agama> aIt = (Page<Agama>) agamaDao.findAll(new String[] {"namaAgama"},"%" + searchParam + "%",pageRequest);

        return aIt.map(Agama::toDto);
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addAgama(@ModelAttribute AgamaFormDto agamaFormDto){
        AgamaDao agamaDao = (AgamaDao) super.baseDao;

        Agama agama = new Agama();
        agama.setNamaAgama(agamaFormDto.getNamaAgama());
        AgamaDto dto = agamaDao.save(agama).toDto();

        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateAgama(@ModelAttribute AgamaFormDto agamaForm){
        AgamaDao agamaDao = (AgamaDao) super.baseDao;
        Agama agama = agamaDao.findById(agamaForm.getId());

        agama.setNamaAgama(agamaForm.getNamaAgama());
        agama.setActive(agamaForm.getActive() !=null && agamaForm.getActive().size() > 0);
        AgamaDto dto = agamaDao.save(agama).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }

        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
