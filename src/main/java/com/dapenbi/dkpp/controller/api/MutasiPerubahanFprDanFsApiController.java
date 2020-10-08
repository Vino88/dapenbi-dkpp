package com.dapenbi.dkpp.controller.api;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.component.SpreadSheetMapping.AktuariaCellMapping;
import com.dapenbi.dkpp.component.SpreadSheetMapping.AktuariaFprCellMapping;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.*;
import com.dapenbi.dkpp.model.*;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import com.dapenbi.dkpp.util.ExcelReaderUtil;
import com.dapenbi.dkpp.util.MessageUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping(PathPrefix.API + PathPrefix.MUTASI_PERUBAHAN_FPR_FS)
public class MutasiPerubahanFprDanFsApiController {

    @Value("${file.upload-dir}")
    private String filePath;

    private TempAktuariaFsDao tempAktuariaFsDao;

    private UploadMutasiFprFsDao uploadMutasiFprFsDao;

    private AktuariaFsDao aktuariaFsDao;

    private AktuariaFprDao aktuariaFprDao;

    private TempAktuariaFprDao tempAktuariaFprDao;

    private FaktorFsDao faktorFsDao;

    private FaktorFPRDao faktorFPRDao;

    private String postModeUserStamp;

    private MutasiPerubahanFprFsDao mutasiPerubahanFprFsDao;

//    private Long idFaktorFs;

    @Autowired
    public MutasiPerubahanFprDanFsApiController(TempAktuariaFsDao tempAktuariaFsDao, UploadMutasiFprFsDao uploadMutasiFprFsDao, AktuariaFsDao aktuariaFsDao, FaktorFsDao faktorFsDao, FaktorFPRDao faktorFPRDao,TempAktuariaFprDao tempAktuariaFprDao, AktuariaFprDao aktuariaFprDao, MutasiPerubahanFprFsDao mutasiPerubahanFprFsDao){
        this.tempAktuariaFsDao = tempAktuariaFsDao;
        this.uploadMutasiFprFsDao = uploadMutasiFprFsDao;
        this.aktuariaFsDao = aktuariaFsDao;
        this.faktorFsDao = faktorFsDao;
        this.faktorFPRDao = faktorFPRDao;
        this.tempAktuariaFprDao = tempAktuariaFprDao;
        this.tempAktuariaFprDao = tempAktuariaFprDao;
        this.aktuariaFprDao = aktuariaFprDao;
        this.mutasiPerubahanFprFsDao = mutasiPerubahanFprFsDao;
    }

