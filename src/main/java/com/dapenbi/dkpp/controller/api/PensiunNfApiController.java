package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.PENERIMA_MP_NF)
public class PensiunNfApiController extends DropdownApiController{

    MPensiunNfDao mPensiunNfDao;
    MKeluargaPensiunNfDao mKeluargaPensiunNfDao;
    TKursDao tKursDao;
    PembayaranMpNfDao pembayaranMpNfDao;
    TMutasiPensiunNfDao tMutasiPensiunNfDao;

    HerRegistrasiMpNFHeaderDao herRegistrasiMpNFHeaderDao;
    HerRegistrasiMpNFDetailDao herRegistrasiMpNFDetailDao;
    HutangNfDao hutangNfDao;
    PembayaranHutangNfDao pembayaranHutangNfDao;

    @Autowired
    public PensiunNfApiController(MPensiunNfDao mPensiunNfDao,
                                  MKeluargaPensiunNfDao mKeluargaPensiunNfDao,
                                  TKursDao tKursDao,
                                  HerRegistrasiMpNFHeaderDao herRegistrasiMpNFHeaderDao,
                                  HerRegistrasiMpNFDetailDao herRegistrasiMpNFDetailDao,
                                  HutangNfDao hutangNfDao,
                                  PembayaranHutangNfDao pembayaranHutangNfDao,
                                  PembayaranMpNfDao pembayaranMpNfDao,
                                  TMutasiPensiunNfDao tMutasiPensiunNfDao){
        super(mPensiunNfDao);
        this.mPensiunNfDao = mPensiunNfDao;
        this.mKeluargaPensiunNfDao = mKeluargaPensiunNfDao;
        this.tKursDao = tKursDao;
        this.pembayaranMpNfDao = pembayaranMpNfDao;
        this.tMutasiPensiunNfDao = tMutasiPensiunNfDao;
        this.herRegistrasiMpNFHeaderDao = herRegistrasiMpNFHeaderDao;
        this.herRegistrasiMpNFDetailDao = herRegistrasiMpNFDetailDao;
        this.hutangNfDao = hutangNfDao;
        this.pembayaranHutangNfDao = pembayaranHutangNfDao;
        this.pembayaranMpNfDao = pembayaranMpNfDao;
        this.tMutasiPensiunNfDao = tMutasiPensiunNfDao;
    }

    @GetMapping
    public Page<MPensiunNfDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MPensiunNf> uIt = (Page<MPensiunNf>)  mPensiunNfDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<MPensiunNfDto> mPensiunNfDtos = uIt.map(u -> {
            MPensiunNfDto dto = u.toDto();
            return dto;
        });

        return mPensiunNfDtos;
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updatePenerimaMP(@ModelAttribute CuspMutasiPensiunNfPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);


        CuspMutasiPensiunNfSPDto spDto = new CuspMutasiPensiunNfSPDto();
        spDto.fromPlainText(plainDto);
        spDto.setParRoleId(role.getId());
        spDto.setParUserName(user.getUsername());
        spDto.setParCompName(DkppUserStamp.getCompName());
        Map result = this.mPensiunNfDao.processCuspMutasiPensiunNf(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }


    @PostMapping("/post-keluarga")
    public ResponseEntity<MessageUtil> addKeluargaPensiunNf(@ModelAttribute MKeluargaPensiunNfPlainDto form) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        form.setUserStamp(DkppUserStamp.postModeUserStamp());
        form.setIdKeluarga("0");
        MKeluargaPensiunNf keluargaPensiunNf = new MKeluargaPensiunNf();
        MKeluargaPensiunNfDto dto = new MKeluargaPensiunNfDto();
        dto.fromPlainDto(form);

        keluargaPensiunNf.fromDto(dto);

        MKeluargaPensiunNfDto dtoOut = mKeluargaPensiunNfDao.save(keluargaPensiunNf).toDto();

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (dtoOut.getIdKeluarga() != null || dtoOut.getIdKeluarga() != 0) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal ditambahkan");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PutMapping("/put-keluarga")
    public ResponseEntity<MessageUtil> updateKeluargaPensiunNf(@ModelAttribute MKeluargaPensiunNfPlainDto form) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        form.setUserStamp(DkppUserStamp.postModeUserStamp());
        MKeluargaPensiunNf keluargaPensiunNf = new MKeluargaPensiunNf();
        MKeluargaPensiunNfDto dto = new MKeluargaPensiunNfDto();
        dto.fromPlainDto(form);

        keluargaPensiunNf.fromDto(dto);

