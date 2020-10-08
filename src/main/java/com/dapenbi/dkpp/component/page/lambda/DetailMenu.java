package com.dapenbi.dkpp.component.page.lambda;

import com.dapenbi.dkpp.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class DetailMenu implements Mustache.Lambda {
    private Mustache.Compiler compiler;

    public DetailMenu(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List detailMenuDto = new ArrayList();
        String compileResult = HtmlUtils.htmlUnescape(frag.execute()).trim().replaceAll("\\n", "");

        if (!StringUtil.isNullOrEmpty(compileResult)) {
            detailMenuDto = mapper.readValue(compileResult, List.class);
        }

        compiler.compile("{{>component/detailMenu}}").execute(detailMenuDto.toArray(), out);
    }
}