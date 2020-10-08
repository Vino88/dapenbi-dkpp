package com.dapenbi.dkpp.controller;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MPensiunDao;
import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.dto.component.BreadcrumbHolderComponentDto;
import com.dapenbi.dkpp.model.MPensiun;
import com.dapenbi.dkpp.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathPrefix.MASTER_DATA + PathPrefix.MPENSIUN)
public class MPensiunController extends MasterDataController{

    private MPensiunDao mPensiunDao;
    private ServletContext servletContext;

    @Autowired
    public MPensiunController(MPensiunDao mPensiunDao, ServletContext servletContext){
        this.mPensiunDao = mPensiunDao;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String index(Map<String,Object> model){

        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.MASTER_DATA, "Master Data"));
        breadcrumb.add(new BreadcrumbHolderComponentDto(servletContext.getContextPath() + PathPrefix.MASTER_DATA + PathPrefix.MPENSIUN, "Master MPensiun"));

        model.put("breadcrumb", breadcrumb);

        return "masterData/mpensiun";
    }

    @GetMapping("/detail/{nip}")
    public String detail(@PathVariable ("nip") String nip, Map<String, Object> model){
        MPensiun mPensiun = mPensiunDao.findByNip(nip);
        MPensiunDto mPensiunDto = mPensiun.toDto();
        model.put("nip", mPensiunDto.getNip());
        model.put("namaPeserta", mPensiunDto.getNamaPeserta());
        model.put("jenisKelaminPeserta", mPensiunDto.getJenisKelaminPeserta());
        model.put("tglLahirPeserta", mPensiunDto.getTglLahirPeserta());
        model.put("tglKerjaPeserta", mPensiunDto.getTglKerjaPeserta());
        model.put("tglDhptPeserta", mPensiunDto.getTglDhptPeserta());
        model.put("tglHentiKerjaPeserta", mPensiunDto.getTglHentiKerjaPeserta());
        model.put("tempatMeninggalPeserta",mPensiunDto.getTempatMeninggalPeserta());
        model.put("tglMeninggalPeserta", mPensiunDto.getTglMeninggalPeserta());
        model.put("tempatLahirPeserta", mPensiunDto.getTempatLahirPeserta());
//        model.put("idGolongan", mPensiun.getGolongan().getId());
        model.put("golonganPangkat", mPensiunDto.getGolonganPangkat());
//        model.put("idAgama", mPensiun.getAgama().getId());
        model.put("namaAgama", mPensiunDto.getNamaAgama());
//        model.put("idKantorBayar", mPensiun.getKantorBayar().getId());
        model.put("namaKantorBayar", mPensiunDto.getNamaKantorBayar());
//        model.put("idPredikatPemberhentian", mPensiun.getPredikatPemberhentian().getId());
        model.put("namaPredikat", mPensiunDto.getNamaPredikat());
//        model.put("idAlasanHenti", mPensiun.getAlasanHenti().getId());
        model.put("keteranganHenti", mPensiunDto.getKeteranganHenti());
        model.put("tglSpBi", mPensiunDto.getTglSpBi()==null?"":mPensiunDto.getTglSpBi());
        model.put("noSpBi", mPensiunDto.getNoSpBi());
        model.put("tglSkBi", mPensiunDto.getTglSkBi()==null?"":mPensiunDto.getTglSkBi());
        model.put("noSkBi", mPensiunDto.getNoSkBi());
        model.put("phdp", mPensiunDto.getPhdp());
        model.put("upahVeteran", mPensiunDto.getUpahVeteran());
//        model.put("idJenisMps", mPensiun.getJenisMps().getId());
        model.put("namaMps", mPensiunDto.getNamaMps());
//        model.put("idKategoriPensiun", mPensiun.getKategoriPensiun().getId());
        model.put("namaKategoriPensiun", mPensiunDto.getNamaKategoriPensiun());
//        model.put("idUsiaBayar", mPensiun.getUsiaBayar().getId());
        model.put("namaUsiaBayar", mPensiunDto.getNamaUsiaBayar());
//        model.put("idStatusBayar", mPensiun.getStatusBayar().getId());
        model.put("statusBayar",mPensiunDto.getStatusBayar());
        model.put("tglTundaJatuhTempo", mPensiunDto.getTglTundaJatuhTempo()==null?"":mPensiunDto.getTglTundaJatuhTempo());
        model.put("tglAwalBayar", mPensiunDto.getTglAwalBayar());
        model.put("tglMpBulananKe13", mPensiunDto.getTglMpBulananKe13());
        model.put("tglHentiBayar", mPensiun.getTglHentiBayar());
        model.put("idPenerimaMP", mPensiun.getIdPenerimaMP());
        model.put("namaPenerimaMp", mPensiunDto.getNamaPenerimaMp());
        model.put("tglLahirPenerimaMp", mPensiunDto.getTglLahirPenerimaMp()==null?"":mPensiunDto.getTglLahirPenerimaMp());
        model.put("jenisKelaminPenerimaMp", mPensiunDto.getJenisKelaminPenerimaMp());
//        model.put("idKategoriPenerima", mPensiun.getKategoriPenerima().getId());
        model.put("namaKategoriPenerimaMp", mPensiunDto.getNamaKategoriPenerimaMp());
        model.put("tglSkDapenbi", mPensiunDto.getTglSkDapenbi()==null?"":mPensiunDto.getTglSkDapenbi());
        model.put("noSkDapenbi", mPensiun.getNoSkDapenbi());
        model.put("alamatIsDalamNegeri", mPensiunDto.isAlamatIsDalamNegeri());
//        model.put("idProvinsi", mPensiun.getProvinsi().getId());
        model.put("namaProvinsi", mPensiunDto.getNamaProvinsi());
//        model.put("idKota", mPensiun.getKota().getId());
        model.put("namaKota", mPensiunDto.getNamaKota());
//        model.put("idKecamatan", mPensiun.getKecamatan().getId());
        model.put("namaKecamatan", mPensiunDto.getNamaKota());
//        model.put("idKelurahan", mPensiun.getKelurahan().getId());
        model.put("namaKelurahan", mPensiunDto.getNamaKelurahan());
        model.put("kodePos", mPensiunDto.getKodePos());
        model.put("alamatLengkap", mPensiunDto.getAlamatLengkap());
        model.put("rt", mPensiunDto.getRt());
        model.put("rw", mPensiunDto.getRw());
//        model.put("idNegara", mPensiun.getNegara().getId());
        model.put("namaNegara", mPensiunDto.getNamaNegara());
        model.put("usiaSaatHenti", mPensiunDto.getUsiaSaatHenti());
        model.put("usiaSaatHentiBulat", mPensiunDto.getUsiaSaatHentiBulat());
        model.put("usiaPenerimaBayar", mPensiunDto.getUsiaPenerimaBayar());
        model.put("usiaPenerimaBayarBulat", mPensiunDto.getUsiaPenerimaBayarBulat());
        model.put("masaKerjaTambahan", mPensiunDto.getMasaKerjaTambahan());
        model.put("masaKerjaTambahanBulat", mPensiunDto.getMasaKerjaTambahanBulat());
        model.put("masaKerjaVeteran", mPensiunDto.getMasaKerjaVeteran());
        model.put("masaKerjaVeteranBulat", mPensiunDto.getMasaKerjaVeteranBulat());
        model.put("totalMasaKerja", mPensiunDto.getTotalMasaKerja());
        model.put("totalMasaKerjaBulat", mPensiunDto.getTotalMasaKerjaBulat());
        model.put("masaKerjaMp", mPensiunDto.getMasaKerjaMp());
//        model.put("idFaktorFPR", StringUtil.isNullOrEmpty(mPensiun.getFaktorFPR()) ? null : mPensiun.getFaktorFPR().getId());
        model.put("namaFaktorFpr", mPensiunDto.getNamaFaktorFpr());
        model.put("nilaiFpr", mPensiunDto.getNilaiFpr());
//        model.put("idFaktorFs", StringUtil.isNullOrEmpty(mPensiun.getFaktorFs()) ? null :mPensiun.getFaktorFs().getId());
        model.put("namaFaktorFs", mPensiunDto.getNamaFaktorFs());
        model.put("nilaiFs", mPensiunDto.getNilaiFs());
        model.put("mps20persen", mPensiunDto.getMps20persen());
        model.put("mps10juta", mPensiunDto.getMps10juta());
        model.put("mps100persen", mPensiunDto.getMps100persen());
        model.put("mpPerbulanRumus", mPensiunDto.getMpPerbulanRumus());
        model.put("mpPerbulan20persen",mPensiunDto.getMpPerbulan20persen());
        model.put("mpPerbulan10juta",mPensiunDto.getMpPerbulan10juta());
        model.put("mpyd",mPensiunDto.getMpyd());
        model.put("mpBulan13", mPensiunDto.getMpBulan13());
        model.put("totalMasaKerjaAdj", mPensiunDto.getTotalMasaKerjaAdj());
        model.put("totalMasaKerjaAdjBulat", mPensiunDto.getTotalMasaKerjaAdjBulat());
//        model.put("idSuskel", mPensiun.getSuskel().getId());
        model.put("namaSuskel",mPensiunDto.getNamaSuskel());
//        model.put("idStatusKawin", mPensiun.getStatusKawin().getId());
        model.put("namaStatusKawinPenerimaMp",mPensiunDto.getNamaStatusKawinPenerimaMp());
        model.put("noHp", mPensiunDto.getNoHp());
        model.put("email",mPensiunDto.getEmail());
        model.put("keteranganOtomatis", mPensiunDto.getKeteranganOtomatis());
        model.put("masaKerjaHenti", mPensiunDto.getMasaKerjaHenti());
        model.put("masaKerjaHentiBulat", mPensiunDto.getMasaKerjaHentiBulat());
        model.put("refIdMutasi", mPensiunDto.getRefIdMutasi());
        model.put("tglUsia25tPenerimaMp", mPensiunDto.getTglUsia25tPenerimaMp());
        model.put("mps100persenBulat", mPensiunDto.getMps100persenBulat());
        model.put("faktorFs",mPensiunDto.getFaktorFs());
        model.put("noTelp", mPensiunDto.getNoTelp());
        model.put("isActive", mPensiunDto.isActive());

        List<BreadcrumbHolderComponentDto> breadcrumb = new ArrayList<>();
        breadcrumb.add(new BreadcrumbHolderComponentDto("/dkpp/master-data", "Master Data"));
        breadcrumb.add(new BreadcrumbHolderComponentDto("/dkpp/master-data/mpensiun", "Master Pensiun"));
        breadcrumb.add(new BreadcrumbHolderComponentDto("/dkpp/master-data/mpensiun/{nip}/detail", "Master Pensiun Detail"));

        model.put("breadcrumb", breadcrumb);

        return "masterData/detailmpensiun";
    }
}
