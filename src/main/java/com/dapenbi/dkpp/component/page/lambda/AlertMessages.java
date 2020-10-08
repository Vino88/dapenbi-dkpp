package com.dapenbi.dkpp.component.page.lambda;

import com.dapenbi.dkpp.dto.component.AlertMessageComponentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.io.Writer;

public class AlertMessages implements Mustache.Lambda {
    private Mustache.Compiler compiler;

    public AlertMessages(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AlertMessageComponentDto alertMessage = mapper.readValue(HtmlUtils.htmlUnescape(frag.execute()), AlertMessageComponentDto.class);

        compiler.compile("{{>component/alertMessage}}").execute(alertMessage, out);
    }
}