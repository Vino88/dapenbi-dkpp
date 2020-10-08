package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.form.DropdownFormDto;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public abstract class DropdownApiController {

    BaseDao baseDao;

    public DropdownApiController(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @GetMapping(PathPrefix.DROPDOWN)
    public List dropdown(@ModelAttribute DropdownFormDto dropdownParam, @RequestParam(name = "searchColumn[]", required = false) List<String> searchColumn) {
        if(dropdownParam.getReferenceValueType() == null || dropdownParam.getReferenceValueType().equals(""))
            return baseDao.getDropdownList(dropdownParam.getValueColumn(), dropdownParam.getTextColumn(), searchColumn, "%" + dropdownParam.getSearchParam() + "%", dropdownParam.getReferenceValue(), dropdownParam.getIncludeObject() == null ? false : dropdownParam.getIncludeObject());
        else
            return baseDao.getDropdownList(dropdownParam.getValueColumn(), dropdownParam.getTextColumn(), searchColumn, "%" + dropdownParam.getSearchParam() + "%", dropdownParam.getReferenceValue(), dropdownParam.getReferenceValueType(), dropdownParam.getIncludeObject() == null ? false : dropdownParam.getIncludeObject());
    }
}
