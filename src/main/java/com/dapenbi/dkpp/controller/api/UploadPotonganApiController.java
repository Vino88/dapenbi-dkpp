package com.dapenbi.dkpp.controller.api;


import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.component.SpreadSheetMapping.KovetriCellMapping;
import com.dapenbi.dkpp.component.SpreadSheetMapping.OlahragaCellMapping;
import com.dapenbi.dkpp.component.SpreadSheetMapping.PgaCellMapping;
import com.dapenbi.dkpp.dao.*;
import com.dapenbi.dkpp.dto.*;
import com.dapenbi.dkpp.form.BaseFormDto;
import com.dapenbi.dkpp.form.UploadPotonganSummaryDto;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@RestController
@RequestMapping(PathPrefix.API + PathPrefix.UPLOAD_POTONGAN)
public class UploadPotonganApiController{

    @Value("${file.upload-dir}")
    private String filePath;

    private TempPotonganOlahragaDao tempPotonganOlahragaDao;

    private TempPotonganKovetriDao tempPotonganKovetriDao;

    private TempPotonganPgaDao tempPotonganPgaDao;

    private PotonganPgaDao potonganPgaDao;

    private PotonganKovetriDao potonganKovetriDao;

    private PotonganOlahragaDao potonganOlahragaDao;

    private UploadPotonganDao uploadPotonganDao;

    private String postModeUserStamp;

    private String putModeUserStamp;

    private String pgaPeriodeMutasi;

    @Autowired
    public UploadPotonganApiController(TempPotonganOlahragaDao tempPotonganOlahragaDao, TempPotonganKovetriDao tempPotonganKovetriDao, TempPotonganPgaDao tempPotonganPgaDao, PotonganOlahragaDao potonganOlahragaDao, PotonganPgaDao potonganPgaDao, PotonganKovetriDao potonganKovetriDao, UploadPotonganDao uploadPotonganDao){
        this.tempPotonganOlahragaDao = tempPotonganOlahragaDao;
        this.tempPotonganKovetriDao = tempPotonganKovetriDao;
        this.tempPotonganPgaDao = tempPotonganPgaDao;
        this.potonganOlahragaDao = potonganOlahragaDao;
        this.potonganPgaDao = potonganPgaDao;
        this.potonganKovetriDao = potonganKovetriDao;
        this.uploadPotonganDao = uploadPotonganDao;
    }





    @GetMapping
    public Page<UploadPotonganDto> index(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam){
        Page<UploadPotongan> aIt = (Page<UploadPotongan>) uploadPotonganDao.findAll(new String[] {}, "%" + searchParam + "%", pageRequest);

        Page<UploadPotonganDto> uploadPotonganDtos = aIt.map(u -> u.toDto());

        return uploadPotonganDtos;
    }

    @GetMapping("/temp_kovetri")
    public Page<TempPotonganKovetriDto> uploadedPotonganKovetri(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<TempPotonganKovetri> aIt = (Page<TempPotonganKovetri>) tempPotonganKovetriDao.findAll(new String[] {}, "%" + searchParam + "%", pageRequest);

        Page<TempPotonganKovetriDto> tempPotonganKovetriDtos = aIt.map(u -> u.toDto());

        return tempPotonganKovetriDtos;
    }

    @GetMapping("/temp_pga")
    public Page<TempPotonganPgaDto> uploadedPotonganPga(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<TempPotonganPga> aIt = (Page<TempPotonganPga>) tempPotonganPgaDao.findAll(new String[] {}, "%" + searchParam + "%", pageRequest);

        Page<TempPotonganPgaDto> tempPotonganPgaDtos = aIt.map(u -> u.toDto());

        return tempPotonganPgaDtos;
    }

