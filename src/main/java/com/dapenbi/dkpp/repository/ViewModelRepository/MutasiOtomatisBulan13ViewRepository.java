package com.dapenbi.dkpp.repository.ViewModelRepository;

import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatisBulan13ViewModel;
import com.dapenbi.dkpp.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface MutasiOtomatisBulan13ViewRepository extends BaseRepository<MutasiOtomatisBulan13ViewModel,Long> {

    @Query("select mp from MutasiOtomatisBulan13ViewModel mp where mp.namaValidasi = 'Belum Validasi' and (lower(mp.nip) like lower(?1) or lower(mp.namaPeserta) like lower(?1))")
    Page<MutasiOtomatisBulan13ViewModel> findAllViewBelumValidasi(String searchParam, Pageable pageable);
}
