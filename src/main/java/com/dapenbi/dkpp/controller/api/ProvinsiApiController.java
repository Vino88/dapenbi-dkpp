package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dto.ProvinsiDto;
import com.dapenbi.dkpp.form.ProvinsiFormDto;
import com.dapenbi.dkpp.model.Provinsi;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PROVINSI)
public class ProvinsiApiController extends DropdownApiController {

    @Autowired
    public ProvinsiApiController(ProvinsiDao provinsiDao) {
        super(provinsiDao);
    }

    @GetMapping
    public Page<ProvinsiDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        ProvinsiDao provinsiDao = (ProvinsiDao) this.baseDao;

        Page<Provinsi> pIt = (Page<Provinsi>) provinsiDao.findAll(new String[]{"namaProvinsi"}, "%" + searchParam + "%", pageRequest);

        Page<ProvinsiDto> provinsiDto = pIt.map(Provinsi::toDto);

        return provinsiDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addProvinsi(@ModelAttribute ProvinsiFormDto provinsiFormDto) {
        ProvinsiDao provinsiDao = (ProvinsiDao) this.baseDao;

        Provinsi provinsi = new Provinsi();
        provinsi.setNamaProvinsi(provinsiFormDto.getNamaProvinsi());
        ProvinsiDto dto = provinsiDao.save(provinsi).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateProvinsi(@ModelAttribute ProvinsiFormDto provinsiFormDto){
        ProvinsiDao provinsiDao = (ProvinsiDao) this.baseDao;

        Provinsi provinsi = provinsiDao.findById(provinsiFormDto.getId());
        provinsi.setNamaProvinsi(provinsiFormDto.getNamaProvinsi());
        provinsi.setActive(provinsiFormDto.getActive() !=null && provinsiFormDto.getActive().size() > 0);
        ProvinsiDto dto = provinsiDao.save(provinsi).toDto();
        MessageUtil msg;

        if (dto != null) {
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        } else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
