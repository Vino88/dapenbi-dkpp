package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.RekeningPenerimaMpDto;
import com.dapenbi.dkpp.form.RekeningPenerimaMpFormDto;
import com.dapenbi.dkpp.model.RekeningPenerimaMp;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.REKENING_PENERIMA_MP)
public class RekeningPenerimaMpApiController {
    @Autowired
    RekeningPenerimaMpDao rekeningPenerimaMpDao;

    @Autowired
    BankDao bankDao;

    @Autowired
    KategoriPenerimaDao kategoriPenerimaDao;


    @GetMapping
    public Page<RekeningPenerimaMpDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<RekeningPenerimaMp> aIt = (Page<RekeningPenerimaMp>) rekeningPenerimaMpDao.findAll(new String[] {"namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<RekeningPenerimaMpDto> rekeningPenerimaDto = aIt.map(u -> u.toDto());

        return rekeningPenerimaDto;
    }

    @PostMapping
    public ResponseEntity<MessageUtil> addRekeningPenerimaMp(@ModelAttribute RekeningPenerimaMpFormDto rekeningPenerimaMpFormDto){
        RekeningPenerimaMp rekeningPenerimaMp = new RekeningPenerimaMp();
        rekeningPenerimaMp.setNip( rekeningPenerimaMpFormDto.getNip() );
        rekeningPenerimaMp.setNamaPeserta( rekeningPenerimaMpFormDto.getNamaPeserta() );
        rekeningPenerimaMp.setPenerimaMP( rekeningPenerimaMpFormDto.getIdPenerimaMp() );
        rekeningPenerimaMp.setNamaPenerimaMp( rekeningPenerimaMpFormDto.getNamaPenerimaMp() );
        rekeningPenerimaMp.setKategoriPenerima( kategoriPenerimaDao.findById(rekeningPenerimaMpFormDto.getIdKategoriPenerima()) );
        rekeningPenerimaMp.setNamaKategoriPenerima( rekeningPenerimaMpFormDto.getNamaKategoriPenerima() );
        rekeningPenerimaMp.setBankNF( bankDao.findById(rekeningPenerimaMpFormDto.getIdBank()) );
        rekeningPenerimaMp.setJenisBank( rekeningPenerimaMpFormDto.getJenisBank() );
        rekeningPenerimaMp.setNamaCabangBank( rekeningPenerimaMpFormDto.getNamaCabangBank() );
        rekeningPenerimaMp.setNamaRekening( rekeningPenerimaMpFormDto.getNamaRekening() );
        rekeningPenerimaMp.setNomorRekening( rekeningPenerimaMpFormDto.getNomorRekening() );
        rekeningPenerimaMp.setActive(rekeningPenerimaMpFormDto.getActive() != null && rekeningPenerimaMpFormDto.getActive().size() > 0);
        rekeningPenerimaMp.setUserStamp(DkppUserStamp.postModeUserStamp());
        rekeningPenerimaMp.setActive(true);
        RekeningPenerimaMpDto dto = rekeningPenerimaMpDao.save(rekeningPenerimaMp).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageUtil> updateRekeningPenerimaMp(@ModelAttribute RekeningPenerimaMpFormDto rekeningPenerimaMpFormDto){
        RekeningPenerimaMp rekeningPenerimaMp= rekeningPenerimaMpDao.findByNip(rekeningPenerimaMpFormDto.getNip());
        rekeningPenerimaMp.setNip( rekeningPenerimaMpFormDto.getNip() );
        rekeningPenerimaMp.setNamaPeserta( rekeningPenerimaMpFormDto.getNamaPeserta() );
        rekeningPenerimaMp.setPenerimaMP( rekeningPenerimaMpFormDto.getIdPenerimaMp() );
        rekeningPenerimaMp.setNamaPenerimaMp( rekeningPenerimaMpFormDto.getNamaPenerimaMp() );
        rekeningPenerimaMp.setKategoriPenerima( kategoriPenerimaDao.findById(rekeningPenerimaMpFormDto.getIdKategoriPenerima()) );
        rekeningPenerimaMp.setNamaKategoriPenerima( rekeningPenerimaMpFormDto.getNamaKategoriPenerima() );
        rekeningPenerimaMp.setBankNF( bankDao.findById(rekeningPenerimaMpFormDto.getIdBank()) );
        rekeningPenerimaMp.setJenisBank( rekeningPenerimaMpFormDto.getJenisBank() );
        rekeningPenerimaMp.setNamaCabangBank( rekeningPenerimaMpFormDto.getNamaCabangBank() );
        rekeningPenerimaMp.setNamaRekening( rekeningPenerimaMpFormDto.getNamaRekening() );
        rekeningPenerimaMp.setNomorRekening( rekeningPenerimaMpFormDto.getNomorRekening() );
        rekeningPenerimaMp.setActive(rekeningPenerimaMpFormDto.getActive() != null && rekeningPenerimaMpFormDto.getActive().size() > 0);
        rekeningPenerimaMp.setUserStamp(DkppUserStamp.putModeUserStamp());

        RekeningPenerimaMpDto dto = rekeningPenerimaMpDao.save(rekeningPenerimaMp).toDto();
        MessageUtil messageUtil;
        if(dto != null){
            messageUtil = new MessageUtil("success", "Data berhasil disimpan");
        } else {
            messageUtil = new MessageUtil("failed", "Data gagal disimpan");
        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

}
