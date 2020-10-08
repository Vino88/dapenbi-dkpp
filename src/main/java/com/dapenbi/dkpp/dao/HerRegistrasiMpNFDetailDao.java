package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.HerRegistrasiMpNFDetailDto;
import com.dapenbi.dkpp.model.HerRegistrasiMpNFDetail;
import com.dapenbi.dkpp.model.HerRegistrasiMpNFHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HerRegistrasiMpNFDetailDao extends BaseDao<HerRegistrasiMpNFDetail, HerRegistrasiMpNFDetailDto, String> {

    Iterable<HerRegistrasiMpNFDetail> findByTahunHer(String tahunHer);
}
