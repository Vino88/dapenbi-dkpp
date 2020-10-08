package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.JenisMps;
import com.dapenbi.dkpp.model.MPensiun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MPensiunRepository extends BaseRepository<MPensiun, String> {

    @Query(
            value = "select * from tbl_m_pensiun where tgl_meninggal_peserta is not null and id_status_bayar != 6 and id_kategori_penerima_mp in (2,20,21) and (nip like ?1 or lower(nama_peserta) like lower(?1))",
            nativeQuery = true
    )
    Page<MPensiun> findAllPensiunByKategoriPenerimaIsJandaDuda(String searchParam, Pageable pageable);

    @Query(
            value = "select * from tbl_m_pensiun where id_status_bayar = 1 and (nip like ?1 or lower(nama_peserta) like lower(?1))",
            nativeQuery = true
    )
    Page<MPensiun> findAllPenerimaMp(String searchParam, Pageable pageable);

    MPensiun findFirstByNip(String nip);

    @Query(
            value = "select * from VW_PENSTUNDA_JATUHTEMPO mp where (mp.NIP like ?1 or lower(mp.NAMA_PESERTA) like lower(?1) or lower(mp.NAMA_PENERIMA_MP) like lower(?1))",
            nativeQuery = true
    )
    Page<MPensiun>  findAllPensiunTundaJatuhTempo(String searchParam, Pageable pageable);

    @Query(
            value = "select DISTINCT mpt.* from VW_PENSTUNDA_JATUHTEMPODIBAYAR mpt LEFT JOIN tbl_t_mutasi_pensiun mp on mpt.nip = mp.nip WHERE mp.nip is null AND (mpt.NIP like ?1 or lower(mpt.NAMA_PESERTA) like lower(?1) or lower(mpt.NAMA_PENERIMA_MP) like lower(?1))",
            nativeQuery = true
    )
    Page<MPensiun> findAllPensiunTundaJatuhTempoDiBayar(String searchParam, Pageable pageable);

    @Query(
            value = "select mp FROM MPensiun mp WHERE mp.statusBayar.id = 1 and (mp.nip like ?1 or lower(mp.namaPeserta) like lower(?1))"

    )
    Page<MPensiun> findAllPensiunStatusBayar1(String searchParam, Pageable pageable);

    @Query(
            value = "select mp FROM MPensiun mp WHERE mp.statusBayar.id = 1"

    )
    Page<MPensiun> findAllPensiunStatusBayarSamaDengan1(Pageable pageable);


    Page<MPensiun> findAllByJenisMps(String idJenisMps ,String searchParam, Pageable pageable);

    @Query(
            value = "select mp from MPensiun mp order by mp.nip"
    )
    List<MPensiun> findAllList();

    @Query(
            value = "select kb from MPensiun  kb where kb.statusBayar.id = 1 order by kb.nip asc"
    )
    Page<MPensiun> findAllNotPeserta(String searchParam, Pageable pageable);
}
