package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.TempPotonganPgaDao;
import com.dapenbi.dkpp.dto.TempPotonganPgaDto;
import com.dapenbi.dkpp.form.UploadPotonganSummaryDto;
import com.dapenbi.dkpp.model.TempPotonganPga;
import com.dapenbi.dkpp.repository.TempPotonganPgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempPotonganPgaDaoImpl extends BaseDaoImpl<TempPotonganPga, TempPotonganPgaDto, Long> implements TempPotonganPgaDao {

    private TempPotonganPgaRepository tempPotonganPgaRepository;

    @Autowired
    public TempPotonganPgaDaoImpl(TempPotonganPgaRepository tempPotonganPgaRepository){
        super(tempPotonganPgaRepository);
        this.tempPotonganPgaRepository = tempPotonganPgaRepository;
    }

    public void deleteAll(){
        tempPotonganPgaRepository.deleteAll();
    }

    public UploadPotonganSummaryDto getSummary(){
        UploadPotonganSummaryDto dto = new UploadPotonganSummaryDto();
        dto.setTotalRow( String.valueOf(tempPotonganPgaRepository.getCount()) );
        dto.setJumlah(String.valueOf(tempPotonganPgaRepository.getJumlah()) );
        dto.setPeriodeMutasi(String.valueOf(tempPotonganPgaRepository.getFirstByPeriodeMutasiIsNotNull().getPeriodeMutasi()));
        return dto;
    }


}
