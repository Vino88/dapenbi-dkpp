package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.MPensiunNf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface MPensiunNfRepository extends BaseRepository<MPensiunNf, String> {

}