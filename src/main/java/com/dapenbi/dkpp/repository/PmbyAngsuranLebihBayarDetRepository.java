package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarDetDto;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarDet;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarHead;

public interface PmbyAngsuranLebihBayarDetRepository extends BaseRepository<PmbyAngsuranLebihBayarDet, Long> {
    Iterable<PmbyAngsuranLebihBayarDet>findAllByPmbyAngsuranLebihBayarHead(PmbyAngsuranLebihBayarHead pmbyAngsuranLebihBayarHead);
}
