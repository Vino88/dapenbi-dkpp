package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.model.MPensiun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MPensiunDao extends BaseDao<MPensiun, MPensiunDto, String> {

    MPensiun findByNip(String nip);

    MPensiun findByNip(MPensiun mPensiun);

    Page<MPensiun> findAllPensiunTundaJatuhTempo(String searchParam, Pageable pageable);

    Page<MPensiun> findAllPensiunStatusBayar1(String searchParam, Pageable pageable);

    Page<MPensiun> findAllPensiunStatusBayarSamaDengan1(Pageable pageable);

    Page<MPensiun> findAllPensiunTundaJatuhTempoDiBayar(String searchParam, Pageable pageable);

    Page<MPensiun>findAllByJenisMps(String idJenisMps ,String searchParam, Pageable pageable);

    List<MPensiun> findAllList();

    Page<MPensiun> findAllPensiunByKategoriPenerimaIsJandaDuda(String searchParam, Pageable pageable);

    Page<MPensiun> findByIsNotPeserta (String searchParam, Pageable pageable);

    Page<MPensiun> findAllPenerimaMp(String searchParam, Pageable pageable);
}