    @GetMapping("/temp_olahraga")
    public Page<TempPotonganOlahragaDto> uploadedPotonganOlahraga(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam) {
        Page<TempPotonganOlahraga> aIt = (Page<TempPotonganOlahraga>) tempPotonganOlahragaDao.findAll(new String[] {}, "%" + searchParam + "%", pageRequest);

        Page<TempPotonganOlahragaDto> tempPotonganOlahragaDtos = aIt.map(u -> u.toDto());

        return tempPotonganOlahragaDtos;
    }

    @GetMapping("/copied_kovetri")
    public Page<PotonganKovetriDto> copiedPotonganKovetri(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @ModelAttribute UploadPotonganDto dto) {
        Page<PotonganKovetri> aIt = potonganKovetriDao.findAllByPeriodeMutasiAndUserStamp(dto.getPeriodeMutasi(), dto.getUserStamp(), pageRequest);

        Page<PotonganKovetriDto> potonganKovetriDtos = aIt.map(u -> u.toDto());

        return potonganKovetriDtos;
    }

    @GetMapping("/copied_pga")
    public Page<PotonganPgaDto> copiedPotonganPga(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @ModelAttribute UploadPotonganDto dto) {
        Page<PotonganPga> aIt = potonganPgaDao.findAllByPeriodeMutasiAndUserStamp(dto.getPeriodeMutasi(), dto.getUserStamp(), pageRequest);
        Page<PotonganPgaDto> potonganPgaDtos = aIt.map(u -> u.toDto());

        return potonganPgaDtos;
    }

    @GetMapping("/copied_olahraga")
    public Page<PotonganOlahragaDto> copiedPotonganOlahraga(Pageable pageRequest, @RequestParam(name = "searchParam", required = false) String searchParam, @ModelAttribute UploadPotonganDto dto) {
        Page<PotonganOlahraga> aIt =  potonganOlahragaDao.findAllByPeriodeMutasiAndUserStamp(dto.getPeriodeMutasi(), dto.getUserStamp(), pageRequest);

        Page<PotonganOlahragaDto> potonganOlahragaDtos = aIt.map(u -> u.toDto());

        return potonganOlahragaDtos;
    }

    @GetMapping("/copy_data")
    public ResponseEntity<MessageUtil> copyData(@ModelAttribute UploadPotonganSummaryDto dto){
        this.postModeUserStamp = DkppUserStamp.postModeUserStamp();
        if(dto.getJenisPotongan().equals("pga")){
            this.copyPga();
        } else if (dto.getJenisPotongan().equals("kovetri")){
            this.copyKovetri();
        } else if (dto.getJenisPotongan().equals("olahraga")){
            this.copyOlahraga();
        }

        UploadPotongan uploadPotongan = new UploadPotongan();
        uploadPotongan.setJenisPotongan(dto.getJenisPotongan());
        uploadPotongan.setTotalData(Integer.valueOf(dto.getTotalRow()));
        uploadPotongan.setTglUpload(DateUtil.stringToDate(dto.getTglUpload(), "dd-MM-yyyy"));
        uploadPotongan.setPeriodeMutasi(dto.getPeriodeMutasi());
        uploadPotongan.setJumlah(Long.valueOf(dto.getJumlah()));
        uploadPotongan.setUserStamp(this.postModeUserStamp);

        uploadPotonganDao.save(uploadPotongan);
        MessageUtil messageUtil = new MessageUtil("success", "Data berhasil disalin.");
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageUtil> uploadPotongan(@RequestParam("file") MultipartFile file, @RequestParam("jenisPotongan") String jenisPotongan){
        UploadPotonganSummaryDto data = new UploadPotonganSummaryDto();
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(this.filePath,file.getOriginalFilename());
            Files.write(path, bytes);


            ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(this.filePath + "/" + file.getOriginalFilename());
            excelReaderUtil.getHeaderRow(excelReaderUtil.getFirstSheet());
            Sheet sheet = excelReaderUtil.getFirstSheet();
            excelReaderUtil.close();

            if(jenisPotongan.equals("kovetri"))
                data = this.saveToTempKovetri(sheet);
            else if (jenisPotongan.equals("pga"))
                data = this.saveToTempPga(sheet);
            else if (jenisPotongan.equals("olahraga"))
                data = this.saveToTempOlahraga(sheet);
        } catch (IOException e){
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


        MessageUtil messageUtil = new MessageUtil("success", "Data berhasil diupload", data);
        return new ResponseEntity<MessageUtil>(messageUtil, HttpStatus.OK);
    }

    private UploadPotonganSummaryDto saveToTempKovetri(Sheet sheet){
        this.tempPotonganKovetriDao.deleteAll();
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            TempPotonganKovetri tempPotonganKovetri = new TempPotonganKovetri();
            tempPotonganKovetri.setPeriodeMutasi( this.convertPeriode( dataFormatter.formatCellValue(row.getCell(KovetriCellMapping.PERIODE_MUTASI))));
            tempPotonganKovetri.setNip(dataFormatter.formatCellValue(row.getCell(KovetriCellMapping.NIP)));
            tempPotonganKovetri.setPotongan(dataFormatter.formatCellValue(row.getCell(KovetriCellMapping.POTONGAN)).replaceAll(",", ""));
            tempPotonganKovetri.setActive(true);
            System.out.println(tempPotonganKovetri.toString());
            if(row.getRowNum() > 3 && !tempPotonganKovetri.getNip().equals(""))
                tempPotonganKovetriDao.save(tempPotonganKovetri);
        }

        UploadPotonganSummaryDto summaryDto = tempPotonganKovetriDao.getSummary();
        return summaryDto;
    }

