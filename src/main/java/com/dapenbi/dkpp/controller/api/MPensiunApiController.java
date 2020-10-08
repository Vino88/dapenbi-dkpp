package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dao.MPensiunDao;
import com.dapenbi.dkpp.dto.GolonganDto;
import com.dapenbi.dkpp.dto.JenisMpsDto;
import com.dapenbi.dkpp.dto.MPensiunDto;
import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.form.MPensiunFormDto;
import com.dapenbi.dkpp.model.JenisMps;
import com.dapenbi.dkpp.model.MPensiun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MPENSIUN)
public class MPensiunApiController extends DropdownApiController{

    @Autowired
    MPensiunDao mPensiunDao;

    public MPensiunApiController(MPensiunDao mPensiunDao) {
        super(mPensiunDao);
    }


    @GetMapping
    public Page<MPensiunDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<MPensiun> mIt = (Page<MPensiun>) mPensiunDao.findAll(new String[]{"nip","namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<MPensiunDto> mPensiunDto = mIt.map(m ->{
            MPensiunDto dto = m.toDto();
            if(m.getKantorBayar() != null) dto.setKantorBayar(m.getKantorBayar().toDto());
            if (m.getAgama() != null) dto.setIdAgama(m.getAgama().toDto());


            return dto;
        });

        return mPensiunDto;
    }

    @GetMapping("/{nip}")
    public MPensiunDto findPensiunByNip(@PathVariable("nip") String nip) {
        MPensiun mPensiun = mPensiunDao.findByNip(nip);
        MPensiunDto mPensiunDto = mPensiun.toDto();
        if (mPensiun.getAgama() != null) {mPensiunDto.setIdAgama(mPensiun.getAgama().toDto());}
        if (mPensiun.getKantorBayar() != null) {mPensiunDto.setKantorBayar(mPensiun.getKantorBayar().toDto());}
        if (mPensiun.getKategoriPenerima() != null) {mPensiunDto.setKategoriPenerima(mPensiun.getKategoriPenerima().toDto());}
        if (mPensiun.getKategoriPensiun() != null) {mPensiunDto.setKategoriPensiun(mPensiun.getKategoriPensiun().toDto());}
        if (mPensiun.getJenisMps() != null) {mPensiunDto.setJenisMps(mPensiun.getJenisMps().toDto());}
        if (mPensiun.getGolongan() != null) {mPensiunDto.setGolongan(mPensiun.getGolongan().toDto());}
        if (mPensiun.getKecamatan() != null) {mPensiunDto.setKecamatan(mPensiun.getKecamatan().toDto());}
        if (mPensiun.getKelurahan() != null) {mPensiunDto.setKelurahan(mPensiun.getKelurahan().toDto());}
        if (mPensiun.getNegara() != null) {mPensiunDto.setNegara(mPensiun.getNegara().toDto());}
        if (mPensiun.getPredikatPemberhentian() != null) {mPensiunDto.setPredikatPemberhentian(mPensiun.getPredikatPemberhentian().toDto());}
        if (mPensiun.getUsiaBayar() != null) {mPensiunDto.setUsiaBayar(mPensiun.getUsiaBayar().toDto());}
        if (mPensiun.getStatusBayar() != null) {mPensiunDto.setStatusBayar(mPensiun.getStatusBayar().toDto());}
        if (mPensiun.getProvinsi() != null) {mPensiunDto.setProvinsi(mPensiun.getProvinsi().toDto());}
        if (mPensiun.getStatusKawin() != null) {mPensiunDto.setStatusKawin(mPensiun.getStatusKawin().toDto());}
        if (mPensiun.getAlasanHenti() != null) {mPensiunDto.setAlasanHenti(mPensiun.getAlasanHenti().toDto());}
        if (mPensiun.getFaktorFPR() != null) {mPensiunDto.setFaktorFPR(mPensiun.getFaktorFPR().toDto());}

        return mPensiunDto;
    }

    @GetMapping(PathPrefix.DATA+PathPrefix.MPENSIUN)
    public List<Select2Default> listPeserta(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q ) {
        Iterable<MPensiun> it = mPensiunDao.findAll(new String[] {"nip", "namaPenerima"}, "%" + q + "%", pageable);
        if(q == null){
            it = mPensiunDao.findAll();
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            MPensiunDto mPensiunDto = k.toDto();
            if (k.getAgama() != null) { mPensiunDto.setIdAgama(k.getAgama().toDto()); }
            if (k.getKategoriPenerima() != null ){ mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto()); }
            if (k.getKantorBayar() != null){mPensiunDto.setKantorBayar(k.getKantorBayar().toDto());}
            if (k.getGolongan() != null){mPensiunDto.setGolongan(k.getGolongan().toDto());}
            if (k.getPredikatPemberhentian() != null){mPensiunDto.setPredikatPemberhentian(k.getPredikatPemberhentian().toDto());}
            if (k.getAlasanHenti() != null){mPensiunDto.setAlasanHenti(k.getAlasanHenti().toDto());}
            if (k.getJenisMps()!=null){mPensiunDto.setJenisMps(k.getJenisMps().toDto());}
            if (k.getKategoriPensiun()!=null){mPensiunDto.setKategoriPensiun(k.getKategoriPensiun().toDto());}
            if (k.getUsiaBayar()!=null){mPensiunDto.setUsiaBayar(k.getUsiaBayar().toDto());}
            if (k.getStatusBayar()!=null){mPensiunDto.setStatusBayar(k.getStatusBayar().toDto());}
            if (k.getKategoriPenerima()!=null){mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto());}
            if (k.getProvinsi()!=null){mPensiunDto.setProvinsi(k.getProvinsi().toDto());}
            if (k.getKota()!=null){mPensiunDto.setKota(k.getKota().toDto());}
            if (k.getKecamatan()!=null){mPensiunDto.setKecamatan(k.getKecamatan().toDto());}
            if (k.getKelurahan()!=null){mPensiunDto.setKelurahan(k.getKelurahan().toDto());}
            if (k.getNegara()!=null){mPensiunDto.setNegara(k.getNegara().toDto());}
            if (k.getFaktorFPR()!=null){mPensiunDto.setFaktorFPR(k.getFaktorFPR().toDto());}
