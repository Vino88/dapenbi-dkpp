package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.AlasanHentiDao;
import com.dapenbi.dkpp.dto.AlasanHentiDto;
import com.dapenbi.dkpp.form.AlasanHentiFormDto;
import com.dapenbi.dkpp.model.AlasanHenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(PathPrefix.API + PathPrefix.ALASAN_HENTI)
public class AlasanHentiApiController extends DropdownApiController {

    @Autowired
    public AlasanHentiApiController(AlasanHentiDao alasanHentiDao) {
        super(alasanHentiDao);
    }

    @GetMapping
    public Page<AlasanHentiDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        AlasanHentiDao alasanHentiDao = (AlasanHentiDao) super.baseDao;

        Page<AlasanHenti> aIt = (Page<AlasanHenti>) alasanHentiDao.findAll(new String[] {"keterangan"}, "%" + searchParam + "%", pageRequest);

        return aIt.map(AlasanHenti::toDto);
    }

    @GetMapping("/{id}")
    public AlasanHentiDto detail(@PathVariable("id") String id) {
        AlasanHentiDao alasanHentiDao = (AlasanHentiDao) this.baseDao;

        return alasanHentiDao.findById(id).toDto();
    }

    @PostMapping
    public AlasanHentiDto addAlasanHenti(@ModelAttribute AlasanHentiFormDto alasanHentiFormDto){
        AlasanHentiDao alasanHentiDao = (AlasanHentiDao) super.baseDao;

        AlasanHenti alasanHenti = new AlasanHenti();
        alasanHenti.setUrutan(2);
        alasanHenti.setKeterangan(alasanHentiFormDto.getKeterangan());

        return alasanHentiDao.save(alasanHenti).toDto();
    }

    @PutMapping
    public AlasanHentiDto updateAlasanHenti(@ModelAttribute AlasanHentiFormDto alasanHentiFormDto){
        AlasanHentiDao alasanHentiDao = (AlasanHentiDao) super.baseDao;

        AlasanHenti alasanHenti = (AlasanHenti) super.baseDao.findById(alasanHentiFormDto.getId());
        alasanHenti.setKeterangan(alasanHentiFormDto.getKeterangan());
        alasanHenti.setActive(alasanHentiFormDto.getActive() != null && alasanHentiFormDto.getActive().size() > 0);

        return alasanHentiDao.save(alasanHenti).toDto();
    }

}
