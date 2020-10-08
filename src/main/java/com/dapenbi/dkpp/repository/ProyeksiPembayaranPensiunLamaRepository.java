package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.ProyeksiPembayaranPensiunLama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface ProyeksiPembayaranPensiunLamaRepository extends BaseRepository<ProyeksiPembayaranPensiunLama, Long> {

    @Query(value = "select pm from ProyeksiPembayaranPensiunLama pm where(lower(pm.nip) like lower(?1) or lower(pm.namaPeserta) like lower (?1) or lower(pm.periodeProyeksi) like lower (?1)) ORDER BY pm.nip, substr(pm.periodeProyeksi,3,4)||substr(pm.periodeProyeksi,1,2)")
    Page<ProyeksiPembayaranPensiunLama>findAllTanpaParam(String SearchParam,Pageable pageable);


}