//            if (k.getFaktorFs()!=null){mPensiunDto.setFaktorFs(k.getFaktorFs().toDto);}
            if (k.getStatusKawin()!=null){mPensiunDto.setStatusKawin(k.getStatusKawin().toDto());}
            if (k.getSuskel()!=null){mPensiunDto.setSuskel(k.getSuskel().toDto());}
            listSelect2.add(new Select2Default(String.valueOf(k.getNip()), k.getNip() + "-" + k.getNamaPeserta(), mPensiunDto));
        });
        return listSelect2;
    }

    @GetMapping(PathPrefix.DATA+PathPrefix.MPENSIUN+"/janda-duda")
    public List<Select2Default> listPenerimaJandaDuda(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q ) {
        Iterable<MPensiun> it = mPensiunDao.findAllPensiunByKategoriPenerimaIsJandaDuda( "%" + q + "%", pageable);
        if (q == null){
            it = mPensiunDao.findAllPensiunByKategoriPenerimaIsJandaDuda("%%", pageable);
        }
        return iterableToSelect2(it);
    }


    @GetMapping(PathPrefix.DATA+PathPrefix.MPENSIUN+"/penerima")
    public List<Select2Default> listPenerima(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q ) {
        Iterable<MPensiun> it = mPensiunDao.findAllPensiunByKategoriPenerimaIsJandaDuda( "%" + q + "%", pageable);
        if (q == null){
            it = mPensiunDao.findAllPensiunByKategoriPenerimaIsJandaDuda("%%", pageable);
        }
        return iterableToSelect2(it);
    }

