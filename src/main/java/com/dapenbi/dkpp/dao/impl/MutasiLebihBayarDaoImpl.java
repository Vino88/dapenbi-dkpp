package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MutasiLebihBayarDao;
import com.dapenbi.dkpp.dto.LebihBayarDto;
import com.dapenbi.dkpp.model.CompositeId.LebihBayarPK;
import com.dapenbi.dkpp.model.LebihBayar;
import com.dapenbi.dkpp.repository.MutasiLebihBayarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MutasiLebihBayarDaoImpl extends BaseDaoImpl<LebihBayar, LebihBayarDto, LebihBayarPK> implements MutasiLebihBayarDao {
    private MutasiLebihBayarRepository mutasiLebihBayarRepository;

    @Autowired
    public MutasiLebihBayarDaoImpl(MutasiLebihBayarRepository mutasiLebihBayarRepository){
        super(mutasiLebihBayarRepository);
        this.mutasiLebihBayarRepository = mutasiLebihBayarRepository;
    }


    @Override
    public Page<LebihBayar> findAllByPeriodeMutasi(String periodeMutasi, Pageable pageable) {
        return mutasiLebihBayarRepository.findAllByPeriodeMutasi(periodeMutasi, pageable);
    }

    @Override
    public Map processMutasiLebihBayar(
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
            String namaValidasi) {

        Map<String, Object> mutasiLebihBayarSPParam = new HashMap<>();
        mutasiLebihBayarSPParam.put("PAR_ROLE_ID", role);
        mutasiLebihBayarSPParam.put("PAR_COMP_NAME",compName);
        mutasiLebihBayarSPParam.put("PAR_USER_NAME",userName);
        mutasiLebihBayarSPParam.put("PAR_NIP",nip);
        mutasiLebihBayarSPParam.put("PAR_PERIODE_LEBIH_BAYAR",periodeLebihBayar);
        mutasiLebihBayarSPParam.put("PAR_LEBIH_BAYAR_MP",lebihBayarMp);
        mutasiLebihBayarSPParam.put("PAR_JENIS_PENGEMBALIAN",jenisPengembalian);
        mutasiLebihBayarSPParam.put("PAR_JENIS_ANGSURAN",jenisAngsuran);
        mutasiLebihBayarSPParam.put("PAR_TENOR",tenor);
        mutasiLebihBayarSPParam.put("PAR_NOMINAL_ANGSURAN",nominalAngsuran);
        mutasiLebihBayarSPParam.put("PAR_PERIODE_MULAI_BAYAR",periodeMulaiBayar);
        mutasiLebihBayarSPParam.put("PAR_ID_KATEGORI_CATATAN",idKategoriCatatan);
        mutasiLebihBayarSPParam.put("PAR_KETERANGAN",keterangan);
        mutasiLebihBayarSPParam.put("PAR_ID_VALIDASI",idValidasi);
        mutasiLebihBayarSPParam.put("PAR_NAMA_VALIDASI",namaValidasi);

        List<String> mutasiLebihBayarOutSPParam = new ArrayList<>();
        mutasiLebihBayarOutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiLebihBayarOutSPParam.add("PAR_MSG");
        return mutasiLebihBayarRepository.callStoredProcedure("LebihBayar.processMutasiLebihBayar",mutasiLebihBayarSPParam,mutasiLebihBayarOutSPParam);
    }
}
