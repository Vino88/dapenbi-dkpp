package com.dapenbi.dkpp.component.page.lambda;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.IOException;
import java.io.Writer;

public class Layout implements Mustache.Lambda {
    public String body;

    public String title = "DKPP";

    public String styles = "";

    public String scripts = "";

    public String modal = "";

    private Mustache.Compiler compiler;

    public Layout(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        body = frag.execute();
        compiler.compile("{{>layout/mainLayout}}").execute(frag.context(), out);
    }
}