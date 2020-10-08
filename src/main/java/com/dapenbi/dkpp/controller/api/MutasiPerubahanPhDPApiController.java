package com.dapenbi.dkpp.controller.api;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dao.StatusValidasiDao;
import com.dapenbi.dkpp.dao.ViewModel.HistoryPmbyMpMiViewDao;
import com.dapenbi.dkpp.dto.StatusValidasiDto;
import com.dapenbi.dkpp.dto.ViewModelDto.HistoryPmbyMpMiViewModelDto;
import com.dapenbi.dkpp.form.MutasiPensiunFormDto;
import com.dapenbi.dkpp.model.SetupParameter;
import com.dapenbi.dkpp.model.ViewModel.HistoryPmbyMpMiViewModel;
import com.dapenbi.dkpp.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.model.MutasiPensiun;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PERUBAHAN_PHDP)
public class MutasiPerubahanPhDPApiController {

	@Autowired
	MutasiPensiunDao mutasiPensiunDao;

	@Autowired
	SetupParameterDao setupParameterDao;

	@Autowired
	HistoryPmbyMpMiViewDao historyPmbyMpMiViewDao;

	@Autowired
    StatusValidasiDao statusValidasiDao;

	private DataSource dataSource;

	public MutasiPerubahanPhDPApiController(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@GetMapping
	public Page<MutasiPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
		SetupParameter setupParameter = this.setupParameterDao.findByBukaPeriode();
		Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasi("13", setupParameter.getPeriode(), "%" + searchParam + "%", pageRequest);
		Page<MutasiPensiunDto> result = uIt.map(u -> {
			MutasiPensiunDto dto = u.toDto();
			if (u.getStatusValidasi() != null){ dto.setStatusValidasi(u.getStatusValidasi().toDto()); }
			if (u.getTglMutasi() != null){ dto.setTglMutasi(u.getTglMutasi()); }
			if (u.getKategoriPensiun() != null) {dto.setKategoriPensiun(u.getKategoriPensiun().toDto());}
			if (u.getKategoriPenerima() != null) {dto.setKategoriPenerima(u.getKategoriPenerima().toDto());}
			if (u.getKantorBayar() != null) {dto.setKantorBayar(u.getKantorBayar().toDto());}
			if (u.getKantorBayarBaru() != null) {dto.setKantorBayarBaru(u.getKantorBayarBaru().toDto());}
			if (u.getKategoryCatatan() != null) {dto.setKategoryCatatan(u.getKategoryCatatan().toDto());}
			if (u.getJenisMps() != null) { dto.setJenisMps(u.getJenisMps().toDto()); }
			if (u.getKategoriMutasi() != null) { dto.setKategoriMutasi(u.getKategoriMutasi().toDto()); }
			if (u.getSuskel() != null) { dto.setSuskel(u.getSuskel().toDto()); }
			if (u.getSuskelBaru() != null) { dto.setSuskelBaru(u.getSuskelBaru().toDto()); }
			if (u.getKelurahan() != null) { dto.setKelurahan(u.getKelurahan().toDto()); }
			return dto;
		});

		return result;
	}

	@GetMapping("/belum-validasi")
	public Page<MutasiPensiunDto> indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
		SetupParameter setupParameter = this.setupParameterDao.findByBukaPeriode();
		Page<MutasiPensiun> uIt = mutasiPensiunDao.findByKategoriMutasiAndPeriodeMutasiBelumValidasi("13", setupParameter.getPeriode(), "%" + searchParam + "%", pageRequest);
		Page<MutasiPensiunDto> result = uIt.map(u -> {
			MutasiPensiunDto dto = u.toDto();
			if (u.getStatusValidasi() != null){ dto.setStatusValidasi(u.getStatusValidasi().toDto()); }
			if (u.getTglMutasi() != null){ dto.setTglMutasi(u.getTglMutasi()); }
			if (u.getKategoriPensiun() != null) {dto.setKategoriPensiun(u.getKategoriPensiun().toDto());}
			if (u.getKategoriPenerima() != null) {dto.setKategoriPenerima(u.getKategoriPenerima().toDto());}
			if (u.getKantorBayar() != null) {dto.setKantorBayar(u.getKantorBayar().toDto());}
			if (u.getKantorBayarBaru() != null) {dto.setKantorBayarBaru(u.getKantorBayarBaru().toDto());}
			if (u.getKategoryCatatan() != null) {dto.setKategoryCatatan(u.getKategoryCatatan().toDto());}
			if (u.getJenisMps() != null) { dto.setJenisMps(u.getJenisMps().toDto()); }
			if (u.getKategoriMutasi() != null) { dto.setKategoriMutasi(u.getKategoriMutasi().toDto()); }
			if (u.getSuskel() != null) { dto.setSuskel(u.getSuskel().toDto()); }
			if (u.getSuskelBaru() != null) { dto.setSuskelBaru(u.getSuskelBaru().toDto()); }
			if (u.getKelurahan() != null) { dto.setKelurahan(u.getKelurahan().toDto()); }
			return dto;
		});

