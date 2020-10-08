package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dao.ViewModel.DashboardChartViewDao;
import com.dapenbi.dkpp.dto.ViewModelDto.DashboardChartViewDto;
import com.dapenbi.dkpp.model.SetupParameter;
import com.dapenbi.dkpp.model.ViewModel.DashboardChartViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.DASHBOARD)
public class DashboardApiController {

    private SetupParameterDao setupParameterDao;

    private DashboardChartViewDao dashboardChartViewDao;

    public DashboardApiController(SetupParameterDao setupParameterDao, DashboardChartViewDao dashboardChartViewDao){
        this.setupParameterDao = setupParameterDao;
        this.dashboardChartViewDao = dashboardChartViewDao;
    }

    @GetMapping("/chart")
    public Page<DashboardChartViewDto> index(@PageableDefault(size = 200) Pageable pageRequest) {
        SetupParameter setupParameter = this.setupParameterDao.findByBukaPeriode();
        Page<DashboardChartViewModel> uIt = (Page<DashboardChartViewModel>) dashboardChartViewDao.findAll(pageRequest);
        Page<DashboardChartViewDto> result = uIt.map(u -> {
            DashboardChartViewDto dto = u.toDto();
            return dto;
        });
        return result;
    }
}
