package com.dapenbi.dkpp.event;

import com.dapenbi.dkpp.dao.UserDao;
import com.dapenbi.dkpp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class LoginFailureEvent implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    UserDao userDao;

    @Autowired
    public LoginFailureEvent(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String userLogin = (String) ((UsernamePasswordAuthenticationToken) event.getSource()).getPrincipal();

        User user = this.userDao.findByUsernameOrEmail(userLogin);
        if (user != null){
            user.setLoginRetryCount(user.getLoginRetryCount() + 1);
            this.userDao.save(user);
        }
    }
}
