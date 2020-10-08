package com.dapenbi.dkpp.dao.impl.ViewModel;

import com.dapenbi.dkpp.dao.ViewModel.DashboardViewDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.ViewModelDto.DashboardViewDto;
import com.dapenbi.dkpp.model.ViewModel.DashboardViewModel;
import com.dapenbi.dkpp.repository.ViewModelRepository.DashboardViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardViewDaoImpl extends BaseDaoImpl<DashboardViewModel, DashboardViewDto, String> implements DashboardViewDao {
    private DashboardViewRepository dashboardViewRepository;

    @Autowired
    public DashboardViewDaoImpl(DashboardViewRepository dashboardViewRepository) {
        super(dashboardViewRepository);
        this.dashboardViewRepository = dashboardViewRepository;
    }

    @Override
    public DashboardViewModel findByPeriodeMutasi(String periodeMutasi) {
        return (DashboardViewModel) this.dashboardViewRepository.findFirstByPeriodeMutasi(periodeMutasi);
    }
}
