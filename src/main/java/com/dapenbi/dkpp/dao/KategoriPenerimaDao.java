package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KategoriPenerimaDto;
import com.dapenbi.dkpp.model.KategoriPenerima;

public interface KategoriPenerimaDao extends BaseDao<KategoriPenerima, KategoriPenerimaDto, Long> {

    KategoriPenerima findFirstById(Long valueOf);
}