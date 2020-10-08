package com.dapenbi.dkpp.dao.impl.ViewModel;

import com.dapenbi.dkpp.dao.ViewModel.MutasiMpSekaligus100ViewDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiMpSekaligus100ViewDto;
import com.dapenbi.dkpp.model.ViewModel.MutasiMpSekaligus100View;
import com.dapenbi.dkpp.repository.BaseRepository;

import com.dapenbi.dkpp.repository.ViewModelRepository.MutasiMpSekaligus100Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class MutasiMpSekaligus100ViewDaoImpl extends BaseDaoImpl<MutasiMpSekaligus100View, MutasiMpSekaligus100ViewDto, Long> implements MutasiMpSekaligus100ViewDao {
    private MutasiMpSekaligus100Repository mutasiMpSekaligus100Repository;

    @Autowired
    public MutasiMpSekaligus100ViewDaoImpl(MutasiMpSekaligus100Repository mutasiMpSekaligus100Repository) {
        super(mutasiMpSekaligus100Repository);
        this.mutasiMpSekaligus100Repository = mutasiMpSekaligus100Repository;
    }


    @Override
    public Map cuspMutasiMps100(
            String compName,
            String userName,
            Long role,
            String periodeMutasi,
            Long idMutasi,
            Date tglMutasi,
            String nip,
            Date tglMohonMps100,
            Date tglBayarMps100,
            String usiaPenerimaBayar,
            String usiaPenerimaBayarBlt,
            Date tglHentiBayar,
            BigDecimal mps100,
            BigDecimal mps100Bulat,
            Long idAlasanMps100,
            String namaAlasanMps100,
            String idValidasi,
            String namaValidasi,
            Long idKategoriCatatan,
            String namaCatatan,
            String keterangan,
            Long idFaktorFs,
            String namaFaktorFs,
            String faktorFs,
            BigDecimal nilaiFaktorFs) {
        Map <String, Object>mutasiMp100SPParam = new HashMap<>();
        mutasiMp100SPParam.put("COMP_NAME", compName);
        mutasiMp100SPParam.put("USER_NAME", userName);
        mutasiMp100SPParam.put("ROLE_ID", role);
        mutasiMp100SPParam.put("PAR_PERIODE_MUTASI",periodeMutasi );
        mutasiMp100SPParam.put("PAR_ID_MUTASI",idMutasi);
        mutasiMp100SPParam.put("PAR_TGL_MUTASI",tglMutasi );
        mutasiMp100SPParam.put("PAR_NIP", nip);
        mutasiMp100SPParam.put("PAR_TGL_MOHON_MPS100", tglMohonMps100);
        mutasiMp100SPParam.put("PAR_TGL_BAYAR_MPS100", tglBayarMps100);
        mutasiMp100SPParam.put("PAR_USIAPNERIMABAYAR_MPS100", usiaPenerimaBayar);
        mutasiMp100SPParam.put("PAR_USIAPNERIMABAYAR_MPS100BLT", usiaPenerimaBayarBlt);
        mutasiMp100SPParam.put("PAR_TGL_HENTI_BAYAR_MPS100", tglHentiBayar);
        mutasiMp100SPParam.put("PAR_MPS100", mps100);
        mutasiMp100SPParam.put("PAR_MPS100_BULAT", mps100Bulat);
        mutasiMp100SPParam.put("PAR_ID_ALASAN_MPS_100", idAlasanMps100);
        mutasiMp100SPParam.put("PAR_NAMA_ALASAN_MPS_100", namaAlasanMps100);
        mutasiMp100SPParam.put("PAR_ID_VALIDASI", idValidasi);
        mutasiMp100SPParam.put("PAR_NAMA_VALIDASI", namaValidasi);
        mutasiMp100SPParam.put("PAR_ID_CATATAN", idKategoriCatatan);
        mutasiMp100SPParam.put("PAR_NAMA_CATATAN", namaCatatan);
        mutasiMp100SPParam.put("PAR_KETERANGAN", keterangan);
        mutasiMp100SPParam.put("PAR_ID_FAKTOR_FS", idFaktorFs);
        mutasiMp100SPParam.put("PAR_NAMA_FAKTOR_FS", namaFaktorFs);
        mutasiMp100SPParam.put("PAR_FAKTOR_FS", faktorFs);
        mutasiMp100SPParam.put("PAR_NILAI_FS", nilaiFaktorFs);

        List<String> mutasiMp100OutSPParam = new ArrayList<>();
        mutasiMp100OutSPParam.add("PAR_STATUS_EKSEKUSI");
        mutasiMp100OutSPParam.add("PAR_MSG");
        return mutasiMpSekaligus100Repository.callStoredProcedure("MutasiPensiunView.cuspMutasiMps100",mutasiMp100SPParam,mutasiMp100OutSPParam);
    }

    @Override
    public Page<MutasiMpSekaligus100View> findAllByBelumValidasi(String searchParam, Pageable pageable) {
        return mutasiMpSekaligus100Repository.findAllByBelumValidasi(searchParam,pageable);
    }
}