    @PostMapping("/upload")
    public ResponseEntity<MessageUtil> uploadAktuaria(@RequestParam("file") MultipartFile file, @RequestParam("jenisFaktor") String jenisFaktor){
        UploadHeaderSummaryDto data = new UploadHeaderSummaryDto();
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(this.filePath,file.getOriginalFilename());
            Files.write(path, bytes);


            ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(this.filePath + "/" + file.getOriginalFilename());
            excelReaderUtil.getHeaderRow(excelReaderUtil.getFirstSheet());
            Sheet sheet = excelReaderUtil.getFirstSheet();
            excelReaderUtil.close();

            if(jenisFaktor.equals("fs"))
                data = this.saveToTempFs(sheet);
            else if (jenisFaktor.equals("fpr"))
                data = this.saveToTempFpr(sheet);
        } catch (IOException e){
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        MessageUtil messageUtil = new MessageUtil("success","Data berhasil diupload",data);

        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    private UploadHeaderSummaryDto saveToTempFs(Sheet sheet){
        this.tempAktuariaFsDao.deleteAll();
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            TempAktuariaFs tempAktuariaFs = new TempAktuariaFs();
            tempAktuariaFs.setTahun(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.TAHUN)));
            tempAktuariaFs.setBulan(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.BULAN)));
            tempAktuariaFs.setPriaL(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.PRIA_L)));
            tempAktuariaFs.setPriaK(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.PRIA_K)));
            tempAktuariaFs.setWanitaL(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.WANITA_L)));
            tempAktuariaFs.setWanitaK(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.WANITA_K)));
            tempAktuariaFs.setUserStamp(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.USR_STAMP_3)));
            tempAktuariaFs.setAnakL(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.ANAK_L)));
            tempAktuariaFs.setAnakP(dataFormatter.formatCellValue(row.getCell(AktuariaCellMapping.ANAK_P)));
            if(row.getRowNum() != 0)
                tempAktuariaFsDao.save(tempAktuariaFs);
        }

        UploadHeaderSummaryDto summaryDto = tempAktuariaFsDao.getSummary();
        return summaryDto;
    }

    private UploadHeaderSummaryDto saveToTempFpr(Sheet sheet){
        this.tempAktuariaFprDao.deleteAll();
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            TempAktuariaFpr tempAktuariaFpr = new TempAktuariaFpr();
            tempAktuariaFpr.setUsiaFk(dataFormatter.formatCellValue(row.getCell(AktuariaFprCellMapping.USIA_FK)));
            tempAktuariaFpr.setFkurang(dataFormatter.formatCellValue(row.getCell(AktuariaFprCellMapping.FKURANG)));
            tempAktuariaFpr.setUserStamp(dataFormatter.formatCellValue(row.getCell(AktuariaFprCellMapping.USR_STAMP)));
            if(row.getRowNum() != 0)
                tempAktuariaFprDao.save(tempAktuariaFpr);
        }

        UploadHeaderSummaryDto summaryFprDto = tempAktuariaFprDao.getSummary();
        return summaryFprDto;
    }

    @GetMapping("/temp_faktor_fs")
    public Page<TempAktuariaFsDto> uploadedDataFs(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<TempAktuariaFs> aIt = (Page<TempAktuariaFs>) tempAktuariaFsDao.findAll(new String[] {}, "%" + searchParam + "%", pageRequest);

        Page<TempAktuariaFsDto> tempPotonganKovetriDtos = aIt.map(u -> u.toDto());

        return tempPotonganKovetriDtos;
    }

    @GetMapping("/temp_faktor_fpr")
    public Page<TempAktuariaFprDto> uploadedDatafpr(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<TempAktuariaFpr> aIt = (Page<TempAktuariaFpr>) tempAktuariaFprDao.findAll(new String[] {}, "%" + searchParam + "%", pageRequest);

        Page<TempAktuariaFprDto> tempAktuariaFprDtos = aIt.map(u -> u.toDto());

        return tempAktuariaFprDtos;
    }

    @GetMapping("/copy_data")
    public ResponseEntity<MessageUtil> copyData(@ModelAttribute UploadHeaderSummaryDto dto){
        MessageUtil messageUtil = null;
        this.postModeUserStamp = DkppUserStamp.postModeUserStamp();
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        if(dto.getJenisFaktor().equals("fs")){
            CuspInsertFaktorFprFsSPDto spDto = new CuspInsertFaktorFprFsSPDto();
            spDto.fromPlainText(dto);
            spDto.setParRoleId(role.getId());

            Map result = uploadMutasiFprFsDao.processCuspInsertFaktorFprFs(spDto);

            if (result.get("PAR_STATUS_EKSEKUSI").equals('1')||result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
                Long idFaktor = (Long) result.get("PAR_ID_FAKTOR");
                this.copyFs(idFaktor);

                UploadMutasiFprFs uploadMutasiFprFs = new UploadMutasiFprFs();
                uploadMutasiFprFs.setJenisFaktor(dto.getJenisFaktor());
                uploadMutasiFprFs.setTotalData(Long.valueOf(dto.getTotalRow()));
                uploadMutasiFprFs.setTglUpload(DateUtil.stringToDate(dto.getTglUpload(), "dd-MM-yyyy"));
                uploadMutasiFprFs.setPeriodeMulai(dto.getPeriodeMulai());
                uploadMutasiFprFs.setTglMulaiBerlaku(DateUtil.stringToDate(dto.getTglMulaiBerlaku(),"dd/MM/yyyy"));
                uploadMutasiFprFs.setIdFs(idFaktor);
                uploadMutasiFprFs.setKeteranganFaktor(dto.getKeterangan());
                uploadMutasiFprFs.setUserStamp(this.postModeUserStamp);

                uploadMutasiFprFsDao.save(uploadMutasiFprFs);
                 messageUtil = new MessageUtil("success", "Data berhasil disalin.");

            }else {
                messageUtil = new MessageUtil("failed", "Data gagal disalin.");
            }
        }
        else if (dto.getJenisFaktor().equals("fpr")){
            CuspInsertFaktorFprFsSPDto spDto = new CuspInsertFaktorFprFsSPDto();
            spDto.fromPlainText(dto);
            spDto.setParRoleId(role.getId());

            Map result = uploadMutasiFprFsDao.processCuspInsertFaktorFprFs(spDto);

            if (result.get("PAR_STATUS_EKSEKUSI").equals('1')||result.get("PAR_STATUS_EKSEKUSI").equals("1")) {
                Long idFaktor = (Long) result.get("PAR_ID_FAKTOR");
                this.copyFpr(idFaktor);

                UploadMutasiFprFs uploadMutasiFprFs = new UploadMutasiFprFs();
                uploadMutasiFprFs.setJenisFaktor(dto.getJenisFaktor());
                uploadMutasiFprFs.setTotalData(Long.valueOf(dto.getTotalRow()));
                uploadMutasiFprFs.setTglUpload(DateUtil.stringToDate(dto.getTglUpload(), "dd-MM-yyyy"));
                uploadMutasiFprFs.setPeriodeMulai(dto.getPeriodeMulai());
                uploadMutasiFprFs.setTglMulaiBerlaku(DateUtil.stringToDate(dto.getTglMulaiBerlaku(),"dd/MM/yyyy"));
                uploadMutasiFprFs.setIdFpr(idFaktor);
                uploadMutasiFprFs.setKeteranganFaktor(dto.getKeterangan());
                uploadMutasiFprFs.setUserStamp(this.postModeUserStamp);

                uploadMutasiFprFsDao.save(uploadMutasiFprFs);
                messageUtil = new MessageUtil("success", "Data berhasil disalin.");

            }else {
                messageUtil = new MessageUtil("failed", "Data gagal disalin.");
            }


        }
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);


    }

    private void copyFs(Long idFaktor){
        FaktorFs ff = (FaktorFs) faktorFsDao.findById(idFaktor);
        Iterable<TempAktuariaFs> itFs = tempAktuariaFsDao.findAll();
        itFs.forEach(tfs -> {
            AktuariaFs fs = tfs.toDestinationTable();
            fs.setFaktorFs(ff);
            fs.setUserStamp(this.postModeUserStamp);
//            System.out.println(fs.toString());
            aktuariaFsDao.save(fs);
        });
        tempAktuariaFsDao.deleteAll();
    }

    private void copyFpr(Long idFaktor){
        FaktorFPR ff = (FaktorFPR) faktorFPRDao.findById(idFaktor);
        Iterable<TempAktuariaFpr> itFs = tempAktuariaFprDao.findAll();
        itFs.forEach(tfs -> {
            AktuariaFpr fr = tfs.toDestinationTable();
            fr.setFaktorFPR(ff);
            fr.setUserStamp(this.postModeUserStamp);
//            System.out.println(fs.toString());
            aktuariaFprDao.save(fr);
        });
        tempAktuariaFprDao.deleteAll();
    }

    @GetMapping("/index")
    public Page<UploadMutasiFprFsDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<UploadMutasiFprFs> aIt = (Page<UploadMutasiFprFs>) uploadMutasiFprFsDao.findAll(new String[] {}, "%" + searchParam + "%", pageRequest);

        Page<UploadMutasiFprFsDto> dtos = aIt.map(u -> u.toDto());

        return dtos;
    }

    @GetMapping("/index-tab4")
    public Page<MutasiPerubahanFprFsDto> indexTab4(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<MutasiPerubahanFprFs> aIt = (Page<MutasiPerubahanFprFs>) mutasiPerubahanFprFsDao.findAll(new String[] {"nip","namaPeserta"}, "%" + searchParam + "%", pageRequest);

        Page<MutasiPerubahanFprFsDto> dtos = aIt.map(u -> {
            MutasiPerubahanFprFsDto dto = u.toDto();
            if (u.getIdKategoriPenerimaMp() !=null) dto.setIdKategoriPenerimaMp(u.getIdKategoriPenerimaMp().toDto());
            if (u.getIdKategoriCatatan()!= null) dto.setIdKategoriCatatan(u.getIdKategoriCatatan().toDto());
            if (u.getIdValidasi() != null) dto.setIdValidasi(u.getIdValidasi().toDto());
            if (u.getIdFaktorFprLama() != null) dto.setIdFaktorFprLama(u.getIdFaktorFprLama().toDto());
            if (u.getIdFaktorFprBaru() != null) dto.setIdFaktorFprBaru(u.getIdFaktorFprBaru().toDto());
            if (u.getIdFaktorFsLama() !=null) dto.setIdFaktorFsLama(u.getIdFaktorFsLama().toDto());
            if (u.getIdFaktorFsBaru() !=null) dto.setIdFaktorFsBaru(u.getIdFaktorFsBaru().toDto());
            if (u.getIdKategoriPensiun() !=null) dto.setIdKategoriPensiun(u.getIdKategoriPensiun().toDto());
            if (u.getIdJenisMps() !=null) dto.setIdJenisMps(u.getIdJenisMps().toDto());
            if (u.getIdStatusKawinPenerimaMp() !=null) dto.setIdStatusKawinPenerimaMp(u.getIdStatusKawinPenerimaMp().toDto());
            if (u.getIdUsiaBayar() != null) dto.setIdUsiaBayar(u.getIdUsiaBayar().toDto());
            if (u.getIdStatusBayar() !=null) dto.setIdStatusBayar(u.getIdStatusBayar().toDto());
            if (u.getIdKantorBayar() !=null) dto.setIdKantorBayar(u.getIdKantorBayar().toDto());
            return dto;
        });

        return dtos;
    }

    @PostMapping("/sp-proses")
    public ResponseEntity<MessageUtil>spPembayaran(@ModelAttribute CuspMutasiPerubahanFprFsPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspMutasiPerubahanFprFsSPDto spDto = new CuspMutasiPerubahanFprFsSPDto();
        spDto.setParRoleId(role.getId());
        spDto.fromPlainText(plainDto);
        Map result = mutasiPerubahanFprFsDao.processCuspMutasiPerubahanFprFs(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")||result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

    @GetMapping("/copied_fs/{idFaktorFs}")
    public Page<AktuariaFsDto> copiedPotonganPga(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @PathVariable Long idFaktorFs) {
        Page<AktuariaFs> aIt = (Page<AktuariaFs>) aktuariaFsDao.findAllByIdFAndFaktorFsWithSearch(idFaktorFs,"%" + String.valueOf(searchParam) + "%", pageRequest);
        Page<AktuariaFsDto> potonganPgaDtos = aIt.map(u -> u.toDto());

        return potonganPgaDtos;
    }

    @GetMapping("/copied_fpr/{idfaktorfpr}")
    public Page<AktuariaFprDto> copiedfpr(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @PathVariable Long idfaktorfpr) {
        Page<AktuariaFpr> aIt = aktuariaFprDao.findAllByIdFAndFaktorFprWithSearch(idfaktorfpr,"%" + searchParam + "%", pageRequest);
        Page<AktuariaFprDto> potonganPgaDtos = aIt.map(u -> u.toDto());

        return potonganPgaDtos;
    }

    @PostMapping("/edit-proses")
    public ResponseEntity<MessageUtil>spEdit(@ModelAttribute CuspMutasiPrbhnFrsFsUpdPlainDto plainDto){
        DkppUserDetail user = DkppUserStamp.getUserPrincipal();
        RoleDto role = user.getUser().getRoles().get(0);
        CuspMutasiPrbhnFrsFsUpdSPDto spDto = new CuspMutasiPrbhnFrsFsUpdSPDto();
        spDto.setParRoleId(role.getId());
        spDto.fromPlainText(plainDto);
        Map result = mutasiPerubahanFprFsDao.processCuspMutasiPrbhnFprFsUpd(spDto);

        MessageUtil messageUtil;
        HttpStatus httpStatus;
        if (result.get("PAR_STATUS_EKSEKUSI").equals("1")||result.get("PAR_STATUS_EKSEKUSI").equals('1')) {
            messageUtil = new MessageUtil("success", "Data berhasil ditambahkan",spDto);
            httpStatus = HttpStatus.OK;
        } else {
            messageUtil = new MessageUtil("failed", result.get("PAR_MSG").toString(),spDto);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<MessageUtil>(messageUtil, httpStatus);
    }

}
