package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MenuDao;
import com.dapenbi.dkpp.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.PEMBAYARAN)
public class PembayaranController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuUtil menuUtil;

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("menuDetail", menuUtil.getList(SecurityContextHolder.getContext(), menuDao, PathPrefix.PEMBAYARAN + "/"));
        model.put("headerDetail", "Pembayaran");
        model.put("menuTitle","Pembayaran");
        return "detailMenu";
    }
}
