package com.dapenbi.dkpp.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelReaderUtil {
    private Workbook workbook;
    private DataFormatter dataFormatter;

    public ExcelReaderUtil(String fileName) throws IOException, InvalidFormatException {
        this.workbook = WorkbookFactory.create(new File(fileName));
        this.dataFormatter = new DataFormatter();
    }

    public Iterator<Sheet> getSheetIterator(){
        Iterator<Sheet> sheetIterator = this.workbook.sheetIterator();
        return sheetIterator;
    }

    public Sheet getFirstSheet(){
        Sheet sheet = this.workbook.getSheetAt(0);
        return sheet;
    }

    public Iterator<Row> getRowIterator(Sheet sheet){
        Iterator<Row> rowIterator = sheet.rowIterator();
        return rowIterator;
    }

    public int getRowCount(Sheet sheet){
        Iterator<Row> rowIterator = sheet.rowIterator();
        int ctr = 0;
        while(rowIterator.hasNext()){
            rowIterator.next();
            ctr++;
        }

        return ctr;
    }

    public List<String> getHeaderRow(Sheet sheet){
        List<String> listStrOut = new ArrayList<String>();
        Row row = sheet.getRow(0);
        if(row != null)
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                listStrOut.add(cellValue);
            });

        return listStrOut;
    }

    public void close() throws IOException {
        this.workbook.close();
    }


}
