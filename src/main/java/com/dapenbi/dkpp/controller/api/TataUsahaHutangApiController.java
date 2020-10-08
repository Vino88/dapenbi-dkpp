package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.TATAUSAHA_HUTANG_MP)
public class TataUsahaHutangApiController {
    private HutangDao hutangDao;
    private HutangDetailDao hutangDetailDao;
    private RekeningPenerimaMpDao rekeningPenerimaMpDao;
    private PembayaranHutangDao pembayaranHutangDao;
    private PembayaranHutangDetailDao pembayaranHutangDetailDao;

    @Autowired
    public TataUsahaHutangApiController(HutangDao hutangDao, HutangDetailDao HutangDetailDao, RekeningPenerimaMpDao rekeningPenerimaMpDao, PembayaranHutangDao pembayaranHutangDao, PembayaranHutangDetailDao pembayaranHutangDetailDao){
        this.hutangDao = hutangDao;
        this.rekeningPenerimaMpDao = rekeningPenerimaMpDao;
        this.hutangDetailDao = HutangDetailDao;
        this.pembayaranHutangDao = pembayaranHutangDao;
        this.pembayaranHutangDetailDao = pembayaranHutangDetailDao;
    }

    @GetMapping
    public Page<HutangDto> index(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<Hutang> uIt = (Page<Hutang>) hutangDao.findAllByType(new String[] {"MP","MPS"}, "%" + searchParam + "%", pageRequest);
        Page<HutangDto> result = uIt.map(u->{
           HutangDto dto = u.toDto();
           dto.setRekeningPenerimaMp(rekeningPenerimaMpDao.findByNip(u.getNip()));
            return dto;
        });
        return result;

    }

    @GetMapping("/pembinaan")
    public Page<HutangDto> indexPembinaan(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<Hutang> uIt = (Page<Hutang>) hutangDao.findAllByType(new String[] {"PEMBINAAN"}, "%" + searchParam + "%", pageRequest);
        Page<HutangDto> result = uIt.map(u->{
            HutangDto dto = u.toDto();
            dto.setRekeningPenerimaMp(rekeningPenerimaMpDao.findByNip(u.getNip()));
            return dto;
        });
        return result;

    }

    @GetMapping("/get-header/{id_hutang}")
    public HutangDto getHeaderData(@PathVariable(name="id_hutang") Long idHutang){
        System.out.println(idHutang);
        Hutang hutang = hutangDao.findById(idHutang);
        HutangDto hutangDto = hutang.toDto();
        hutangDto.setRekeningPenerimaMp(rekeningPenerimaMpDao.findByNip(hutang.getNip()));
        return hutangDto;
    }

    @GetMapping("/get-detail/{id}")
    public Page<HutangDetailDto> getHutangDetail(Pageable pageRequest, @PathVariable(name="id") Long id){
        Page<HutangDetail> uIt = hutangDetailDao.findAllByHutangId(id, pageRequest);
        Page<HutangDetailDto> result = uIt.map(u->{
            HutangDetailDto dto = u.toDto();
            return dto;
        });

        return result;

    }

