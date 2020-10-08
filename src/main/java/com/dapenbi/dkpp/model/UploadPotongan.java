package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.TempPotonganPgaDto;
import com.dapenbi.dkpp.dto.UploadPotonganDto;
import com.dapenbi.dkpp.util.DateUtil;
import com.dapenbi.dkpp.util.DkppUserStamp;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBL_T_UPLOAD_POTONGAN")
public class UploadPotongan extends BaseModel<UploadPotonganDto> {

    @Id
    @Column(name="ID_UPLOAD_POTONGAN", unique=true, nullable=false, precision=38)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMP_UPLOAD_POTONGAN_ID_SEQ")
    @SequenceGenerator(sequenceName = "tempUploadPotonganId_seq", allocationSize = 1, name = "TEMP_UPLOAD_POTONGAN_ID_SEQ")
    private long id;

    @Column(name = "PERIODE_MUTASI", length = 20)
    private String periodeMutasi;

    @Column(name = "JENIS_POTONGAN", length = 40)
    private String jenisPotongan;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGL_UPLOAD")
    private Date tglUpload;

    @Column(name = "TOTAL_DATA")
    private int totalData;

    @Column(name = "JUMLAH")
    private Long jumlah;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriodeMutasi() {
        return periodeMutasi;
    }

    public void setPeriodeMutasi(String periodeMutasi) {
        this.periodeMutasi = periodeMutasi;
    }

    public String getJenisPotongan() {
        return jenisPotongan;
    }

    public void setJenisPotongan(String jenisPotongan) {
        this.jenisPotongan = jenisPotongan;
    }

    public Date getTglUpload() {
        return tglUpload;
    }

    public void setTglUpload(Date tglUpload) {
        this.tglUpload = tglUpload;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public void fromDto(UploadPotonganDto dto) {
        this.setPeriodeMutasi(dto.getPeriodeMutasi());
        this.setTglUpload(DateUtil.stringToDate(dto.getTglUpload(), "dd-MM-yyyy"));
        this.setJenisPotongan(dto.getJenisPotongan());
        this.setTotalData(dto.getTotalData());
        this.setJumlah(Long.valueOf(dto.getJumlah() ));
    }

    @Override
    public UploadPotonganDto toDto() {
        UploadPotonganDto dto = new UploadPotonganDto();
        dto.setId(this.getId());
        dto.setPeriodeMutasi(this.getPeriodeMutasi());
        dto.setTglUpload(DateUtil.dateToString(this.getTglUpload(), "dd-MM-yyyy"));
        dto.setJenisPotongan(this.getJenisPotongan());
        dto.setTotalData(this.getTotalData());
        dto.setUserStamp(this.getUserStamp());
        dto.setJumlah(String.valueOf(this.getJumlah()));
        return dto;
    }


}