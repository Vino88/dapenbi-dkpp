package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.TempPotonganKovetriDao;
import com.dapenbi.dkpp.dto.TempPotonganKovetriDto;
import com.dapenbi.dkpp.form.UploadPotonganSummaryDto;
import com.dapenbi.dkpp.model.TempPotonganKovetri;
import com.dapenbi.dkpp.repository.TempPotonganKovetriRepository;
import org.apache.catalina.core.ApplicationContext;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class TempPotonganKovetriDaoImpl extends BaseDaoImpl<TempPotonganKovetri, TempPotonganKovetriDto, Long> implements TempPotonganKovetriDao {

    private TempPotonganKovetriRepository tempPotonganKovetriRepository;

    private static SessionFactory factory;

    private Session session;

    @Autowired
    public TempPotonganKovetriDaoImpl(TempPotonganKovetriRepository tempPotonganKovetriRepository){
        super(tempPotonganKovetriRepository);
        this.tempPotonganKovetriRepository = tempPotonganKovetriRepository;
    }

    public void deleteAll(){
        this.tempPotonganKovetriRepository.deleteAll();
    }

    public UploadPotonganSummaryDto getSummary(){
        UploadPotonganSummaryDto dto = new UploadPotonganSummaryDto();
        dto.setTotalRow( String.valueOf(tempPotonganKovetriRepository.getCount()) );
        dto.setJumlah(String.valueOf(tempPotonganKovetriRepository.getJumlah()) );
        dto.setPeriodeMutasi(String.valueOf(tempPotonganKovetriRepository.getFirstByPeriodeMutasiIsNotNull().getPeriodeMutasi()));
        return dto;
    }


}
