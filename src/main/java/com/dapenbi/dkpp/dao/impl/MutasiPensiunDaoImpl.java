package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.form.MenikahKembaliSPFormDto;
import com.dapenbi.dkpp.form.MutasiMeninggalSPFormDto;
import com.dapenbi.dkpp.form.MutasiSuskelDataKeluargaFormDto;
import com.dapenbi.dkpp.form.MutasiSuskelFormDto;
import com.dapenbi.dkpp.model.KategoriMutasi;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.repository.MutasiPensiunRepository;
import com.dapenbi.dkpp.repository.ViewModelRepository.MutasiMpSekaligus100Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class MutasiPensiunDaoImpl extends BaseDaoImpl<MutasiPensiun, MutasiPensiunDto, Long>
		implements MutasiPensiunDao {
	private MutasiPensiunRepository mutasiPensiunRepository;
	private MutasiMpSekaligus100Repository mutasiMpSekaligus100Repository;

	@Autowired
	public MutasiPensiunDaoImpl(MutasiPensiunRepository mutasiPensiunRepository, MutasiMpSekaligus100Repository mutasiMpSekaligus100Repository) {
		super(mutasiPensiunRepository);
		this.mutasiPensiunRepository = mutasiPensiunRepository;
		this.mutasiMpSekaligus100Repository = mutasiMpSekaligus100Repository;
	}

	@Override
	public MutasiPensiun findByNip(String nip) {
		return mutasiPensiunRepository.findFirstByNip(nip);
	}

	@Override
	public Map cufnHitungMps100(String nip, String periodeMutasi) {
		return mutasiPensiunRepository.cufnHitungMps100(nip,periodeMutasi);
	}

	@Override
	public Map checkMps100PersenBaru(
			Date tglLahirPeserta,
			Date tglKerjaPeserta,
			Date tglHentiPeserta,
			Date tglAwalBayarMP,
			Date tglLahirPenerima,
			String idKategoryPensiun,
			BigDecimal phdp) {
		return mutasiPensiunRepository.checkMps100PersenValid(tglLahirPeserta, tglKerjaPeserta, tglHentiPeserta,
				tglAwalBayarMP, tglLahirPenerima, idKategoryPensiun, phdp);
	}

	@Override
	public Map checkMps100PersenTunda(
			String nip,
			Date tglMutasi,
			String periodeMutasi,
			Date tglAwalBayarMP,
			String idKategoryPensiun,
			Boolean isJatuhTempoBayar,
			Date tglMeninggalPeserta) {
		if (tglMeninggalPeserta == null) {
			return mutasiPensiunRepository.checkMps100PersenTunda(nip, tglMutasi, periodeMutasi, tglAwalBayarMP, idKategoryPensiun, isJatuhTempoBayar);
		} else {
			return mutasiPensiunRepository.checkMps100PersenTunda(nip, tglMutasi, periodeMutasi, tglAwalBayarMP, idKategoryPensiun, isJatuhTempoBayar, tglMeninggalPeserta);
		}
	}

	@Override
	public Map mpSimulation(Date tglLahirPeserta, Date tglKerjaPeserta, Date tglHentiPeserta, Date tglDPHTPeserta,
			Long idKategoriPenerima, Date tglLahirPenerima, Date tglAwalBayarMP, String idKatergoryPensiun,
			Long idJenisMPS, Long idStatusKawin, Long idUsiaBayar, BigDecimal phdp, Date tglMutasi,
			String periodeMutasi) {
		return mutasiPensiunRepository.mpSimulation(tglLahirPeserta, tglKerjaPeserta, tglHentiPeserta, tglDPHTPeserta,
				idKategoriPenerima, tglLahirPenerima, tglAwalBayarMP, idKatergoryPensiun, idJenisMPS, idStatusKawin,
				idUsiaBayar, phdp, tglMutasi, periodeMutasi);
	}

	@Override
	public Map genSukselanakOtomatis(String Nip, String IdPenerimaMPBaru, Date TglAwalBayar, Date TglAwalBayarbefore, Date tglLahirPenerima, Integer TypeSukel, Integer TypeMutasiOtomatis) {
		return null;
	}

	@Override
    public Map mpWafatSimulation(String nip, String periodeMutasi, String tglMeninggal, Long idStatusBayar) {
        return mutasiPensiunRepository.cufnMpWftSimulation(nip, periodeMutasi, tglMeninggal, idStatusBayar);
    }

    @Override
	public Page<MutasiPensiun> findMutasiPensiunBaru(String searchParam, Pageable pageable) {
		return mutasiPensiunRepository.findAllMutasiPensiunBaru(searchParam, pageable);
	}

	@Override
	public Page<MutasiPensiun> findMutasiPensiunBaruBelumValidasi(String searchParam, Pageable pageable) {
		return mutasiPensiunRepository.findAllMutasiPensiunBaruBelumValidasi(searchParam, pageable);
	}

	@Override
	public Page<MutasiPensiun> findByKategoriMutasi(String idKategoriMutasi, String searchParam, Pageable pageable) {
		KategoriMutasi kategoriMutasi = new KategoriMutasi();
		kategoriMutasi.setId(idKategoriMutasi);
		return mutasiPensiunRepository.findAllByKategoriMutasi(kategoriMutasi, searchParam, pageable);
	}

	@Override
	public Page<MutasiPensiun> findByKategoriMutasiAndPeriodeMutasi(String idKategoriMutasi, String periodeMutasi,String searchParam, Pageable pageable) {
		KategoriMutasi kategoriMutasi = new KategoriMutasi();
		kategoriMutasi.setId(idKategoriMutasi);
		if (searchParam != ""){
			return mutasiPensiunRepository.findAllByKategoriMutasiAndPeriodeMutasiByNip(kategoriMutasi,periodeMutasi, searchParam, pageable);
		}else {
			return mutasiPensiunRepository.findAllByKategoriMutasiAndPeriodeMutasi(kategoriMutasi, periodeMutasi, pageable);
		}
	}

	@Override
	public Page<MutasiPensiun> findByKategoriMutasiAndPeriodeMutasiBelumValidasi(String idKategoriMutasi, String periodeMutasi, String searchParam, Pageable pageable) {
		KategoriMutasi kategoriMutasi = new KategoriMutasi();
		kategoriMutasi.setId(idKategoriMutasi);
		if (searchParam != ""){
			return mutasiPensiunRepository.findAllByKategoriMutasiAndPeriodeMutasiByNipBelumValidasi(kategoriMutasi,periodeMutasi, searchParam, pageable);
		}else {
			return mutasiPensiunRepository.findAllByKategoriMutasiAndPeriodeMutasiBelumValidasi(kategoriMutasi, periodeMutasi, pageable);
		}
	}


	public Map processMutasiPensiunBaru(Long role, String compName, String userName, Long idMutasi, String kodeMutasi,
			String kategoriMutasi, String periodeMutasi, Date tglMutasi, String nip, String namaPeserta,
			Character jenisKelaminPeserta, Date tglLahirPeserta, Date tglKerjaPeserta, Date tglDPHTPeserta,
			Date tglHentiPeserta, String tempatMeninggalPeserta, Date tglMeninggalPeserta, String tempatLahirPeserta,
			Long golongan, String golonganPangkat, Long agama, String namaAgama, String kantorBayar,
			String namaKantorBayar, Long predikat, String namaPredikat, String alasanHenti, String keteranganHenti,
			Date tglSPBI, String noSPBI, Date tglSKBI, String noSKBI, BigDecimal phdpLama, BigDecimal upahVeteran,
			Long jenisMPS, String namaMPS, String kategoriPensiun, String namaKategoriPensiun, Long usiaBayar,
			String namaUsiaBayar, Long statusBayar, String namaStatusBayar, Long statusKawin, String namaStatusKawin,
			Date tglTundaJatuhTempo, Date tglAwalBayar, Date tglMPBulanKe13, Date tglHentiBayar, String idPenerimaMP,
			String namaPenerimaMP, Date tglLahirPenerimaMP, String jenisKelaminPenerimaMP, Long kategoriPenerimaMP,
			String namaKategoriPenerimaMP, Date tglSKDapenbi, String noSKDapenbi, Date tglUsia25TPenerimaMP,
			Boolean alamatIsDalamNegeri, Long provinsi, String namaProvinsi, Long kota, String namaKota, Long kecamatan,
			String namaKecamatan, Long kelurahan, String namaKelurahan, String kodePos, String alamaLengkap, String rt,
			String rw, Long negera, String namaNegara, Long suskel, String namaSuskel, Long kategoriCatatan,
			String namaKategoriCatatan, Long statusKawinPenerimaMP, String namaStatusKawinPenerimaMP, String noHP,
			String noTlp, String email, Long validasi, String namaValidasi, String userStamp, String userValidasi,
			String keterangan) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();

		mutasiPensiunSPParam.put("ROLE_ID", role);
		mutasiPensiunSPParam.put("COMP_NAME", compName);
		mutasiPensiunSPParam.put("USER_NAME", userName);
		mutasiPensiunSPParam.put("PAR_ID_MUTASI", idMutasi);
		mutasiPensiunSPParam.put("PAR_KODE_MUTASI", kodeMutasi);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_MUTASI", kategoriMutasi);
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", periodeMutasi);
		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", tglMutasi);
		mutasiPensiunSPParam.put("PAR_NIP", nip);
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA", namaPeserta);
		mutasiPensiunSPParam.put("PAR_JENIS_KELAMIN_PESERTA", jenisKelaminPeserta.toString());
		mutasiPensiunSPParam.put("PAR_TGL_LAHIR_PESERTA", tglLahirPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_KERJA_PESERTA", tglKerjaPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_DPTHT_PESERTA", tglDPHTPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_HENTI_KERJA_PESERTA", tglHentiPeserta);
		mutasiPensiunSPParam.put("PAR_TEMPAT_MENINGGAL_PESERTA", tempatMeninggalPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_MENINGGAL_PESERTA", tglMeninggalPeserta);
		mutasiPensiunSPParam.put("PAR_TEMPAT_LAHIR_PESERTA", tempatLahirPeserta);
		mutasiPensiunSPParam.put("PAR_ID_GOLONGAN", golongan);
		mutasiPensiunSPParam.put("PAR_GOLONGAN_PANGKAT", golonganPangkat);
		mutasiPensiunSPParam.put("PAR_ID_AGAMA", agama);
		mutasiPensiunSPParam.put("PAR_NAMA_AGAMA", namaAgama);
		mutasiPensiunSPParam.put("PAR_ID_KANTOR_BAYAR", kantorBayar);
		mutasiPensiunSPParam.put("PAR_NAMA_KANTOR_BAYAR", namaKantorBayar);
		mutasiPensiunSPParam.put("PAR_ID_PREDIKAT", predikat);
		mutasiPensiunSPParam.put("PAR_NAMA_PREDIKAT", namaPredikat);
		mutasiPensiunSPParam.put("PAR_ID_HENTI", alasanHenti);
		mutasiPensiunSPParam.put("PAR_KETERANGAN_HENTI", keteranganHenti);
		mutasiPensiunSPParam.put("PAR_TGL_SP_BI", tglSPBI);
		mutasiPensiunSPParam.put("PAR_NO_SP_BI", noSPBI);
		mutasiPensiunSPParam.put("PAR_TGL_SK_BI", tglSKBI);
		mutasiPensiunSPParam.put("PAR_NO_SK_BI", noSKBI);
		mutasiPensiunSPParam.put("PAR_PHDP_LAMA", phdpLama);
		mutasiPensiunSPParam.put("PAR_UPAH_VETERAN", upahVeteran);
		mutasiPensiunSPParam.put("PAR_ID_JENIS_MPS", jenisMPS);
		mutasiPensiunSPParam.put("PAR_NAMA_MPS", namaMPS);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_PENSIUN", kategoriPensiun);
		mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_PENSIUN", namaKategoriPensiun);
		mutasiPensiunSPParam.put("PAR_ID_USIA_BAYAR", usiaBayar);
		mutasiPensiunSPParam.put("PAR_NAMA_USIA_BAYAR", namaUsiaBayar);
		mutasiPensiunSPParam.put("PAR_ID_STATUS_BAYAR", statusBayar);
		mutasiPensiunSPParam.put("PAR_STATUS_BAYAR", namaStatusBayar);
		mutasiPensiunSPParam.put("PAR_ID_STATUS_KAWIN", statusKawin);
		mutasiPensiunSPParam.put("PAR_NAMA_STATUS_KAWIN", namaStatusKawin);
		mutasiPensiunSPParam.put("PAR_TGL_TUNDA_JATUH_TEMPO", tglTundaJatuhTempo);
		mutasiPensiunSPParam.put("PAR_TGL_AWAL_BAYAR", tglAwalBayar);
		mutasiPensiunSPParam.put("PAR_TGL_MP_BULAN_KE13", tglMPBulanKe13);
		mutasiPensiunSPParam.put("PAR_TGL_HENTI_BAYAR", tglHentiBayar);
		mutasiPensiunSPParam.put("PAR_ID_PENERIMA_MP", idPenerimaMP);
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP", namaPenerimaMP);
		mutasiPensiunSPParam.put("PAR_TGL_LAHIR_PENERIMA_MP", tglLahirPenerimaMP);
		mutasiPensiunSPParam.put("PAR_JENIS_KELAMIN_PENERIMA_MP", jenisKelaminPenerimaMP);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_PENERIMA_MP", kategoriPenerimaMP);
		mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_PENERIMA_MP", namaKategoriPenerimaMP);
		mutasiPensiunSPParam.put("PAR_TGL_SK_DAPENBI", tglSKDapenbi);
		mutasiPensiunSPParam.put("PAR_NO_SK_DAPENBI", noSKDapenbi);
		mutasiPensiunSPParam.put("PAR_TGL_USIA25T_PENERIMA_MP", tglUsia25TPenerimaMP);
		mutasiPensiunSPParam.put("PAR_ALAMAT_IS_DALAM_NEGERI", alamatIsDalamNegeri);
		mutasiPensiunSPParam.put("PAR_ID_PROVINSI", provinsi);
		mutasiPensiunSPParam.put("PAR_NAMA_PROVINSI", namaProvinsi);
		mutasiPensiunSPParam.put("PAR_ID_KOTA_KAB", kota);
		mutasiPensiunSPParam.put("PAR_NAMA_KOTA_KAB", namaKota);
		mutasiPensiunSPParam.put("PAR_ID_KECAMATAN", kecamatan);
		mutasiPensiunSPParam.put("PAR_NAMA_KECAMATAN", namaKecamatan);
		mutasiPensiunSPParam.put("PAR_ID_KELURAHAN", kelurahan);
		mutasiPensiunSPParam.put("PAR_NAMA_KELURAHAN", namaKelurahan);
		mutasiPensiunSPParam.put("PAR_KODE_POS", kodePos);
		mutasiPensiunSPParam.put("PAR_ALAMAT_LENGKAP", alamaLengkap);
		mutasiPensiunSPParam.put("PAR_RT", rt);
		mutasiPensiunSPParam.put("PAR_RW", rw);
		mutasiPensiunSPParam.put("PAR_ID_NEGARA", negera);
		mutasiPensiunSPParam.put("PAR_NAMA_NEGARA", namaNegara);
		mutasiPensiunSPParam.put("PAR_ID_SUSKEL", suskel);
		mutasiPensiunSPParam.put("PAR_NAMA_SUSKEL", namaSuskel);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", kategoriCatatan);
		mutasiPensiunSPParam.put("PAR_NAMA_CATATAN", namaKategoriCatatan);
		mutasiPensiunSPParam.put("PAR_ID_KAWIN_PENERIMA_MP", statusKawinPenerimaMP);
		mutasiPensiunSPParam.put("PAR_NAMA_KAWIN_PENERIMA_MP", namaStatusKawinPenerimaMP);
		mutasiPensiunSPParam.put("PAR_NO_HP", noHP);
		mutasiPensiunSPParam.put("PAR_NO_TLP", noTlp);
		mutasiPensiunSPParam.put("PAR_EMAIL", email);
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", validasi);
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", namaValidasi);
		mutasiPensiunSPParam.put("PAR_USER_STAMP", userStamp);
		mutasiPensiunSPParam.put("PAR_USER_VALIDASI", userValidasi);
		mutasiPensiunSPParam.put("PAR_KETERANGAN", keterangan);

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");
		mutasiPensiunOutSPParam.add("PAR_ID_MUTASI_VAL");

		return mutasiPensiunRepository.callStoredProcedure("MutasiPensiun.processMutasiPensiun", mutasiPensiunSPParam,
			mutasiPensiunOutSPParam);
	}

	@Override
	public Map processMutasiPensiunTunda(Long roleId,
										 String compName,
										 String userName,
										 Long idMutasi,
										 String kodeMutasi,
										 String idKategoriMutasi,
										 String periodeMutasi,
										 Date tglMutasi,
										 String nip,
										 String namaPeserta,
										 String jenisKelaminPeserta,
										 Date tglLahirPeserta,
										 Date tglKerjaPeserta,
										 Date tglDpthtPeserta,
										 Date tglHentiKerjaPeserta,
										 String tempatMeninggalPeserta,
										 Date tglMeninggalPeserta,
										 String tempatLahirPeserta,
										 Long idGolongan,
										 String golonganPangkat,
										 Long idAgama,
										 String namaAgama,
										 String idKantorBayar,
										 String namaKantorBayar,
										 Long idPredikat,
										 String namaPredikat,
										 String idHenti,
										 String keteranganHenti,
										 Date tglSpBi,
										 String noSpBi,
										 Date tglSkBi,
										 String noSkBi,
										 BigDecimal phdpLama,
										 BigDecimal upahVeteran,
										 Long idJenisMps,
										 String namaMps,
										 String idKategoriPensiun,
										 String namaKategoriPensiun,
										 Long idUsiaBayar,
										 String namaUsiaBayar,
										 Long idStatusBayar,
										 String statusBayar,
										 Long idStatusKawin,
										 String namaStatusKawin,
										 Date tglTundaJatuhTempo,
										 Date tglAwalBayar,
										 Date tglMpBulanKe13,
										 Date tglHentiBayar,
										 String idPenerimaMp,
										 String namaPenerimaMp,
										 Date tglLahirPenerimaMp,
										 String jenisKelaminPenerimaMp,
										 Long idKategoriPenerimaMp,
										 String namaKategoriPenerimaMp,
										 Date tglSkDapenbi,
										 String noSkDapenbi,
										 Date tglUsia25TPenerimaMp,
										 Boolean alamatIsDalamNegeri,
										 Long idProvinsi,
										 String namaProvinsi,
										 Long idKotaKab,
										 String namaKotaKab,
										 Long idKecamatan,
										 String namaKecamatan,
										 Long idKelurahan,
										 String namaKelurahan,
										 String kodePos,
										 String alamatLengkap,
										 String rt,
										 String rw,
										 Long idNegara,
										 String namaNegara,
										 Long idSuskel,
										 String namaSuskel,
										 Long idKategoriCatatan,
										 String namaCatatan,
										 Long idKawinPenerimaMp,
										 String namaKawinPenerimaMp,
										 String noHp,
										 String noTlp,
										 String email,
										 Long idValidasi,
										 String namaValidasi,
										 String userStamp,
										 String userValidasi,
										 String keterangan,
										 Long idAlasanMps100,
										 String namaAlasanMps100) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();

		mutasiPensiunSPParam.put("ROLE_ID", roleId);
		mutasiPensiunSPParam.put("COMP_NAME", compName);
		mutasiPensiunSPParam.put("USER_NAME", userName);
		mutasiPensiunSPParam.put("PAR_ID_MUTASI", idMutasi);
		mutasiPensiunSPParam.put("PAR_KODE_MUTASI", kodeMutasi);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_MUTASI", idKategoriMutasi);
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", periodeMutasi);
		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", tglMutasi);
		mutasiPensiunSPParam.put("PAR_NIP", nip);
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA", namaPeserta);
		mutasiPensiunSPParam.put("PAR_JENIS_KELAMIN_PESERTA", jenisKelaminPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_LAHIR_PESERTA", tglLahirPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_KERJA_PESERTA", tglKerjaPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_DPTHT_PESERTA", tglDpthtPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_HENTI_KERJA_PESERTA", tglHentiKerjaPeserta);
		mutasiPensiunSPParam.put("PAR_TEMPAT_MENINGGAL_PESERTA", tempatMeninggalPeserta);
		mutasiPensiunSPParam.put("PAR_TGL_MENINGGAL_PESERTA", tglMeninggalPeserta);
		mutasiPensiunSPParam.put("PAR_TEMPAT_LAHIR_PESERTA", tempatLahirPeserta);
		mutasiPensiunSPParam.put("PAR_ID_GOLONGAN", idGolongan);
		mutasiPensiunSPParam.put("PAR_GOLONGAN_PANGKAT", golonganPangkat);
		mutasiPensiunSPParam.put("PAR_ID_AGAMA", idAgama);
		mutasiPensiunSPParam.put("PAR_NAMA_AGAMA", namaAgama);
		mutasiPensiunSPParam.put("PAR_ID_KANTOR_BAYAR", idKantorBayar);
		mutasiPensiunSPParam.put("PAR_NAMA_KANTOR_BAYAR", namaKantorBayar);
		mutasiPensiunSPParam.put("PAR_ID_PREDIKAT", idPredikat);
		mutasiPensiunSPParam.put("PAR_NAMA_PREDIKAT", namaPredikat);
		mutasiPensiunSPParam.put("PAR_ID_HENTI", idHenti);
		mutasiPensiunSPParam.put("PAR_KETERANGAN_HENTI", keteranganHenti);
		mutasiPensiunSPParam.put("PAR_TGL_SP_BI", tglSpBi);
		mutasiPensiunSPParam.put("PAR_NO_SP_BI", noSpBi);
		mutasiPensiunSPParam.put("PAR_TGL_SK_BI", tglSkBi);
		mutasiPensiunSPParam.put("PAR_NO_SK_BI", noSkBi);
		mutasiPensiunSPParam.put("PAR_PHDP_LAMA", phdpLama);
		mutasiPensiunSPParam.put("PAR_UPAH_VETERAN", upahVeteran);
		mutasiPensiunSPParam.put("PAR_ID_JENIS_MPS", idJenisMps);
		mutasiPensiunSPParam.put("PAR_NAMA_MPS", namaMps);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_PENSIUN", idKategoriPensiun);
		mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_PENSIUN", namaKategoriPensiun);
		mutasiPensiunSPParam.put("PAR_ID_USIA_BAYAR", idUsiaBayar);
		mutasiPensiunSPParam.put("PAR_NAMA_USIA_BAYAR", namaUsiaBayar);
		mutasiPensiunSPParam.put("PAR_ID_STATUS_BAYAR", idStatusBayar);
		mutasiPensiunSPParam.put("PAR_STATUS_BAYAR", statusBayar);
		mutasiPensiunSPParam.put("PAR_ID_STATUS_KAWIN", idStatusKawin);
		mutasiPensiunSPParam.put("PAR_NAMA_STATUS_KAWIN", namaStatusKawin);
		mutasiPensiunSPParam.put("PAR_TGL_TUNDA_JATUH_TEMPO", tglTundaJatuhTempo);
		mutasiPensiunSPParam.put("PAR_TGL_AWAL_BAYAR", tglAwalBayar);
		mutasiPensiunSPParam.put("PAR_TGL_MP_BULAN_KE13", tglMpBulanKe13);
		mutasiPensiunSPParam.put("PAR_TGL_HENTI_BAYAR", tglHentiBayar);
		mutasiPensiunSPParam.put("PAR_ID_PENERIMA_MP", idPenerimaMp);
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP", namaPenerimaMp);
		mutasiPensiunSPParam.put("PAR_TGL_LAHIR_PENERIMA_MP", tglLahirPenerimaMp);
		mutasiPensiunSPParam.put("PAR_JENIS_KELAMIN_PENERIMA_MP", jenisKelaminPenerimaMp);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_PENERIMA_MP", idKategoriPenerimaMp);
		mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_PENERIMA_MP", namaKategoriPenerimaMp);
		mutasiPensiunSPParam.put("PAR_TGL_SK_DAPENBI", tglSkDapenbi);
		mutasiPensiunSPParam.put("PAR_NO_SK_DAPENBI", noSkDapenbi);
		mutasiPensiunSPParam.put("PAR_TGL_USIA25T_PENERIMA_MP", tglUsia25TPenerimaMp);
		mutasiPensiunSPParam.put("PAR_ALAMAT_IS_DALAM_NEGERI", alamatIsDalamNegeri);
		mutasiPensiunSPParam.put("PAR_ID_PROVINSI", idProvinsi);
		mutasiPensiunSPParam.put("PAR_NAMA_PROVINSI", namaProvinsi);
		mutasiPensiunSPParam.put("PAR_ID_KOTA_KAB", idKotaKab);
		mutasiPensiunSPParam.put("PAR_NAMA_KOTA_KAB", namaKotaKab);
		mutasiPensiunSPParam.put("PAR_ID_KECAMATAN", idKecamatan);
		mutasiPensiunSPParam.put("PAR_NAMA_KECAMATAN", namaKecamatan);
		mutasiPensiunSPParam.put("PAR_ID_KELURAHAN", idKelurahan);
		mutasiPensiunSPParam.put("PAR_NAMA_KELURAHAN", namaKelurahan);
		mutasiPensiunSPParam.put("PAR_KODE_POS", kodePos);
		mutasiPensiunSPParam.put("PAR_ALAMAT_LENGKAP", alamatLengkap);
		mutasiPensiunSPParam.put("PAR_RT", rt);
		mutasiPensiunSPParam.put("PAR_RW", rw);
		mutasiPensiunSPParam.put("PAR_ID_NEGARA", idNegara);
		mutasiPensiunSPParam.put("PAR_NAMA_NEGARA", namaNegara);
		mutasiPensiunSPParam.put("PAR_ID_SUSKEL", idSuskel);
		mutasiPensiunSPParam.put("PAR_NAMA_SUSKEL", namaSuskel);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", idKategoriCatatan);
		mutasiPensiunSPParam.put("PAR_NAMA_CATATAN", namaCatatan);
		mutasiPensiunSPParam.put("PAR_ID_KAWIN_PENERIMA_MP", idKawinPenerimaMp);
		mutasiPensiunSPParam.put("PAR_NAMA_KAWIN_PENERIMA_MP", namaKawinPenerimaMp);
		mutasiPensiunSPParam.put("PAR_NO_HP", noHp);
		mutasiPensiunSPParam.put("PAR_NO_TLP", noTlp);
		mutasiPensiunSPParam.put("PAR_EMAIL", email);
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", idValidasi);
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", namaValidasi);
		mutasiPensiunSPParam.put("PAR_USER_STAMP", userStamp);
		mutasiPensiunSPParam.put("PAR_USER_VALIDASI", userValidasi);
		mutasiPensiunSPParam.put("PAR_KETERANGAN", keterangan);
		mutasiPensiunSPParam.put("PAR_ID_ALASAN_MPS100", idAlasanMps100);
		mutasiPensiunSPParam.put("PAR_NAMA_ALASAN_MPS100", namaAlasanMps100);

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");
		mutasiPensiunOutSPParam.add("PAR_ID_MUTASI_VAL");

		return mutasiPensiunRepository.callStoredProcedure("MutasiPensiun.processMutasiPensiunTunda", mutasiPensiunSPParam,
			mutasiPensiunOutSPParam);
	}

	@Override
	public Map processMutasiMpMeninggalDunia(Long roleId, String compName, String userName, Long idMutas, String kodeMutasi, String periodeMutasi, Date tglMutasi, String nip, String namaPesertaUpdate, Long idAgamaUpdate, String namaAgamaUpdate, Long idGolonganUpdate, String namaGolonganUpdate, BigDecimal phdp, String idKantorBayarUpdate, String namaKantorBayarUpdate, Date tglSpBI, String noSpBI, Date tglSkBIUpdate, String noSkBIUpdate, Boolean alamatIsDalamNegeriUpdate, Long idProvinsiUpdate, String namaProvinsiUpdate, Long idKotaKabUpdate, String namaKotaKabUpdate, Long idKecamatanUpdate, String namaKecamatanUpdate, Long idKelurahanUpdate, String namaKelurahanUpdate, String kodePosUpdate, String alamatLengkapUpdate, String noHpUpdate, String noTlpUpdate, String emailUpdate, String rtUpdate, String rwUpdate, Long idNegaraUpdate, String namaNegaraUpdate, String idPenerimaMpLama, String namaPenerimaMpLama, Long idKategoriPenerimaMpLama, Date tglWftPenerimaMpLama, Date tglInfWftPenerimaMpLama, String idPenerimaMpBaru, String namaPeneirmaMpBaru, Long idKategoriPenerimaMpBaru, String namaKategoriPenerimaMpBaru, Character jkPenerimaMpBaru, Date tglLahirPenerimaMpBaru, Long idKawinPenerimaMpBaru, String namaKawinPenerimaMpbaru, Long idSuskelPenerimaMpBaru, String namaSuskelBaru, Date tglBulan13, BigDecimal lebihBayarNominal, BigDecimal lebihBayarBulan, BigDecimal lebihBayarNominal13, BigDecimal lebihBayarJmlBulan13, BigDecimal nominalTerbayar, BigDecimal saldoAkhirLebihBayar, Long idStatusBayarUpdate, String namaStatusBayarUpdate, Date tglHentiBayarUpdate, Long idKategoriCatatan, String namaKategoriCatatan, String Keterangan, Long idValidasi, String namaValidasi) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("ROLE_ID", roleId);
		mutasiPensiunSPParam.put("COMP_NAME", compName);
		mutasiPensiunSPParam.put("USER_NAME", userName);
		mutasiPensiunSPParam.put("PAR_ID_MUTASI", idMutas);
		mutasiPensiunSPParam.put("PAR_KODE_MUTASI", kodeMutasi);
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", periodeMutasi);
		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", tglMutasi);
		mutasiPensiunSPParam.put("PAR_NIP", nip);
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA_UPDATE", namaPesertaUpdate);
		mutasiPensiunSPParam.put("PAR_ID_AGAMA_UPDATE", idAgamaUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_AGAMA_UPDATE", namaAgamaUpdate);
		mutasiPensiunSPParam.put("PAR_ID_GOLONGAN_UPDATE", idGolonganUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_GOLONGAN_UPDATE", namaGolonganUpdate);
		mutasiPensiunSPParam.put("PAR_PHDP", phdp);
		mutasiPensiunSPParam.put("PAR_ID_KANTOR_BAYAR_UPDATE", idKantorBayarUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_KANTOR_BAYAR_UPDATE", namaKantorBayarUpdate);
		mutasiPensiunSPParam.put("PAR_TGL_SP_BI_UPDATE", tglSpBI);
		mutasiPensiunSPParam.put("PAR_NO_SP_BI_UPDATE", noSpBI);
		mutasiPensiunSPParam.put("PAR_TGL_SK_BI_UPDATE", tglSkBIUpdate);
		mutasiPensiunSPParam.put("PAR_NO_SK_BI_UPDATE", noSkBIUpdate);
		mutasiPensiunSPParam.put("PAR_ALMT_IS_DALAMNEGERI_UPDATE", alamatIsDalamNegeriUpdate);
		mutasiPensiunSPParam.put("PAR_ID_PROVINSI_UPDATE", idProvinsiUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_PROVINSI_UPDATE", namaProvinsiUpdate);
		mutasiPensiunSPParam.put("PAR_ID_KOTA_KAB_UPDATE", idKotaKabUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_KOTA_KAB_UPDATE", namaKotaKabUpdate);
		mutasiPensiunSPParam.put("PAR_ID_KECAMATAN_UPDATE", idKecamatanUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_KECAMATAN_UPDATE", namaKecamatanUpdate);
		mutasiPensiunSPParam.put("PAR_ID_KELURAHAN_UPDATE", idKelurahanUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_KELURAHAN_UPDATE", namaKelurahanUpdate);
		mutasiPensiunSPParam.put("PAR_KODE_POS_UPDATE", kodePosUpdate);
		mutasiPensiunSPParam.put("PAR_ALAMAT_LENGKAP_UPDATE", alamatLengkapUpdate);
		mutasiPensiunSPParam.put("PAR_NO_HP_UPDATE", noHpUpdate);
		mutasiPensiunSPParam.put("PAR_NO_TLP_UPDATE", noTlpUpdate);
		mutasiPensiunSPParam.put("PAR_EMAIL_UPDATE", emailUpdate);
		mutasiPensiunSPParam.put("PAR_RT_UPDATE", rtUpdate);
		mutasiPensiunSPParam.put("PAR_RW_UPDATE", rwUpdate);
		mutasiPensiunSPParam.put("PAR_ID_NEGARA_UPDATE", idNegaraUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_NEGARA_UPDATE", namaNegaraUpdate);
		mutasiPensiunSPParam.put("PAR_ID_PENERIMAMP_LAMA", idPenerimaMpLama);
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMAMPLAMA_UPDATE", namaPenerimaMpLama);
		mutasiPensiunSPParam.put("PAR_ID_KAT_PENERIMAMP_LAMA", idKategoriPenerimaMpLama);
		mutasiPensiunSPParam.put("PAR_TGL_WFT_PENERIMAMPLAMA", tglWftPenerimaMpLama);
		mutasiPensiunSPParam.put("PAR_TGL_INFWFT_PENERIMAMPLAMA", tglInfWftPenerimaMpLama);
		mutasiPensiunSPParam.put("PAR_ID_PENERIMA_MP_BARU", idPenerimaMpBaru);
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMA_MP_BARU", namaPeneirmaMpBaru);
		mutasiPensiunSPParam.put("PAR_ID_KAT_PENERIMAMP_BARU", idKategoriPenerimaMpBaru);
		mutasiPensiunSPParam.put("PAR_NAMA_KAT_PENERIMAMP_BARU", namaKategoriPenerimaMpBaru);
		mutasiPensiunSPParam.put("PAR_JK_PENERIMAMP_BARU", jkPenerimaMpBaru);
		mutasiPensiunSPParam.put("PAR_TGL_LHR_PENERIMAMP_BARU", tglLahirPenerimaMpBaru);
		mutasiPensiunSPParam.put("PAR_ID_KAWIN_PENERIMAMP_BARU", idKawinPenerimaMpBaru);
		mutasiPensiunSPParam.put("PAR_NAMA_KAWIN_PENERIMAMP_BARU", namaKawinPenerimaMpbaru);
		mutasiPensiunSPParam.put("PAR_ID_SUSKEL_BARU", idSuskelPenerimaMpBaru);
		mutasiPensiunSPParam.put("PAR_NAMA_SUSKEL_BARU", namaSuskelBaru);
		mutasiPensiunSPParam.put("PAR_TGL_BULAN13", tglBulan13);
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_NOMINAL", lebihBayarNominal);
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_JML_BULAN", lebihBayarBulan);
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_NOMINAL_13", lebihBayarNominal13);
		mutasiPensiunSPParam.put("PAR_LEBIH_BAYAR_JML_BULAN_13", lebihBayarJmlBulan13);
		mutasiPensiunSPParam.put("PAR_NOMINAL_TERBAYAR", nominalTerbayar);
		mutasiPensiunSPParam.put("PAR_SALDO_AKHIR_LEBIH_BAYAR", saldoAkhirLebihBayar);
		mutasiPensiunSPParam.put("PAR_ID_STATUS_BAYAR_UPDATE", idStatusBayarUpdate);
		mutasiPensiunSPParam.put("PAR_NAMA_STATUS_BAYAR_UPDATE", namaStatusBayarUpdate);
		mutasiPensiunSPParam.put("PAR_TGL_HENTI_BAYAR_UPDATE", tglHentiBayarUpdate);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", idKategoriCatatan);
		mutasiPensiunSPParam.put("PAR_NAMA_KATEGORI_CATATAN", namaKategoriCatatan);
		mutasiPensiunSPParam.put("PAR_KETERANGAN", Keterangan);
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", idValidasi);
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", namaValidasi);

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return mutasiPensiunRepository.callStoredProcedure("MutasiPensiun.cuspMutasiMpMeninggal", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	public Map processMutasiPerubahanNamaPenerimaMp(Long role, String compName, String userName, Long idMutasiPensiun,
			String kodeMutasi, String idKategoriMutasi, String periodeMutasi, Date tglMutasi, String nip,
			String namaPeserta, String idPenerimaMp, String namaPenerimaMp, Long idKategoriPenerimaMp,
			String namaKategoriPenerimaMp, Date tglLahirPenerimaMp, String jenis_kelaminPenerimaMp,
			String idPenerimaMpBaru, String namaPenerimaMpBaru, Long idKtgoriPenerimaMpBaru,
			String nmKtgoripenerimaMpBaru, Date tglLahirPenerimaMpBaru, String jkPenerimaMpBaru, Long idKategoriCatatan,
			String keterangan, String idValidasi, String namaValidasi) {
		Map<String, Object> mutasiPerubahanNamaPenerimaSPParam = new HashMap();

		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ROLE_ID", role);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_COMP_NAME", compName);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_USER_NAME", userName);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_MUTASI_PENSIUN", idMutasiPensiun);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_KODE_MUTASI", kodeMutasi);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_KATEGORI_MUTASI", idKategoriMutasi);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_PERIODE_MUTASI", periodeMutasi);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_TGL_MUTASI", tglMutasi);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_NIP", nip);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_NAMA_PESERTA", namaPeserta);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_PENERIMA_MP", idPenerimaMp);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_NAMA_PENERIMA_MP", namaPenerimaMp);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_TGL_LAHIR_PENERIMA_MP", tglLahirPenerimaMp);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_JENIS_KELAMIN_PENERIMA_MP", jenis_kelaminPenerimaMp);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_KATERGORI_PENERIMA_MP", idKategoriPenerimaMp);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_NAMA_KATEGORI_PENERIMA_MP", namaKategoriPenerimaMp);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_PENERIMA_MP_BARU", idPenerimaMpBaru);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_NAMA_PENERIMA_MP_BARU", namaPenerimaMpBaru);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_TGL_LAHIR_PENERIMA_MP_BARU", tglLahirPenerimaMpBaru);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_JK_PENERIMA_MP_BARU", jkPenerimaMpBaru);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_KTGORI_PENERIMA_MP_BARU", idKtgoriPenerimaMpBaru);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_NM_KTGORI_PENERIMA_MP_BARU", nmKtgoripenerimaMpBaru);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_KATEGORI_CATATAN", idKategoriCatatan);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_KETERANGAN", keterangan);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_ID_VALIDASI", idValidasi);
		mutasiPerubahanNamaPenerimaSPParam.put("PAR_NAMA_VALIDASI", namaValidasi);

		List<String> mutasiPerubahanNamaPenerimaOutSPParam = new ArrayList<>();
		mutasiPerubahanNamaPenerimaOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPerubahanNamaPenerimaOutSPParam.add("PAR_MSG");
		mutasiPerubahanNamaPenerimaOutSPParam.add("PAR_ID_MUTASI_VAL");

		return mutasiPensiunRepository.callStoredProcedure("MutasiPensiun.processMutasiPerubahanNamaPenerimaMp",
				mutasiPerubahanNamaPenerimaSPParam, mutasiPerubahanNamaPenerimaOutSPParam);
	}

	public Map processMutasiKantorBayar(Long role, String compName, String userName, Long idMutasiPensiun,
			String kodeMutasi, String idKategoriMutasi, String periodeMutasi, Date tglMutasi, String nip,
			String namaPeserta, String idKantorBayar, String namaKantorBayar, String idKantorBayarBaru,
			String namaKantorBayarBaru, Long idKategoriCatatan, String keterangan, String idValidasi,
			String namaValidasi) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();

		mutasiPensiunSPParam.put("PAR_ROLE_ID", role);
		mutasiPensiunSPParam.put("PAR_COMP_NAME", compName);
		mutasiPensiunSPParam.put("PAR_USER_NAME", userName);
		mutasiPensiunSPParam.put("PAR_ID_MUTASI_PENSIUN", idMutasiPensiun);
		mutasiPensiunSPParam.put("PAR_KODE_MUTASI", kodeMutasi);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_MUTASI", idKategoriMutasi);
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", periodeMutasi);
		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", tglMutasi);
		mutasiPensiunSPParam.put("PAR_NIP", nip);
		mutasiPensiunSPParam.put("PAR_NAMA_PESERTA", namaPeserta);
		mutasiPensiunSPParam.put("PAR_ID_KANTOR_BAYAR", idKantorBayar);
		mutasiPensiunSPParam.put("PAR_NAMA_KANTOR_BAYAR", namaKantorBayar);
		mutasiPensiunSPParam.put("PAR_ID_KANTOR_BAYAR_BARU", idKantorBayarBaru);
		mutasiPensiunSPParam.put("PAR_NAMA_KANTOR_BAYAR_BARU", namaKantorBayarBaru);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", idKategoriCatatan);
		mutasiPensiunSPParam.put("PAR_KETERANGAN", keterangan);
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", idValidasi);
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", namaValidasi);

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");
		mutasiPensiunOutSPParam.add("PAR_ID_MUTASI_VAL");

		return mutasiPensiunRepository.callStoredProcedure("MutasiPensiun.processMutasiKantorBayar",
				mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Map cuspMutasiPerubahanPhdp(Long role, Long idMutasi, String compName, String userName, String nip,
			BigDecimal phdpBaru, Date tglBerlakuPhdpBaru, Date tglMutasi, String periodeMutasi, Long kategoriCatatan,
			String keteranganOtomatisUpdate, String keterangan, Long validasi, String namaValidasi) {
		
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("ROLE_ID", role);
		mutasiPensiunSPParam.put("PAR_ID_MUTASI", idMutasi);
		mutasiPensiunSPParam.put("COMP_NAME", compName);
		mutasiPensiunSPParam.put("USER_NAME", userName);
		mutasiPensiunSPParam.put("PAR_NIP", nip);
		mutasiPensiunSPParam.put("PAR_PHDP_BARU", phdpBaru);
		mutasiPensiunSPParam.put("PAR_TGL_BERLAKU_PHDP", tglBerlakuPhdpBaru);
		mutasiPensiunSPParam.put("PAR_TGL_MUTASI", tglMutasi);
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", periodeMutasi);
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", kategoriCatatan);
		mutasiPensiunSPParam.put("PAR_KETERANGAN", keterangan);
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", validasi);
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", namaValidasi);

		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return mutasiPensiunRepository.callStoredProcedure("MutasiPensiun.cuspMutasiPerubahanPhdp",
			mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Map cuspMiSimulation(String nip, BigDecimal phDPBaru, String tglBerlakuPhDPBaru, String tglMutasi,
			String periodeMutasi) {
		return mutasiPensiunRepository.cufnMiSimulation(nip, phDPBaru, tglBerlakuPhDPBaru, tglMutasi, periodeMutasi);
	}

	@Override
	public Page<MutasiPensiun> findAllMutasiPensiunTunda(String searchParam, Pageable pageable) {
		return mutasiPensiunRepository.findAllMutasiPensiunTunda(searchParam, pageable);
	}

	@Override
	public Page<MutasiPensiun> findAllMutasiPensiunTundaBelumValidasi(String searchParam, Pageable pageable) {
		return mutasiPensiunRepository.findAllMutasiPensiunTundaBelumValidasi(searchParam, pageable);
	}

	@Override
    public Page<MutasiPensiun> findAllMutasiPensiunTundaDibayar(String searchParam, Pageable pageable) {
        return mutasiPensiunRepository.findAllMutasiPensiunTundaDibayar(searchParam, pageable);
    }


    public Page<MutasiPensiun> findAllMutasiPensiunJandaDudaMenikahKembali(String searchParam, Pageable pageable){
		return mutasiPensiunRepository.findAllMutasiJandaDudaMenikahKembali(searchParam, pageable);
	}

    /*@Override
    public List<MutasiPensiun> getListMutasiPenerimaMPMeninggal(String periodeMutasi) {

		return mutasiPensiunRepository.getListMutasiPenerimaMPMeninggal(periodeMutasi);
    }*/

    /*@Override
    public Page<MutasiPensiun> findAllMutasiPensiunMeninggal(String periodeMutasi, String searchParam, Pageable pageable) {
        return mutasiPensiunRepository.findAllMutasiPensiunMeninggalDunia(periodeMutasi,searchParam,pageable);
    }*/

	@Override
	public Map cuspMutasiMps100(
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
			, BigDecimal nilaiFaktorFs) {

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
	public Map spMutasiSuskel(MutasiSuskelFormDto spDto) {
		Map<String, Object>mutasiSuskelSpParam = new HashMap<>();
			mutasiSuskelSpParam.put("PAR_ROLE_ID",spDto.getRoleId());
			mutasiSuskelSpParam.put("PAR_COMP_NAME",spDto.getCompName());
			mutasiSuskelSpParam.put("PAR_USER_NAME",spDto.getUserName());
			mutasiSuskelSpParam.put("PAR_ID_MUTASI_PENSIUN",spDto.getIdMutasiPensiun());
			mutasiSuskelSpParam.put("PAR_PERIODE_MUTASI",spDto.getPeriodeMutasi());
			mutasiSuskelSpParam.put("PAR_TGL_MUTASI",spDto.getTglMutasi());
			mutasiSuskelSpParam.put("PAR_NIP",spDto.getNip());
			mutasiSuskelSpParam.put("PAR_NAMA_PESERTA",spDto.getNamaPeserta());
			mutasiSuskelSpParam.put("PAR_ID_PENERIMA_MP",spDto.getIdPenerimaMp());
			mutasiSuskelSpParam.put("PAR_NAMA_PENERIMA_MP",spDto.getNamaPenerimaMp());
			mutasiSuskelSpParam.put("PAR_ID_KATEGORI_PENERIMA_MP",spDto.getIdKategoriPenerimaMp());
			mutasiSuskelSpParam.put("PAR_NAMA_KATEGORI_PENERIMA_MP",spDto.getNamaKategoriPenerimaMp());
			mutasiSuskelSpParam.put("PAR_ID_SUSKEL",spDto.getIdSuskel());
			mutasiSuskelSpParam.put("PAR_NAMA_SUSKEL",spDto.getNamaSuskel());
			mutasiSuskelSpParam.put("PAR_ID_SUSKEL_BARU",spDto.getIdSuskel());
			mutasiSuskelSpParam.put("PAR_NAMA_SUSKEL_BARU",spDto.getNamaSuskelBaru());
			mutasiSuskelSpParam.put("PAR_ID_KATEGORI_CATATAN",spDto.getIdKategoriCatatan());
			mutasiSuskelSpParam.put("PAR_NAMA_KATEGORI_CATATAN",spDto.getNamaKategoriCatatan());
			mutasiSuskelSpParam.put("PAR_KETERANGAN",spDto.getKeterangan());
			mutasiSuskelSpParam.put("PAR_ID_VALIDASI",spDto.getIdValidasi());
			mutasiSuskelSpParam.put("PAR_NAMA_VALIDASI",spDto.getNamaValidasi());

		List<String> mutasiSuskelSpOutParam = new ArrayList<>();
			mutasiSuskelSpOutParam.add("PAR_STATUS_EKSEKUSI");
			mutasiSuskelSpOutParam.add("PAR_MSG");
			mutasiSuskelSpOutParam.add("PAR_ID_MUTASI_PENSIUN_VAL");
		return mutasiPensiunRepository.callStoredProcedure("mutasisuskel.cuspMutasiSuskel",mutasiSuskelSpParam,mutasiSuskelSpOutParam);
	}

	@Override
	public Map spMutasiSuskelDataKeluarga(MutasiSuskelDataKeluargaFormDto spDto) {
		Map<String, Object>mutasiSuskelDataKeluargaSpParam = new HashMap<>();
			mutasiSuskelDataKeluargaSpParam.put("PAR_COMP_NAME",spDto.getCompName());
			mutasiSuskelDataKeluargaSpParam.put("PAR_USER_NAME",spDto.getUserName());
			mutasiSuskelDataKeluargaSpParam.put("PAR_ID_MUTASI_PENSIUN",spDto.getIdMutasiPensiun());
			mutasiSuskelDataKeluargaSpParam.put("PAR_ID_KELUARGA",spDto.getIdKeluarga());
		mutasiSuskelDataKeluargaSpParam.put("PAR_NIP",spDto.getNip());
		mutasiSuskelDataKeluargaSpParam.put("PAR_NAMA_KELUARGA",spDto.getNamaKeluarga());
		mutasiSuskelDataKeluargaSpParam.put("PAR_ID_KATEGORI_PENERIMA",spDto.getIdKategoriPenerima());
		mutasiSuskelDataKeluargaSpParam.put("PAR_NAMA_KATEGORI_PENERIMA",spDto.getNamaKategoriPenerima());
		mutasiSuskelDataKeluargaSpParam.put("PAR_JENIS_KELAMIN",spDto.getJenisKelamin());
		mutasiSuskelDataKeluargaSpParam.put("PAR_TEMPAT_LAHIR",spDto.getTempatLahir());
		mutasiSuskelDataKeluargaSpParam.put("PAR_TGL_LAHIR",spDto.getTglLahir());
			mutasiSuskelDataKeluargaSpParam.put("PAR_TGL_MENIKAH",spDto.getTglMenikah());
			mutasiSuskelDataKeluargaSpParam.put("PAR_TGL_CERAI",spDto.getTglCerai());
		mutasiSuskelDataKeluargaSpParam.put("PAR_TGL_USIA25",spDto.getTglUsia25());
			mutasiSuskelDataKeluargaSpParam.put("PAR_TGL_WAFAT",spDto.getTglWafat());
		mutasiSuskelDataKeluargaSpParam.put("PAR_TEMPAT_MENIKAH",spDto.getTempatMenikah());
		mutasiSuskelDataKeluargaSpParam.put("PAR_TEMPAT_WAFAT",spDto.getTempatWafat());
		mutasiSuskelDataKeluargaSpParam.put("PAR_IS_PENERIMA_MP",spDto.getIsPenerimaMp());
		mutasiSuskelDataKeluargaSpParam.put("PAR_ID_ST_KAWIN_PENERIMA_MP",spDto.getIdStKawinPenerimaMp());
		mutasiSuskelDataKeluargaSpParam.put("PAR_NAMA_ST_KAWIN_PENERIMA_MP",spDto.getNamaStKawinPenerimaMp());
//			mutasiSuskelDataKeluargaSpParam.put("PAR_ACTION",spDto.getAction());

		List<String> mutasiSuskelDataKeluargaOutParam = new ArrayList<>();
			mutasiSuskelDataKeluargaOutParam.add("PAR_STATUS_EKSEKUSI");
			mutasiSuskelDataKeluargaOutParam.add("PAR_MSG");
		return mutasiPensiunRepository.callStoredProcedure("mutasisuskel.cuspMutasiSuskelUpd",mutasiSuskelDataKeluargaSpParam,mutasiSuskelDataKeluargaOutParam);
	}

	@Override
	public Map processMutasiPenerimaMpMeninggal(MutasiMeninggalSPFormDto spDto) {
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
		mutasiPensiunSPParam.put("PAR_NAMA_PENERIMAMPLAMA_UPDATE", spDto.getParNamaPenerimamplamaUpdate().trim());
		mutasiPensiunSPParam.put("PAR_ID_KAT_PENERIMAMP_LAMA", spDto.getParIdKatPenerimampLama());
		mutasiPensiunSPParam.put("PAR_TGL_WFT_PENERIMAMPLAMA", spDto.getParTglWftPenerimaMpLama());
		mutasiPensiunSPParam.put("PAR_TGL_INFWFT_PENERIMAMPLAMA", spDto.getParTglInfWftPenerimaMpLama());
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
		return this.mutasiPensiunRepository.callStoredProcedure("MutasiPensiun.cuspMutasiMpMeninggal",
				mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}
}
