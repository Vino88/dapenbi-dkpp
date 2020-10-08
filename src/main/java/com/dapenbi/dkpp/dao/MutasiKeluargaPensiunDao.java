package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.MutasiKeluargaPensiunDto;
import com.dapenbi.dkpp.model.MutasiKeluargaPensiun;

import java.util.List;
import java.util.Map;

public interface MutasiKeluargaPensiunDao extends BaseDao<MutasiKeluargaPensiun, MutasiKeluargaPensiunDto, String> {

    MutasiKeluargaPensiun findByNip(String nip);

    List<MutasiKeluargaPensiun> findByIdMutasi(Long idMutasi);

    void deleteByMutasiPensiun(Long idMutasi);

    boolean deleteAllByIdMutasi(Long idMutasi);

    Map cufnDeleteMutasiKeluarga(String idMutasi);

}
