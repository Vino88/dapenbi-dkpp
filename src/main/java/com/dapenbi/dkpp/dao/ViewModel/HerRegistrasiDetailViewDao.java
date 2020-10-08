package com.dapenbi.dkpp.dao.ViewModel;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.ViewModelDto.HerRegistrasiDetailViewDto;
import com.dapenbi.dkpp.model.ViewModel.HerRegistrasiDetailView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HerRegistrasiDetailViewDao extends BaseDao<HerRegistrasiDetailView, HerRegistrasiDetailViewDto, Long> {
    Page<HerRegistrasiDetailView> findByTahunHer(String tahunHer, String searchParam, Pageable pageable);
}