    @GetMapping("/detail/{id_hutang}")
    public Page<HutangDetailDto>hutangDetail(Pageable pageRequest,@RequestParam(name = "searchParam",required = false) String searchParam, @PathVariable(name="id_hutang") Long idHutang){
        Page<HutangDetail> uIt = (Page<HutangDetail>) hutangDetailDao.findAllByHutangId(idHutang, pageRequest);
        Page<HutangDetailDto> result = uIt.map(u->{
            HutangDetailDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @GetMapping("/detail-pembinaan/{id_hutang}")
    public Page<HutangDetailDto> hutangPembinaanDetail(Pageable pageRequest,@RequestParam(name = "searchParam",required = false) String searchParam, @PathVariable(name="id_hutang") Long idHutang){
        Page<HutangDetail> uIt = (Page<HutangDetail>) hutangDetailDao.findAllByHutangId(idHutang, pageRequest);
        Page<HutangDetailDto> result = uIt.map(u->{
            HutangDetailDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @GetMapping("/pembayaran")
    public Page<PembayaranHutangDto> indexPembayaran(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<PembayaranHutang> uIt = (Page<PembayaranHutang>) pembayaranHutangDao.findAllByIsHutangMp ("1", "%" + searchParam + "%", pageRequest);
        Page<PembayaranHutangDto> result = uIt.map(u->{
            PembayaranHutangDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @GetMapping("/get-header-pembayaran/{id}")
    public PembayaranHutangDto getHeaderPembayaranData(@PathVariable(name="id") Long id){
        PembayaranHutang pembayaranHutang = pembayaranHutangDao.findById(id);
        PembayaranHutangDto pembayaranHutangDto = pembayaranHutang.toDto();
        RekeningPenerimaMp rmp = rekeningPenerimaMpDao.findByNip(pembayaranHutang.getNip());
        if(rmp != null)
            pembayaranHutangDto.setRekeningPenerimaMpDto( rmp.toDto() );

        return pembayaranHutangDto;
    }

    @GetMapping("/detail-pembayaran-mp/{id}")
    public Page<PembayaranHutangDetailDto> getPembayaranMpDetail(Pageable pageRequest, @PathVariable(name="id") Long id){
        Page<PembayaranHutangDetail> uIt = pembayaranHutangDetailDao.findByPembayaranId (id, pageRequest);
        Page<PembayaranHutangDetailDto> result = uIt.map(u->{
            PembayaranHutangDetailDto dto = u.toDto();
            return dto;
        });

        return result;

    }

    @GetMapping("/pembayaran-pembinaan")
    public Page<PembayaranHutangDto> indexPembayaranPembinaan(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<PembayaranHutang> uIt = (Page<PembayaranHutang>) pembayaranHutangDao.findAllByIsHutangPembinaan("1", "%" + searchParam + "%", pageRequest);
        Page<PembayaranHutangDto> result = uIt.map(u->{
            PembayaranHutangDto dto = u.toDto();
            return dto;
        });
        return result;
    }

    @GetMapping("/detail-pembayaran-pembinaan/{id}")
    public Page<PembayaranHutangDetailDto> getPembayaranPembinaanDetail(Pageable pageRequest, @PathVariable(name="id") Long id){
        Page<PembayaranHutangDetail> uIt = pembayaranHutangDetailDao.findByPembayaranId (id, pageRequest);
        Page<PembayaranHutangDetailDto> result = uIt.map(u->{
            PembayaranHutangDetailDto dto = u.toDto();
            return dto;
        });

        return result;

    }

    @PostMapping("process-call-sp")
    public ResponseEntity<MessageUtil> processMutasi(@ModelAttribute CuspPembayaranHutangPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPembayaranHutangSPDto spDto = new CuspPembayaranHutangSPDto();
        spDto.fromPlainText(plainDto);
        spDto.setParCompName(DkppUserStamp.getCompName());
        spDto.setParUserName(DkppUserStamp.getUserName());

        Map result = this.hutangDao.processCuspPembayaranHutang(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil diproses.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

    }

    @PostMapping("process-call-sp-ptr")
    public ResponseEntity<MessageUtil> processSendToPtr(@ModelAttribute CuspPembayaranHutangPtrPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPembayaranHutangPtrSPDto spDto = new CuspPembayaranHutangPtrSPDto();
        spDto.fromPlainText(plainDto);
        spDto.setParCompName(DkppUserStamp.getCompName());
        spDto.setParUserName(DkppUserStamp.getUserName());
        spDto.setParIdBayar(Long.valueOf(plainDto.getParIdBayar()));

        Map result = this.hutangDao.processCuspPembayaranHutangPtr(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil diproses.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);

    }


}
