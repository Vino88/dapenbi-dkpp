package com.dapenbi.dkpp.component.page.lambda;

import com.dapenbi.dkpp.dto.component.CardComponentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.io.Writer;

public class Card implements Mustache.Lambda {
    private Mustache.Compiler compiler;

    public Card(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CardComponentDto cardComponentDto = mapper.readValue(HtmlUtils.htmlUnescape(frag.execute()), CardComponentDto.class);

        compiler.compile("{{>component/card}}").execute(cardComponentDto, out);
    }
}