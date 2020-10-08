package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.MKeluargaPensiunNfDto;
import com.dapenbi.dkpp.model.MKeluargaPensiunNf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MKeluargaPensiunNfDao extends BaseDao<MKeluargaPensiunNf, MKeluargaPensiunNfDto, Long> {
    Iterable<MKeluargaPensiunNf> findByNip(String nip);
    void delete(MKeluargaPensiunNf mKeluargaPensiunNf);
}