//    @GetMapping("/detail")
//    public MPensiunDto detail(@ModelAttribute MPensiunFormDto mPensiunFormDto){
//        MPensiun mPensiun = mPensiunDao.findByNip(mPensiunFormDto.getNip());
//        mPensiun.setNip(mPensiunFormDto.getNip());
//        mPensiun.setNamaPeserta(mPensiunFormDto.getNamaPeserta());
//        mPensiun.setJenisKelaminPeserta(mPensiunFormDto.getJenisKelaminPeserta());
//
//
//
//        return mPensiunDao.save(mPensiun).toDto();
//
//    }


    @GetMapping(PathPrefix.DATA + "/status-bayar-1")
    public List<Select2Default> listPesertaByStatus(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q) {
        Iterable<MPensiun> it = mPensiunDao.findAllPensiunStatusBayar1("%"+q+"%", pageable);
        if(q == null){
            it = mPensiunDao.findAllPensiunStatusBayarSamaDengan1(pageable);
        }
        List<Select2Default> listSelect2StatusBayar = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            MPensiunDto mPensiunDto = k.toDto();
            if (k.getAgama() != null) { mPensiunDto.setIdAgama(k.getAgama().toDto()); }
            if (k.getKategoriPenerima() != null ){ mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto()); }
            if (k.getKantorBayar() != null){mPensiunDto.setKantorBayar(k.getKantorBayar().toDto());}
            if (k.getGolongan() != null){mPensiunDto.setGolongan(k.getGolongan().toDto());}
            if (k.getPredikatPemberhentian() != null){mPensiunDto.setPredikatPemberhentian(k.getPredikatPemberhentian().toDto());}
            if (k.getAlasanHenti() != null){mPensiunDto.setAlasanHenti(k.getAlasanHenti().toDto());}
            if (k.getJenisMps()!=null){mPensiunDto.setJenisMps(k.getJenisMps().toDto());}
            if (k.getKategoriPensiun()!=null){mPensiunDto.setKategoriPensiun(k.getKategoriPensiun().toDto());}
            if (k.getUsiaBayar()!=null){mPensiunDto.setUsiaBayar(k.getUsiaBayar().toDto());}
            if (k.getStatusBayar()!=null){mPensiunDto.setStatusBayar(k.getStatusBayar().toDto());}
            if (k.getKategoriPenerima()!=null){mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto());}
            if (k.getProvinsi()!=null){mPensiunDto.setProvinsi(k.getProvinsi().toDto());}
            if (k.getKota()!=null){mPensiunDto.setKota(k.getKota().toDto());}
            if (k.getKecamatan()!=null){mPensiunDto.setKecamatan(k.getKecamatan().toDto());}
            if (k.getKelurahan()!=null){mPensiunDto.setKelurahan(k.getKelurahan().toDto());}
            if (k.getNegara()!=null){mPensiunDto.setNegara(k.getNegara().toDto());}
            if (k.getFaktorFPR()!=null){mPensiunDto.setFaktorFPR(k.getFaktorFPR().toDto());}
            if (k.getStatusKawin()!=null){mPensiunDto.setStatusKawin(k.getStatusKawin().toDto());}
            if (k.getSuskel()!=null){mPensiunDto.setSuskel(k.getSuskel().toDto());}
            listSelect2StatusBayar.add(new Select2Default(String.valueOf(k.getNip()), k.getNip() + "-" + k.getNamaPeserta(), mPensiunDto));
        });
        return listSelect2StatusBayar;
    }

    @GetMapping(PathPrefix.DATA+PathPrefix.MPENSIUN+"/jenis-mps")
    public List<Select2Default> listPesertaByJenisMps(Pageable pageable, @RequestParam(name = "searchParam", required = false) String q) {
        Iterable<MPensiun> it = mPensiunDao.findAllByJenisMps("3", "%" + q + "%", pageable);
        if (q == null) {
            it = mPensiunDao.findAllByJenisMps("3", "", pageable);
        }
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            MPensiunDto mPensiunDto = k.toDto();
            if (k.getAgama() != null) { mPensiunDto.setIdAgama(k.getAgama().toDto()); }
            if (k.getKategoriPenerima() != null ){ mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto()); }
            if (k.getKantorBayar() != null){mPensiunDto.setKantorBayar(k.getKantorBayar().toDto());}
            if (k.getGolongan() != null){mPensiunDto.setGolongan(k.getGolongan().toDto());}
            if (k.getPredikatPemberhentian() != null){mPensiunDto.setPredikatPemberhentian(k.getPredikatPemberhentian().toDto());}
            if (k.getAlasanHenti() != null){mPensiunDto.setAlasanHenti(k.getAlasanHenti().toDto());}
            if (k.getJenisMps()!=null){mPensiunDto.setJenisMps(k.getJenisMps().toDto());}
            if (k.getKategoriPensiun()!=null){mPensiunDto.setKategoriPensiun(k.getKategoriPensiun().toDto());}
            if (k.getUsiaBayar()!=null){mPensiunDto.setUsiaBayar(k.getUsiaBayar().toDto());}
            if (k.getStatusBayar()!=null){mPensiunDto.setStatusBayar(k.getStatusBayar().toDto());}
            if (k.getKategoriPenerima()!=null){mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto());}
            if (k.getProvinsi()!=null){mPensiunDto.setProvinsi(k.getProvinsi().toDto());}
            if (k.getKota()!=null){mPensiunDto.setKota(k.getKota().toDto());}
            if (k.getKecamatan()!=null){mPensiunDto.setKecamatan(k.getKecamatan().toDto());}