    private UploadPotonganSummaryDto saveToTempPga(Sheet sheet){
        this.tempPotonganPgaDao.deleteAll();
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            this.setPeriodeMutasiByFile(dataFormatter.formatCellValue(row.getCell(0)));

            String cell0 = dataFormatter.formatCellValue((row.getCell(0)));
            TempPotonganPga tempPotonganPga = new TempPotonganPga();
            tempPotonganPga.setPeriodeMutasi(this.pgaPeriodeMutasi);
            tempPotonganPga.setNip(dataFormatter.formatCellValue(row.getCell(PgaCellMapping.NIP)).replace("\\s", ""));
            tempPotonganPga.setNamaPeserta(dataFormatter.formatCellValue(row.getCell(PgaCellMapping.NAMA_PESERTA)));
            tempPotonganPga.setPotongan(dataFormatter.formatCellValue(row.getCell(PgaCellMapping.POTONGAN)).replaceAll(",", ""));
            tempPotonganPga.setCode(dataFormatter.formatCellValue(row.getCell(PgaCellMapping.CODE)));
            System.out.println(tempPotonganPga.toString());
            if(!cell0.equals("") && !tempPotonganPga.getNip().equals("") && !tempPotonganPga.getNamaPeserta().equals("") && !tempPotonganPga.getCode().equals("") && !tempPotonganPga.getPotongan().equals("") && !tempPotonganPga.getCode().equals("SND"))
                tempPotonganPgaDao.save(tempPotonganPga);
        }

