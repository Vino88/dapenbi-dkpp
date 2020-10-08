package com.dapenbi.dkpp.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.HerRegistrasiDao;
import com.dapenbi.dkpp.dao.HerRegistrasiDetailDao;
import com.dapenbi.dkpp.dto.DkppUserDetail;
import com.dapenbi.dkpp.dto.HerRegistrasiDetailDto;
import com.dapenbi.dkpp.dto.HerRegistrasiDto;
import com.dapenbi.dkpp.dto.RoleDto;
import com.dapenbi.dkpp.form.HerRegistrasiFormDto;
import com.dapenbi.dkpp.model.HerRegistrasi;
import com.dapenbi.dkpp.model.HerRegistrasiDetail;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.ResponseUtil;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.REGISTASI_ULANG_PENSIUN)
public class RegistrasiUlangPensiunApiController {

	@Autowired
	HerRegistrasiDao herRegistrasiDao;

	
	@GetMapping
	public Page<HerRegistrasiDto> index(Pageable pageRequest,
			@RequestParam(name = "searchParam", required = false) String searchParam) {
		Page<HerRegistrasi> uIt = (Page<HerRegistrasi>) herRegistrasiDao.findAll(new String[] { "tahunHer","jenisHerDesc","totalPusat","totalCabang","periodeTerdaftarPeserta" }, "%" + searchParam + "%", pageRequest);
		Page<HerRegistrasiDto> result = uIt.map(u -> {
			HerRegistrasiDto dto = u.toDto();
            if (u.getStatusValidasi() != null) dto.setStatusValidasi(u.getStatusValidasi().toDto());
            return dto;
        });
		
		return result;
	}
	

	


}
