package com.dapenbi.dkpp.controller.api;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;

import com.dapenbi.dkpp.dao.HerRegistrasiDetailDao;
import com.dapenbi.dkpp.dao.ProvinsiDao;
import com.dapenbi.dkpp.dao.ViewModel.HerRegistrasiDetailViewDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.HerRegistrasiDetailDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.dto.ViewModelDto.HerRegistrasiDetailViewDto;
import com.dapenbi.dkpp.form.CuspUpdateHerRegisPlainDto;
import com.dapenbi.dkpp.form.CuspUpdateHerRegisSPDto;
import com.dapenbi.dkpp.form.HerRegistrasiFormDto;
import com.dapenbi.dkpp.form.HerRegistrasiUpdateFormDto;
import com.dapenbi.dkpp.model.HerRegistrasiDetail;
import com.dapenbi.dkpp.model.Provinsi;
import com.dapenbi.dkpp.model.ViewModel.HerRegistrasiDetailView;
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
import org.springframework.web.bind.annotation.*;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.HerRegistrasiDao;
import com.dapenbi.dkpp.dto.HerRegistrasiDto;
import com.dapenbi.dkpp.model.HerRegistrasi;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.HERREGISTRASI)
public class HerRegistrasiApiController {

	@Autowired
	HerRegistrasiDao herDao;

	@Autowired
	HerRegistrasiDetailDao herRegistrasiDetailDao;

	@Autowired
    HerRegistrasiDetailViewDao herDetailViewDao;

	@Autowired
	ProvinsiDao provinsiDao;

	private DataSource dataSource;

