package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.CompositeId.HerRegistrasiDetailPK;
import com.dapenbi.dkpp.model.HerRegistrasiDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HerRegistrasiDetailRepository extends BaseRepository<HerRegistrasiDetail, HerRegistrasiDetailPK>{
	HerRegistrasiDetail findByTahunHerAndNip(String tahunHer, String nip);

	@Query(
			value = "select * from TBL_T_HER_REGISTRASI_DETAIL where TAHUN_HER = ?1 or (nip like ?2 or nama_peserta like ?2 or tahun_her like ?2)",
			nativeQuery = true
	)
	Page<HerRegistrasiDetail> findByTahunHer(String tahunHer, String searchParam, Pageable pageable);

	List<HerRegistrasiDetail> findAllByTahunHer(String tahunHer);

	@Query(
			value = "select CUFN_GENERATE_NO_HERREGISTRASI(?1) from dual",
			nativeQuery = true
	)
	String generateNoReg(String tahunHer);


	@Query(
            value = "select count(*) from TBL_T_HER_REGISTRASI_DETAIL where IS_SUDAH_HER = 0",
            nativeQuery = true
	)
    HerRegistrasiDetail findByBlmRegistrasi();
}
