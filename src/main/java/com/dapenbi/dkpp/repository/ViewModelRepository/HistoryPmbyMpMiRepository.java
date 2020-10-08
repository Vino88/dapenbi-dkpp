package com.dapenbi.dkpp.repository.ViewModelRepository;

import com.dapenbi.dkpp.model.ViewModel.HistoryPmbyMpMiViewModel;
import com.dapenbi.dkpp.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryPmbyMpMiRepository extends BaseRepository<HistoryPmbyMpMiViewModel,Long> {
    Page<HistoryPmbyMpMiViewModel> findAllByNip(String nip, Pageable pageable);
}
