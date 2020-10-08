package com.dapenbi.dkpp.dao.impl;

import java.util.*;

import com.dapenbi.dkpp.form.CuspUpdateHerRegisSPDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dapenbi.dkpp.dao.HerRegistrasiDao;
import com.dapenbi.dkpp.dto.HerRegistrasiDto;
import com.dapenbi.dkpp.model.HerRegistrasi;
import com.dapenbi.dkpp.repository.HerRegistrasiRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Service
public class HerRegistrasiDaoImpl extends BaseDaoImpl<HerRegistrasi, HerRegistrasiDto, Long>
		implements HerRegistrasiDao {

	private HerRegistrasiRepository repository;
	

	@Autowired
	public HerRegistrasiDaoImpl(HerRegistrasiRepository repository) {
		super(repository);
		this.repository = repository;
	}


	@Override
	public Map cuspCreateMasterHerRegis(Long roleId, String compName, String userName, String parTahun,
			Long parJenisHer, String parJenisHerDesc, String parPeriodeTerdaftarPeserta, Long parIdValidasi,
			String parNamaValidasi, String parIdCatatan, String parKategoriCatatan, String parKeterangan) {
		Map<String, Object> masterHerInParam = new HashMap();

		masterHerInParam.put("ROLE_ID", roleId);
		masterHerInParam.put("COMP_NAME", compName);
		masterHerInParam.put("USER_NAME", userName);
		masterHerInParam.put("PAR_TAHUN_HER", parTahun); 
		masterHerInParam.put("PAR_JENIS_HER", parJenisHer);  
		masterHerInParam.put("PAR_JENIS_HER_DESC", parJenisHerDesc); 
		masterHerInParam.put("PAR_PERIODE_TERDAFTAR_PESERTA", parPeriodeTerdaftarPeserta); 
		masterHerInParam.put("PAR_ID_VALIDASI", parIdValidasi); 
		masterHerInParam.put("PAR_NAMA_VALIDASI", parNamaValidasi); 
		masterHerInParam.put("PAR_ID_CATATAN", parIdCatatan); 
		masterHerInParam.put("PAR_KATEGORI_CATATAN", parKategoriCatatan); 
		masterHerInParam.put("PAR_KETERANGAN", parKeterangan); 

        List<String> masterHerOutSPParam = new ArrayList<>();
        masterHerOutSPParam.add("PAR_STATUS_EKSEKUSI");
        masterHerOutSPParam.add("PAR_MSG");
		
		return repository.callStoredProcedure("HerRegistrasi.cuspCreateMasterHerRegis", masterHerInParam, masterHerOutSPParam);
	}


	@Override
	public HerRegistrasi findByTahunHer(String tahunHer) {
		return repository.findByTahunHer(tahunHer);
	}

	@Override
	public Map cuspUpdateMasterHerRegis(
			Long roleId
			, String compName
			, String userName
			, String parTahun
			, String parStatusHer
			, Long parIdValidasi
			, String parNamaValidasi) {

		Map<String, Object> masterHerInParam = new HashMap<>();
		masterHerInParam.put("PAR_ROLE_ID", roleId);
		masterHerInParam.put("PAR_COMP_NAME", compName);
		masterHerInParam.put("PAR_USER_NAME", userName);
		masterHerInParam.put("PAR_TAHUN_HER", parTahun);
		masterHerInParam.put("PAR_STATUS_HER", parStatusHer);
		masterHerInParam.put("PAR_ID_VALIDASI", parIdValidasi);
		masterHerInParam.put("PAR_NAMA_VALIDASI", parNamaValidasi);

		List<String> masterHerOutSPParam = new ArrayList<>();
		masterHerOutSPParam.add("PAR_STATUS_EKSEKUSI");
		masterHerOutSPParam.add("PAR_MSG");

		return repository.callStoredProcedure("HerRegistrasiUpdate.cuspUpdateMasterHerRegis",masterHerInParam,masterHerOutSPParam);
	}

	@Override
	public Map cuspUpdateHerRegis(
			Long roleId,
			String compName,
			String userName,
			String parTahunHer,
			String parNip,
			String parIdPenerimaHer,
			String parNomorHer,
			Date parTglHer,
			String parNipPas1Her,
			String parJenisKelaminPas1Her,
			String parNipPas2Her,
			String parJenisKelaminPas2Her,
			String parNamaPenerimaMpHer,
			Date parTglMeninggalPenerimaHer,
			Long parIdKantorBayarHer,
			String parNamaKantorBayarHer,
			Character parAlamatIsDalamNegeriHer,
			String parAlamatLengkapHer,
			String parRtHer,
			String parRwHer,
			Long parIdKelurahanHer,
			String parNamaKelurahanHer,
			Long parIdKecamatanHer,
			String parNamaKecamatanHer,
			Long parIdKotaKabHer,
			String parNamaKotaKabHer,
			Long parIdProvinsiHer,
			String parNamaProvinsiHer,
			String parKodePosHer,
			Long parIdNegaraHer,
			String parNamaNegaraHer,
			String parNoHpHer,
			String parEmailHer,
			Character parIsNamaPenerimaSama,
			Character parIsTglLahirSama,
			Character parIsSuskelSama,
			Character parIsKantorBayarSama,
			Character parIsAlamatSama,
			Character parIsAdaPhoto,
			Character parIsAdaKk,
			Character parIsAdaKtp,
			Character parIsDataLengkap,
			Character parIsPenerimaMenikahLagi,
			String parTempatMenikah,
			Date parTglMenikah,
			Long parIdSerah,
			String parNamaSerah,
			String parKeteranganSerah,
			Long parIdCatatan,
			String parNamaCatatan,
			String parCatatan,
			Long parIdValidasi,
			String parNamaValidasi
	) {
		Map<String, Object> masterHerInParam = new HashMap<>();
		masterHerInParam.put("PAR_ROLE_ID", roleId);
		masterHerInParam.put("PAR_COMP_NAME", compName);
		masterHerInParam.put("PAR_USER_NAME", userName);
		masterHerInParam.put("PAR_TAHUN_HER", parTahunHer);
		masterHerInParam.put("PAR_NIP", parNip);
		masterHerInParam.put( "PAR_ID_PENERIMA_HER", parIdPenerimaHer);
		masterHerInParam.put( "PAR_NOMOR_HER", parNomorHer);
		masterHerInParam.put("PAR_TGL_HER", parTglHer);
		masterHerInParam.put( "PAR_NIP_PAS_1_HER", parNipPas1Her);
		masterHerInParam.put( "PAR_JENIS_KELAMIN_PAS_1_HER", parJenisKelaminPas1Her);
		masterHerInParam.put( "PAR_NIP_PAS_2_HER", parNipPas2Her);
		masterHerInParam.put( "PAR_JENIS_KELAMIN_PAS_2_HER", parJenisKelaminPas2Her);
		masterHerInParam.put( "PAR_NAMA_PENERIMA_MP_HER", parNamaPenerimaMpHer);
		masterHerInParam.put("PAR_TGL_MENINGGAL_PENERIMA_HER", parTglMeninggalPenerimaHer);
		masterHerInParam.put( "PAR_ID_KANTOR_BAYAR_HER", parIdKantorBayarHer);
		masterHerInParam.put( "PAR_NAMA_KANTOR_BAYAR_HER", parNamaKantorBayarHer);
		masterHerInParam.put("PAR_ALAMAT_IS_DALAM_NEGERI_HER", parAlamatIsDalamNegeriHer);
		masterHerInParam.put( "PAR_ALAMAT_LENGKAP_HER", parAlamatLengkapHer);
		masterHerInParam.put( "PAR_RT_HER", parRtHer);
		masterHerInParam.put( "PAR_RW_HER", parRwHer);
		masterHerInParam.put("PAR_ID_KELURAHAN_HER", parIdKelurahanHer);
		masterHerInParam.put( "PAR_NAMA_KELURAHAN_HER", parNamaKelurahanHer);
		masterHerInParam.put("PAR_ID_KECAMATAN_HER", parIdKecamatanHer);
		masterHerInParam.put( "PAR_NAMA_KECAMATAN_HER", parNamaKecamatanHer);
		masterHerInParam.put("PAR_ID_KOTA_KAB_HER", parIdKotaKabHer);
		masterHerInParam.put( "PAR_NAMA_KOTA_KAB_HER", parNamaKotaKabHer);
		masterHerInParam.put("PAR_ID_PROVINSI_HER", parIdProvinsiHer);
		masterHerInParam.put( "PAR_NAMA_PROVINSI_HER", parNamaProvinsiHer);
		masterHerInParam.put( "PAR_KODE_POS_HER", parKodePosHer);
		masterHerInParam.put("PAR_ID_NEGARA_HER", parIdNegaraHer);
		masterHerInParam.put( "PAR_NAMA_NEGARA_HER", parNamaNegaraHer);
		masterHerInParam.put( "PAR_NO_HP_HER", parNoHpHer);
		masterHerInParam.put( "PAR_EMAIL_HER", parEmailHer);
		masterHerInParam.put("PAR_IS_NAMA_PENERIMA_SAMA", parIsNamaPenerimaSama);
		masterHerInParam.put("PAR_IS_TGL_LAHIR_SAMA", parIsTglLahirSama);
		masterHerInParam.put("PAR_IS_SUSKEL_SAMA", parIsSuskelSama);
		masterHerInParam.put("PAR_IS_KANTOR_BAYAR_SAMA", parIsKantorBayarSama);
		masterHerInParam.put("PAR_IS_ALAMAT_SAMA", parIsAlamatSama);
		masterHerInParam.put("PAR_IS_ADA_PHOTO",parIsAdaPhoto);
		masterHerInParam.put("PAR_IS_ADA_KK", parIsAdaKk);
		masterHerInParam.put("PAR_IS_ADA_KTP", parIsAdaKtp);
		masterHerInParam.put("PAR_IS_DATA_LENGKAP", parIsDataLengkap);
		masterHerInParam.put("PAR_IS_PENERIMA_MENIKAH_LAGI", parIsPenerimaMenikahLagi);
		masterHerInParam.put( "PAR_TEMPAT_MENIKAH", parTempatMenikah);
		masterHerInParam.put("PAR_TGL_MENIKAH", parTglMenikah);
		masterHerInParam.put("PAR_ID_SERAH", parIdSerah);
		masterHerInParam.put( "PAR_NAMA_SERAH", parNamaSerah);
		masterHerInParam.put( "PAR_KETERANGAN_SERAH", parKeteranganSerah);
		masterHerInParam.put("PAR_ID_CATATAN", parIdCatatan);
		masterHerInParam.put( "PAR_NAMA_CATATAN", parNamaCatatan);
		masterHerInParam.put( "PAR_CATATAN", parCatatan);
		masterHerInParam.put("PAR_ID_VALIDASI", parIdValidasi);
		masterHerInParam.put("PAR_NAMA_VALIDASI",parNamaValidasi);

		List<String> masterHerOutSPParam = new ArrayList<>();
		masterHerOutSPParam.add("PAR_STATUS_EKSEKUSI");
		masterHerOutSPParam.add("PAR_MSG");
		masterHerOutSPParam.add("PAR_NOMOR_REGISTRASI");
		return repository.callStoredProcedure("HerRegistrasiUpdate.processCuspUpdateHerRegis",masterHerInParam,masterHerOutSPParam);
	}

	@Override
	public Map cuspUpdateHerRegis(CuspUpdateHerRegisSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("ROLE_ID", spDto.getRoleId());
		mutasiPensiunSPParam.put("COMP_NAME", spDto.getCompName());
		mutasiPensiunSPParam.put("USER_NAME", spDto.getUserName());
		mutasiPensiunSPParam.put("PAR_TAHUN_HER", spDto.getParTahunHer());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_ID_PENERIMA_HER", spDto.getParIdPenerimaHer());
		mutasiPensiunSPParam.put("PAR_NOMOR_HER", spDto.getParNomorHer());
		mutasiPensiunSPParam.put("PAR_TGL_HER", spDto.getParTglHer());
		mutasiPensiunSPParam.put("PAR_NIP_PAS_1_HER", spDto.getParNipPas1Her());
		mutasiPensiunSPParam.put("PAR_JENIS_KELAMIN_PAS_1_HER", spDto.getParJenisKelaminPas1Her());
		mutasiPensiunSPParam.put("PAR_NIP_PAS_2_HER", spDto.getParNipPas2Her());
		mutasiPensiunSPParam.put("PAR_JENIS_KELAMIN_PAS_2_HER", spDto.getParJenisKelaminPas2Her());
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP_HER", spDto.getParNamaPenerimaMpHer());
		mutasiPensiunSPParam.put("PAR_TGL_MENINGGAL_PENERIMA_HER", spDto.getParTglMeninggalPenerimaHer());
		mutasiPensiunSPParam.put("PAR_ID_KANTOR_BAYAR_HER", spDto.getParIdKantorBayarHer());
		mutasiPensiunSPParam.put("PAR_NAMA_KANTOR_BAYAR_HER", spDto.getParNamaKantorBayarHer());
		mutasiPensiunSPParam.put("PAR_ALAMAT_IS_DALAM_NEGERI_HER", spDto.getParAlamatIsDalamNegeriHer());
		mutasiPensiunSPParam.put("PAR_ALAMAT_LENGKAP_HER", spDto.getParAlamatLengkapHer());
		mutasiPensiunSPParam.put("PAR_RT_HER", spDto.getParRtHer());
		mutasiPensiunSPParam.put("PAR_RW_HER", spDto.getParRwHer());
		mutasiPensiunSPParam.put("PAR_ID_KELURAHAN_HER", spDto.getParIdKelurahanHer());
		mutasiPensiunSPParam.put("PAR_NAMA_KELURAHAN_HER", spDto.getParNamaKelurahanHer());
		mutasiPensiunSPParam.put("PAR_ID_KECAMATAN_HER", spDto.getParIdKecamatanHer());
		mutasiPensiunSPParam.put("PAR_NAMA_KECAMATAN_HER", spDto.getParNamaKecamatanHer());
		mutasiPensiunSPParam.put("PAR_ID_KOTA_KAB_HER", spDto.getParIdKotaKabHer());
		mutasiPensiunSPParam.put("PAR_NAMA_KOTA_KAB_HER", spDto.getParNamaKotaKabHer());
		mutasiPensiunSPParam.put("PAR_ID_PROVINSI_HER", spDto.getParIdProvinsiHer());
		mutasiPensiunSPParam.put("PAR_NAMA_PROVINSI_HER", spDto.getParNamaProvinsiHer());
		mutasiPensiunSPParam.put("PAR_KODE_POS_HER", spDto.getParKodePosHer());
		mutasiPensiunSPParam.put("PAR_ID_NEGARA_HER", spDto.getParIdNegaraHer());
		mutasiPensiunSPParam.put("PAR_NAMA_NEGARA_HER", spDto.getParNamaNegaraHer());
		mutasiPensiunSPParam.put("PAR_NO_HP_HER", spDto.getParNoHpHer());
		mutasiPensiunSPParam.put("PAR_EMAIL_HER", spDto.getParEmailHer());
		mutasiPensiunSPParam.put("PAR_IS_NAMA_PENERIMA_SAMA", spDto.getParIsNamaPenerimaSama());
		mutasiPensiunSPParam.put("PAR_IS_TGL_LAHIR_SAMA", spDto.getParIsTglLahirSama());
		mutasiPensiunSPParam.put("PAR_IS_SUSKEL_SAMA", spDto.getParIsSuskelSama());
		mutasiPensiunSPParam.put("PAR_IS_KANTOR_BAYAR_SAMA", spDto.getParIsKantorBayarSama());
		mutasiPensiunSPParam.put("PAR_IS_ALAMAT_SAMA", spDto.getParIsAlamatSama());
		mutasiPensiunSPParam.put("PAR_IS_ADA_PHOTO", spDto.getParIsAdaPhoto());
		mutasiPensiunSPParam.put("PAR_IS_ADA_KK", spDto.getParIsAdaKk());
		mutasiPensiunSPParam.put("PAR_IS_ADA_KTP", spDto.getParIsAdaKtp());
		mutasiPensiunSPParam.put("PAR_IS_DATA_LENGKAP", spDto.getParIsDataLengkap());
		mutasiPensiunSPParam.put("PAR_IS_PENERIMA_MENIKAH_LAGI", spDto.getParIsPenerimaMenikahLagi());
		mutasiPensiunSPParam.put("PAR_TEMPAT_MENIKAH", spDto.getParTempatMenikah());
		mutasiPensiunSPParam.put("PAR_TGL_MENIKAH", spDto.getParTglMenikah());
		mutasiPensiunSPParam.put("PAR_ID_SERAH", spDto.getParIdSerah());
		mutasiPensiunSPParam.put("PAR_NAMA_SERAH", spDto.getParNamaSerah());
		mutasiPensiunSPParam.put("PAR_KETERANGAN_SERAH", spDto.getParKeteranganSerah());
		mutasiPensiunSPParam.put("PAR_ID_CATATAN", spDto.getParIdCatatan());
		mutasiPensiunSPParam.put("PAR_NAMA_CATATAN", spDto.getParNamaCatatan());
		mutasiPensiunSPParam.put("PAR_CATATAN", spDto.getParCatatan());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());

		List<String> masterHerOutSPParam = new ArrayList<>();
		masterHerOutSPParam.add("PAR_STATUS_EKSEKUSI");
		masterHerOutSPParam.add("PAR_MSG");
		masterHerOutSPParam.add("PAR_NOMOR_REGISTRASI");
		return repository.callStoredProcedure("HerRegistrasi.processCuspUpdateHerRegis",mutasiPensiunSPParam,masterHerOutSPParam);
	}



}
