package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.model.MutasiPensiun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface MutasiPenerimaAnakTab3Repository extends BaseRepository <MutasiPensiun, Long> {

    @Query("select mp from MutasiPensiun mp where mp.kategoriMutasi = ?1 and (lower(mp.nip) like lower(?2) or lower(mp.namaPeserta) like lower(?2))")
    Page<MutasiPensiun> findAllByKategoriMutasi(KategoriMutasi kategoriMutasi,String searchParam, Pageable pageable);

    @Query("select mp from MutasiPensiun mp where mp.namaValidasi = 'Belum Validasi' and (lower(mp.nip) like lower(?1) or lower(mp.namaPeserta) like lower(?1))")
    Page<MutasiPensiun> findAllBelumValidasi( String searchParam, Pageable pageable);
}
