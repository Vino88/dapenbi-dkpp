package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.TMutasiPensiunNfDto;
import com.dapenbi.dkpp.form.CuspMutasiHapusPensiunNfSPDto;
import com.dapenbi.dkpp.model.TMutasiPensiunNf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface TMutasiPensiunNfDao extends BaseDao<TMutasiPensiunNf, TMutasiPensiunNfDto, String> {
    Map processCuspMutasiHapusPensiunNf(CuspMutasiHapusPensiunNfSPDto spDto);
}