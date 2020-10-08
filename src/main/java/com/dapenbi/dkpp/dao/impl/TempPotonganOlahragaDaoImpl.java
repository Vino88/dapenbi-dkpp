package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.OlahragaDao;
import com.dapenbi.dkpp.dao.TempPotonganOlahragaDao;
import com.dapenbi.dkpp.dto.OlahragaDto;
import com.dapenbi.dkpp.dto.TempPotonganOlahragaDto;
import com.dapenbi.dkpp.form.UploadPotonganSummaryDto;
import com.dapenbi.dkpp.model.Olahraga;
import com.dapenbi.dkpp.model.TempPotonganOlahraga;
import com.dapenbi.dkpp.repository.OlahragaRepository;
import com.dapenbi.dkpp.repository.TempPotonganOlahragaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempPotonganOlahragaDaoImpl extends BaseDaoImpl<TempPotonganOlahraga, TempPotonganOlahragaDto, Long> implements TempPotonganOlahragaDao {

    private TempPotonganOlahragaRepository tempPotonganOlahragaRepository;

    @Autowired
    public TempPotonganOlahragaDaoImpl(TempPotonganOlahragaRepository tempPotonganOlahragaRepository){
        super(tempPotonganOlahragaRepository);
        this.tempPotonganOlahragaRepository = tempPotonganOlahragaRepository;
    }

    public void deleteAll(){
        tempPotonganOlahragaRepository.deleteAll();
    }

    public UploadPotonganSummaryDto getSummary(){
        UploadPotonganSummaryDto dto = new UploadPotonganSummaryDto();
        dto.setTotalRow( String.valueOf(tempPotonganOlahragaRepository.getCount()) );
        dto.setJumlah(String.valueOf(tempPotonganOlahragaRepository.getJumlah()) );
        dto.setPeriodeMutasi(String.valueOf(tempPotonganOlahragaRepository.getFirstByPeriodeMutasiIsNotNull().getPeriodeMutasi()));
        return dto;
    }


}
