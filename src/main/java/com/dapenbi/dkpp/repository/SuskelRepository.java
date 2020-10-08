package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.Suskel;

public interface SuskelRepository extends BaseRepository<Suskel, Long> {
    Suskel findFirstByNamaSuskel(String namaSuskel);
}
