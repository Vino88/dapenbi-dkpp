package com.dapenbi.dkpp.repository.ViewModelRepository;

import com.dapenbi.dkpp.model.ViewModel.DashboardChartViewModel;
import com.dapenbi.dkpp.repository.BaseRepository;

public interface DashboardChartViewRepository extends BaseRepository<DashboardChartViewModel, String> {

    DashboardChartViewModel findAllByPeriodeMutasi(String periodeMutasi);
}
