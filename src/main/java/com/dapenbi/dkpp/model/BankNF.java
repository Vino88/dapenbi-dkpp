package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.BankDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_R_BANK_NF")
public class BankNF extends BaseModel<BankDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANK_NF_ID_SEQ")
    @SequenceGenerator(sequenceName = "bankNFId_seq", allocationSize = 1, name = "BANK_NF_ID_SEQ")
    @Column(name = "id_bank_nf")
    private Long id;

    @Column(name = "nama_bank_nf", nullable = false)
    private String namaBankNF;

    private String alamat;

    private String negara;

    private String tlp;

    @Column(name = "swift_code")
    private String swiftCode;

    @Column(name = "iban_code")
    private String ibanCode;

    public BankNF(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBankNF() {
        return namaBankNF;
    }

    public void setNamaBankNF(String namaBankNF) {
        this.namaBankNF = namaBankNF;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getIbanCode() {
        return ibanCode;
    }

    public void setIbanCode(String ibanCode) {
        this.ibanCode = ibanCode;
    }

    @Override
    public void fromDto(BankDto dto) {
        this.setId(dto.getId());
        this.setNamaBankNF(dto.getNamaBankNF());
        this.setAlamat(dto.getAlamat());
        this.setNegara(dto.getNegara());
        this.setTlp(dto.getTlp());
        this.setSwiftCode(dto.getSwiftCode());
        this.setIbanCode(dto.getIbanCode());
        this.setActive(dto.isActive());
        this.setUserStamp(dto.getUserStamp());
    }

    @Override
    public BankDto toDto() {
        BankDto dto = new BankDto();
        dto.setId(this.getId());
        dto.setNamaBankNF(this.getNamaBankNF());
        dto.setAlamat(this.getAlamat());
        dto.setNegara(this.getNegara());
        dto.setTlp(this.getTlp());
        dto.setSwiftCode(this.getSwiftCode());
        dto.setIbanCode(this.getIbanCode());
        dto.setActive(this.isActive());
        dto.setUserStamp(this.getUserStamp());
        return dto ;
    }
}
