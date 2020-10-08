package com.dapenbi.dkpp.controller.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dao.ViewModel.PensLamaMeninggalViewDao;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.dto.ViewModelDto.PensiunLamaMeninggalViewDto;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.model.ViewModel.PensiunLamaMeninggalView;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import com.dapenbi.dkpp.util.ResponseUtil;
import org.jetbrains.annotations.NotNull;
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

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PENERIMA_MP_MENINGGAL_DUNIA)
public class MutasiPenerimaMPMeninggalApiController {

    @Autowired
    PensLamaMeninggalViewDao pensLamaMeninggalViewDao;

    @Autowired
    MutasiPensiunDao mutasiPensiunDao;

    @Autowired
    SetupParameterDao setupParameterDao;

    @Autowired
    KotaDao kotaDao;

    @Autowired
    AgamaDao agamaDao;

    @Autowired
    ProvinsiDao provinsiDao;

    @Autowired
    KecamatanDao kecamatanDao;

    @Autowired
    KelurahanDao kelurahanDao;

    @Autowired
    MPensiunDao pensiunDao;

    @Autowired
    NegaraDao negaraDao;

    @Autowired
    PesertaDao pesertaDao;

    @Autowired
    SuskelDao suskelDao;

    @Autowired
    StatusKawinDao statusKawinDao;

    @Autowired
    KeluargaPensiunDao keluargaPensiunDao;

    private DataSource dataSource;
    public MutasiPenerimaMPMeninggalApiController(DataSource dataSource) {
    this.dataSource = dataSource;
    }


    @GetMapping
    public Page<PensiunLamaMeninggalViewDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        SetupParameter setupParameter = this.setupParameterDao.findByBukaPeriode();
        Page<PensiunLamaMeninggalView> uIt = (Page<PensiunLamaMeninggalView>) pensLamaMeninggalViewDao.findAll(new String[]{"nip", "namaPeserta"}, "%" + searchParam + "%", pageRequest);

                Page<PensiunLamaMeninggalViewDto> result = uIt.map(u -> {
            PensiunLamaMeninggalViewDto dto = u.toDto();
            return dto;
        });

