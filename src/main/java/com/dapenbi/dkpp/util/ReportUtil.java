package com.dapenbi.dkpp.util;

import com.zaxxer.hikari.HikariDataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class ReportUtil {

    private String jasperFile;

    private OutputStream outputStream;

    private Exporter exporter;

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;

    public ReportUtil(String jasperFile,OutputStream outputStream) {
        this.jasperFile = this.getClass().getClassLoader().getResource("com/dapenbi/dkpp/report/" + jasperFile + ".jasper").getFile();
        this.outputStream = outputStream;
    }

    public void setReport(Map<String, Object> parameters, JRDataSource datasource, Exporter exporter) throws JRException {
        try {

            this.jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFile);

            this.jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);

            this.exporter = exporter;

            this.exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            this.exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        }catch (JRException ex){
            ex.printStackTrace();
        }
    }

    public void setReport(Map<String, Object> parameters, Connection conn, Exporter exporter) throws JRException {
        jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFile);
        try {
            if(!conn.isClosed()) {
                System.out.println("Connection open");
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            }
        } catch (SQLException | JRException | JRRuntimeException e) {
            System.out.println("Connection is closed.");
            e.printStackTrace();
        } finally {
            System.out.println("Sampai baris ini.");
        }

        this.exporter = exporter;

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
    }



    public Exporter<SimpleExporterInput, ReportExportConfiguration, ExporterConfiguration, SimpleOutputStreamExporterOutput> getExporter() {

        return exporter;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public String getSubReportPath(String jasperFile) {
        String out = this.getClass().getClassLoader().getResource("").getPath() + "com/dapenbi/dkpp/report/" + jasperFile + ".jasper";
        return out;

    }
}
