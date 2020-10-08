package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dao.RoleDao;
import com.dapenbi.dkpp.dao.UserDao;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.UserDto;
import com.dapenbi.dkpp.form.UserFormDto;
import com.dapenbi.dkpp.model.Role;
import com.dapenbi.dkpp.model.User;
import com.dapenbi.dkpp.util.BCryptHash;
import com.dapenbi.dkpp.util.MessageUtil;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.USER)
public class UserApiController extends DropdownApiController{

   private RoleDao roleDao;

   private UserDao userDao;

    @Autowired
    public UserApiController(UserDao userDao,RoleDao roleDao) {
        super(userDao);
        this.roleDao = roleDao;
    }

    @GetMapping
    public Page<UserDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        UserDao userDao = (UserDao) this.baseDao;

        Page<User> uIt = (Page<User>) userDao.findAll(new String[] {"name", "username", "email"}, "%" + searchParam + "%", pageRequest);

        Page<UserDto> userDto = uIt.map(u ->{
            UserDto dto = u.toDto();
            return dto;
        });

        return userDto;
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateUser(@ModelAttribute UserFormDto userForm) {
        UserDao userDao = (UserDao) this.baseDao;
        User user = userDao.findById(userForm.getId());

        user.setName(userForm.getName());
        user.setUsername(userForm.getUsername());
        user.setActive(userForm.getActive() != null && userForm.getActive().size() > 0);
        if (userForm.getActive() != null && userForm.getActive().size() > 0) {
            user.setLoginRetryCount(0);
        }
        if (!StringUtil.isNullOrEmpty(userForm.getNewPassword())) {
            user.setPassword(new BCryptHash().encode(userForm.getNewPassword()));
        }
        UserDto dto = userDao.save(user).toDto();

        MessageUtil msg;
        if (dto != null){
            msg = new MessageUtil("success", "Data Berhasil Dirubah");
        }else {
            msg = new MessageUtil("failed", "Data Gagal Dirubah");
        }

        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}