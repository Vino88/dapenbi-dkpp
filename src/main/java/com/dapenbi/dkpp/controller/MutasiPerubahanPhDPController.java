package com.dapenbi.dkpp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dapenbi.dkpp.dao.StatusValidasiDao;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.MutasiPensiunFormDto;
import com.dapenbi.dkpp.model.StatusValidasi;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.SelectValueUtil;
import com.dapenbi.dkpp.util.StringUtil;
import org.apache.poi.ss.formula.functions.Now;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.KategoriCatatanDao;
import com.dapenbi.dkpp.dao.MutasiPensiunDao;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.KategoriCatatanDto;
import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.model.KategoriCatatan;
import com.dapenbi.dkpp.model.MutasiPensiun;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;

@Controller
@RequestMapping(PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PERUBAHAN_PHDP)
public class MutasiPerubahanPhDPController {

	ServletContext servletContext;
	
	private MutasiPensiunDao mutasiPensiunDao;
	
	private SetupParameterDao setupParameterDao;
	
	private KategoriCatatanDao kategoriCatatanDao;

	@Autowired
	StatusValidasiDao statusValidasiDao;
	
	public MutasiPerubahanPhDPController(MutasiPensiunDao mutasiPensiunDao, SetupParameterDao setupParameterDao, KategoriCatatanDao kategoriCatatanDao, ServletContext servletContext) {
		this.mutasiPensiunDao = mutasiPensiunDao;
		this.setupParameterDao = setupParameterDao;
		this.kategoriCatatanDao = kategoriCatatanDao;
		this.servletContext = servletContext;
	}
	
	@GetMapping
	public String index(Map<String, Object> model) {
		List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
		String isStaf = "";
		RoleDto roleDto = DkppUserStamp.getUserRoles();
		if (roleDto.getId() == 43){
			isStaf = roleDto.getId().toString();
			model.put("role",isStaf);
		}
		model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
		model.put("mutasiPhdpPath", PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PERUBAHAN_PHDP);
		model.put("report_path_api", PathPrefix.PENSIUN_BARU + PathPrefix.MUTASI_PERUBAHAN_PHDP + "/report-phdp");
		breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU, "Pensiun Baru"));
		breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU + "/mutasi-perubahan-phdp", "Mutasi Perubahan PhDP"));
		model.put("breadcrumb", breadcrumb);
		return "pensiunBaru/mutasi-perubahan-phdp";
	}
	
	@GetMapping("/entry")
	public String entry(Map<String, Object> model, @RequestParam(name = "id", required = false) Long id) {
		List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
		String periodeMutasi = setupParameterDao.findByBukaPeriode().getPeriode();
		String isStaf = "";
		RoleDto roleDto = DkppUserStamp.getUserRoles();
		if (roleDto.getId() == 43){
			isStaf = roleDto.getId().toString();
			model.put("isStaf",isStaf);
		}
		model.put("periodeMutasi", periodeMutasi);
		breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU, "Pensiun Baru"));
		breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.PENSIUN_BARU+ PathPrefix.MUTASI_PERUBAHAN_PHDP, "Mutasi Perubahan PhDP"));
		model.put("report_path_api", PathPrefix.API + PathPrefix.MUTASI_PERUBAHAN_PHDP + "/report-phdp");
		model.put("breadcrumb", breadcrumb);
        model.put("statusValidasiRadio", ((List<StatusValidasi>) statusValidasiDao.findAllActive()).stream().map(StatusValidasi::toDto).collect(Collectors.toList()));
		MutasiPensiun mp = new MutasiPensiun();
		MutasiPensiunDto dto = new MutasiPensiunDto();
		MutasiPensiunFormDto formDto = new MutasiPensiunFormDto();
		KategoriCatatanDto kategoriCatatanDto = new KategoriCatatanDto();
		List<KategoriCatatan> kcList = kategoriCatatanDao.findByKategoriMutasi("14");
		model.put("kcList", kcList);
		if (id != null) {
			mp = mutasiPensiunDao.findById(id);
			dto = mp.toDto();

			if(mp.getStatusValidasi() != null) {
				dto.setStatusValidasi(mp.getStatusValidasi().toDto());
			}
			if (mp.getStatusKawin() != null){ dto.setStatusKawin(mp.getStatusKawin().toDto()); }
			if (mp.getKategoriPenerima() != null){ dto.setKategoriPenerima(mp.getKategoriPenerima().toDto()); }
			if (mp.getKategoryCatatan() != null) { kategoriCatatanDto = mp.getKategoryCatatan().toDto(); }
			formDto.setTanggalInput(DateUtil.dateToString(dto.getTglMutasi()));
			model.put("isEdit",1);
			if (mp.getStatusValidasi().getId() == 2){
				model.put("isSudahValidasi",1);
			}
			model.put("kategoriCatatanDefaultSelect", StringUtil.objToJson(kategoriCatatanDto));
		}else{
			dto.setPeriodeMutasi(periodeMutasi);
			dto.setTglMutasi(new Date());
			formDto.setTanggalInput(DateUtil.dateToString(new Date()));
			model.put("listPesertaCombo", PathPrefix.API + PathPrefix.MPENSIUN + PathPrefix.DATA + PathPrefix.MPENSIUN);
		}
		model.put("dto", dto);
		model.put("formdto", formDto);
		model.put("historyPembayaranMpPathApi", PathPrefix.API + PathPrefix.MUTASI_PERUBAHAN_PHDP + "/mutasi-mi-history-pembayaran-mp");
		model.put("gender", SelectValueUtil.createGenderSelect());

		return "pensiunBaru/entry-mutasi-perubahan-phdp";
	}
}
