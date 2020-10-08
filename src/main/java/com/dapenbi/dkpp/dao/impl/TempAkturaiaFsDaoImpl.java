package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.TempAktuariaFsDao;
import com.dapenbi.dkpp.dto.TempAktuariaFsDto;
import com.dapenbi.dkpp.dto.UploadHeaderSummaryDto;
import com.dapenbi.dkpp.model.TempAktuariaFs;
import com.dapenbi.dkpp.repository.TempAktuariaFsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempAkturaiaFsDaoImpl  extends BaseDaoImpl<TempAktuariaFs, TempAktuariaFsDto,Long>implements TempAktuariaFsDao {

    private TempAktuariaFsRepository tempAktuariaFsRepository;

    private static SessionFactory factory;

    private Session session;

    @Autowired
    public TempAkturaiaFsDaoImpl(TempAktuariaFsRepository tempAktuariaFsRepository) {
        super(tempAktuariaFsRepository);
        this.tempAktuariaFsRepository = tempAktuariaFsRepository;
    }

    @Override
    public void deleteAll() {
        this.tempAktuariaFsRepository.deleteAll();
    }

    @Override
    public UploadHeaderSummaryDto getSummary() {
        UploadHeaderSummaryDto dto = new UploadHeaderSummaryDto();
        dto.setTotalRow( String.valueOf(tempAktuariaFsRepository.getCount()) );
//        dto.setJumlah(String.valueOf(tempAktuariaFsRepository.getJumlah()) );
//        dto.setPeriodeMulai(String.valueOf(tempAktuariaFsRepository.getFirstByPeriodeMutasiIsNotNull().getPeriodeMutasi()));
        return dto;
    }
}
