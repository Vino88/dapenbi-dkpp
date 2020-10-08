package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.KategoriCatatanDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.model.KategoriMutasi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import java.util.List;

public interface KategoriCatatanDao extends BaseDao<KategoriCatatan, KategoriCatatanDto, Long> {
    List<KategoriCatatan> findByKategoriMutasi(String idKategorMutasi);
    Page<KategoriCatatan> findAllByKategoriMutasi(KategoriMutasi kategoriMutasi, String searchParam, Pageable pageable);

    List<KategoriCatatan> getListKategoriCatatanLebihBayar();
    List<KategoriCatatan> getListKategoriCatatanMutasiMpSekaligus();
    List<KategoriCatatan> getListKategoriCatatanPenerimaMpMeninggal();
}
