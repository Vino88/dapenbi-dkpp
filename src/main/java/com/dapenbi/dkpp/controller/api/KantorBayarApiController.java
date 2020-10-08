package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KantorBayarDao;
import com.dapenbi.dkpp.dto.KantorBayarDto;
import com.dapenbi.dkpp.form.KantorBayarFormDto;
import com.dapenbi.dkpp.model.KantorBayar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(PathPrefix.API + PathPrefix.KANTOR_BAYAR)
public class KantorBayarApiController extends DropdownApiController {

    @Autowired
    public KantorBayarApiController(KantorBayarDao kantorBayarDao) {
        super(kantorBayarDao);
    }

    @GetMapping
    public Page<KantorBayarDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        KantorBayarDao kantorBayarDao = (KantorBayarDao) this.baseDao;

        Page<KantorBayar> aIt = (Page<KantorBayar>) kantorBayarDao.findAll(new String[] {"id","namaKantorBayar", "alamatSurat1", "alamatSurat2", "alamatSurat3", "alamatSurat3"}, "%" + searchParam + "%", pageRequest);

        Page<KantorBayarDto> kantorBayarDto = aIt.map(KantorBayar::toDto);

        return kantorBayarDto;
    }

    @PostMapping
    public KantorBayarDto addKantorBayar(@ModelAttribute KantorBayarFormDto kantorBayarFormDto){
        KantorBayarDao kantorBayarDao = (KantorBayarDao) this.baseDao;

        KantorBayar kantorBayar = new KantorBayar();
        kantorBayar.setId(kantorBayarFormDto.getId());
        kantorBayar.setNamaKantorBayar(kantorBayarFormDto.getNamaKantorBayar());
        kantorBayar.setAlamatSurat1(kantorBayarFormDto.getAlamatSurat1());
        kantorBayar.setAlamatSurat2(kantorBayarFormDto.getAlamatSurat2());
        kantorBayar.setAlamatSurat3(kantorBayarFormDto.getAlamatSurat3());
        kantorBayar.setAlamatSurat4(kantorBayarFormDto.getAlamatSurat4());
        kantorBayar.setActive(kantorBayarFormDto.getActive() != null && kantorBayarFormDto.getActive().size() > 0);
        return kantorBayarDao.save(kantorBayar).toDto();
    }

    @PutMapping
    public KantorBayarDto updateKantorBayar(@ModelAttribute KantorBayarFormDto kantorBayarFormDto){
        KantorBayarDao kantorBayarDao = (KantorBayarDao) this.baseDao;

        KantorBayar kantorBayar = kantorBayarDao.findById(kantorBayarFormDto.getId());
        kantorBayar.setNamaKantorBayar(kantorBayarFormDto.getNamaKantorBayar());
        kantorBayar.setAlamatSurat1(kantorBayarFormDto.getAlamatSurat1());
        kantorBayar.setAlamatSurat2(kantorBayarFormDto.getAlamatSurat2());
        kantorBayar.setAlamatSurat3(kantorBayarFormDto.getAlamatSurat3());
        kantorBayar.setAlamatSurat4(kantorBayarFormDto.getAlamatSurat4());
        kantorBayar.setActive(kantorBayarFormDto.getActive() != null && kantorBayarFormDto.getActive().size() > 0);

        return kantorBayarDao.save(kantorBayar).toDto();
    }
}
