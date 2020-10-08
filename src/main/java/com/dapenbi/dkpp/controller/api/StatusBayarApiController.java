package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.StatusBayarDao;
import com.dapenbi.dkpp.dto.StatusBayarDto;
import com.dapenbi.dkpp.form.StatusBayarFormDto;
import com.dapenbi.dkpp.model.StatusBayar;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(PathPrefix.API + PathPrefix.STATUS_BAYAR)
public class StatusBayarApiController {

    @Autowired
    StatusBayarDao statusBayarDao;

    @GetMapping
    public Page<StatusBayarDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<StatusBayar> sIt = (Page<StatusBayar>) statusBayarDao.findAll(new String[] {"statusBayar"},"%" + searchParam + "%",pageRequest);

        Page<StatusBayarDto> statusBayarDto = sIt.map(s -> s.toDto());

        return statusBayarDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil>  addStatusBayar(@ModelAttribute StatusBayarFormDto statusBayarFormDto){
        StatusBayar statusBayar = new StatusBayar();

        statusBayar.setStatusBayar(statusBayarFormDto.getStatusBayar());
        StatusBayarDto dto = statusBayarDao.save(statusBayar).toDto();
        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);


    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateStatusBayar(@ModelAttribute StatusBayarFormDto statusBayarFormDto){
        StatusBayar statusBayar = statusBayarDao.findById(statusBayarFormDto.getId());

        statusBayar.setStatusBayar(statusBayarFormDto.getStatusBayar());
        statusBayar.setActive(statusBayarFormDto.getActive() !=null && statusBayarFormDto.getActive().size() > 0);
        StatusBayarDto dto = statusBayarDao.save(statusBayar).toDto();

        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }
        return new ResponseEntity<MessageUtil>(msg, HttpStatus.OK);
    }
}
