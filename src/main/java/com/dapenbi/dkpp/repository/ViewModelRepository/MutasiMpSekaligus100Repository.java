package com.dapenbi.dkpp.repository.ViewModelRepository;

import com.dapenbi.dkpp.model.ViewModel.MutasiMpSekaligus100View;
import com.dapenbi.dkpp.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface MutasiMpSekaligus100Repository extends BaseRepository<MutasiMpSekaligus100View,Long> {
    @Query(value = "select mp from MutasiMpSekaligus100View mp where mp.namaValidasi='Belum Validasi' and mp.nip like ?1 or lower(mp.namaPeserta) like lower(?1) ")
    Page<MutasiMpSekaligus100View> findAllByBelumValidasi(String searchParam, Pageable pageable);

}