        MKeluargaPensiunNfDto dtoOut = mKeluargaPensiunNfDao.save(keluargaPensiunNf).toDto();

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (dtoOut.getIdKeluarga() != null || dtoOut.getIdKeluarga() != 0) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal ditambahkan");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/delete-keluarga/{id}")
    public ResponseEntity<MessageUtil> updateKeluargaPensiunNf(@PathVariable Long id) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        MKeluargaPensiunNf keluargaPensiunNf = (MKeluargaPensiunNf) mKeluargaPensiunNfDao.findById(id);
        mKeluargaPensiunNfDao.delete(keluargaPensiunNf);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        messageUtil = new MessageUtil("success", "Data berhasil dihapus");
        httpStatus = HttpStatus.OK;
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/{nip}/get-keluarga")
    public Map getKeluarga(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @PathVariable String nip) {
        List<MKeluargaPensiunNf> uIt = (List<MKeluargaPensiunNf>) mKeluargaPensiunNfDao.findByNip(nip);
        List<MKeluargaPensiunNfDto> mKeluargaPensiunNfDtos = new ArrayList<>();
        uIt.forEach(u -> {
            MKeluargaPensiunNfDto dto = u.toDto();
            dto.setNip(u.getNip());
            dto.setIdKeluarga(u.getIdKeluarga());
            dto.setTglLahir(u.getTglLahir());
            dto.setNama(u.getNama());
            dto.setTempatLahir(u.getTempatLahir());
            dto.setUserStamp(u.getUserStamp());
            dto.setHubungan(u.getHubungan());
            dto.setJenisKelamin(u.getJenisKelamin());

            mKeluargaPensiunNfDtos.add(dto);
        });
        Map out = new HashMap();
        out.put("data", mKeluargaPensiunNfDtos);
        return out;
    }

    @GetMapping("/kurs")
    public Map getKurs(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        List<TKurs> uIt = (List<TKurs>) tKursDao.findAll();
        List<TKursDto> tKursDtos = new ArrayList<>();
        uIt.forEach(u -> {
            TKursDto dto = u.toDto();
            tKursDtos.add(dto);
        });
        Map out = new HashMap();
        out.put("data", tKursDtos);
        return out;
    }

    @PostMapping("/kurs")
    public ResponseEntity<MessageUtil> postKurs(@ModelAttribute CuspKursPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);


        CuspKursSPDto spDto = new CuspKursSPDto();
        spDto.fromPlainText(plainDto);
        spDto.setParUserName(DkppUserStamp.getUserName());
        spDto.setParCompName(DkppUserStamp.getCompName());
        Map result = this.tKursDao.processCuspKurs(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1") || result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/proses-pembayaran-mp-nf")
    public ResponseEntity<MessageUtil> prosesPembayaranMpNf(@ModelAttribute CuspPembayaranMpNfPlainDto form) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPembayaranMpNfSPDto spDto = new CuspPembayaranMpNfSPDto();
        spDto.fromPlainText(form);
        spDto.setParRoleId(role.getId());
        spDto.setParCompName(DkppUserStamp.getCompName());
        spDto.setParUserName(DkppUserStamp.getUserName());
        Map result = this.mPensiunNfDao.processCuspPembayaranMpNf(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1") || result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diproses.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
            }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/her-registrasi-nf")
    public Page<HerRegistrasiMpNFHeaderDto> getData(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<HerRegistrasiMpNFHeader> uIt = (Page<HerRegistrasiMpNFHeader>) herRegistrasiMpNFHeaderDao.findAll(new String[] {"tahunHer"}, "%" + searchParam + "%", pageRequest);

        Page<HerRegistrasiMpNFHeaderDto> HerRegistrasiMpNFHeaderDto = uIt.map(u -> {
            HerRegistrasiMpNFHeaderDto dto = u.toDto();

            return dto;
        });

        return HerRegistrasiMpNFHeaderDto;
    }

    @GetMapping("/data-header-her/{tahun}")
    public HerRegistrasiMpNFHeaderDto getDataHer(Pageable pageRequest, @PathVariable(name = "tahun", required = true) String tahun) {
        HerRegistrasiMpNFHeader herRegistrasiMpNFHeader = (HerRegistrasiMpNFHeader) herRegistrasiMpNFHeaderDao.findFirstByTahunHer(tahun);
        return herRegistrasiMpNFHeader.toDto();
    }

    @PostMapping("/post-her-registrasi")
    public ResponseEntity<MessageUtil> prosesHer(@ModelAttribute CuspHerRegistrasiNFProses plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspHerRegistrasiNFProses spDto = new CuspHerRegistrasiNFProses();
        spDto.fromPlainText(plainDto);
        Map result = herRegistrasiMpNFHeaderDao.CuspHerRegistrasiNFProses(spDto);
        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || (result.get("PAR_STATUS_EKSEKUSI").equals("1"))) {
            messageUtil = new MessageUtil("success", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/proses-pembayaran-mp-nf-send-ptr")
    public ResponseEntity<MessageUtil> prosesPembayaranMpNfSendPtr(@ModelAttribute CuspPembayaranMpNfPtrPlainDto form) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPembayaranMpNfPtrSPDto spDto = new CuspPembayaranMpNfPtrSPDto();
        spDto.fromPlainText(form);
        spDto.setParCompName(DkppUserStamp.getCompName());
        spDto.setParUserName(DkppUserStamp.getUserName());
        Map result = this.pembayaranMpNfDao.processCuspPembayaranMpNfPtr(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1") || result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diproses.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
            }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/her-registrasi-nf-detail/{tahunHer}")
    public Map getDataDetail(Pageable pageRequest,@RequestParam(name = "searchParam", required = false) String searchParam, @PathVariable(value = "tahunHer") String tahunHer) {
        List<HerRegistrasiMpNFDetail> uIt = (List<HerRegistrasiMpNFDetail>) herRegistrasiMpNFDetailDao.findByTahunHer(tahunHer);
        List<HerRegistrasiMpNFDetailDto> herRegistrasiMpNFDetailDtos = new ArrayList<>();
        uIt.forEach(u -> {
            HerRegistrasiMpNFDetailDto dto = u.toDto();
            dto.setNip(u.getNip());
            dto.setNamaPeserta(u.getNamaPeserta());
            dto.setNamaPenerimaMp(u.getNamaPenerimaMp());
            dto.setSudahHerDesc(u.getSudahHerDesc());

            herRegistrasiMpNFDetailDtos.add(dto);
        });
        Map out = new HashMap();
        out.put("data", herRegistrasiMpNFDetailDtos);
        return out;
    }

    @PostMapping("/post-registrasi-update")
    public ResponseEntity<MessageUtil> prosesHerUpdate(@ModelAttribute CuspHerRegistrasiNFUpdate plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspHerRegistrasiNFUpdate spDto = new CuspHerRegistrasiNFUpdate();
        spDto.fromPlainText(plainDto);
        Map result = herRegistrasiMpNFHeaderDao.CuspHerRegistrasiNFUpdate(spDto);
        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || (result.get("PAR_STATUS_EKSEKUSI").equals("1") )){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/data-pembayaran-mp-nf")
    public Page<PembayaranMpNfDto> dataPembayaranPenerimaMpNf(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<PembayaranMpNf> uIt = (Page<PembayaranMpNf>) pembayaranMpNfDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<PembayaranMpNfDto> pembayaranMpNfDtos = uIt.map(u -> {
            PembayaranMpNfDto dto = u.toDto();
            return dto;
        });

        return pembayaranMpNfDtos;
    }

    @GetMapping("/data-mutasi-hapus-nf")
    public Page<TMutasiPensiunNfDto> getDataMutasiHapus(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<TMutasiPensiunNf> uIt = (Page<TMutasiPensiunNf>) tMutasiPensiunNfDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<TMutasiPensiunNfDto> tPensiunNfDtos = uIt.map(u -> {
            TMutasiPensiunNfDto dto = u.toDto();
            return dto;
        });

        return tPensiunNfDtos;
    }

    @PostMapping("/insert-mutasi-hapus")
    public ResponseEntity<MessageUtil> postMutasiHapusPenerimaMpNf(@ModelAttribute CuspMutasiHapusPensiunNfPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);

        CuspMutasiHapusPensiunNfSPDto spDto = new CuspMutasiHapusPensiunNfSPDto();
        spDto.setParRoleId(role.getId());
        spDto.fromPlainText(plainDto);
        spDto.setParUserName(DkppUserStamp.getUserName());
        spDto.setParCompName(DkppUserStamp.getCompName());
        Map result = this.tMutasiPensiunNfDao.processCuspMutasiHapusPensiunNf(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1") || result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }
    @GetMapping("/hutang-nf")
    public Page<HutangNfDto> hutangView(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<HutangNF> uIt = (Page<HutangNF>) hutangNfDao.findAll(new String[] {"periodeMutasi"}, "%" + searchParam + "%", pageRequest);
        Page<HutangNfDto> HutangNfDto = uIt.map(u -> {
            HutangNfDto dto = u.toDto();

            return dto;
        });
        return HutangNfDto;
    }

    @GetMapping("/pembayaran-hutang-nf")
    public Page<PembayaranHutangNfDto> pembayaranHutangView(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<PembayaranHutangNf> uIt = (Page<PembayaranHutangNf>) pembayaranHutangNfDao.findAll(new String[] {"nip"}, "%" + searchParam + "%", pageRequest);
        Page<PembayaranHutangNfDto> PembayaranHutangNfDto = uIt.map(u -> {
            PembayaranHutangNfDto dto = u.toDto();

            return dto;
        });
        return PembayaranHutangNfDto;
    }

    @PostMapping("/post-pembayaran-hutang-update")
    public ResponseEntity<MessageUtil> updateHutangNf(@ModelAttribute CuspPembayaranHutangNf plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPembayaranHutangNf spDto = new CuspPembayaranHutangNf();
        spDto.fromPlainText(plainDto);
        Map result = pembayaranHutangNfDao.CuspPembayaranHutangNf(spDto);
        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || (result.get("PAR_STATUS_EKSEKUSI").equals("1") )){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PostMapping("/sent-to-ptr-nf")
    public ResponseEntity<MessageUtil> kirimPtrNf(@ModelAttribute CuspPembayaranHutangNfPtr plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspPembayaranHutangNfPtr spDto = new CuspPembayaranHutangNfPtr();
        spDto.fromPlainText(plainDto);
        Map result = pembayaranHutangNfDao.CuspPembayaranHutangNfPtr(spDto);
        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1') || (result.get("PAR_STATUS_EKSEKUSI").equals("1") )){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

}
