package com.dapenbi.dkpp.model;


import com.dapenbi.dkpp.dto.TempAktuariaFprDto;

import javax.persistence.*;

@Entity
@Table(name = "TBL_TEMP_AKTUARIA_FPR")
public class TempAktuariaFpr extends BaseModel<TempAktuariaFprDto>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMP_AKTUARIA_FPR_ID_SEQ")
    @SequenceGenerator(sequenceName = "tempAktuariaFprId_seq", allocationSize = 1, name = "TEMP_AKTUARIA_FPR_ID_SEQ")
    @Column(name = "ID_AKTUARIA_FPR_TEMP", length = 22)
    private Long id;

    @Column(name = "USIA_FK", length = 20)
    private String usiaFk;

    @Column(name = "FKURANG", length = 20)
    private String fkurang;

    @Column(name = "IS_ACTIVE", length = 22)
    private Long isActive;

    @Column(name = "USER_STAMP", length = 60)
    private String userStamp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsiaFk(String usiaFk){
        this.usiaFk = usiaFk;
    }

    public String getUsiaFk(){
        return this.usiaFk;
    }

    public void setFkurang(String fkurang){
        this.fkurang = fkurang;
    }

    public String getFkurang(){
        return this.fkurang;
    }

    public void setIsActive(Long isActive){
        this.isActive = isActive;
    }

    public Long getIsActive(){
        return this.isActive;
    }

    public void setUserStamp(String userStamp){
        this.userStamp = userStamp;
    }

    public String getUserStamp(){
        return this.userStamp;
    }




    @Override
    public void fromDto(TempAktuariaFprDto dto){
        this.setId( dto.getId() );
        this.setUsiaFk( dto.getUsiaFk() );
        this.setFkurang( dto.getFkurang() );
        this.setIsActive( dto.getIsActive() );
        this.setUserStamp( dto.getUserStamp() );
    }




    @Override
    public TempAktuariaFprDto toDto(){
        TempAktuariaFprDto dto = new TempAktuariaFprDto();
        dto.setId( this.getId() );
        dto.setUsiaFk( this.getUsiaFk() );
        dto.setFkurang( this.getFkurang() );
        dto.setIsActive( this.getIsActive() );
        dto.setUserStamp( this.getUserStamp() );


        return dto;
    }

    public AktuariaFpr toDestinationTable(){
        AktuariaFpr afr = new AktuariaFpr();
        afr.setUsia(this.getUsiaFk());
        afr.setNilaifpr(Double.valueOf(this.getFkurang()));
        afr.setUserStamp(this.getUserStamp());
        return afr;
    }

}
