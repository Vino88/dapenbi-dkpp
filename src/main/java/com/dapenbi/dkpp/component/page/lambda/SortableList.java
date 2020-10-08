package com.dapenbi.dkpp.component.page.lambda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class SortableList implements Mustache.Lambda {
    private Mustache.Compiler compiler;

    public SortableList(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List sortableListDto = mapper.readValue(HtmlUtils.htmlUnescape(frag.execute()), List.class);

        compiler.compile("{{>component/sortableList}}").execute(sortableListDto, out);
    }
}