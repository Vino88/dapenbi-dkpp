package com.dapenbi.dkpp.dao;

import java.util.Date;
import java.util.Map;

import com.dapenbi.dkpp.dto.HerRegistrasiDto;
import com.dapenbi.dkpp.form.CuspUpdateHerRegisSPDto;
import com.dapenbi.dkpp.model.HerRegistrasi;
import com.dapenbi.dkpp.model.HerRegistrasiDetail;

public interface HerRegistrasiDao extends BaseDao<HerRegistrasi, HerRegistrasiDto, Long>{
	Map cuspCreateMasterHerRegis(Long roleId
			, String compName
			, String userName
			, String parTahun 
			, Long parJenisHer 
			, String parJenisHerDesc
			, String parPeriodeTerdaftarPeserta
			, Long parIdValidasi
			, String parNamaValidasi
			, String parIdCatatan
			, String parKategoriCatatan
			, String parKeterangan);
	
	HerRegistrasi findByTahunHer(String tahunHer);

	Map cuspUpdateMasterHerRegis(Long roleId
			, String compName
			, String userName
			, String parTahun
			, String parStatusHer
			, Long parIdValidasi
			, String parNamaValidasi);

	Map cuspUpdateHerRegis(
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
	);

	Map cuspUpdateHerRegis(CuspUpdateHerRegisSPDto spDto);
}
