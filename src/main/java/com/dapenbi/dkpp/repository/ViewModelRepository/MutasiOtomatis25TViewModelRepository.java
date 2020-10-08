package com.dapenbi.dkpp.repository.ViewModelRepository;

import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25TViewModel;
import com.dapenbi.dkpp.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface MutasiOtomatis25TViewModelRepository extends BaseRepository<MutasiOtomatis25TViewModel, Long> {

    @Query(value = "select mp from MutasiOtomatis25TViewModel mp where mp.namaValidasi='Belum Validasi' and mp.nip like ?1 or lower(mp.namaPeserta) like lower(?1) ")
    Page<MutasiOtomatis25TViewModel> findAllByBelumValidasi( String searchParam, Pageable pageable);
}
