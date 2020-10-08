package com.dapenbi.dkpp.dao.impl.ViewModel;

import com.dapenbi.dkpp.dao.MutasiOtomatis25TViewModelDao;
import com.dapenbi.dkpp.dao.ViewModel.MutasiOtomatis25MP80ViewModelDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.MutasiOtomatis25TViewModelDto;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiOtomatis25MP80ViewModelDto;
import com.dapenbi.dkpp.form.CuspMutasiOtomAnak25MP80FormDto;
import com.dapenbi.dkpp.form.MutasiPensiunOtomatis25TSPFormDto;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25MP80ViewModel;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25TViewModel;
import com.dapenbi.dkpp.repository.ViewModelRepository.MutasiOtomatis25MP80ViewModelRepository;
import com.dapenbi.dkpp.repository.ViewModelRepository.MutasiOtomatis25TViewModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MutasiOtomatis25MP80ViewModelDaoImpl extends BaseDaoImpl<MutasiOtomatis25MP80ViewModel, MutasiOtomatis25MP80ViewModelDto,Long> implements MutasiOtomatis25MP80ViewModelDao {

    private MutasiOtomatis25MP80ViewModelRepository mutasiOtomatis25MP80ViewModelRepository;

    @Autowired
    public MutasiOtomatis25MP80ViewModelDaoImpl(MutasiOtomatis25MP80ViewModelRepository mutasiOtomatis25MP80ViewModelRepository){
        super(mutasiOtomatis25MP80ViewModelRepository);
        this.mutasiOtomatis25MP80ViewModelRepository = mutasiOtomatis25MP80ViewModelRepository;
    }


    @Override
    public Map processMutasiOtomatis25MP80(CuspMutasiOtomAnak25MP80FormDto spDto) {
        Map<String, Object> mutasiPensiunOtomatis25MP80SPParam = new HashMap();
        mutasiPensiunOtomatis25MP80SPParam.put("COMP_NAME", spDto.getCompName());
        mutasiPensiunOtomatis25MP80SPParam.put("USER_NAME", spDto.getUserName());
        mutasiPensiunOtomatis25MP80SPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
        mutasiPensiunOtomatis25MP80SPParam.put("PAR_TGL_MUTASI", spDto.getParTglMutasi());


        List<String> mutasiPensiunOtomatis25TOutSParam = new ArrayList<>();
        mutasiPensiunOtomatis25TOutSParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOtomatis25TOutSParam.add("PAR_MSG");
        return this.mutasiOtomatis25MP80ViewModelRepository.callStoredProcedure("MutasiPensiun.processMutasiOtomatis25MP80",
                mutasiPensiunOtomatis25MP80SPParam, mutasiPensiunOtomatis25TOutSParam);
    }
}
