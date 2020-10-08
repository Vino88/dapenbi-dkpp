package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.Agama;

public interface AgamaRepository extends BaseRepository<Agama, Long> {

    Agama findBynamaAgama(String namaAgama);
}
