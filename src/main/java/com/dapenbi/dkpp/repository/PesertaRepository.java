package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.Peserta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface PesertaRepository extends BaseRepository<Peserta, Long> {

    @Query("select p from Peserta p where p.isActive = 1 and (p.nip like ?1 or lower(p.namaPeserta) like lower(?1)) and not exists (select 'x' from MutasiPensiun mp where mp.nip = p.nip and mp.statusValidasi not in (4, 7) and mp.kategoriMutasi = '01')")
    Page<Peserta> findNotExistsOnMutasiTransaction(String searchParam, Pageable pageable);

    @Query(
            value = "select * from vw_pensbaru_pelepasan p where (p.nip like ?1 or lower(p.nama_peserta) like lower(?1))",
            nativeQuery = true
    )
    Page<Peserta> findPesertaPelepasan(String searchParam, Pageable pageable);

    Peserta findFirstByNip(String nip);
}
