package com.dapenbi.dkpp.component.page;

import com.dapenbi.dkpp.component.page.lambda.SortableList;
import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SortableListAdvice {

    private final Mustache.Compiler compiler;

    @Autowired
    public SortableListAdvice(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("sortableList")
    public Mustache.Lambda sortableList() {
        return new SortableList(compiler);
    }
}