        return result;
    }

    @GetMapping("/belum-validasi")
    public Page<PensiunLamaMeninggalViewDto>indexBelumValidasi(Pageable pageRequest, @RequestParam(name = "searchParam",required = false) String searchParam){
        Page<PensiunLamaMeninggalView> uIt = (Page<PensiunLamaMeninggalView>) pensLamaMeninggalViewDao.findAllByBelumValidasi("%"+searchParam+"%",pageRequest);
        Page<PensiunLamaMeninggalViewDto> result = uIt.map(u->{
            PensiunLamaMeninggalViewDto dto = u.toDto();
            return dto;
        });
        return result;
    }


    @PostMapping
    public ResponseEntity<MessageUtil> addMutasiPenerimaMpMenikah(@ModelAttribute MutasiMeninggalPlainTextFormDto plainDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        MutasiMeninggalSPFormDto spDto = new MutasiMeninggalSPFormDto();
        spDto.fromPlainText(plainDto);
        spDto.setRoleId(role.getId());
        try {
            KeluargaPensiun keluargaPensiun = keluargaPensiunDao.findById(spDto.getParIdPenerimaMpBaru());
            spDto.setParJkPenerimampBaru(keluargaPensiun.getJenisKelamin().charAt(0));
            spDto.setParTglLhrPenerimampBaru(keluargaPensiun.getTglLahir());
            spDto.setParNamaKawinPenerimampBaru(keluargaPensiun.getNamaStatusKawin());
            spDto.setParIdKawinPenerimampBaru(keluargaPensiun.getStatusKawin().getId());
            StatusKawin statusKawin = statusKawinDao.findById(spDto.getParIdKawinPenerimampBaru());
            spDto.setParNamaKawinPenerimampBaru(statusKawin.getStatusKawin());
        }catch (Exception ex){

        }

        Map result = mutasiPensiunDao.processMutasiPenerimaMpMeninggal(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }

        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateMutasiPenerimaMpMenikah(@ModelAttribute MutasiMeninggalPlainTextFormDto plainDto) {
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        MutasiMeninggalSPFormDto spDto = new MutasiMeninggalSPFormDto();
        spDto.fromPlainText(plainDto);
        spDto.setRoleId(role.getId());
        try {
            KeluargaPensiun keluargaPensiun = keluargaPensiunDao.findById(spDto.getParIdPenerimaMpBaru());
            spDto.setParJkPenerimampBaru(keluargaPensiun.getJenisKelamin().charAt(0));
            spDto.setParTglLhrPenerimampBaru(keluargaPensiun.getTglLahir());
            spDto.setParNamaKawinPenerimampBaru(keluargaPensiun.getNamaStatusKawin());
            spDto.setParIdKawinPenerimampBaru(keluargaPensiun.getStatusKawin().getId());
            StatusKawin statusKawin = statusKawinDao.findById(spDto.getParIdKawinPenerimampBaru());
            spDto.setParNamaKawinPenerimampBaru(statusKawin.getStatusKawin());
            spDto.setParNamaStatusBayarUpdate(spDto.getParNamaStatusBayarUpdate().toUpperCase());
        } catch (Exception ex){

        }

        if (spDto.getParIdNegaraUpdate() == null) {
            spDto.setParAlmtIsDalamnegeriUpdate('1');
        }else{
            spDto.setParAlmtIsDalamnegeriUpdate('0');
        }
        Map result = mutasiPensiunDao.processMutasiPenerimaMpMeninggal(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil diubah.", spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(), spDto);
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/kota")
    public KotaDto kota(@RequestParam(name = "id", required = true) Long id){
        Kota kota_ = kotaDao.findById(id);
        KotaDto kotaDto = kota_.toDto();
        return kotaDto;
    }

    @GetMapping("/detail_alamat")
    public Object getDetailAlamatByKodePos(@RequestParam(name = "kodePos", required = true) String kodePos){
        return kelurahanDao.findAlamatByKodePos(kodePos);
    }

    @GetMapping("/mpWafatSimulation")
    public Map cufnMenikahSimulation(@RequestParam(name = "nip") String nip, @RequestParam("tglMeninggal") String tglMeninggal, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idStatusBayar") Long idStatusBayar){
        return this.mutasiPensiunDao.mpWafatSimulation(nip, periodeMutasi, tglMeninggal, idStatusBayar);
    }

    @PostMapping("/checksuskel")
    public SuskelDto checksuskelPenerimaMeninggal(@ModelAttribute SuskelFormDto suskelFormDto, @RequestParam(name = "idKategoriPenerima") String idKategoriPenerima, @RequestParam(name = "tglWafat") String tglWafat) {
        MPensiun peserta = pensiunDao.findByNip(suskelFormDto.getNip());
        PesertaFormDto pesertaFormDto = new PesertaFormDto();
        pesertaFormDto.setNip(peserta.getNip());
        if (idKategoriPenerima.equals("1") ){
            pesertaFormDto.setTglWafat(tglWafat);
        }else{
            if(peserta.getTglMeninggalPeserta() != null) {
                pesertaFormDto.setTglWafat(peserta.getTglMeninggalPeserta().toString());
            }
        }

        if (peserta.getNamaPeserta() !=null){
            pesertaFormDto.setNamaPeserta(peserta.getNamaPeserta());
        }
        if (peserta.getJenisKelaminPeserta() != null){
            pesertaFormDto.setJenisKelamin(peserta.getJenisKelaminPeserta());
        }
        if (peserta.getTglLahirPeserta() != null){
            pesertaFormDto.setTglLahir(peserta.getTglLahirPeserta().toString());
        }
        if (peserta.getTglKerjaPeserta() != null){
            pesertaFormDto.setTglKerja(peserta.getTglKerjaPeserta().toString());
        }
        if (peserta.getTglDhptPeserta() != null){
            pesertaFormDto.setTglPeserta(peserta.getTglDhptPeserta().toString());
        }
        if (peserta.getTglHentiKerjaPeserta() != null){
            pesertaFormDto.setTglHenti(peserta.getTglHentiKerjaPeserta().toString());
        }
        if (peserta.getGolongan().getId() !=null){
            pesertaFormDto.setGolongan(peserta.getGolongan().getId());
        }
        if (peserta.getAgama().getId() != null) {
            pesertaFormDto.setAgama(peserta.getAgama().getId());
        }
        /*if (peserta.getnpwp() != null){
            pesertaFormDto.setNpwp(peserta.getNpwp());
        }*/
        if (peserta.getPhdp() !=null){
            pesertaFormDto.setGapok(peserta.getPhdp());
        }
        if (peserta.getUpahVeteran()!= null){
            pesertaFormDto.setUpahVeteran(peserta.getUpahVeteran());
        }
        if (peserta.getUpahVeteran()!=null){
            pesertaFormDto.setMkVeteran(String.valueOf(peserta.getUpahVeteran()));
        }
        if (peserta.getAlasanHenti().getId()!=null){
            pesertaFormDto.setAlasanHenti(peserta.getAlasanHenti().getId());
        }
        if (peserta.getPredikatPemberhentian().getId()!=null){
            pesertaFormDto.setPredikatPemberhentian(peserta.getPredikatPemberhentian().getId());
        }
        if (peserta.getNoSkBi()!=null){
            pesertaFormDto.setNoSKBI(peserta.getNoSkBi());
        }
        if (peserta.getTglSkBi()!=null){
            pesertaFormDto.setTglSKBI(peserta.getTglSkBi().toString());
        }
        if (peserta.getAlamatLengkap()!=null){
            pesertaFormDto.setAlamat(peserta.getAlamatLengkap());
        }
        List<KeluargaPesertaFormDto> dataKeluargas = extractkeluarga(suskelFormDto);

        Suskel suskel = new Suskel();
        try {
            suskel = suskelDao.generateSuskel(pesertaFormDto, dataKeluargas);
            SuskelDto suskelDto = suskel.toDto();
            return suskelDto;
        } catch (Exception e) {
            return null;
        }

    }

    @NotNull
    public List<KeluargaPesertaFormDto> extractkeluarga(@ModelAttribute SuskelFormDto formDto) {
        List<KeluargaPesertaFormDto> dataKeluargas = new ArrayList<>();
        if (formDto.getDataKeluarga() != null) {
            for (Map<String, String> keluarga : formDto.getDataKeluarga()) {
                KeluargaPesertaFormDto dataKeluarga = new KeluargaPesertaFormDto();
                if (!keluarga.get("id").startsWith("tmp")) {
                    dataKeluarga.setId(keluarga.get("id"));
                }
                dataKeluarga.setNamaKeluarga(keluarga.get("namaKeluarga"));
                dataKeluarga.setJenisKelamin(keluarga.get("jenisKelamin"));
                try {
                    dataKeluarga.setIdKategoriPenerima(Long.valueOf(keluarga.get("idKategoriPenerima")));
                    dataKeluarga.setTanggalLahir(DateUtil.stringToDate(keluarga.get("tglLahir")));
                    dataKeluarga.setTanggalMenikah(DateUtil.stringToDate(keluarga.get("tglMenikah")));
                    dataKeluarga.setTanggalCerai(DateUtil.stringToDate(keluarga.get("tglCerai")));
                    dataKeluarga.setTanggalWafat(DateUtil.stringToDate(keluarga.get("tglWafat")));
                    dataKeluarga.setTanggalUsia25(DateUtil.stringToDate(keluarga.get("tglUsia25")));
                    dataKeluarga.setStatusKawin(Long.valueOf(keluarga.get("statusKawin")));
                }catch (Exception ex) {

                }
                dataKeluargas.add(dataKeluarga);
            }
        }
        return dataKeluargas;
    }


    @PostMapping("/process")
    public ResponseEntity<ResponseUtil> put(Pageable pageRequest,
                                            @RequestParam(name = "idMutasi", required = false) Long idMutasi,
                                            @RequestParam(name = "roleId", required = false) Long roleId,
                                            @RequestParam(name = "compName", required = false) String compName,
                                            @RequestParam(name = "userName", required = false) String userName,
                                            @RequestParam(name = "kodeMutasi", required = false) String kodeMutasi,
                                            @RequestParam(name = "periodeMutasi", required = false) String periodeMutasi,
                                            @RequestParam(name = "tglMutasi", required = false) Date tglMutasi,
                                            @RequestParam(name = "nip", required = false) String nip,
                                            @RequestParam(name = "namaPesertaUpdate", required = false) String namaPesertaUpdate,
                                            @RequestParam(name = "idAgamaUpdate", required = false)Long idAgamaUpdate,
                                            @RequestParam(name = "namaAgamaUpdate", required = false) String namaAgamaUpdate,
                                            @RequestParam(name = "idGolonganUpdate", required = false) Long idGolonganUpdate,
                                            @RequestParam(name = "namaGolonganUpdate", required = false) String namaGolonganUpdate,
                                            @RequestParam(name = "phdp", required = false) BigDecimal phdp,
                                            @RequestParam(name = "idKantorBayarUpdate", required = false) String idKantorBayarUpdate,
                                            @RequestParam(name = "namaKantorBayarUpdate", required = false)String namaKantorBayarUpdate,
                                            @RequestParam(name = "tlgSpBiUpdate", required = false) Date tglSpBiUpdate,
                                            @RequestParam(name = "noSpBiUpdate", required = false) String noSpBiUpdate,
                                            @RequestParam(name = "tglSkBiUpdate", required = false) Date tglSkBiUpdate,
                                            @RequestParam(name = "noSkBiUpdate", required = false) String noSkBiUpdate,
                                            @RequestParam(name = "alamatisDalamNegeriUpdate", required = false) Boolean alamatisDalamNegeriUpdate,
                                            @RequestParam(name = "idProvinsiUpdate", required = false) Long idProvinsiUpdate,
                                            @RequestParam(name = "namaProvinsiUpdate", required = false) String namaProvinsiUpdate,
                                            @RequestParam(name = "idKotaKabUpdate", required = false) Long idKotaKabUpdate,
                                            @RequestParam(name = "namaKotaKabUpdate", required = false) String namaKotaKabUpdate,
                                            @RequestParam(name = "idKecamatanUpdate", required = false) Long idKecamatanUpdate,
                                            @RequestParam(name = "namaKecamatanUpdate", required = false) String namaKecamatanUpdate,
                                            @RequestParam(name = "idKelurahanUpdate", required = false) Long idKelurahanUpdate,
                                            @RequestParam(name = "namaKelurahanUpdate", required = false) String namaKelurahanUpdate,
                                            @RequestParam(name = "kodePosUpdate", required = false) String kodePosUpdate,
                                            @RequestParam(name = "alamatLengkapUpdate", required = false) String alamatLengkapUpdate,
                                            @RequestParam(name = "noHpUpdate", required = false) String noHpUpdate,
                                            @RequestParam(name = "noTelpUpdate", required = false) String noTelpUpdate,
                                            @RequestParam(name = "emailUpdate", required = false) String emailUpdate,
                                            @RequestParam(name = "rtUpdate", required = false) String rtUpdate,
                                            @RequestParam(name = "rwUpdate", required = false) String rwUpdate,
                                            @RequestParam(name = "idNegaraUpdate",required = false) Long idNegaraUpdate,
                                            @RequestParam(name = "namaNegaraUpdate", required = false) String namaNegaraUpdate,
                                            @RequestParam(name = "idPenerimaMpLama", required = false) String idPenerimaMpLama,
                                            @RequestParam(name = "namaPenerimaMpLamaUpdate", required = false) String namaPenerimaMpLamaUpdate,
                                            @RequestParam(name = "idKategoriPenerimaMpLama", required = false) Long idKategoriPenerimaMpLama,
                                            @RequestParam(name = "tglWftPenerimaMpLama", required = false) Date tglWftPenerimaMpLama,
                                            @RequestParam(name = "tglInfWftPenerimaMpLama", required = false) Date tglInfWftPenerimaMpLama,
                                            @RequestParam(name = "idPenerimaMpBaru", required = false) String idPenerimaMpBaru,
                                            @RequestParam(name = "namaPenerimaMpBaru", required = false) String namaPenerimaMpBaru,
                                            @RequestParam(name = "idKategoriPenerimaMpBaru", required = false) Long idKategoriPenerimaMpBaru,
                                            @RequestParam(name = "namaKategoriPenerimaMpBaru", required = false) String namaKategoriPenerimaMpBaru,
                                            @RequestParam(name = "jkPenerimaMpBaru", required = false) Character jkPenerimaMpBaru,
                                            @RequestParam(name = "tglLahirPenerimaMpBaru", required = false) Date tglLahirPenerimaMpBaru,
                                            @RequestParam(name = "idKawinPenerimaMpBaru", required = false) Long idKawinPenerimaMpBaru,
                                            @RequestParam(name = "namaKawinPenerimaMpBaru", required = false) String namaKawinPenerimaMpBaru,
                                            @RequestParam(name = "idSuskerlBaru", required = false) Long idSuskelBaru,
                                            @RequestParam(name = "namaSuskelBaru", required = false) String namaSuskelBaru,
                                            @RequestParam(name = "tglBulan13", required = false) Date tglBulan13,
                                            @RequestParam(name = "lebihBayarNominal", required = false) BigDecimal lebihBayarNominal,
                                            @RequestParam(name = "lebihBayarJmlBulan", required = false) BigDecimal lebihBayarJmlBulan,
                                            @RequestParam(name = "lebihBayarNominal13",required =  false) BigDecimal lebihBayarNominal13,
                                            @RequestParam(name = "lebihBayarJmlBulan13", required = false) BigDecimal lebihBayarJmlBulan13,
                                            @RequestParam(name = "nominalTerbayar", required = false) BigDecimal nominalTerbayar,
                                            @RequestParam(name = "saldoAkhirLebihBayar", required = false) BigDecimal saldoAkhirLebihBayar,
                                            @RequestParam(name = "idStatusBayarUpdate", required = false) Long idStatusBayarUpdate,
                                            @RequestParam(name = "namaStatusBayarUpdate", required = false) String namaStatusBayarUpdate,
                                            @RequestParam(name = "tglHentiBayarUpdate", required = false) Date tglHentiBayarUpdate,
                                            @RequestParam(name = "idKategoriCatatan", required = false) Long idKategoriCatatan,
                                            @RequestParam(name = "namaKategoriCatatan", required = false) String namaKategoriCatatan,
                                            @RequestParam(name = "Keterangan", required = false) String keterangan,
                                            @RequestParam(name = "idValidasi", required = false) Long idValidasi,
                                            @RequestParam(name = "namaValidasi", required = false) String namaValidasi) throws ParseException {

        SecurityContext context = SecurityContextHolder.getContext();
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        String compName_ = DkppUserStamp.getCompName();
        String userName_ = user.getUsername();

        Agama agamaUpdate_ = agamaDao.findById(idAgamaUpdate);
        Provinsi provinsiUpdate_ = provinsiDao.findById(idProvinsiUpdate);
        Kota kotaUpdate_ = kotaDao.findById(idKotaKabUpdate);
        Kecamatan kecamatanUpdate_ = kecamatanDao.findById(idKecamatanUpdate);
        Kelurahan kelurahanUpdate_ = kelurahanDao.findById(idKelurahanUpdate);
        MPensiun pensiun_ = pensiunDao.findByNip(nip);
        Negara negaraUpdate_ = negaraDao.findById(idNegaraUpdate);

        Map uIt = mutasiPensiunDao.processMutasiMpMeninggalDunia(role.getId(),compName_,userName_,idMutasi,kodeMutasi,periodeMutasi, tglMutasi, nip, namaPesertaUpdate,
                idAgamaUpdate, agamaUpdate_.getNamaAgama(),idGolonganUpdate,namaGolonganUpdate,phdp,idKantorBayarUpdate, namaKantorBayarUpdate, tglSpBiUpdate, noSpBiUpdate,
                tglSkBiUpdate, noSkBiUpdate, alamatisDalamNegeriUpdate, idProvinsiUpdate, provinsiUpdate_.getNamaProvinsi(), idKotaKabUpdate, kotaUpdate_.getNamaKota(), idKecamatanUpdate,
                kecamatanUpdate_.getNamaKecamatan(), idKelurahanUpdate, kelurahanUpdate_.getNamaKelurahan(), kodePosUpdate, alamatLengkapUpdate, pensiun_.getNoHp(), pensiun_.getNoTelp(), pensiun_.getEmail(), rtUpdate,
                rwUpdate, idNegaraUpdate, negaraUpdate_.getNamaNegara(), idPenerimaMpLama, namaPenerimaMpLamaUpdate, idKategoriPenerimaMpLama, tglWftPenerimaMpLama,
                tglInfWftPenerimaMpLama, idPenerimaMpBaru, namaPenerimaMpBaru, idKategoriPenerimaMpBaru, namaKategoriPenerimaMpBaru, jkPenerimaMpBaru, tglLahirPenerimaMpBaru,
                idKawinPenerimaMpBaru, namaKawinPenerimaMpBaru, idSuskelBaru, namaSuskelBaru, tglBulan13, lebihBayarNominal, lebihBayarJmlBulan, lebihBayarNominal13,
                lebihBayarJmlBulan13, nominalTerbayar, saldoAkhirLebihBayar, idStatusBayarUpdate, namaStatusBayarUpdate, tglHentiBayarUpdate, idKategoriCatatan, namaKategoriCatatan,
                keterangan, idValidasi, namaValidasi);

        ResponseUtil response =  null;

        if (uIt.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            response = new ResponseUtil(true, "Data berhasil disimpan");
        }else {
            response = new ResponseUtil(false, "Data tidak berhasil disimpan");
        }

        return new ResponseEntity<ResponseUtil>(response, HttpStatus.OK);

    }

    @GetMapping("/report-pensiun-lama")
    public void reportMeninggal(HttpServletResponse httpServletResponse,@RequestParam("tipeReport") String tipeReport, @RequestParam("nip") String nip, @RequestParam("periodeMutasi") String periodeMutasi, @RequestParam("idKategoriMutasi") String idKategorimutasi, @RequestParam("idKategoriPenerimaMpBaru") String idKategoriPenerimaMpBaru, @RequestParam("idKategoriPenerimaMp") String idKategoriPenerimaMp, @RequestParam("idMutasiPensiun") String idMutasiPensiun, @RequestParam(name = "download", required = false) Boolean download){
        String jasperFileName = null;
        String subReport = null;
        HashMap<String,Object> parameters = null;

        try {
            System.out.println("Nilai nip: " + nip);
            switch (tipeReport) {
                case "formulir_entry_mutasi":

                        jasperFileName = "Entry_Mutasi_PensiunPenerimaSelanjutnya";
                        parameters = new HashMap<>();
                        parameters.put("nip", nip);
                        parameters.put("periode_mutasi", periodeMutasi);
                        parameters.put("id_kategori_mutasi", idKategorimutasi);
                        break;


                case "catatan_perhitungan_manfaat_pensiun" :

                    switch(idKategorimutasi) {
                        case "04" :
                            switch(idKategoriPenerimaMp) {
                                case "1" :
                                jasperFileName = "PerhitunganMP_pensiunAnak_pesertaMeninggal";
                                subReport = "keluarga_pensiunMI";
                                parameters = new HashMap<>();
                                parameters.put("nip", nip);
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_mutasi", idKategorimutasi);
                                break;

                                case "2" :
                                jasperFileName = "PerhitunganMP_pensiunAnak_penerimaMeninggal";
                                subReport = "keluarga_pensiunMI";
                                parameters = new HashMap<>();
                                parameters.put("nip", nip);
                                parameters.put("periode_mutasi", periodeMutasi);
                                parameters.put("id_kategori_mutasi", idKategorimutasi);
                                break;
                            }
                            break;
                        case "03" :
                            jasperFileName = "PerhitunganMP_pensiunDudaJanda_pesertaMeninggal";
                            subReport = "keluarga_pensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("periode_mutasi", periodeMutasi);
                            parameters.put("id_kategori_mutasi", idKategorimutasi);
                            parameters.put("id_mutasi_pensiun", idMutasiPensiun);
                            break;
                        }
                    break;

                    case "surat_pemberitahuan" :
                    switch (idKategoriPenerimaMpBaru) {
                        case "2":
                            jasperFileName = "SuratPemberitahuanHakAtasManfaatPensiunJandaDuda";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_penerima_mp", idKategoriPenerimaMpBaru);
                            break;
                        case "11":
                            jasperFileName = "SuratPembayaranMPS100persen";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            break;
                        default:
                            jasperFileName = "SuratPemberitahuanHakAtasManfaatPensiunAnak";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_penerima_mp", idKategoriPenerimaMpBaru);
                            break;
                    }
                    break;

                case "surat_pengantar_mp" :
                    switch (idKategoriPenerimaMpBaru){
                        case "2" :
                            jasperFileName = "SuratPengantarHakAtasManfaatPensiunJandaDuda";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_penerima_mp", idKategoriPenerimaMpBaru);
                            break;
                        case "11" :
                            jasperFileName = "SuratPembayaranMPS100persen";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            break;
                            default:
                                jasperFileName = "SuratPengantarHakAtasManfaatPensiunAnak";
                                parameters = new HashMap<>();
                                parameters.put("nip", nip);
                                parameters.put("id_kategori_penerima_mp", idKategoriPenerimaMpBaru);
                                break;
                    }
                    break;

                case "surat_perubahan_domisili_penerima_mp" :
                    jasperFileName = "SuratPermohonanPerubahanDomisili";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    parameters.put("id_kategori_mutasi", idKategorimutasi);
                    break;

                case "sk" :
                    switch (idKategoriPenerimaMpBaru) {
                        case "2":
                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_LAMA_DUDA_JANDA";
                            subReport = "susunan_keluarga_pensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_mutasi", idKategorimutasi);
                            parameters.put("id_mutasi_pensiun", idMutasiPensiun);
                            break;

                        case "20":
                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN_LAMA_DUDA_JANDA";
                            subReport = "susunan_keluarga_pensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_mutasi", idKategorimutasi);
                            parameters.put("id_mutasi_pensiun", idMutasiPensiun);
                            break;

                        case "11" :
                            jasperFileName = "SK_MPS_100persen";
                            subReport = "susunan_keluarga_pensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("nip", nip);
                            parameters.put("id_kategori_pensiun", "PM");
                            parameters.put("id_jenis_mps", "3");
                            parameters.put("id_kategori_mutasi", idKategorimutasi);
                            break;

                        default :
                            jasperFileName = "Keputusan_HakAtasManfaat_PENSIUN__LAMA_ANAK";
                            subReport = "susunan_keluarga_pensiunLama";
                            parameters = new HashMap<>();
                            parameters.put("NIP", nip);
                            parameters.put("id_kategori_mutasi", idKategorimutasi);
                            parameters.put("id_mutasi_pensiun", idMutasiPensiun);
                            break;
                    }
                    break;

                case "kartu" :
                    jasperFileName = "KartuPensiunLama";
                    parameters = new HashMap<>();
                    parameters.put("nip", nip);
                    parameters.put("id_kategori_mutasi", idKategorimutasi);
                    break;

            }
            if (jasperFileName != null) {
                createReport(httpServletResponse, nip, download, parameters, jasperFileName, subReport);
            }
        } catch (IOException | JRException e1) {
            e1.printStackTrace();
        }
    }

    private void createReport(HttpServletResponse httpServletResponse, String nip, Boolean download, Map<String, Object> parameters, String jasperFileName, String subReport) throws JRException, IOException {
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

    @GetMapping("/validasi-semua")
    public ResponseUtil prosesValidasiSemua(){
        Iterable<PensiunLamaMeninggalView> itView = pensLamaMeninggalViewDao.findAllByBelumValidasi();
        itView.forEach(mView->{
            System.out.println(mView.getIdMutasiPensiun());
            DkppUserDetail user = DkppUserStamp.getUserPrincipal();
            RoleDto role = user.getUser().getRoles().get(0);
            MutasiMeninggalSPFormDto spFormDto = mView.toSpProses();
            spFormDto.setRoleId(role.getId());
            spFormDto.setUserName(user.getUsername());
            spFormDto.setCompName(DkppUserStamp.getCompName());
            spFormDto.setParIdValidasi(Long.valueOf(2));
            spFormDto.setParNamaValidasi(String.valueOf("Sudah Validasi"));
            mutasiPensiunDao.processMutasiPenerimaMpMeninggal(spFormDto);
        });
        return new ResponseUtil(true,"success");
    }


}
