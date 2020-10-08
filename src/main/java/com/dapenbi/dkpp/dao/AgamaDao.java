package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.AgamaDto;
import com.dapenbi.dkpp.model.Agama;

public interface AgamaDao extends BaseDao<Agama, AgamaDto, Long>{

    Agama findBynamaAgama(String namaAgama);

}