//            if (k.getKelurahan()!=null){mPensiunDto.setKelurahan(k.getKelurahan().toDto());}
//            if (k.getNegara()!=null){mPensiunDto.setNegara(k.getNegara().toDto());}
//            if (k.getFaktorFPR()!=null){mPensiunDto.setFaktorFPR(k.getFaktorFPR().toDto());}
//            if (k.getFaktorFs()!=null){mPensiunDto.setFaktorFs(k.getFaktorFs().toDto);}
            if (k.getStatusKawin()!=null){mPensiunDto.setStatusKawin(k.getStatusKawin().toDto());}
//            if (k.getSuskel()!=null){mPensiunDto.setSuskel(k.getSuskel().toDto());}
            listSelect2.add(new Select2Default(String.valueOf(k.getNip()), k.getNip() + "-" + k.getNamaPeserta(), mPensiunDto));
        });
        return listSelect2;
    }

    private List<Select2Default> iterableToSelect2(Iterable<MPensiun> it){
        List<Select2Default> listSelect2 = new ArrayList<Select2Default>();
        it.forEach((k) -> {
            MPensiunDto mPensiunDto = k.toDto();
            if (k.getAgama() != null) { mPensiunDto.setIdAgama(k.getAgama().toDto()); }
            if (k.getKategoriPenerima() != null ){ mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto()); }
            if (k.getKantorBayar() != null){mPensiunDto.setKantorBayar(k.getKantorBayar().toDto());}
            if (k.getGolongan() != null){mPensiunDto.setGolongan(k.getGolongan().toDto());}
            if (k.getPredikatPemberhentian() != null){mPensiunDto.setPredikatPemberhentian(k.getPredikatPemberhentian().toDto());}
            if (k.getAlasanHenti() != null){mPensiunDto.setAlasanHenti(k.getAlasanHenti().toDto());}
            if (k.getJenisMps()!=null){mPensiunDto.setJenisMps(k.getJenisMps().toDto());}
            if (k.getKategoriPensiun()!=null){mPensiunDto.setKategoriPensiun(k.getKategoriPensiun().toDto());}
            if (k.getUsiaBayar()!=null){mPensiunDto.setUsiaBayar(k.getUsiaBayar().toDto());}
            if (k.getStatusBayar()!=null){mPensiunDto.setStatusBayar(k.getStatusBayar().toDto());}
            if (k.getKategoriPenerima()!=null){mPensiunDto.setKategoriPenerima(k.getKategoriPenerima().toDto());}
            if (k.getProvinsi()!=null){mPensiunDto.setProvinsi(k.getProvinsi().toDto());}
            if (k.getKota()!=null){mPensiunDto.setKota(k.getKota().toDto());}
            if (k.getKecamatan()!=null){mPensiunDto.setKecamatan(k.getKecamatan().toDto());}
            if (k.getKelurahan()!=null){mPensiunDto.setKelurahan(k.getKelurahan().toDto());}
            if (k.getNegara()!=null){mPensiunDto.setNegara(k.getNegara().toDto());}
            if (k.getFaktorFPR()!=null){mPensiunDto.setFaktorFPR(k.getFaktorFPR().toDto());}
//            if (k.getFaktorFs()!=null){mPensiunDto.setFaktorFs(k.getFaktorFs().toDto);}
            if (k.getStatusKawin()!=null){mPensiunDto.setStatusKawin(k.getStatusKawin().toDto());}
            if (k.getSuskel()!=null){mPensiunDto.setSuskel(k.getSuskel().toDto());}
            listSelect2.add(new Select2Default(String.valueOf(k.getNip()), k.getNip() + "-" + k.getNamaPeserta(), mPensiunDto));
        });
        return listSelect2;
    }
}
