package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.model.KategoriMutasi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface KategoriCatatanRepository extends BaseRepository<KategoriCatatan, Long> {

    List<KategoriCatatan> findAllByKategoriMutasi(KategoriMutasi kategoriMutasi);

    @Query(
            value = "select kc from KategoriCatatan kc where kc.kategoriMutasi in ('21','22')"
    )
    List<KategoriCatatan> getListKategoriCatatanLebihBayar();

    @Query(
            value = "select kc from KategoriCatatan kc where kc.kategoriMutasi ='12'"
    )
    List<KategoriCatatan> getListKategoriCatatanMutasiMpSekaligus();

    @Query(
            value = "select kc from KategoriCatatan kc where kc.kategoriMutasi in ('03','04','05')"
    )
    List<KategoriCatatan> getListKategoriCatatanPenerimaMpMeninggal();

    Page<KategoriCatatan> findAllByKategoriMutasi(KategoriMutasi kategoriMutasi, String searchParam, Pageable pageable);

}
