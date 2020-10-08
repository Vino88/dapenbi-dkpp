package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MutasiPenerimaAnakTab3Dao;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiOtomatisBulan13ViewDto;
import com.dapenbi.dkpp.form.MutasiOtomatisAnakBulan13FormDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatisBulan13ViewModel;
import com.dapenbi.dkpp.repository.MutasiPenerimaAnakTab3Repository;
import com.dapenbi.dkpp.repository.ViewModelRepository.MutasiOtomatisBulan13ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MutasiPenerimaAnakTab3DaoImpl extends BaseDaoImpl<MutasiOtomatisBulan13ViewModel, MutasiOtomatisBulan13ViewDto,Long> implements MutasiPenerimaAnakTab3Dao {

    private MutasiOtomatisBulan13ViewRepository mutasiOtomatisBulan13ViewRepository;

    private MutasiPenerimaAnakTab3Repository mutasiPenerimaAnakTab3Repository;

    @Autowired
    public MutasiPenerimaAnakTab3DaoImpl(MutasiOtomatisBulan13ViewRepository mutasiOtomatisBulan13ViewRepository,MutasiPenerimaAnakTab3Repository mutasiPenerimaAnakTab3Repository) {
        super(mutasiOtomatisBulan13ViewRepository);
        this.mutasiOtomatisBulan13ViewRepository = mutasiOtomatisBulan13ViewRepository;
        this.mutasiPenerimaAnakTab3Repository = mutasiPenerimaAnakTab3Repository;
    }

    @Override
    public Map spMutasiOtomatisanak(MutasiOtomatisAnakBulan13FormDto spDto) {
        Map<String, Object> mutasiOtomatisanakSpParam = new HashMap();
                mutasiOtomatisanakSpParam.put("PAR_ROLE_ID", spDto.getParRoleId());
                mutasiOtomatisanakSpParam.put("PAR_COMP_NAME", spDto.getParCompName());
                mutasiOtomatisanakSpParam.put("PAR_USER_NAME", spDto.getParUserName());
                mutasiOtomatisanakSpParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
                mutasiOtomatisanakSpParam.put("PAR_ID_MUTASI", spDto.getParIdMutasi());
                mutasiOtomatisanakSpParam.put("PAR_NIP", spDto.getParNip());
                mutasiOtomatisanakSpParam.put("PAR_MPYD_BARU", spDto.getParMpydBaru());
                mutasiOtomatisanakSpParam.put("PAR_ID_KATEGORI_CATATAN", spDto.getParIdKategoriCatatan());
                mutasiOtomatisanakSpParam.put("PAR_NAMA_KATEGORI_CATATAN", spDto.getParNamaKategoriCatatan());
                mutasiOtomatisanakSpParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
                mutasiOtomatisanakSpParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
                mutasiOtomatisanakSpParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());


        List<String> mutasiOtomatisanakOutSpParam = new ArrayList<>();
            mutasiOtomatisanakOutSpParam.add("PAR_STATUS_EKSEKUSI");
            mutasiOtomatisanakOutSpParam.add("PAR_MSG");
        return mutasiOtomatisBulan13ViewRepository.callStoredProcedure("MutasiOtomatisBulan13ViewModel.spMutasiOtomatisanak",mutasiOtomatisanakSpParam,mutasiOtomatisanakOutSpParam);
    }

    @Override
    public Page<MutasiPensiun> findAllBelumValidasi(String searchParam, Pageable pageable) {
        return mutasiPenerimaAnakTab3Repository.findAllBelumValidasi(searchParam,pageable);
    }

    @Override
    public Page<MutasiOtomatisBulan13ViewModel> findAllViewBelumValidasi(String searchParam, Pageable pageable) {
        return mutasiOtomatisBulan13ViewRepository.findAllViewBelumValidasi(searchParam, pageable);
    }


//    @Override
//    public Page<MutasiPensiun> findAllByKategoriMutasi(String idKategoriMutasi, String searchParam, Pageable pageable) {
//        KategoriMutasi kategoriMutasi = new KategoriMutasi();
//        kategoriMutasi.setId(idKategoriMutasi);
//        return mutasiPenerimaAnakTab3Repository.findAllByKategoriMutasi(kategoriMutasi,searchParam,pageable);
//    }
}
