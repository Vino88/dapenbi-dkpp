package com.dapenbi.dkpp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;

@Controller
@RequestMapping(PathPrefix.MUTASI_KURANG_BAYAR)
public class MutasiKurangBayarController {

	private SetupParameterDao setupParameterDao;

	@Autowired
    public MutasiKurangBayarController(SetupParameterDao setupParameterDao) {
        this.setupParameterDao = setupParameterDao;
    }

	@GetMapping
	public String index(Map<String, Object> model) {
		List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
		model.put("periodeMutasi", setupParameterDao.findByBukaPeriode().getPeriode());
		breadcrumb.add(new BreadcrumbHolderComponentDto("/pensiun-baru", "Pensiun Baru"));
		breadcrumb.add(new BreadcrumbHolderComponentDto("/mutasi-kurang-bayar", "Mutasi Kurang Bayar"));
		model.put("breadcrumb", breadcrumb);
		return "mutasiKurangBayar/kurangBayar";
	}
}
