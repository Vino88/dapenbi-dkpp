package com.dapenbi.dkpp.dao.ViewModel;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.dto.ViewModelDto.MutasiMpSekaligus100ViewDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.model.ViewModel.MutasiMpSekaligus100View;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public interface MutasiMpSekaligus100ViewDao extends BaseDao<MutasiMpSekaligus100View, MutasiMpSekaligus100ViewDto,Long> {

    Map cuspMutasiMps100(
            String compName
            , String userName
            , Long role
            , String periodeMutasi
            , Long idMutasi
            , Date tglMutasi
            , String nip
            , Date tglMohonMps100
            , Date tglBayarMps100
            , String usiaPenerimaBayar
            , String usiaPenerimaBayarBlt
            , Date tglHentiBayar
            , BigDecimal mps100
            , BigDecimal mps100Bulat
            , Long idAlasanMps100
            , String namaAlasanMps100
            , String idValidasi
            , String namaValidasi
            , Long idKategoriCatatan
            , String namaCatatan
            , String keterangan
            , Long idFaktorFs
            , String namaFaktorFs
            , String faktorFs
            , BigDecimal nilaiFaktorFs
    );

    Page<MutasiMpSekaligus100View> findAllByBelumValidasi(String searchParam, Pageable pageable);
}
