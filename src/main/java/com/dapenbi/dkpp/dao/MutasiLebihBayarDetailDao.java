package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.LebihBayarDetailDto;
import com.dapenbi.dkpp.model.LebihBayarDetail;

public interface MutasiLebihBayarDetailDao extends BaseDao<LebihBayarDetail, LebihBayarDetailDto, Long>{
    Iterable<LebihBayarDetail> findByNipAndPeriode(String nip, String periode);
}
