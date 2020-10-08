package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.RekonsiliasiRekeningDto;
import com.dapenbi.dkpp.form.CuspProsesRekonRekeningSPDto;
import com.dapenbi.dkpp.form.CuspValidasiRekonRekeningSPDto;
import com.dapenbi.dkpp.model.RekonsiliasiRekening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface RekonsiliasiRekeningDao extends BaseDao<RekonsiliasiRekening, RekonsiliasiRekeningDto, String> {
    Map processCuspProsesRekonRekening(CuspProsesRekonRekeningSPDto spDto);
    Map processCuspValidasiRekonRekening(CuspValidasiRekonRekeningSPDto spDto);
    Long getCount();
}