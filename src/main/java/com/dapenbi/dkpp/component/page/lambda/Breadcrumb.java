package com.dapenbi.dkpp.component.page.lambda;

import com.dapenbi.dkpp.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Breadcrumb implements Mustache.Lambda {
    private Mustache.Compiler compiler;

    public Breadcrumb(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List breadcrumbHolderComponentDto = new ArrayList();
        String compileResult = HtmlUtils.htmlUnescape(frag.execute()).trim().replaceAll("\\n", "");

        if (!StringUtil.isNullOrEmpty(compileResult)) {
            breadcrumbHolderComponentDto = mapper.readValue(compileResult, List.class);
        }

        Map<String, Object> breadcrumb = new HashMap<>();

        breadcrumb.put("crumb", breadcrumbHolderComponentDto);
        breadcrumb.put("display", breadcrumbHolderComponentDto.size() > 0);

        compiler.compile("{{>component/breadcrumbHolder}}").execute(breadcrumb, out);
    }
}