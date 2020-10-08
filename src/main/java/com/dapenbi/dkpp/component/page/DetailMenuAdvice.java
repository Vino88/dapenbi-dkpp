package com.dapenbi.dkpp.component.page;

import com.dapenbi.dkpp.component.page.lambda.DetailMenu;
import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DetailMenuAdvice {

    private final Mustache.Compiler compiler;

    @Autowired
    public DetailMenuAdvice(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("detailMenu")
    public Mustache.Lambda card() {
        return new DetailMenu(compiler);
    }
}
