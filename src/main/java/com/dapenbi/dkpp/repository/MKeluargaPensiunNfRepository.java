package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.MKeluargaPensiunNf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;


public interface MKeluargaPensiunNfRepository extends BaseRepository<MKeluargaPensiunNf, Long> {
    Iterable<MKeluargaPensiunNf> findAllByNip(String nip);
}