	public HerRegistrasiApiController(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@GetMapping("/registrasi-ulang-pensiun")
	public Page<HerRegistrasiDto> registrasiUlangPensiun(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
		Page<HerRegistrasi> uIt = (Page<HerRegistrasi>) herDao.findAll(new String[] { "tahunHer, periode" }, "%" + searchParam + "%", pageRequest);

		Page<HerRegistrasiDto> HerRegistrasiDto = uIt.map( u -> u.toDto());
		return HerRegistrasiDto;
	}

	@GetMapping("/detail/{searchparam}")
	public Page<HerRegistrasiDetailViewDto> detail(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        int tahunHer = Year.now().getValue();
	    Page<HerRegistrasiDetailView> uIt = (Page<HerRegistrasiDetailView>) herDetailViewDao.findByTahunHer(String.valueOf(tahunHer),"%" + searchParam + "%", pageRequest);
		Page<HerRegistrasiDetailViewDto> HerRegistrasiDetailDto = uIt.map(u -> u.toDto());
		return HerRegistrasiDetailDto;
	}

	@GetMapping("/entry")
	public HerRegistrasiDetailDto entry(Pageable pageRequest,
											  @RequestParam(name = "periode", required = false) String periode,
											  @RequestParam(name = "nip", required = false) String nip) {
		HerRegistrasiDetail herRegistrasiDetail = herRegistrasiDetailDao.findByTahunHerAndNip(periode,nip);
		herRegistrasiDetail.setNomorHer(herRegistrasiDetailDao.generateNoHer(String.valueOf(periode)));
		HerRegistrasiDetailDto herRegistrasiDetailDto = herRegistrasiDetail.toDto();
		Provinsi provinsi = provinsiDao.findById(herRegistrasiDetailDto.getIdProvinsiNumber());
		herRegistrasiDetailDto.setNamaProvinsi(provinsi.getNamaProvinsi());

		return herRegistrasiDetailDto;
	}

	@GetMapping("/view")
	public HerRegistrasiDto viewPeserta(@RequestParam(name = "tahun", required = false) String tahun) {
		List<HerRegistrasiDetail> herRegistrasiDetails = herRegistrasiDetailDao.findAllByTahunHer(tahun);
		List<HerRegistrasiDetailDto> herRegistrasiDetailDtos = new ArrayList<HerRegistrasiDetailDto>();
		herRegistrasiDetailDtos.clear();
		for(HerRegistrasiDetail herRegistrasiDetail: herRegistrasiDetails){
			HerRegistrasiDetailDto herRegistrasiDetailDto = new HerRegistrasiDetailDto();
			herRegistrasiDetailDto.setIdNegaraHer(herRegistrasiDetail.getIdNegaraHer());
			herRegistrasiDetailDto.setIdProvinsiHer(herRegistrasiDetail.getIdProvinsiHer());
			herRegistrasiDetailDto.setNamaPeserta(herRegistrasiDetail.getNamaPeserta());
			herRegistrasiDetailDto.setAlamatIsDalamNegeri(herRegistrasiDetail.getAlamatIsDalamNegeri());
			herRegistrasiDetailDto.setAlamatIsDalamNegeriHer(herRegistrasiDetail.getAlamatIsDalamNegeriHer());
			herRegistrasiDetailDto.setAlamatLengkap(herRegistrasiDetail.getAlamatLengkap());
			herRegistrasiDetailDto.setAlamatLengkapHer(herRegistrasiDetail.getAlamatLengkapHer());
			herRegistrasiDetailDto.setCatatan(herRegistrasiDetail.getCatatan());
			herRegistrasiDetailDto.setEmail(herRegistrasiDetail.getEmail());
			herRegistrasiDetailDto.setEmailHer(herRegistrasiDetail.getEmailHer());
			herRegistrasiDetailDto.setIdCatatan(herRegistrasiDetail.getIdCatatan());
			herRegistrasiDetailDto.setIdKantorBayar(herRegistrasiDetail.getIdKantorBayar());
			herRegistrasiDetailDto.setIdKantorBayarHer(herRegistrasiDetail.getIdKantorBayarHer());
			herRegistrasiDetailDto.setIdKategoriPenerimaMP(herRegistrasiDetail.getIdKategoriPenerimaMP());
			herRegistrasiDetailDto.setIdKecamatan(herRegistrasiDetail.getIdKecamatan());
			herRegistrasiDetailDto.setNip(herRegistrasiDetail.getNip());
			herRegistrasiDetailDto.setNamaPeserta(herRegistrasiDetail.getNamaPeserta());
			herRegistrasiDetailDto.setNamaKantorBayar(herRegistrasiDetail.getNamaKantorBayar());
			herRegistrasiDetailDto.setNamaKantorBayarHer(herRegistrasiDetail.getNamaKantorBayarHer());
			herRegistrasiDetailDto.setStatusHerDesc(herRegistrasiDetail.getStatusHerDesc());

			herRegistrasiDetailDtos.add(herRegistrasiDetailDto);
		}
		HerRegistrasi uIt = (HerRegistrasi) herDao.findByTahunHer(tahun);
		uIt.setHerRegistrasiDetail(herRegistrasiDetails);
		HerRegistrasiDto herRegistrasiDto = uIt.toDto();
		herRegistrasiDto.setStatusValidasi(uIt.getStatusValidasi().toDto());
		herRegistrasiDto.setHerRegistrasiDetail(herRegistrasiDetailDtos);
		return herRegistrasiDto;
	}


	@GetMapping(value="/cusp_create_master_her_regis", produces="application/json")
	public ResponseEntity<MessageUtil> cuspCreateMasterHerRegis(@ModelAttribute HerRegistrasiFormDto formDto) {
		SecurityContext context = SecurityContextHolder.getContext();
		DkppUserDetail user = DkppUserStamp.getUserPrincipal();
		RoleDto role = user.getUser().getRoles().get(0);
		formDto.setParIdValidasi((long) 1);
		formDto.setParNamaValidasi("Belum Validasi");
		formDto.setParKeterangan(null);
		formDto.setParKategoriCatatan(null);
		Map result = herDao.cuspCreateMasterHerRegis(role.getId(), DkppUserStamp.getCompName(), user.getUsername(), formDto.getParTahun(), formDto.getParJenisHer(), formDto.getParJenisHerDesc(), formDto.getParPeriodeTerdaftarPeserta(), formDto.getParIdValidasi(), formDto.getParNamaValidasi(), "54", "Mutasi Otomatis", formDto.getParKeterangan());
		ResponseUtil response = null;
		MessageUtil messageUtil;
		HttpStatus httpStatus;
		if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
			messageUtil = new MessageUtil("success", "Proses Her Registrasi Berhasil");
			httpStatus = HttpStatus.OK;
		} else {
			messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
	}

	@GetMapping(value="/cusp_update_her_regis", produces="application/json")
	public ResponseEntity<MessageUtil> cuspUpdateHerRegis(Long roleId,
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
														  String parNamaValidasi) {

		DkppUserDetail user = DkppUserStamp.getUserPrincipal();
		RoleDto role = user.getUser().getRoles().get(0);
		String compName_ = DkppUserStamp.getCompName();
		String userName_ = DkppUserStamp.getUserName();

		//TODO
		//Eksekusi SP
		Map result = herDao.cuspUpdateHerRegis(
				role.getId(),
				compName_,
				userName_,
				parTahunHer,
				parNip,
				parIdPenerimaHer,
				parNomorHer,
				parTglHer,
				parNipPas1Her,
				parJenisKelaminPas1Her,
				parNipPas2Her,
				parJenisKelaminPas2Her,
				parNamaPenerimaMpHer,
				parTglMeninggalPenerimaHer,
				parIdKantorBayarHer,
				parNamaKantorBayarHer,
				parAlamatIsDalamNegeriHer,
				parAlamatLengkapHer,
				parRtHer,
				parRwHer,
				parIdKelurahanHer,
				parNamaKelurahanHer,
				parIdKecamatanHer,
				parNamaKecamatanHer,
				parIdKotaKabHer,
				parNamaKotaKabHer,
				parIdProvinsiHer,
				parNamaProvinsiHer,
				parKodePosHer,
				parIdNegaraHer,
				parNamaNegaraHer,
				parNoHpHer,
				parEmailHer,
				parIsNamaPenerimaSama,
				parIsTglLahirSama,
				parIsSuskelSama,
				parIsKantorBayarSama,
				parIsAlamatSama,
				parIsAdaPhoto,
				parIsAdaKk,
				parIsAdaKtp,
				parIsDataLengkap,
				parIsPenerimaMenikahLagi,
				parTempatMenikah,
				parTglMenikah,
				parIdSerah,
				parNamaSerah,
				parKeteranganSerah,
				parIdCatatan,
				parNamaCatatan,
				parCatatan,
				parIdValidasi,
				parNamaValidasi
		);
		//End Eksekusi SP
		MessageUtil messageUtil;
		HttpStatus httpStatus;
		if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
			messageUtil = new MessageUtil("success", "Proses Her Registrasi Berhasil");
			httpStatus = HttpStatus.OK;
		} else {
			messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

	}

	@PostMapping(value="/cusp_update_her_registrasi", produces="application/json")
	public ResponseEntity<MessageUtil> cuspUpdateHerRegistrasi(@ModelAttribute CuspUpdateHerRegisPlainDto plainDto) {
		CuspUpdateHerRegisSPDto spDto = new CuspUpdateHerRegisSPDto();
		spDto.fromPlainText(plainDto);

		DkppUserDetail user = DkppUserStamp.getUserPrincipal();
		RoleDto role = user.getUser().getRoles().get(0);
		String compName_ = DkppUserStamp.getCompName();
		String userName_ = DkppUserStamp.getUserName();
		spDto.setRoleId(role.getId());
		spDto.setCompName(compName_);
		spDto.setUserName(userName_);

		//TODO
		//Eksekusi SP
		Map result = herDao.cuspUpdateHerRegis(spDto);
		//End Eksekusi SP
		MessageUtil messageUtil;
		HttpStatus httpStatus;
		if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
			messageUtil = new MessageUtil("success", "Proses Her Registrasi Berhasil");
			httpStatus = HttpStatus.OK;
		} else {
			messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

	}

	@GetMapping(value="/cusp_update_master_her_regis", produces="application/json")
	public ResponseEntity<MessageUtil> cuspUpdateMasterHerRegis(@ModelAttribute HerRegistrasiUpdateFormDto formDto) {
		DkppUserDetail user = DkppUserStamp.getUserPrincipal();
		RoleDto role = user.getUser().getRoles().get(0);

		Map result = herDao.cuspUpdateMasterHerRegis(
				role.getId(),
				formDto.getCompName(),
				formDto.getUserName(),
				formDto.getParTahun(),
				formDto.getParStatusHer(),
				formDto.getParIdValidasi(),
				formDto.getParNamaValidasi()
		);
		MessageUtil messageUtil;
		HttpStatus httpStatus;
		if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
			messageUtil = new MessageUtil("success", "Proses Her Registrasi Berhasil");
			httpStatus = HttpStatus.OK;
		} else {
			messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
	}

	@GetMapping("/report-her")
	public void report(HttpServletResponse httpServletResponse,@RequestParam("nip") String nip, @RequestParam("tipeReport") String tipeReport, @RequestParam("tahunHer") String tahunHer, @RequestParam(name="download", required = false) Boolean download){
		String jasperFileName = null;
		Map<String, Object> parameters = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

		try {

			switch (tipeReport) {
				case "Resi_Her_Registrasi" :

					jasperFileName = "BuktiPenerimaanFormulirRegistrasi";
					parameters = new HashMap<>();
					parameters.put("nip",nip);
					parameters.put("tahun_her", tahunHer);
					break;
			}
			if (jasperFileName != null) {
				createReport(httpServletResponse, nip, download, parameters, jasperFileName);
			}

		} catch (IOException | JRException e1) {
			e1.printStackTrace();
		}
	}

	private void createReport(HttpServletResponse httpServletResponse, String nip, Boolean download, Map<String, Object> parameters, String jasperFileName) throws JRException, IOException {
		ReportCompiler rc = new ReportCompiler();
		JasperReport jasperReport = rc.compileReport(jasperFileName);
		setReportHeader(httpServletResponse, nip, jasperFileName, download);
		// Set report
		ReportUtil reportUtil = new ReportUtil(jasperFileName, httpServletResponse.getOutputStream());
		Connection conn = DataSourceUtils.getConnection(dataSource);
		reportUtil.setReport(parameters, conn, new JRPdfExporter());
		SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);
		reportUtil.getExporter().setConfiguration(reportConfig);
		// write report to output stream
		reportUtil.getExporter().exportReport();
		reportUtil.getOutputStream().flush();
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
