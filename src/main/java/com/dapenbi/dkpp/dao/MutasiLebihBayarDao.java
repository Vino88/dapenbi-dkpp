package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.LebihBayarDto;
import com.dapenbi.dkpp.model.CompositeId.LebihBayarPK;
import com.dapenbi.dkpp.model.LebihBayar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MutasiLebihBayarDao extends BaseDao<LebihBayar, LebihBayarDto, LebihBayarPK> {
    Page<LebihBayar>findAllByPeriodeMutasi(String periodeMutasi, Pageable pageable);

    Map processMutasiLebihBayar(
            Long role,
            String compName,
            String userName,
            String nip,
            String periodeLebihBayar,
            Long lebihBayarMp,
            String jenisPengembalian,
            String jenisAngsuran,
            Long tenor,
            Double nominalAngsuran,
            String periodeMulaiBayar,
            Long idKategoriCatatan,
            String keterangan,
            String idValidasi,
            String namaValidasi
    );

}