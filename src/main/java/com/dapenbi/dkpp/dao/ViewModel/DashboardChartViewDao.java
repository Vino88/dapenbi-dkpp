package com.dapenbi.dkpp.dao.ViewModel;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.ViewModelDto.DashboardChartViewDto;
import com.dapenbi.dkpp.model.ViewModel.DashboardChartViewModel;

public interface DashboardChartViewDao extends BaseDao<DashboardChartViewModel, DashboardChartViewDto, String> {
    DashboardChartViewModel findByPeriode(String periodeMutasi);
}
