package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.TMutasiRekeningDto;
import com.dapenbi.dkpp.form.CuspMutasiRekeningSPDto;
import com.dapenbi.dkpp.model.TMutasiRekening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Map;

public interface TMutasiRekeningDao extends BaseDao<TMutasiRekening, TMutasiRekeningDto, String> {
    Map processCuspMutasiRekening(CuspMutasiRekeningSPDto spDto);
    Page<TMutasiRekening> findAllByFilterForm(String periode, Date startDate, Date endDate, String searchParam, Pageable page);
}