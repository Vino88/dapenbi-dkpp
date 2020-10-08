package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.RoleDao;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.RoleFormDto;
import com.dapenbi.dkpp.model.Role;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(PathPrefix.API+PathPrefix.ROLE)
public class RoleApiController extends DropdownApiController{


    @Autowired
    public RoleApiController(RoleDao roleDao){
        super(roleDao);
    }

    @GetMapping
    public Page<RoleDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        RoleDao roleDao = (RoleDao) super.baseDao;

        Page<Role> aIt = (Page<Role>) roleDao.findAll(new String[] {"code","name"},"%" + searchParam + "%",pageRequest);

        return aIt.map(Role::toDto);
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addAgama(@ModelAttribute RoleFormDto roleFormDto){
        RoleDao roleDao = (RoleDao) super.baseDao;

        Role role = new Role();
        role.setCode(roleFormDto.getCode());
        role.setName(roleFormDto.getName());
        RoleDto dto = roleDao.save(role).toDto();

        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success","Data Berhasil Ditambahkan");
        }else {
            msg = new MessageUtil("failed","Data Gagal Ditambahkan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateAgama(@ModelAttribute RoleFormDto roleFormDto){
        RoleDao roleDao = (RoleDao) super.baseDao;
        Role role = roleDao.findById(roleFormDto.getIdRole());

        role.setCode(roleFormDto.getCode());
        role.setName(roleFormDto.getName());
        role.setActive(roleFormDto.getIsActive() !=null && roleFormDto.getIsActive().size() > 0);
        RoleDto dto = roleDao.save(role).toDto();
        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }

        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

}
