package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.MutasiOtomatis25TViewModelDto;
import com.dapenbi.dkpp.form.MenikahKembaliSPFormDto;
import com.dapenbi.dkpp.form.MutasiPensiunOtomatis25TSPFormDto;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25TViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MutasiOtomatis25TViewModelDao extends BaseDao<MutasiOtomatis25TViewModel, MutasiOtomatis25TViewModelDto, Long> {
    Map processMutasiOtomatis25T(MutasiPensiunOtomatis25TSPFormDto spDto);

    Page<MutasiOtomatis25TViewModel>findAllByBelumValidasi(String searchParam, Pageable pageable);
}

