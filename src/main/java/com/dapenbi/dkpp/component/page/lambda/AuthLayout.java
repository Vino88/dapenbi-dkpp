package com.dapenbi.dkpp.component.page.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.IOException;
import java.io.Writer;

public class AuthLayout implements Mustache.Lambda {
    String body;

    private Mustache.Compiler compiler;

    public AuthLayout(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        body = frag.execute();
        compiler.compile("{{>layout/authLayout}}").execute(frag.context(), out);
    }
}