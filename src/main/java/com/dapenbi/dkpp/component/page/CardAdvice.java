package com.dapenbi.dkpp.component.page;

import com.dapenbi.dkpp.component.page.lambda.Card;
import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CardAdvice {

    private final Mustache.Compiler compiler;

    @Autowired
    public CardAdvice(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @ModelAttribute("card")
    public Mustache.Lambda card() {
        return new Card(compiler);
    }
}
