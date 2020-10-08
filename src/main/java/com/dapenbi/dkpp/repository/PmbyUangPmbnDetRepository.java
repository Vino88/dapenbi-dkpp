package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.PmbyUangPmbnDet;
import com.dapenbi.dkpp.model.PmbyUangPmbnH;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface PmbyUangPmbnDetRepository extends BaseRepository<PmbyUangPmbnDet, Long> {
//    Iterable<PmbyUangPmbnDet> findByIdUangPembinaanH(PmbyUangPmbnH pmbyUangPmbnH);

    @Query(
            value = "select h from PmbyUangPmbnDet h where h.idUangPembinaanH = ?1 and (lower(h.nip)like lower(?2) or lower(h.namaPeserta)like  lower(?2) )"
    )
    Page<PmbyUangPmbnDet> findAllByIdUangPembinaanH(Long idUangPembinaanH,String searchParam, Pageable pageable);

}