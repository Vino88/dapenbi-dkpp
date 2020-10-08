package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.SetupParameterDao;
import com.dapenbi.dkpp.dto.SetupParameterDto;
import com.dapenbi.dkpp.model.SetupParameter;
import com.dapenbi.dkpp.repository.SetupParameterRepository;
import org.springframework.stereotype.Service;

@Service
public class SetupParameterDaoImpl extends BaseDaoImpl<SetupParameter, SetupParameterDto, Long> implements SetupParameterDao {
    private SetupParameterRepository setupParameterRepository;


    public SetupParameterDaoImpl(SetupParameterRepository setupParameterRepository) {
        super(setupParameterRepository);
        this.setupParameterRepository = setupParameterRepository;
    }

    @Override
    public SetupParameter findByPeriode(String id) {
        return (SetupParameter) this.setupParameterRepository.findFirstByPeriode(id);
    }

    @Override
    public SetupParameter findByBukaPeriode() {
        return this.setupParameterRepository.findFirstByIsBukaPeriodeIsTrue();
    }

    @Override
    public SetupParameter findByTutupPeriode() {
        return this.setupParameterRepository.findFirstByIsBukaPeriodeIsFalse();
    }

    @Override
    public String getSystemDate() {
        return this.setupParameterRepository.getDatabaseDate();
    }
}
