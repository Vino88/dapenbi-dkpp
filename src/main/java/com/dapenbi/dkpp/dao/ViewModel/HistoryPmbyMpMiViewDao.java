package com.dapenbi.dkpp.dao.ViewModel;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.ViewModelDto.HistoryPmbyMpMiViewModelDto;
import com.dapenbi.dkpp.model.ViewModel.HistoryPmbyMpMiViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryPmbyMpMiViewDao extends BaseDao<HistoryPmbyMpMiViewModel, HistoryPmbyMpMiViewModelDto, Long> {
    Page<HistoryPmbyMpMiViewModelDto> findAllByNip(String nip, Pageable pageable);
}
