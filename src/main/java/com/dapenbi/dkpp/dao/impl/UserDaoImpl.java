package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.UserDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.UserDto;
import com.dapenbi.dkpp.model.User;
import com.dapenbi.dkpp.repository.UserRepository;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class UserDaoImpl extends BaseDaoImpl<User, UserDto, Long> implements UserDao {

    private UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsernameOrEmail(String userLogin) {
        return StringUtil.isEmail(userLogin) ?
                userRepository.findOneByEmail(userLogin) :
                userRepository.findOneByUsername(userLogin);
    }

    @Override
    public User findByConfirmationKey(String confirmationKey) {
        return userRepository.findOneByConfirmationKey(confirmationKey);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final User user = StringUtil.isEmail(username) ?
                userRepository.findOneByEmail(username) :
                userRepository.findOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        UserDto userDto = user.toDto();
        userDto.setRoles(user.getRoles().stream().map(role -> role.toDto()).collect(Collectors.toList()));

        return new DkppUserDetail(userDto);
    }
}
