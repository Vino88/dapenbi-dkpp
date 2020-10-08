package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.CuspProsesPiutangBulananPlainDto;
import com.dapenbi.dkpp.form.CuspProsesPiutangBulananSPFormDto;
import com.dapenbi.dkpp.form.CuspUpdatePiutangBulananPlainDto;
import com.dapenbi.dkpp.form.CuspUpdatePiutangBulananSPDto;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.TATAUSAHA_PIUTANG_MP)
public class TataUsahaPiutangApiController extends DropdownApiController{

    private PiutangDao piutangDao;
    private PiutangDetailDao piutangDetailDao;
    private PmbyPiutangHistoryDao pmbyPiutangHistoryDao;
    private PmbyPiutangDao pmbyPiutangDao;
    private MPensiunDao mPensiunDao;

    @Autowired
    public TataUsahaPiutangApiController(PiutangDao piutangDao, PiutangDetailDao piutangDetailDao, PmbyPiutangHistoryDao pmbyPiutangHistoryDao, PmbyPiutangDao pmbyPiutangDao, MPensiunDao mPensiunDao){
        super(piutangDao);
        this.piutangDao = piutangDao;
        this.piutangDetailDao = piutangDetailDao;
        this.pmbyPiutangHistoryDao = pmbyPiutangHistoryDao;
        this.pmbyPiutangDao = pmbyPiutangDao;
        this.mPensiunDao = mPensiunDao;
    }

    @GetMapping
    public Page<PiutangDto> index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<Piutang> uIt = (Page<Piutang>) piutangDao.findAll(new String[] {"nip","namaPeserta"},"%"+searchParam+"%",pageRequest);
        Page<PiutangDto> result = uIt.map(u->{
           PiutangDto dto = u.toDto();
           if(u.getIdKantorBayar()!=null) dto.setIdKantorBayar(u.getIdKantorBayar().toDto());
           if(u.getIdKategoriPenerimaMp()!=null) dto.setIdKategoriPenerimaMp(u.getIdKategoriPenerimaMp().toDto());
            return dto;
        });
        return result;

    }

    @GetMapping("/piutang-detail"+"/{nip}")
    public Page<PiutangDetailDto>piutangDetail(Pageable pageRequest,@RequestParam(name = "searchParam",required = false) String searchParam, @PathVariable String nip){
        MPensiun mPensiun = mPensiunDao.findByNip(nip);
        Page<PiutangDetail> uIt = (Page<PiutangDetail>) piutangDetailDao.findAllByNip(mPensiun,pageRequest);
        Page<PiutangDetailDto> result = uIt.map(u->{
            PiutangDetailDto dto = u.toDto();

            if (u.getIdKategoriPenerimaMp()!=null) dto.setIdKategoriPenerimaMp(u.getIdKategoriPenerimaMp().toDto());
                if (u.getIdKantorBayar()!=null) dto.setIdKantorBayar(u.getIdKantorBayar().toDto());
            if (u.getIdValidasi()!=null) dto.setIdValidasi(u.getIdValidasi().toDto());
            if (u.getNip()!=null) dto.setNip(u.getNip().toDto());

            return dto;
        });
        return result;
    }

    @GetMapping("/pmby-piutang-history"+"/{nip}")
    public Page<PmbyPiutangHistoryDto>pmbyPiutangHistory(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam, @PathVariable String nip){
        Page<PmbyPiutangHistory> uIt = (Page<PmbyPiutangHistory>) pmbyPiutangHistoryDao.findAllByNip(nip,pageRequest);
        Page<PmbyPiutangHistoryDto> result = uIt.map(u->{
            PmbyPiutangHistoryDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @PostMapping("/tab2/proses")
    public ResponseEntity<MessageUtil> process(@ModelAttribute CuspProsesPiutangBulananPlainDto plainDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspProsesPiutangBulananSPFormDto spDto = new CuspProsesPiutangBulananSPFormDto();
        spDto.fromPlainText(plainDto);
        Map result = pmbyPiutangDao.processCuspProsesPiutangBulanan(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/tab2/update")
    public ResponseEntity<MessageUtil> processUpdate(@ModelAttribute CuspUpdatePiutangBulananPlainDto plainDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspUpdatePiutangBulananSPDto spDto = new CuspUpdatePiutangBulananSPDto();
        spDto.setParRoleId(role.getId());
        spDto.fromPlainText(plainDto);
        Map result = pmbyPiutangDao.cuspUpdatePiutangBulananSPDto(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping(PathPrefix.DATA+"/list")
    public List<Select2Default> listPeserta(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q ) {
        Iterable<Piutang> it = piutangDao.findAllBySisaPiutang("%" + q + "%", pageable);
        if(q == null){
            it = piutangDao.findAll();
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            PiutangDto piutangDto = k.toDto();
            if (k.getIdKantorBayar() != null){piutangDto.setIdKantorBayar(k.getIdKantorBayar().toDto());}
            if (k.getIdKategoriPenerimaMp()!=null){piutangDto.setIdKategoriPenerimaMp(k.getIdKategoriPenerimaMp().toDto());}
            listSelect2.add(new Select2Default(String.valueOf(k.getNip()), k.getNip() + "-" + k.getNamaPeserta(), piutangDto));
        });
        return listSelect2;
    }

}
