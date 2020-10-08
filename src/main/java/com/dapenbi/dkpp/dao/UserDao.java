package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.UserDto;
import com.dapenbi.dkpp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDao extends UserDetailsService, BaseDao<User, UserDto, Long> {

    User findByUsernameOrEmail(String userLogin);

    User findByConfirmationKey(String confirmationKey);
}
