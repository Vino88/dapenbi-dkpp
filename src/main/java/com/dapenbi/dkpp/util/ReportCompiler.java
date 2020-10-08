package com.dapenbi.dkpp.util;

import net.sf.jasperreports.crosstabs.JRCrosstab;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRElementsVisitor;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReportCompiler {
    private static final String reportsPath = "/src/main/jasperreports/com/dapenbi/dkpp/report/";
    private ArrayList<String> completedSubReports = new ArrayList<String>(30);
    private Throwable subReportException = null;
    /**
     * Compile report
     */
    public JasperReport compileReport(String reportName) throws JRException {
        File jasperFile = new File(this.getClass().getClassLoader().getResource("").getPath() + "com/dapenbi/dkpp/report/" + reportName + ".jasper");

        if (!jasperFile.exists()) {
            String rootPath = Paths.get(System.getProperty("user.dir")).toString();
            JasperDesign jasperDesign = JRXmlLoader.load(rootPath + reportsPath + reportName + ".jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JRSaver.saveObject(jasperReport, this.getClass().getClassLoader().getResource("").getPath() + "com/dapenbi/dkpp/report/" + reportName + ".jasper");

            //Compile sub reports
            JRElementsVisitor.visitReport(jasperReport, new JRVisitor() {
                @Override
                public void visitBreak(JRBreak breakElement) {
                }

                @Override
                public void visitChart(JRChart chart) {
                }

                @Override
                public void visitCrosstab(JRCrosstab crosstab) {
                }

                @Override
                public void visitElementGroup(JRElementGroup elementGroup) {
                }

                @Override
                public void visitEllipse(JREllipse ellipse) {
                }

                @Override
                public void visitFrame(JRFrame frame) {
                }

                @Override
                public void visitImage(JRImage image) {
                }

                @Override
                public void visitLine(JRLine line) {
                }

                @Override
                public void visitRectangle(JRRectangle rectangle) {
                }

                @Override
                public void visitStaticText(JRStaticText staticText) {
                }

                @Override
                public void visitSubreport(JRSubreport subreport) {
                }

                @Override
                public void visitTextField(JRTextField textField) {
                }

                @Override
                public void visitComponentElement(JRComponentElement componentElement) {
                }

                @Override
                public void visitGenericElement(JRGenericElement element) {
                }
            });
            if (subReportException != null) throw new RuntimeException(subReportException);
            return jasperReport;
        } else {
            return null;
        }
    }

}
