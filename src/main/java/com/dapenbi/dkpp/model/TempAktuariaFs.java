package com.dapenbi.dkpp.model;

import com.dapenbi.dkpp.dto.TempAktuariaFsDto;
import com.dapenbi.dkpp.util.DkppUserStamp;

import javax.persistence.*;

@Entity
@Table(name = "TBL_TEMP_AKTUARIA_FS")
public class TempAktuariaFs extends BaseModel<TempAktuariaFsDto> {

    @Id
    @Column(name="ID_AKTUARIA_FS", unique=true, nullable=false, precision=38)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMP_AKTUARIA_FS_ID_SEQ")
    @SequenceGenerator(sequenceName = "tempAktuariaFsId_seq", allocationSize = 1, name = "TEMP_AKTUARIA_FS_ID_SEQ")
    private long id;

    @Column(name = "tahun", length = 20)
    private String tahun;

    @Column(name = "BULAN",length = 20)
    private String bulan;

    @Column(name = "PRIA_L",length = 20)
    private String priaL;

    @Column(name = "PRIA_K",length = 20)
    private String priaK;

    @Column(name = "WANITA_L",length = 20)
    private String wanitaL;

    @Column(name = "WANITA_K",length = 20)
    private String wanitaK;

    @Column(name = "USR_STAMP_3",length = 60)
    private String userStamp;

    @Column(name = "ANAK_L",length = 20)
    private String anakL;

    @Column(name = "ANAK_P",length = 20)
    private String anakP;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getPriaL() {
        return priaL;
    }

    public void setPriaL(String priaL) {
        this.priaL = priaL;
    }

    public String getPriaK() {
        return priaK;
    }

    public void setPriaK(String priaK) {
        this.priaK = priaK;
    }

    public String getWanitaL() {
        return wanitaL;
    }

    public void setWanitaL(String wanitaL) {
        this.wanitaL = wanitaL;
    }

    public String getWanitaK() {
        return wanitaK;
    }

    public void setWanitaK(String wanitaK) {
        this.wanitaK = wanitaK;
    }

    @Override
    public String getUserStamp() {
        return userStamp;
    }

    @Override
    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getAnakL() {
        return anakL;
    }

    public void setAnakL(String anakL) {
        this.anakL = anakL;
    }

    public String getAnakP() {
        return anakP;
    }

    public void setAnakP(String anakP) {
        this.anakP = anakP;
    }




    @Override
    public void fromDto(TempAktuariaFsDto dto){
        this.setId( dto.getId() );
        this.setUserStamp( dto.getUserStamp() );
        this.setAnakL( dto.getAnakL() );
        this.setAnakP( dto.getAnakP() );
        this.setBulan( dto.getBulan() );
        this.setPriaK( dto.getPriaK() );
        this.setPriaL( dto.getPriaL() );
        this.setTahun( dto.getTahun() );
        this.setWanitaK( dto.getWanitaK() );
        this.setWanitaL( dto.getWanitaL() );
    }




    @Override
    public TempAktuariaFsDto toDto(){
        TempAktuariaFsDto dto = new TempAktuariaFsDto();
        dto.setId( this.getId() );
        dto.setUserStamp( this.getUserStamp() );
        dto.setAnakL( this.getAnakL() );
        dto.setAnakP( this.getAnakP() );
        dto.setBulan( this.getBulan() );
        dto.setPriaK( this.getPriaK() );
        dto.setPriaL( this.getPriaL() );
        dto.setTahun( this.getTahun() );
        dto.setWanitaK( this.getWanitaK() );
        dto.setWanitaL( this.getWanitaL() );

        return dto;
    }

    public AktuariaFs toDestinationTable(){
        AktuariaFs afs = new AktuariaFs();
        afs.setUsiaFs(this.getTahun()+this.getBulan());
        afs.setFsPrialajang(Double.valueOf(this.getPriaL()));
        afs.setFsPriakawin(Double.valueOf(this.getPriaK()));
        afs.setFsWanitalajang(Double.valueOf(this.getWanitaL()));
        afs.setFsWanitakawin(Double.valueOf(this.getWanitaK()));
        afs.setFsPriaanak(Double.valueOf(this.getAnakL()));
        afs.setFsWanitaanak(Double.valueOf(this.getAnakP()));
        afs.setUserStamp(DkppUserStamp.postModeUserStamp());
        return afs;
    }

}
