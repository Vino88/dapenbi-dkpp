package com.dapenbi.dkpp.dao.ViewModel;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.MutasiOtomatis25TViewModelDto;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiOtomatis25MP80ViewModelDto;
import com.dapenbi.dkpp.form.CuspMutasiOtomAnak25MP80FormDto;
import com.dapenbi.dkpp.form.MutasiPensiunOtomatis25TSPFormDto;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25MP80ViewModel;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25TViewModel;

import java.util.Map;

public interface MutasiOtomatis25MP80ViewModelDao extends BaseDao<MutasiOtomatis25MP80ViewModel, MutasiOtomatis25MP80ViewModelDto, Long> {
    Map processMutasiOtomatis25MP80(CuspMutasiOtomAnak25MP80FormDto spDto);
}