        UploadPotonganSummaryDto summaryDto = tempPotonganPgaDao.getSummary();
        return summaryDto;
    }

    private UploadPotonganSummaryDto saveToTempOlahraga(Sheet sheet){
        this.tempPotonganOlahragaDao.deleteAll();
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            TempPotonganOlahraga tempPotonganOlahraga = new TempPotonganOlahraga();
            tempPotonganOlahraga.setPeriodeMutasi(dataFormatter.formatCellValue(row.getCell(OlahragaCellMapping.PERIODE_MUTASI)));
            tempPotonganOlahraga.setNip(dataFormatter.formatCellValue(row.getCell(OlahragaCellMapping.NIP)));
            tempPotonganOlahraga.setNamaPeserta(dataFormatter.formatCellValue(row.getCell(OlahragaCellMapping.NAMA_PESERTA)));
            tempPotonganOlahraga.setIdOlahraga(dataFormatter.formatCellValue(row.getCell(OlahragaCellMapping.ID_OLAHRAGA)));
            tempPotonganOlahraga.setNamaOlahraga(dataFormatter.formatCellValue(row.getCell(OlahragaCellMapping.NAMA_OLAHRAGA)));
            tempPotonganOlahraga.setPotongan(dataFormatter.formatCellValue(row.getCell(OlahragaCellMapping.POTONGAN)).replaceAll(",", ""));
            if(row.getRowNum() != 0 && tempPotonganOlahraga.getNip() != null && !tempPotonganOlahraga.getNip().equals("") )
                tempPotonganOlahragaDao.save(tempPotonganOlahraga);
        }

        UploadPotonganSummaryDto summaryDto = tempPotonganOlahragaDao.getSummary();
        return summaryDto;
    }

    private void copyPga(){
        Iterable<TempPotonganPga> itPga = tempPotonganPgaDao.findAll();
        itPga.forEach(tpga -> {
            PotonganPga pga = tpga.toDestinationTable();
            pga.setUserStamp(this.postModeUserStamp);
            potonganPgaDao.save(pga);
        });
        tempPotonganPgaDao.deleteAll();
    }

    private void copyKovetri(){
        Iterable<TempPotonganKovetri> itKov = tempPotonganKovetriDao.findAll();
        itKov.forEach(tkov -> {
            PotonganKovetri kovetri = tkov.toDestinationTable();
            kovetri.setUserStamp(this.postModeUserStamp);
            potonganKovetriDao.save(kovetri);
        });
        tempPotonganKovetriDao.deleteAll();
    }

    private void copyOlahraga(){
        Iterable<TempPotonganOlahraga> itOr = tempPotonganOlahragaDao.findAll();
        itOr.forEach(tor -> {
            PotonganOlahraga olahraga = tor.toDestinationTable();
            olahraga.setUserStamp(this.postModeUserStamp);
            potonganOlahragaDao.save(olahraga);
        });
        tempPotonganOlahragaDao.deleteAll();
    }

    private String convertPeriode(String rawPeriodeString){
        String out = "";
        Map bulan = new HashMap<String, String>();
        bulan.put("JANUARI", "01");
        bulan.put("FEBRUARI", "02");
        bulan.put("MARET", "03");
        bulan.put("APRIL", "04");
        bulan.put("MEI", "05");
        bulan.put("JUNI", "06");
        bulan.put("JULI", "07");
        bulan.put("AGUSTUS", "08");
        bulan.put("SEPTEMBER", "09");
        bulan.put("OKTOBER", "10");
        bulan.put("NOVEMBER", "11");
        bulan.put("DESEMBER", "12");
        String[] arr = rawPeriodeString.split("_");
        if(arr.length > 1){
            out = (String)bulan.get(arr[0]) + arr[1];
        } else {
            out = "";
        }

        return out;
    }

    private void setPeriodeMutasiByFile(String cellValue){
        Map mapPeroide = new HashMap<String, String>();
        mapPeroide.put("JANUARI", "01");
        mapPeroide.put("FEBRUARI", "02");
        mapPeroide.put("MARET", "03");
        mapPeroide.put("APRIL", "04");
        mapPeroide.put("MEI", "05");
        mapPeroide.put("JUNI", "06");
        mapPeroide.put("JULI", "07");
        mapPeroide.put("AGUSTUS", "08");
        mapPeroide.put("SEPTEMBER", "09");
        mapPeroide.put("OKTOBER", "10");
        mapPeroide.put("NOVEMBER", "11");
        mapPeroide.put("DESEMBER", "12");

        if(cellValue.contains("BULAN")){
            cellValue = cellValue.replaceAll("\\s", "");
            String[] arr = cellValue.split(":");
            String periode = arr[1];
            String month = periode.replaceAll("[0-9]", "");
            String year = periode.replaceAll("[a-zA-Z]", "");
            this.pgaPeriodeMutasi = (String) mapPeroide.get(month) + year;
        }
    }


}
