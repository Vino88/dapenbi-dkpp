package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dto.KategoriCatatanDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.repository.KategoriCatatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriCatatanDaoImpl extends BaseDaoImpl<KategoriCatatan, KategoriCatatanDto, Long> implements KategoriCatatanDao {
    private KategoriCatatanRepository kategoriCatatanRepository;

    @Autowired
    public KategoriCatatanDaoImpl(KategoriCatatanRepository kategoriCatatanRepository) {
        super(kategoriCatatanRepository);
        this.kategoriCatatanRepository = kategoriCatatanRepository;
    }

    @Override
    public List<KategoriCatatan> findByKategoriMutasi(String idKategorMutasi) {
        KategoriMutasi kategoriMutasi = new KategoriMutasi();
        kategoriMutasi.setId(idKategorMutasi);
        return kategoriCatatanRepository.findAllByKategoriMutasi(kategoriMutasi);
    }

    @Override
    public Page<KategoriCatatan> findAllByKategoriMutasi(KategoriMutasi kategoriMutasi, String searchParam, Pageable pageable) {
        return kategoriCatatanRepository.findAllByKategoriMutasi(kategoriMutasi, searchParam,pageable);
    }

    @Override
    public List<KategoriCatatan> getListKategoriCatatanLebihBayar() {
        return kategoriCatatanRepository.getListKategoriCatatanLebihBayar();

    }

    @Override
    public List<KategoriCatatan> getListKategoriCatatanMutasiMpSekaligus() {
        return kategoriCatatanRepository.getListKategoriCatatanMutasiMpSekaligus();
    }

    @Override
    public List<KategoriCatatan> getListKategoriCatatanPenerimaMpMeninggal() {
        return kategoriCatatanRepository.getListKategoriCatatanPenerimaMpMeninggal();
    }
}
