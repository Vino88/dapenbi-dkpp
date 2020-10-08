package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KategoriPenerima;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriPenerimaRepository extends BaseRepository<KategoriPenerima, Long> {

    KategoriPenerima findFirstById(Long id);

}
