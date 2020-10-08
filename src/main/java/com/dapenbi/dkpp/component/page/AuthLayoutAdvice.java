package com.dapenbi.dkpp.component.page;

import com.dapenbi.dkpp.component.page.lambda.AuthLayout;
import com.dapenbi.dkpp.config.DkppConfig;
import com.dapenbi.dkpp.dto.component.AlertMessageComponentDto;
import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
class AuthLayoutAdvice {
    private final Mustache.Compiler compiler;

    @Autowired
    public AuthLayoutAdvice(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("authLayout")
    public Mustache.Lambda layout() {
        return new AuthLayout(compiler);
    }

    @ModelAttribute("loginError")
    public AlertMessageComponentDto error(HttpServletRequest request) {
        if (request.getSession().getAttribute(DkppConfig.LOGIN_MESSAGE) != null) {
            Object message = request.getSession().getAttribute(DkppConfig.LOGIN_MESSAGE);
            request.getSession().removeAttribute(DkppConfig.LOGIN_MESSAGE);
            return (AlertMessageComponentDto) message;
        } else if (request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) != null) {
            Exception exception = (Exception) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            return new AlertMessageComponentDto("bg-danger", exception.getMessage());
        }

        return null;
    }
}