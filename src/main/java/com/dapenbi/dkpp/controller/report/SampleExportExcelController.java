package com.dapenbi.dkpp.controller.report;

import com.dapenbi.dkpp.PathPrefix;
import com.dapenbi.dkpp.dao.MPensiunDao;
import com.dapenbi.dkpp.model.MPensiun;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class SampleExportExcelController extends AbstractXlsView{

    @Autowired
    MPensiunDao mPensiunDao;

    Sheet excelSheet;

    @GetMapping(PathPrefix.REPORT + "/exportExcel")
    public ModelAndView downloadExcel(HttpServletResponse httpServletResponse, HttpServletRequest request){
        List<MPensiun> mPensiun = mPensiunDao.findAllList();
        return new ModelAndView(this, "mPensiun", mPensiun);
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet excelSheet = workbook.createSheet("MPensiun");
        setExcelHeader(excelSheet);

        List animalList = (List) model.get("mPensiun");
        setExcelRows(excelSheet,animalList);
    }

    public void setExcelHeader(Sheet excelSheet) {
        Row excelHeader = excelSheet.createRow(0);
        excelHeader.createCell(0).setCellValue("Id");
        excelHeader.createCell(1).setCellValue("Name");
        excelHeader.createCell(2).setCellValue("Type");
        excelHeader.createCell(3).setCellValue("Aggressive");
        excelHeader.createCell(4).setCellValue("Weight");
    }

    public void setExcelRows(Sheet excelSheet, List<MPensiun> mPensiuns){
        int record = 1;
        for (MPensiun mPensiun : mPensiuns) {
            Row excelRow = excelSheet.createRow(record++);
            excelRow.createCell(0).setCellValue(mPensiun.getNip());
            excelRow.createCell(1).setCellValue(mPensiun.getNamaPeserta());
            excelRow.createCell(2).setCellValue(mPensiun.getTglLahirPeserta());
            excelRow.createCell(3).setCellValue(mPensiun.getAlamatLengkap());
            excelRow.createCell(4).setCellValue(mPensiun.getEmail());
        }
    }
}
