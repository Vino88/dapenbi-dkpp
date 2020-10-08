package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KeluargaPensiunDto;
import com.dapenbi.dkpp.model.KeluargaPensiun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KeluargaPensiunDao extends BaseDao<KeluargaPensiun, KeluargaPensiunDto, String> {
    void deleteByNip(String nip);
    Iterable<KeluargaPensiun> findAllByNip(String nip);

}