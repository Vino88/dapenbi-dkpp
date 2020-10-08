package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KeluargaPesertaDto;
import com.dapenbi.dkpp.model.KeluargaPeserta;

import java.util.List;

public interface KeluargaPesertaDao extends BaseDao<KeluargaPeserta, KeluargaPesertaDto, String> {
    Iterable<KeluargaPeserta> findByNip(String nip);
}