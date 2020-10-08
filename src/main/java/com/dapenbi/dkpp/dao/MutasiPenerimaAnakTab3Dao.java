package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.ViewModelDto.MutasiOtomatisBulan13ViewDto;
import com.dapenbi.dkpp.form.MutasiOtomatisAnakBulan13FormDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.ViewModel.MutasiOtomatisBulan13ViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MutasiPenerimaAnakTab3Dao extends BaseDao<MutasiOtomatisBulan13ViewModel, MutasiOtomatisBulan13ViewDto,Long> {

    Map spMutasiOtomatisanak( MutasiOtomatisAnakBulan13FormDto mutasiOtomatisAnakBulan13FormDto
    );
//    Page<MutasiPensiun>findAllByKategoriMutasi(String idKategoriMutasi, String searchParam, Pageable pageable);

    Page<MutasiPensiun> findAllBelumValidasi(String searchParam, Pageable pageable);

    Page<MutasiOtomatisBulan13ViewModel> findAllViewBelumValidasi(String searchParam, Pageable pageable);
}
