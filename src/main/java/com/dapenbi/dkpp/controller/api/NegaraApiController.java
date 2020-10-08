package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.NegaraDao;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dto.NegaraDto;
import com.dapenbi.dkpp.dto.ProvinsiDto;
import com.dapenbi.dkpp.form.NegaraFormDto;
import com.dapenbi.dkpp.form.ProvinsiFormDto;
import com.dapenbi.dkpp.model.Negara;
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
@RequestMapping(PathPrefix.API + PathPrefix.NEGARA)
public class NegaraApiController extends DropdownApiController {

    @Autowired
    public NegaraApiController(NegaraDao negaraDao) {
        super(negaraDao);
    }

    @GetMapping
    public Page<NegaraDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        NegaraDao provinsiDao = (NegaraDao) this.baseDao;

        Page<Negara> pIt = (Page<Negara>) provinsiDao.findAll(new String[]{"namaNegara"}, "%" + searchParam + "%", pageRequest);

        return pIt.map(Negara::toDto);
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addNegara(@ModelAttribute NegaraFormDto negaraFormDto) {

        Negara negara = new Negara();

        if (getNegaraDto(negaraFormDto, negara) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Ditambahkan"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Ditambahkan"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateNegara(@ModelAttribute NegaraFormDto negaraFormDto) {
        NegaraDao negaraDao = (NegaraDao) super.baseDao;
        Negara negara = negaraDao.findById(negaraFormDto.getId());

        if (getNegaraDto(negaraFormDto, negara) != null) {
            return new ResponseEntity<>(new MessageUtil("success","Data Berhasil Dirubah"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageUtil("failed","Data Gagal Dirubah"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private NegaraDto getNegaraDto(NegaraFormDto negaraFormDto , Negara negara) {
        NegaraDao negaraDao = (NegaraDao) super.baseDao;
        negara.setId(negaraFormDto.getId());
        negara.setNamaNegara(negaraFormDto.getNamaNegara());
        negara.setActive(negaraFormDto.getActive() != null && negaraFormDto.getActive().size() > 0);
        negara.setUserStamp(DkppUserStamp.postModeUserStamp());
        return negaraDao.save(negara).toDto();
    }
}
