package com.dapenbi.dkpp.form;

import java.math.BigDecimal;

public class CuspKursSPDto extends BaseFormDto  {
    private String parCompName;
    private String parUserName;
    private String parPeriodeMutasi;
    private Long parKursEuro;
    private BigDecimal parKursRupiah;

    public void setParCompName(String parCompName){
        this.parCompName = parCompName;
    }

    public String getParCompName(){
        return this.parCompName;
    }

    public void setParUserName(String parUserName){
        this.parUserName = parUserName;
    }

    public String getParUserName(){
        return this.parUserName;
    }

    public void setParPeriodeMutasi(String parPeriodeMutasi){
        this.parPeriodeMutasi = parPeriodeMutasi;
    }

    public String getParPeriodeMutasi(){
        return this.parPeriodeMutasi;
    }

    public void setParKursEuro(Long parKursEuro){
        this.parKursEuro = parKursEuro;
    }

    public Long getParKursEuro(){
        return this.parKursEuro;
    }

    public void setParKursRupiah(BigDecimal parKursRupiah){
        this.parKursRupiah = parKursRupiah;
    }

    public BigDecimal getParKursRupiah(){
        return this.parKursRupiah;
    }

    public void fromPlainText(CuspKursPlainDto dto){
        this.setParCompName( dto.getParCompName());
        this.setParCompName( dto.getParCompName());
        this.setParUserName( dto.getParUserName());
        this.setParUserName( dto.getParUserName());
        this.setParPeriodeMutasi( dto.getParPeriodeMutasi());
        this.setParPeriodeMutasi( dto.getParPeriodeMutasi());
        this.setParKursEuro( Long.valueOf(dto.getParKursEuro()));
        this.setParKursRupiah( BigDecimal.valueOf(Double.valueOf( dto.getParKursRupiah() )) );
    }

}
