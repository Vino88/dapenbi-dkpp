package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.AlamatDto;
import com.dapenbi.dkpp.dto.JandaDudaMenikahKembaliViewModelDto;
import com.dapenbi.dkpp.form.MenikahKembaliSPFormDto;
import com.dapenbi.dkpp.model.JandaDudaMenikahKembaliViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface JandaDudaMenikahKembaliViewModelDao extends BaseDao<JandaDudaMenikahKembaliViewModel, JandaDudaMenikahKembaliViewModelDto, Long> {
    JandaDudaMenikahKembaliViewModel findFirstByNip(String nip);
    JandaDudaMenikahKembaliViewModel findFirstByIdAndNip(Long id, String nip);
    Object findAlamatByKelurahan(String id);
    Map cufnMenikahSimulation(String nip, String periodeMutasi, String tglMenikah, Long idStatusBayarBaru);
    Map processMutasiPenerimaMpMenikah(MenikahKembaliSPFormDto spDto);
    Page<JandaDudaMenikahKembaliViewModel> indexBelumValidasi(String searchParam, Pageable pageable);

}

