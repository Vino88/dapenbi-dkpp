package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface PembayaranMpDetailMpsRepository extends BaseRepository<PembayaranMpDetailMps, Long> {

//    Page<PembayaranMpDetailMps> findAllByIdPembayaran(String[] column, String searchParam, Pageable pageable, PembayaranMp pembayaranMp);


    @Query(
            value = "select * from tbl_t_pembayaran_detail_mps d where d.id_pembayaran = ?1 and (lower(d.nip)like lower(?2) or lower(d.nama_peserta)like  lower(?2) )",
            nativeQuery = true
    )
    Page<PembayaranMpDetailMps> findAllByIdPembayaranWithSearch(Long idPembayaran,String searchParam, Pageable pageable);


}