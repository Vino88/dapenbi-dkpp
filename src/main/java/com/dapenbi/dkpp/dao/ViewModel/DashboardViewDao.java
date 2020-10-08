package com.dapenbi.dkpp.dao.ViewModel;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.ViewModelDto.DashboardViewDto;
import com.dapenbi.dkpp.model.ViewModel.DashboardChartViewModel;
import com.dapenbi.dkpp.model.ViewModel.DashboardViewModel;

import java.util.List;


public interface DashboardViewDao extends BaseDao<DashboardViewModel, DashboardViewDto, String> {

    DashboardViewModel findByPeriodeMutasi(String periodeMutasi);
}
