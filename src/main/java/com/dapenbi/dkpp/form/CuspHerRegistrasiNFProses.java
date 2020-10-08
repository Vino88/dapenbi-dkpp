package com.dapenbi.dkpp.form;

public class CuspHerRegistrasiNFProses extends BaseFormDto {

    private String parCompName;
    private String parUserName;
    private String parTahunHer;
    private String parStatusHer;
    private Character parAction;

    public String getParCompName() {
        return parCompName;
    }

    public void setParCompName(String parCompName) {
        this.parCompName = parCompName;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }

    public String getParTahunHer() {
        return parTahunHer;
    }

    public void setParTahunHer(String parTahunHer) {
        this.parTahunHer = parTahunHer;
    }

    public String getParStatusHer() {
        return parStatusHer;
    }

    public void setParStatusHer(String parStatusHer) {
        this.parStatusHer = parStatusHer;
    }

    public Character getParAction() {
        return parAction;
    }

    public void setParAction(Character parAction) {
        this.parAction = parAction;
    }

    public void fromPlainText(CuspHerRegistrasiNFProses plainDto){
        this.setParCompName( plainDto.getParCompName());
        this.setParUserName( plainDto.getParUserName());
        this.setParTahunHer( plainDto.getParTahunHer());
        this.setParStatusHer( plainDto.getParStatusHer());
        this.setParAction( plainDto.getParAction());
    }
}
