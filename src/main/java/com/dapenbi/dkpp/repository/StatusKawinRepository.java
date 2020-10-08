package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.StatusKawin;

public interface StatusKawinRepository extends BaseRepository<StatusKawin, Long> {

    StatusKawin findFirstById(Long id);
}
