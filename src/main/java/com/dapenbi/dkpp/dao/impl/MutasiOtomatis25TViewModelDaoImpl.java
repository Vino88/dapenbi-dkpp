package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MutasiOtomatis25TViewModelDao;
import com.dapenbi.dkpp.dto.MutasiOtomatis25TViewModelDto;
import com.dapenbi.dkpp.form.MenikahKembaliSPFormDto;
import com.dapenbi.dkpp.form.MutasiPensiunOtomatis25TSPFormDto;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatis25TViewModel;
import com.dapenbi.dkpp.repository.ViewModelRepository.MutasiOtomatis25TViewModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MutasiOtomatis25TViewModelDaoImpl extends BaseDaoImpl<MutasiOtomatis25TViewModel, MutasiOtomatis25TViewModelDto,Long> implements MutasiOtomatis25TViewModelDao {

    private MutasiOtomatis25TViewModelRepository mutasiOtomatis25TViewModelRepository;

    @Autowired
    public MutasiOtomatis25TViewModelDaoImpl(MutasiOtomatis25TViewModelRepository mutasiOtomatis25TViewModelRepository){
        super(mutasiOtomatis25TViewModelRepository);
        this.mutasiOtomatis25TViewModelRepository = mutasiOtomatis25TViewModelRepository;
    }


    @Override
    public Map processMutasiOtomatis25T(MutasiPensiunOtomatis25TSPFormDto spDto) {
        Map<String, Object> mutasiPensiunOtomatis25TSPParam = new HashMap();
        mutasiPensiunOtomatis25TSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
        mutasiPensiunOtomatis25TSPParam.put("PAR_USER_NAME", spDto.getParUserName());
        mutasiPensiunOtomatis25TSPParam.put("PAR_ID_MUTASI_PENSIUN", spDto.getParIdMutasiPensiun());
        mutasiPensiunOtomatis25TSPParam.put("PAR_ID_KATEGORI_CATATAN", spDto.getParIdKategoriCatatan());
        mutasiPensiunOtomatis25TSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
        mutasiPensiunOtomatis25TSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
        mutasiPensiunOtomatis25TSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());


        List<String> mutasiPensiunOtomatis25TOutSParam = new ArrayList<>();
        mutasiPensiunOtomatis25TOutSParam.add("PAR_STATUS_EKSEKUSI");
        mutasiPensiunOtomatis25TOutSParam.add("PAR_MSG");
        return this.mutasiOtomatis25TViewModelRepository.callStoredProcedure("MutasiPensiun.processMutasiOtomatis25T",
                mutasiPensiunOtomatis25TSPParam, mutasiPensiunOtomatis25TOutSParam);
    }

    @Override
    public Page<MutasiOtomatis25TViewModel> findAllByBelumValidasi(String searchParam, Pageable pageable) {
        return mutasiOtomatis25TViewModelRepository.findAllByBelumValidasi(searchParam,pageable);
    }
}
