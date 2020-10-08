package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.HerRegistrasiMpNFHeader;

public interface HerRegistrasiMpNFHeaderRepository extends BaseRepository<HerRegistrasiMpNFHeader, String> {
    HerRegistrasiMpNFHeader findFirstByTahunHer(String tahun);
}
