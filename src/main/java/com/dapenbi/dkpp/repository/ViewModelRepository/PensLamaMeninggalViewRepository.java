package com.dapenbi.dkpp.repository.ViewModelRepository;

import com.dapenbi.dkpp.model.ViewModel.PensiunLamaMeninggalView;
import com.dapenbi.dkpp.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PensLamaMeninggalViewRepository extends BaseRepository<PensiunLamaMeninggalView, Long> {

    @Query(
            value = "SELECT d from PensiunLamaMeninggalView d where d.namaValidasi = 'Belum Validasi' and (lower(d.nip) like lower(?1) or lower(d.namaPeserta) like lower(?1)) "
    )
    Page<PensiunLamaMeninggalView> findAllByBelumValidasi(String searchParam, Pageable pageable);

    @Query(
            value = "SELECT d from PensiunLamaMeninggalView d where d.namaValidasi = 'Belum Validasi'"
    )
    List<PensiunLamaMeninggalView> findAllByBelumValidasi();
}
