package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.AppConfigDao;
import com.dapenbi.dkpp.dto.AppConfigDto;
import com.dapenbi.dkpp.model.AppConfig;
import com.dapenbi.dkpp.repository.AppConfigRepository;
import com.dapenbi.dkpp.repository.SetupParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppConfigDaoImpl extends BaseDaoImpl<AppConfig, AppConfigDto, Long> implements AppConfigDao {
    private AppConfigRepository appConfigRepository;

    public AppConfigDaoImpl(AppConfigRepository appConfigRepository) {
        super(appConfigRepository);
        this.appConfigRepository = appConfigRepository;
    }
}
