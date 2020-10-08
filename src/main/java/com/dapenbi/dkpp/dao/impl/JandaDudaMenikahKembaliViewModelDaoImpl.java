package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.JandaDudaMenikahKembaliViewModelDao;
import com.dapenbi.dkpp.dto.AlamatDto;
import com.dapenbi.dkpp.dto.JandaDudaMenikahKembaliViewModelDto;
import com.dapenbi.dkpp.form.MenikahKembaliSPFormDto;
import com.dapenbi.dkpp.model.JandaDudaMenikahKembaliViewModel;
import com.dapenbi.dkpp.repository.JandaDudaMenikahKembaliViewModelRepository;
import com.dapenbi.dkpp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.*;

@Service
public class JandaDudaMenikahKembaliViewModelDaoImpl extends BaseDaoImpl<JandaDudaMenikahKembaliViewModel, JandaDudaMenikahKembaliViewModelDto, Long>
		implements JandaDudaMenikahKembaliViewModelDao {
	private JandaDudaMenikahKembaliViewModelRepository jandaDudaMenikahKembaliViewModelRepository;

	private final EntityManager entityManager;

	@Autowired
	public JandaDudaMenikahKembaliViewModelDaoImpl(JandaDudaMenikahKembaliViewModelRepository jandaDudaMenikahKembaliViewModelRepository, EntityManager entityManager) {
		super(jandaDudaMenikahKembaliViewModelRepository);
		this.jandaDudaMenikahKembaliViewModelRepository = jandaDudaMenikahKembaliViewModelRepository;
		this.entityManager = entityManager;
	}


	@Override
	public JandaDudaMenikahKembaliViewModel findFirstByNip(String nip) {
		return this.jandaDudaMenikahKembaliViewModelRepository.findFirstByNip(nip);
	}

	@Override
	public JandaDudaMenikahKembaliViewModel findFirstByIdAndNip(Long id, String nip) {
		return this.jandaDudaMenikahKembaliViewModelRepository.findFirstByIdMutasiPensiunAndNip(id, nip);
	}

	@Override
	public Object findAlamatByKelurahan(String id) {
		return this.jandaDudaMenikahKembaliViewModelRepository.findAlamatByKelurahan(id);
	}

	@Override
	public Map cufnMenikahSimulation(String nip, String periodeMutasi, String tglMenikah, Long idStatusBayarBaru) {
		return this.jandaDudaMenikahKembaliViewModelRepository.cufnMenikahSimulation(nip,periodeMutasi ,tglMenikah ,idStatusBayarBaru);
	}

	@Override
	public Map processMutasiPenerimaMpMenikah(MenikahKembaliSPFormDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("ROLE_ID", spDto.getRoleId());
		mutasiPensiunSPParam.put("COMP_NAME", spDto.getCompName());
		mutasiPensiunSPParam.put("USER_NAME", spDto.getUserName());
		mutasiPensiunSPParam.put("PAR_ID_MUTASI", spDto.getParIdMutasi());
		mutasiPensiunSPParam.put("PAR_KODE_MUTASI", spDto.getParKodeMutasi());
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", spDto.getParTglMutasi());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA_UPDATE", spDto.getParNamaPesertaUpdate());
		mutasiPensiunSPParam.put("PAR_ID_AGAMA_UPDATE", spDto.getParIdAgamaUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_AGAMA_UPDATE", spDto.getParNamaAgamaUpdate());
		mutasiPensiunSPParam.put("PAR_ID_GOLONGAN_UPDATE", spDto.getParIdGolonganUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_GOLONGAN_UPDATE", spDto.getParNamaGolonganUpdate());
		mutasiPensiunSPParam.put("PAR_PHDP", spDto.getParPhdp());
		mutasiPensiunSPParam.put("PAR_ID_KANTOR_BAYAR_UPDATE", spDto.getParIdKantorBayarUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_KANTOR_BAYAR_UPDATE", spDto.getParNamaKantorBayarUpdate());
		mutasiPensiunSPParam.put("PAR_TGL_SP_BI_UPDATE", spDto.getParTglSpBiUpdate());
		mutasiPensiunSPParam.put("PAR_NO_SP_BI_UPDATE", spDto.getParNoSpBiUpdate());
		mutasiPensiunSPParam.put("PAR_TGL_SK_BI_UPDATE", spDto.getParTglSkBiUpdate());
		mutasiPensiunSPParam.put("PAR_NO_SK_BI_UPDATE", spDto.getParNoSkBiUpdate());
		mutasiPensiunSPParam.put("PAR_ALMT_IS_DALAMNEGERI_UPDATE", spDto.getParAlmtIsDalamnegeriUpdate());
		mutasiPensiunSPParam.put("PAR_ID_PROVINSI_UPDATE", spDto.getParIdProvinsiUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_PROVINSI_UPDATE", spDto.getParNamaProvinsiUpdate());
		mutasiPensiunSPParam.put("PAR_ID_KOTA_KAB_UPDATE", spDto.getParIdKotaKabUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_KOTA_KAB_UPDATE", spDto.getParNamaKotaKabUpdate());
		mutasiPensiunSPParam.put("PAR_ID_KECAMATAN_UPDATE", spDto.getParIdKecamatanUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_KECAMATAN_UPDATE", spDto.getParNamaKecamatanUpdate());
		mutasiPensiunSPParam.put("PAR_ID_KELURAHAN_UPDATE", spDto.getParIdKelurahanUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_KELURAHAN_UPDATE", spDto.getParNamaKelurahanUpdate());
		mutasiPensiunSPParam.put("PAR_KODE_POS_UPDATE", spDto.getParKodePosUpdate());
		mutasiPensiunSPParam.put("PAR_ALAMAT_LENGKAP_UPDATE", spDto.getParAlamatLengkapUpdate());
		mutasiPensiunSPParam.put("PAR_NO_HP_UPDATE", spDto.getParNoHpUpdate());
		mutasiPensiunSPParam.put("PAR_NO_TLP_UPDATE", spDto.getParNoTlpUpdate());
		mutasiPensiunSPParam.put("PAR_EMAIL_UPDATE", spDto.getParEmailUpdate());
		mutasiPensiunSPParam.put("PAR_RT_UPDATE", spDto.getParRtUpdate());
		mutasiPensiunSPParam.put("PAR_RW_UPDATE", spDto.getParRwUpdate());
		mutasiPensiunSPParam.put("PAR_ID_NEGARA_UPDATE", spDto.getParIdNegaraUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_NEGARA_UPDATE", spDto.getParNamaNegaraUpdate());
		mutasiPensiunSPParam.put("PAR_ID_PENERIMAMP_LAMA", spDto.getParIdPenerimampLama());
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMAMPLAMA_UPDATE", spDto.getParNamaPenerimamplamaUpdate());
		mutasiPensiunSPParam.put("PAR_ID_KAT_PENERIMAMP_LAMA", spDto.getParIdKatPenerimampLama());
		mutasiPensiunSPParam.put("PAR_TGL_NIKAH_PENERIMAMPLAMA", spDto.getParTglNikahPenerimamplama());
		mutasiPensiunSPParam.put("PAR_TGL_INFNKH_PENERIMAMPLAMA", spDto.getParTglInfnkhPenerimamplama());
		mutasiPensiunSPParam.put("PAR_ID_PENERIMA_MP_BARU", spDto.getParIdPenerimaMpBaru());
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP_BARU", spDto.getParNamaPenerimaMpBaru());
		mutasiPensiunSPParam.put("PAR_ID_KAT_PENERIMAMP_BARU", spDto.getParIdKatPenerimampBaru());
		mutasiPensiunSPParam.put("PAR_NAMA_KAT_PENERIMAMP_BARU", spDto.getParNamaKatPenerimampBaru());
		mutasiPensiunSPParam.put("PAR_JK_PENERIMAMP_BARU", spDto.getParJkPenerimampBaru());
		mutasiPensiunSPParam.put("PAR_TGL_LHR_PENERIMAMP_BARU", spDto.getParTglLhrPenerimampBaru());
		mutasiPensiunSPParam.put("PAR_ID_KAWIN_PENERIMAMP_BARU", spDto.getParIdKawinPenerimampBaru());
		mutasiPensiunSPParam.put("PAR_NAMA_KAWIN_PENERIMAMP_BARU", spDto.getParNamaKawinPenerimampBaru());
		mutasiPensiunSPParam.put("PAR_ID_SUSKEL_BARU", spDto.getParIdSuskelBaru());
		mutasiPensiunSPParam.put("PAR_NAMA_SUSKEL_BARU", spDto.getParNamaSuskelBaru());
		mutasiPensiunSPParam.put("PAR_TGL_BULAN13", spDto.getParTglBulan13());
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_NOMINAL", spDto.getParLebihBayarNominal());
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_JML_BULAN", spDto.getParLebihBayarJmlBulan());
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_NOMINAL_13", spDto.getParLebihBayarNominal13());
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_JML_BULAN_13", spDto.getParLebihBayarJmlBulan13());
		mutasiPensiunSPParam.put("PAR_NOMINAL_TERBAYAR", spDto.getParNominalTerbayar());
		mutasiPensiunSPParam.put("PAR_SALDO_AKHIR_LEBIH_BAYAR", spDto.getParSaldoAkhirLebihBayar());
		mutasiPensiunSPParam.put("PAR_ID_STATUS_BAYAR_UPDATE", spDto.getParIdStatusBayarUpdate());
		mutasiPensiunSPParam.put("PAR_NAMA_STATUS_BAYAR_UPDATE", spDto.getParNamaStatusBayarUpdate());
		mutasiPensiunSPParam.put("PAR_TGL_HENTI_BAYAR_UPDATE", spDto.getParTglHentiBayarUpdate());
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", spDto.getParIdKategoriCatatan());
		mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_CATATAN", spDto.getParNamaKategoriCatatan());
		mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());


		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");
		return this.jandaDudaMenikahKembaliViewModelRepository.callStoredProcedure("MutasiPensiun.processMutasiPenerimaMPNikah",
				mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Page<JandaDudaMenikahKembaliViewModel> indexBelumValidasi(String searchParam, Pageable pageable) {
		return jandaDudaMenikahKembaliViewModelRepository.indexBelumValidasi(searchParam, pageable);
	}


}
