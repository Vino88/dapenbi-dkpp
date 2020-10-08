package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface PembayaranMpDetailMpRepository extends BaseRepository<PembayaranMpDetailMp,Long>{

    @Query(
            value = "SELECT * from tbl_t_pembayaran_detail_mp d where d.id_pembayaran = ?1 and d.id_status_bayar = 1 and (lower(d.nip)like lower(?2) or lower(d.nama_peserta)like  lower(?2)  )",
            nativeQuery = true
    )
    Page<PembayaranMpDetailMp> findAllByIdPembayaranSearch(Long idPembayaran,String searchParam, Pageable pageable);

    @Query(
            value = "SELECT * from tbl_t_pembayaran_detail_mp d where d.id_pembayaran = ?1 and d.id_status_bayar = 1 )",
            nativeQuery = true
    )
    Page<PembayaranMpDetailMp> findAllByIdPembayaranSearchNull(Long idPembayaran, Pageable pageable);


}