		return result;
	}

	@GetMapping
	@RequestMapping(value = "/cuspMutasiPerubahanPhdp", produces = "application/json")
	public ResponseEntity<ResponseUtil> put(Pageable pageRequest,
											@RequestParam(name = "idMutasi", required = false) Long idMutasi,
											@RequestParam(name = "nip", required = false) String nip,
											@RequestParam(name = "phdpBaru", required = false) BigDecimal phdpBaru,
											@RequestParam(name = "tglBerlakuPhdpBaru", required = false) String tglBerlakuPhdpBaru,
											@RequestParam(name = "tglMutasi", required = false) String tglMutasi,
											@RequestParam(name = "periodeMutasi", required = false) String periodeMutasi,
											@RequestParam(name = "kategoriCatatan", required = false) Long kategoriCatatan,
											@RequestParam(name = "keterangan", required = false) String keterangan,
											@RequestParam(name = "keteranganOtomatisUpdate", required = false) String keteranganOtomatisUpdate,
											@RequestParam(name = "validasi", required = false) Long validasi,
											@RequestParam(name = "namaValidasi", required = false) String namaValidasi) throws ParseException {

		SecurityContext context = SecurityContextHolder.getContext();
		DkppUserDetail user = DkppUserStamp.getUserPrincipal();
		RoleDto role = user.getUser().getRoles().get(0);
		String compName = DkppUserStamp.getCompName();
		String userName = user.getUsername();

        StatusValidasiDto statusValidasiDto = statusValidasiDao.findById(validasi).toDto();

		Date tglBerlaku = DateUtil.stringToDate(tglBerlakuPhdpBaru, "dd/MM/yyyy");
		Date tglInput = DateUtil.stringToDate(tglMutasi, "dd/MM/yyyy");

		Map uIt = mutasiPensiunDao.cuspMutasiPerubahanPhdp(role.getId(), idMutasi, compName, userName, nip, phdpBaru, tglBerlaku, tglInput, periodeMutasi, kategoriCatatan, keteranganOtomatisUpdate, keterangan, validasi, statusValidasiDto.getNamaValidasi());

		ResponseUtil response = null;

		if (uIt.get("PAR_STATUS_EKSEKUSI").equals('1')) {
			response = new ResponseUtil(true, "Data berhasil disimpan");
		} else {
			response = new ResponseUtil(false, "Data tidak berhasil disimpan");
		}

		return new ResponseEntity<ResponseUtil>(response, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping(value = "/cufnMiSimulation", produces = "application/json")
	public ResponseEntity<ResponseUtil> miSimulation(Pageable pageRequest,
													 @RequestParam(name = "nip", required = false) String nip,
													 @RequestParam(name = "phdpBaru", required = false) BigDecimal phdpBaru,
													 @RequestParam(name = "tglBerlakuPhdpBaru", required = false) String tglBerlakuPhdpBaru,
													 @RequestParam(name = "tglMutasi", required = false) String tglMutasi,
													 @RequestParam(name = "periodeMutasi", required = false) String periodeMutasi) throws ParseException {

		SecurityContext context = SecurityContextHolder.getContext();
		DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        String compName = DkppUserStamp.getCompName();
        String userName = user.getUsername();


        Date tglBerlaku = DateUtil.stringToDate(tglBerlakuPhdpBaru, "yyyy-MM-dd");
		Date tglInput = DateUtil.stringToDate(tglMutasi, "yyyy-MM-dd");

		Map uIt = mutasiPensiunDao.cuspMiSimulation(nip, phdpBaru, tglBerlakuPhdpBaru, tglMutasi, periodeMutasi);

		List<MutasiPensiunDto> data = new ArrayList<MutasiPensiunDto>();
		MutasiPensiunDto dto = new MutasiPensiunDto();
		dto.setMps20PersenLama(StdUtil.toBigDecimal(uIt.get("MPS_20PERSEN_LAMA")));
		dto.setMps10JutaLama(StdUtil.toBigDecimal(uIt.get("MPS_10JUTA_LAMA")));
		dto.setMps100PersenLama(StdUtil.toBigDecimal(uIt.get("MPS_100PERSEN_LAMA")));
		dto.setMps100PersenBulatLama(StdUtil.toBigDecimal(uIt.get("MPS_100PERSEN_BULAT_LAMA")));
		dto.setMpPerbulanRumusLama(StdUtil.toBigDecimal(uIt.get("MP_PERBULAN_RUMUS_LAMA")));
		dto.setMpPerbulan20PersenLama(StdUtil.toBigDecimal(uIt.get("MP_PERBULAN_20PERSEN_LAMA")));
		dto.setMpPerbulan10JutaLama(StdUtil.toLong(uIt.get("MP_PERBULAN_10JUTA_LAMA")));
		dto.setMpydLama(StdUtil.toBigDecimal(uIt.get("MPYD_LAMA")));
		dto.setMps20PersenBaru(StdUtil.toBigDecimal(uIt.get("MPS_20PERSEN_BARU")));
		dto.setMps10JutaBaru(StdUtil.toBigDecimal(uIt.get("MPS_10JUTA_BARU")));
		dto.setMps100PersenBaru(StdUtil.toBigDecimal(uIt.get("MPS_100PERSEN_BARU")));
		dto.setMps100PersenBulatBaru(StdUtil.toBigDecimal(uIt.get("MPS_100PERSEN_BULAT_BARU")));
		dto.setMpPerbulanRumusBaru(StdUtil.toBigDecimal(uIt.get("MP_PERBULAN_RUMUS_BARU")));
		dto.setMpPerbulan20PersenBaru(StdUtil.toBigDecimal(uIt.get("MP_PERBULAN_20PERSEN_BARU")));
		dto.setMpPerbulan10JutaBaru(StdUtil.toBigDecimal(uIt.get("MP_PERBULAN_10JUTA_BARU")));
		dto.setMpydBaru(StdUtil.toBigDecimal(uIt.get("MPYD_BARU")));
		dto.setKurangBayarMPS20Persen(StdUtil.toBigDecimal(uIt.get("KURANG_BAYAR_MPS20PERSEN")));
		dto.setKurangBayarMPS10Juta(StdUtil.toBigDecimal(uIt.get("KURANG_BAYAR_MPS10JUTA")));
		dto.setKurangBayarMPS100Persen(StdUtil.toBigDecimal(uIt.get("KURANG_BAYAR_MPS100PERSEN")));
		dto.setKurangBayarMPRumus(StdUtil.toBigDecimal(uIt.get("KURANG_BAYAR_MP_RUMUS")));
		dto.setKurangBayarMPYD(StdUtil.toBigDecimal(uIt.get("KURANG_BAYAR_MPYD_RAPEL")));
		dto.setRapelMPYDKurang(StdUtil.toBigDecimal(uIt.get("KURANG_BAYAR_MPYD_RAPEL")));
		dto.setLebihBayarMPS20Persen(StdUtil.toBigDecimal(uIt.get("LEBIH_BAYAR_MPS20PERSEN")));
		dto.setLebihBayarMPS10Juta(StdUtil.toBigDecimal(uIt.get("LEBIH_BAYAR_MPS10JUTA")));
		dto.setLebihBayarMPS100Persen(StdUtil.toBigDecimal(uIt.get("LEBIH_BAYAR_MPS100PERSEN")));
		dto.setLebihBayarMPRumus(StdUtil.toBigDecimal(uIt.get("LEBIH_BAYAR_MP_RUMUS")));
		dto.setRapelMPYDLebih(StdUtil.toBigDecimal(uIt.get("LEBIH_BAYAR_MPYD_RAPEL")));
		dto.setKategoriPensiun(dto.getKategoriPensiun());
		dto.setJenisMps(dto.getJenisMps());
		data.add(dto);
		ResponseUtil response = null;

		if (uIt != null && uIt.size() > 0) {
			response = new ResponseUtil(true, data, "Data berhasil ditampilkan");
		} else {
			response = new ResponseUtil(false, "Data tidak berhasil ditampilkan");
		}

		return new ResponseEntity<ResponseUtil>(response, HttpStatus.OK);
	}

	@GetMapping("/mutasi-mi-history-pembayaran-mp")
	public Page<HistoryPmbyMpMiViewModelDto> getListHistoryPembayaranMp(Pageable pageRequest,@RequestParam("nip") String nip){
		Page<HistoryPmbyMpMiViewModelDto> formDto = historyPmbyMpMiViewDao.findAllByNip(nip, pageRequest);
		return formDto;
	};

	@GetMapping("/report-phdp")
	public void reportPhdp (HttpServletResponse httpServletResponse, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idJenisMps") String idJenisMps, @RequestParam("idKategoriPensiun") String idKategoriPensiun, @RequestParam("idKategoriMutasi") String idKategoriMutasi, @RequestParam("idKantorBayar") String idKantorBayar, @RequestParam("tipeReport") String tipeReport, @RequestParam(name = "download", required = false) Boolean download){
		String jasperFileName = null;
		String subReport = null;
		HashMap<String, Object> parameters = null;
		try{
				switch (tipeReport) {
					case "formulir_entry_mutasi": {
						jasperFileName = "Entry_Mutasi_Pensiun_MI";
						parameters = new HashMap<>();
						parameters.put("nip", nip);
						parameters.put("id_kategori_pensiun", idKategoriPensiun);
						parameters.put("periode_mutasi", periodeMutasi);
						parameters.put("id_kategori_mutasi", idKategoriMutasi);

					}
					break;

					case "catatan_perhitungan_manfaat_pensiun": {
						switch (idKategoriPensiun) {
							case "PN": {
								switch (idJenisMps) {
									case "5": {
										jasperFileName = "PerhitunganMP_NormalTanpaMPS20persen_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "1": {

										jasperFileName = "PerhitunganMP_NormalDenganMPS20persen_MeritIncrease";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "2": {
										jasperFileName = "PerhitunganMP_NormalDenganMPS10Juta_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "4": {

										jasperFileName = "PerhitunganMP_NormalDenganMPS20persen_dan_MPS_Lebih10Jta";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;
									case "3" : {
										jasperFileName = "PensiunMPS100persen";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("idKategoriMutasi", idKategoriMutasi);
									}
								}
							}
							break;

							case "PD": {
								switch (idJenisMps) {
									case "5": {

										jasperFileName = "PerhitunganMP_Dipercepat_TanpaMPS20persen_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "1": {

										jasperFileName = "PerhitunganMP_DipercepatDengan_MPS20persen_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "2": {

										jasperFileName = "PerhitunganMP_Dipercepat_DenganMPS10jt_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "4": {

										jasperFileName = "PerhitunganMP_Dipercepat_DenganMPS20persen_MPS10jt_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;
									case "3" : {
										jasperFileName = "PensiunMPS100persen";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("idKategoriMutasi", idKategoriMutasi);
									}
								}
							}
							break;

							case "PC": {
								switch (idJenisMps) {
									case "5": {
										jasperFileName = "PerhitunganMP_CACAT_TanpaMPS_MI2";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "1": {

										jasperFileName = "PerhitunganMP_CACAT_DenganMPS20persen_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "2": {

										jasperFileName = "PerhitunganMP_CACAT_TanpaMPS20persen_DenganMPS10jt_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;

									case "4": {
										jasperFileName = "PerhitunganMP_CACAT_DenganMPS20persen_MPS10jt_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);

									}
									break;
									case "3" : {
										jasperFileName = "PensiunMPS100persen";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("idKategoriMutasi", idKategoriMutasi);
									}
								}
							}
							break;
							case "PM" : {
								switch (idJenisMps){
									case "1" :
										jasperFileName = "PerhitunganMP_MeninggalDuniaDenganMPS20persen_MeritIncrease";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);
										break;
									case "2" :
										jasperFileName = "PerhitunganMP_MeninggalDuniaDenganMPS10Juta_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);
										break;
									case "4" :
										jasperFileName = "PerhitunganMP_MeninggalDuniaDenganMPS20persen_dan_MPS_Lebih10Jta";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);
										break;
									case "5" :
										jasperFileName = "PerhitunganMP_MeninggalDuniaTanpaMPS20persen_MI";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);
										break;
									case "3" :
										jasperFileName = "PerhitunganMP_Sekaligus_KepadaAhliWaris";
										subReport = "keluarga_pensiunMI";
										parameters = new HashMap<>();
										parameters.put("id_jenis_mps", idJenisMps);
										parameters.put("id_kategori_pensiun", idKategoriPensiun);
										parameters.put("nip", nip);
										parameters.put("periode_mutasi", periodeMutasi);
										parameters.put("id_kategori_mutasi", idKategoriMutasi);
										break;
								}
								break;
							}

							case "PT" :
								jasperFileName = "PerhitunganMP_PT_MI";
								subReport = "keluarga_pensiunMI";
								parameters = new HashMap<>();
								parameters.put("id_jenis_mps", idJenisMps);
								parameters.put("id_kategori_pensiun", idKategoriPensiun);
								parameters.put("nip", nip);
								parameters.put("periode_mutasi", periodeMutasi);
								parameters.put("id_kategori_mutasi", idKategoriMutasi);
								break;
						}
					}
					break;

					case "surat_penyesuaian_gapok":
						jasperFileName = "HakAtasmanfaatPensiunPeserta";
						parameters = new HashMap<>();
						parameters.put("nip", nip);
						parameters.put("periode_mutasi", periodeMutasi);
						parameters.put("id_kategori_mutasi", idKategoriMutasi);
						parameters.put("id_kantor_bayar", idKantorBayar);
						break;

					case "sp_phdp" :
						jasperFileName = "HakAtasmanfaatPensiunPeserta";
						parameters = new HashMap<>();
						parameters.put("nip", nip);
						parameters.put("periode_mutasi", periodeMutasi);
						parameters.put("id_kategori_mutasi", idKategoriMutasi);
						parameters.put("id_kantor_bayar", idKantorBayar);
						break;
				}
				if (jasperFileName != null) {
				showReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
			}

		}catch (IOException | JRException e1) {
			e1.printStackTrace();
		}
	}
	private void showReport(HttpServletResponse httpServletResponse, String nip, Boolean download, Map<String, Object> parameters, String jasperFileName, String subReport) throws JRException, IOException {
		ReportCompiler rc = new ReportCompiler();
		JasperReport jasperReport = rc.compileReport(jasperFileName);
		setReportHeader(httpServletResponse, nip, jasperFileName, download);
		// Set report
		ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
		if (subReport != null) {
			parameters.put("subReport", reportUtil.getSubReportPath(subReport));
		}
		Connection conn = DataSourceUtils.getConnection(dataSource);
		reportUtil.setReport(parameters, conn, new JRPdfExporter());
		SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);
		reportUtil.getExporter().setConfiguration(reportConfig);
		// write report to output stream
		reportUtil.getExporter().exportReport();
		reportUtil.getOutputStream().flush();
		reportUtil.getOutputStream().close();
	}

	private void setReportHeader(HttpServletResponse httpServletResponse, String nip, String jasperFileName, Boolean download) {
		// Set web response output stream
		MediaType mediaType = MediaType.parseMediaType("application/pdf");
		httpServletResponse.setContentType(mediaType.getType());
		if ((download != null) && (download)) {
			httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jasperFileName + "-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + nip + ".pdf");
		} else {
			httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/pdf");
		}
	}
}
