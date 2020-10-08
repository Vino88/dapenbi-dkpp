package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.KenaikanMpDto;
import com.dapenbi.dkpp.form.CuspKenaikanMpSPDto;
import com.dapenbi.dkpp.model.KenaikanMp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface KenaikanMpDao extends BaseDao<KenaikanMp, KenaikanMpDto, Long> {
    Map processCuspKenaikanMp(CuspKenaikanMpSPDto spDto);
}