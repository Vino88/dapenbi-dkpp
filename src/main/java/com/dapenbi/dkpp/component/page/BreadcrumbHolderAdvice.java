package com.dapenbi.dkpp.component.page;

import com.dapenbi.dkpp.component.page.lambda.Breadcrumb;
import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class BreadcrumbHolderAdvice {

    private final Mustache.Compiler compiler;

    @Autowired
    public BreadcrumbHolderAdvice(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("breadcrumbHolder")
    public Mustache.Lambda card() {
        return new Breadcrumb(compiler);
    }
}
