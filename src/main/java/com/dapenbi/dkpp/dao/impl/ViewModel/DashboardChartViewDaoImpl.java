package com.dapenbi.dkpp.dao.impl.ViewModel;

import com.dapenbi.dkpp.dao.ViewModel.DashboardChartViewDao;
import com.dapenbi.dkpp.dao.ViewModel.DashboardViewDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.ViewModelDto.DashboardChartViewDto;
import com.dapenbi.dkpp.model.ViewModel.DashboardChartViewModel;
import com.dapenbi.dkpp.model.ViewModel.DashboardViewModel;
import com.dapenbi.dkpp.repository.ViewModelRepository.DashboardChartViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardChartViewDaoImpl extends BaseDaoImpl<DashboardChartViewModel, DashboardChartViewDto, String> implements DashboardChartViewDao {

    private DashboardChartViewRepository dashboardChartViewRepository;

    @Autowired
    public DashboardChartViewDaoImpl( DashboardChartViewRepository dashboardChartViewRepository){
        super(dashboardChartViewRepository);
        this.dashboardChartViewRepository = dashboardChartViewRepository;
    }

    @Override
    public DashboardChartViewModel findByPeriode(String periodeMutasi) {
        return dashboardChartViewRepository.findAllByPeriodeMutasi(periodeMutasi);
    }
}
