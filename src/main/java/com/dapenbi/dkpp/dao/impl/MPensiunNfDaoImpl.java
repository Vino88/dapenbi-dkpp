package com.dapenbi.dkpp.dao.impl;


import com.dapenbi.dkpp.dao.MPensiunNfDao;


import com.dapenbi.dkpp.dto.MPensiunNfDto;
import com.dapenbi.dkpp.form.CuspMutasiPensiunNfSPDto;
import com.dapenbi.dkpp.form.CuspPembayaranMpNfSPDto;
import com.dapenbi.dkpp.model.MPensiunNf;
import com.dapenbi.dkpp.repository.MPensiunNfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MPensiunNfDaoImpl extends BaseDaoImpl<MPensiunNf, MPensiunNfDto, String> implements MPensiunNfDao {
	private MPensiunNfRepository mPensiunNfRepository;

	@Autowired
		public MPensiunNfDaoImpl(MPensiunNfRepository mPensiunNfRepository){
			super(mPensiunNfRepository);
			this.mPensiunNfRepository = mPensiunNfRepository;
	}

	@Override
	public Map processCuspMutasiPensiunNf(CuspMutasiPensiunNfSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_TEMPAT_LAHIR", spDto.getParTempatLahir());
		mutasiPensiunSPParam.put("PAR_TGL_LAHIR", spDto.getParTglLahir());
		mutasiPensiunSPParam.put("PAR_TEMPAT_MENIKAH", spDto.getParTempatMenikah());
		mutasiPensiunSPParam.put("PAR_TGL_MENIKAH", spDto.getParTglMenikah());
		mutasiPensiunSPParam.put("PAR_TGL_LAHIR_PENERIMA_MP", spDto.getParTglLahirPenerimaMp());
		mutasiPensiunSPParam.put("PAR_TGL_MENINGGAL", spDto.getParTglMeninggal());
		mutasiPensiunSPParam.put("PAR_MP_BULANAN_EURO", spDto.getParMpBulananEuro());
		mutasiPensiunSPParam.put("PAR_ALAMAT", spDto.getParAlamat());
		mutasiPensiunSPParam.put("PAR_KOTA", spDto.getParKota());
		mutasiPensiunSPParam.put("PAR_KODE_POS", spDto.getParKodePos());
		mutasiPensiunSPParam.put("PAR_NOMOR_REKENING", spDto.getParNomorRekening());
		mutasiPensiunSPParam.put("PAR_NAMA_REKENING", spDto.getParNamaRekening());
		mutasiPensiunSPParam.put("PAR_ID_BANK_NF", spDto.getParIdBankNf());
		mutasiPensiunSPParam.put("PAR_SWIFT_CODE", spDto.getParSwiftCode());
		mutasiPensiunSPParam.put("PAR_IBAN_CODE", spDto.getParIbanCode());
		mutasiPensiunSPParam.put("PAR_PERS_NS", spDto.getParPersNs());
		mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");

		return this.mPensiunNfRepository.callStoredProcedure("MutasiPensiun.processCuspMutasiPensiunNf", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

	@Override
	public Map processCuspPembayaranMpNf(CuspPembayaranMpNfSPDto spDto) {
		Map<String, Object> mutasiPensiunSPParam = new HashMap();
		mutasiPensiunSPParam.put("PAR_ROLE_ID", spDto.getParRoleId());
		mutasiPensiunSPParam.put("PAR_COMP_NAME", spDto.getParCompName());
		mutasiPensiunSPParam.put("PAR_USER_NAME", spDto.getParUserName());
		mutasiPensiunSPParam.put("PAR_PERIODE_MUTASI", spDto.getParPeriodeMutasi());
		mutasiPensiunSPParam.put("PAR_ID_PEMBAYARAN", spDto.getParIdPembayaran());
		mutasiPensiunSPParam.put("PAR_NIP", spDto.getParNip());
		mutasiPensiunSPParam.put("PAR_STATUS_HER", spDto.getParStatusHer());
		mutasiPensiunSPParam.put("PAR_ID_KATEGORI_CATATAN", spDto.getParIdKategoriCatatan());
		mutasiPensiunSPParam.put("PAR_KETERANGAN", spDto.getParKeterangan());
		mutasiPensiunSPParam.put("PAR_ID_VALIDASI", spDto.getParIdValidasi());
		mutasiPensiunSPParam.put("PAR_NAMA_VALIDASI", spDto.getParNamaValidasi());
		List<String> mutasiPensiunOutSPParam = new ArrayList<>();
		mutasiPensiunOutSPParam.add("PAR_STATUS_EKSEKUSI");
		mutasiPensiunOutSPParam.add("PAR_MSG");
		mutasiPensiunOutSPParam.add("PAR_ID_PEMBAYARAN_VAL");

		return this.mPensiunNfRepository.callStoredProcedure("MutasiPensiun.processCuspPembayaranMpNf", mutasiPensiunSPParam, mutasiPensiunOutSPParam);
	}

}