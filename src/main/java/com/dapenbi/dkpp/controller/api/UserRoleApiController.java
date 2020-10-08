package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.RoleDao;
import com.dapenbi.dkpp.dao.UserDao;
import com.dapenbi.dkpp.dao.UserRoleDao;
import com.dapenbi.dkpp.dto.UserRoleDto;
import com.dapenbi.dkpp.form.UserRoleFormDto;
import com.dapenbi.dkpp.model.User;
import com.dapenbi.dkpp.model.UserRole;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API+PathPrefix.USERROLE)
public class UserRoleApiController {

    private UserRoleDao userRoleDao;
    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public UserRoleApiController(UserRoleDao userRoleDao, UserDao userDao,RoleDao roleDao){
        this.userRoleDao = userRoleDao;
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @GetMapping
    public Page<UserRoleDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<UserRole> uIt = (Page<UserRole>) userRoleDao.findAll(new String[] {"idUser.email", "idRole.name"}, "%" + searchParam + "%", pageRequest);

        Page<UserRoleDto> userRoleDto = uIt.map(u ->{
            UserRoleDto dto = u.toDto();
            if (u.getIdUser()!=null) dto.setIdUser(u.getIdUser().toDto());
            if (u.getIdRole()!=null) dto.setIdRole(u.getIdRole().toDto());
            return dto;
        });

        return userRoleDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil>create(@ModelAttribute UserRoleFormDto userRoleFormDto){
        UserRole userRole = new UserRole();
        userRole.setIdUser(userDao.findById(userRoleFormDto.getIdUser()));
        userRole.setIdRole(roleDao.findById(userRoleFormDto.getIdRole()));
        UserRoleDto dto = userRoleDao.save(userRole).toDto();

        MessageUtil msg;
        if(dto != null){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil>Update(@ModelAttribute UserRoleFormDto userRoleFormDto){
        Boolean statusSave = userRoleDao.updateData(userRoleFormDto.getIdUser(),userRoleFormDto.getIdRole(),userRoleFormDto.getIdUserUpdate(),userRoleFormDto.getIdRoleUpdate());

        MessageUtil msg;
        if(statusSave == true){
            msg = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            msg = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
