package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dao.UsiaBayarDao;
import com.dapenbi.dkpp.dto.ProvinsiDto;
import com.dapenbi.dkpp.dto.UsiaBayarDto;
import com.dapenbi.dkpp.form.ProvinsiFormDto;
import com.dapenbi.dkpp.form.UsiaBayarFormDto;
import com.dapenbi.dkpp.model.Provinsi;
import com.dapenbi.dkpp.model.UsiaBayar;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.USIABAYAR)
public class UsiaBayarApiController extends DropdownApiController {

    public UsiaBayarApiController(UsiaBayarDao usiaBayarDao) {
        super(usiaBayarDao);
    }

    @GetMapping
    public Page<UsiaBayarDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        UsiaBayarDao usiaBayarDao = (UsiaBayarDao) this.baseDao;

        Page<UsiaBayar> pIt = (Page<UsiaBayar>) usiaBayarDao.findAll(new String[]{"namaUsiaBayar"}, "%" + searchParam + "%", pageRequest);

        Page<UsiaBayarDto> usiaBayarDto = pIt.map(p ->p.toDto() );
        return usiaBayarDto;
    }

    @GetMapping("/{id}")
    public UsiaBayarDto detail(@PathVariable("id") Long id) {
        UsiaBayarDao usiaBayarDao = (UsiaBayarDao) this.baseDao;

        return usiaBayarDao.findById(id).toDto();
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addUsiaBayar(@ModelAttribute UsiaBayarFormDto usiaBayarFormDto){
        UsiaBayarDao usiaBayarDao = (UsiaBayarDao) this.baseDao;

        UsiaBayar usiaBayar = new UsiaBayar();
        usiaBayar.setNamaUsiaBayar(usiaBayarFormDto.getNamaUsiaBayar());
        usiaBayar.setUserStamp(DkppUserStamp.postModeUserStamp());
        UsiaBayarDto dto = usiaBayarDao.save(usiaBayar).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateUsiaBayar(@ModelAttribute UsiaBayarFormDto usiaBayarFormDto){
        UsiaBayarDao usiaBayarDao = (UsiaBayarDao) this.baseDao;

        UsiaBayar usiaBayar = usiaBayarDao.findById(usiaBayarFormDto.getId());

        usiaBayar.setNamaUsiaBayar(usiaBayarFormDto.getNamaUsiaBayar());
        usiaBayar.setActive(usiaBayarFormDto.getActive() !=null && usiaBayarFormDto.getActive().size() > 0);
        usiaBayar.setUserStamp(DkppUserStamp.putModeUserStamp());
        UsiaBayarDto dto = usiaBayarDao.save(usiaBayar).toDto();
        MessageUtil msg;

        if(dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
