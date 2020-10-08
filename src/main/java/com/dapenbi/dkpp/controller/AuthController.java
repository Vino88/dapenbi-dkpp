package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.component.Messages;
import com.dapenbi.dkpp.config.DkppConfig;
import com.dapenbi.dkpp.dao.RoleDao;
import com.dapenbi.dkpp.dao.UserDao;
import com.dapenbi.dkpp.dto.component.AlertMessageComponentDto;
import com.dapenbi.dkpp.form.ForgotPasswordForm;
import com.dapenbi.dkpp.form.SignupForm;
import com.dapenbi.dkpp.model.Role;
import com.dapenbi.dkpp.model.User;
import com.dapenbi.dkpp.util.BCryptHash;
import com.dapenbi.dkpp.component.Email;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.AUTH)
public class AuthController {

    UserDao userDao;

    RoleDao roleDao;

    Messages messages;

    Email email;

    @Autowired
    public AuthController(UserDao userDao, RoleDao roleDao, Messages messages, Email email) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.messages = messages;
        this.email = email;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/forgot")
    public String forgot() {
        return "auth/forgot";
    }

    @GetMapping("/signup")
    public String signup() {
        return "auth/signup";
    }

    @PostMapping("/porsessignup")
    public String createUser(@ModelAttribute SignupForm signupForm, HttpServletRequest request) {
        User user = new User();
        user.setActive(false);
        user.setUsername(signupForm.getUsername());
        user.setEmail(signupForm.getEmail());
        user.setName(signupForm.getName());
        user.setPassword(new BCryptHash().encode(signupForm.getPassword()));
        user.setLoginRetryCount(0);
        user.setLastLogin(new Date());
        user.setLastLoginIP(request.getRemoteAddr());
        user.setRoles(new ArrayList<Role>() {{
            add(roleDao.findOneByCode("ROLE_USER"));
        }});
        user.setConfirmationKey(StringUtil.createRandomString(85));
        userDao.save(user);

        email.initializeEmail("confirmationEmail", user.toDto(), messages.get("email.confirmation.subject"));
        email.setTo(user.getEmail());
        email.sendMail();

        request.getSession().setAttribute(
            DkppConfig.LOGIN_MESSAGE,
            new AlertMessageComponentDto("bg-success", messages.get("user.signup.success"))
        );

        return "redirect:/auth/login";
    }

    @GetMapping("/confirm-account")
    public String confirmAccount(@RequestParam(required = true) String confirmationKey, HttpServletRequest request) {
        User user = userDao.findByConfirmationKey(confirmationKey);
        if (user == null) {
            request.getSession().setAttribute(
                DkppConfig.LOGIN_MESSAGE,
                new AlertMessageComponentDto("bg-danger", messages.get("user.confirmation.error"))
            );
        } else {
            if (user.isActive()) {
                request.getSession().setAttribute(
                    DkppConfig.LOGIN_MESSAGE,
                    new AlertMessageComponentDto("bg-warning", messages.get("user.confirmation.warning"))
                );
            } else {
                user.setActive(true);
                userDao.save(user);

                request.getSession().setAttribute(
                    DkppConfig.LOGIN_MESSAGE,
                    new AlertMessageComponentDto("bg-success", messages.get("user.confirmation.success"))
                );
            }
        }
        return "redirect:/auth/login";
    }

    @PostMapping("/forgot-password")
    public String sendForgotPassword(@ModelAttribute ForgotPasswordForm forgotPasswordForm, HttpServletRequest request) {
        User user = userDao.findByUsernameOrEmail(forgotPasswordForm.getEmail());

        email.initializeEmail("confirmationForgotPasswordEmail", user.toDto(), messages.get("email.confirmationForgotPassword.subject"));
        email.setTo(user.getEmail());
        email.sendMail();

        request.getSession().setAttribute(
                DkppConfig.LOGIN_MESSAGE,
                new AlertMessageComponentDto("bg-success", messages.get("user.forgot.success"))
        );

        return "redirect:/auth/login";
    }

    @GetMapping("/confirm-account-forgot")
    public String confirmAccountForgot(@RequestParam(required = true) String confirmationKey, HttpServletRequest request, Map<String, Object> model) {
    model.put("confirmationKey",confirmationKey);

        return "auth/changePassword";
    }

    @PostMapping("/change-password")
    public String changePasswordAccount(@ModelAttribute ForgotPasswordForm forgotPasswordForm, HttpServletRequest request) {
        User user = userDao.findByConfirmationKey(forgotPasswordForm.getConfirmationKey());
        user.setPassword(new BCryptHash().encode(forgotPasswordForm.getPassword()));
        user.setConfirmationKey(StringUtil.createRandomString(85));
        userDao.save(user);
        if (user == null) {
            request.getSession().setAttribute(
                    DkppConfig.LOGIN_MESSAGE,
                    new AlertMessageComponentDto("bg-danger", messages.get("user.confirmation.error"))
            );
        } else {
            if (user.isActive()) {
                request.getSession().setAttribute(
                        DkppConfig.LOGIN_MESSAGE,
                        new AlertMessageComponentDto("bg-warning", messages.get("user.confirmation.warning"))
                );
            } else {
                user.setActive(true);
                userDao.save(user);

                request.getSession().setAttribute(
                        DkppConfig.LOGIN_MESSAGE,
                        new AlertMessageComponentDto("bg-success", messages.get("user.confirmation.success"))
                );
            }
        }

        return "redirect:/auth/login";
    }
}
