package com.dapenbi.dkpp.repository.ViewModelRepository;
import com.dapenbi.dkpp.model.ViewModel.DashboardViewModel;
import com.dapenbi.dkpp.repository.BaseRepository;


public interface DashboardViewRepository extends BaseRepository<DashboardViewModel, String> {

    DashboardViewModel findFirstByPeriodeMutasi(String periodeMutasi);
}
