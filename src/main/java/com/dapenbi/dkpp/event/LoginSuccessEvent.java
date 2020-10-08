package com.dapenbi.dkpp.event;

import com.dapenbi.dkpp.dao.UserDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.UserDto;
import com.dapenbi.dkpp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoginSuccessEvent implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    UserDao userDao;

    @Autowired
    public LoginSuccessEvent(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        Authentication userAuth = event.getAuthentication();
        WebAuthenticationDetails details = (WebAuthenticationDetails) userAuth.getDetails();
        String remoteAddress = details.getRemoteAddress();

        UserDto userDto = null;
        if (event.getSource() instanceof UsernamePasswordAuthenticationToken) {
            userDto = ((DkppUserDetail) ((UsernamePasswordAuthenticationToken) event.getSource()).getPrincipal()).getUser();
        } else {
            userDto = ((DkppUserDetail) ((RememberMeAuthenticationToken) event.getSource()).getPrincipal()).getUser();
        }

        User user = this.userDao.findById(userDto.getId());
        user.setLastLogin(new Date());
        user.setLastLoginIP(remoteAddress);
        user.setLoginRetryCount(0);

        this.userDao.save(user);
    }
}
