package com.dapenbi.dkpp.dao.ViewModel;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.ViewModelDto.PensiunLamaMeninggalViewDto;
import com.dapenbi.dkpp.model.ViewModel.PensiunLamaMeninggalView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PensLamaMeninggalViewDao extends BaseDao<PensiunLamaMeninggalView, PensiunLamaMeninggalViewDto, Long> {

    Page<PensiunLamaMeninggalView>findAllByBelumValidasi(String searchParam, Pageable pageable);
    List<PensiunLamaMeninggalView> findAllByBelumValidasi();


}
