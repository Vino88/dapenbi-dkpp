package com.dapenbi.dkpp.component.page;

import com.dapenbi.dkpp.component.page.lambda.AlertMessages;
import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class AlertMessagesAdvice {

    private final Mustache.Compiler compiler;

    @Autowired
    public AlertMessagesAdvice(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("alertMessages")
    public Mustache.Lambda alertMessages() {
        return new AlertMessages(compiler);
    }
}
