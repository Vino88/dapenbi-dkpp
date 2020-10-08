package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.StatusKawinDao;
import com.dapenbi.dkpp.dto.StatusKawinDto;
import com.dapenbi.dkpp.form.StatusKawinFormDto;
import com.dapenbi.dkpp.model.StatusKawin;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(PathPrefix.API + PathPrefix.STATUS_KAWIN)
public class StatusKawinApiController extends DropdownApiController {

    @Autowired
    public StatusKawinApiController(StatusKawinDao statusKawinDao) {
        super(statusKawinDao);
    }

    @GetMapping
    public Page<StatusKawinDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false)String searchParam){
        StatusKawinDao statusKawinDao = (StatusKawinDao) this.baseDao;

        Page<StatusKawin> sIt = (Page<StatusKawin>) statusKawinDao.findAll(new String[] {"statusKawin"},"%" + searchParam + "%",pageRequest);

        Page<StatusKawinDto> statusKawinDto = sIt.map(s -> s.toDto() );
        return statusKawinDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addStatusKawin(@ModelAttribute StatusKawinFormDto statusKawinFormDto){
        StatusKawinDao statusKawinDao = (StatusKawinDao) this.baseDao;

        StatusKawin statusKawin = new StatusKawin();

        statusKawin.setStatusKawin(statusKawinFormDto.getStatusKawin());
        StatusKawinDto dto = statusKawinDao.save(statusKawin).toDto();
        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public StatusKawinDto updateStatusKawin(@ModelAttribute StatusKawinFormDto statusKawinFormDto){
        StatusKawinDao statusKawinDao = (StatusKawinDao) this.baseDao;

        StatusKawin statusKawin = statusKawinDao.findById(statusKawinFormDto.getId());

        statusKawin.setStatusKawin(statusKawinFormDto.getStatusKawin());
        statusKawin.setActive(statusKawinFormDto.getActive() !=null && statusKawinFormDto.getActive().size()>0);

        return statusKawinDao.save(statusKawin).toDto();
    }
}
