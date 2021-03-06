package com.dapenbi.dkpp.controller;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.USER)
public class UserProfileController extends MasterDataController {

    @GetMapping
    public String index(Map<String, Object> model) {
        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(PathPrefix.USER, "Profile"));

        model.put("breadcrumb", breadcrumb);
        return "user/profile";
    }

}
