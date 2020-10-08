package com.dapenbi.dkpp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterDataMenuController {

    @RequestMapping("/amat")
    public String hello(){
        return "Hi";
    }
}
