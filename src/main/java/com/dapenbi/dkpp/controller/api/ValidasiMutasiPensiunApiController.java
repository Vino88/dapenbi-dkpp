package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import com.dapenbi.dkpp.util.ReportCompiler;
import com.dapenbi.dkpp.util.ReportUtil;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.VALIDASI_MUTASI_PENSIUN)
public class ValidasiMutasiPensiunApiController {

    private ValidasiMutasiPensiunViewDao validasiMutasiPensiunViewDao;

    @Autowired
    public ValidasiMutasiPensiunApiController(ValidasiMutasiPensiunViewDao validasiMutasiPensiunViewDao){
        this.validasiMutasiPensiunViewDao = validasiMutasiPensiunViewDao;

    }


    @GetMapping
    public Page<ValidasiMutasiPensiunViewDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {

        Page<ValidasiMutasiPensiunView> uIt = (Page<ValidasiMutasiPensiunView>) validasiMutasiPensiunViewDao.findAll(new String[]{"namaMutasi"},"%" + searchParam + "%", pageRequest);
        Page<ValidasiMutasiPensiunViewDto> result = uIt.map(u -> {
            ValidasiMutasiPensiunViewDto dto = u.toDto();
            return dto;
        });

        return result;
    }

}

