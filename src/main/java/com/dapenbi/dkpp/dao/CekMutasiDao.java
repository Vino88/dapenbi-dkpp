package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.AgamaDto;
import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.model.Agama;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.model.MutasiPensiun;

public interface CekMutasiDao extends BaseDao<MutasiPensiun, MutasiPensiunDto, Long>{
    String isExist(String nip);
}
