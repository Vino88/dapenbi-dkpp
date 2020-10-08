package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.HerRegistrasiMpNFDetail;
import com.dapenbi.dkpp.model.HerRegistrasiMpNFHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface HerRegistrasiMpNFDetailRepository extends BaseRepository<HerRegistrasiMpNFDetail, String> {

    Iterable<HerRegistrasiMpNFDetail> findByTahunHer(String tahunHer);
}
