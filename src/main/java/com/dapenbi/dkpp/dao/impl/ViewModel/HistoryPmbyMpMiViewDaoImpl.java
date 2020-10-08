package com.dapenbi.dkpp.dao.impl.ViewModel;

import com.dapenbi.dkpp.dao.ViewModel.HistoryPmbyMpMiViewDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.ViewModelDto.HistoryPmbyMpMiViewModelDto;import com.dapenbi.dkpp.model.ViewModel.HerRegistrasiDetailView;
import com.dapenbi.dkpp.model.ViewModel.HistoryPmbyMpMiViewModel;
import com.dapenbi.dkpp.repository.ViewModelRepository.HistoryPmbyMpMiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HistoryPmbyMpMiViewDaoImpl extends BaseDaoImpl<HistoryPmbyMpMiViewModel, HistoryPmbyMpMiViewModelDto, Long> implements HistoryPmbyMpMiViewDao {

    private HistoryPmbyMpMiRepository historyPmbyMpMiRepository;

    @Autowired
    public HistoryPmbyMpMiViewDaoImpl(HistoryPmbyMpMiRepository historyPmbyMpMiRepository) {
        super(historyPmbyMpMiRepository);
        this.historyPmbyMpMiRepository = historyPmbyMpMiRepository;
    }

    @Override
    public Page<HistoryPmbyMpMiViewModelDto> findAllByNip(String nip, Pageable pageable) {
        Page<HistoryPmbyMpMiViewModel> historyPmbyMpMiViewModel = historyPmbyMpMiRepository.findAllByNip(nip, pageable);
        Page<HistoryPmbyMpMiViewModelDto> historyPmbyMpMiViewModelDto = historyPmbyMpMiViewModel.map(u -> u.toDto());
        return historyPmbyMpMiViewModelDto;
    }
}
