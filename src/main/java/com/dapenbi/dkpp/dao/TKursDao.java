package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.TKursDto;
import com.dapenbi.dkpp.form.CuspKursSPDto;
import com.dapenbi.dkpp.model.TKurs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface TKursDao extends BaseDao<TKurs, TKursDto, String> {
    Map processCuspKurs(CuspKursSPDto spDto);
}