package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.dao.CekMutasiDao;
import com.dapenbi.dkpp.dto.MutasiPensiunDto;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.repository.CekMutasiRepository;
import org.springframework.stereotype.Service;

@Service
public class CekMutasiDaoImpl extends BaseDaoImpl<MutasiPensiun, MutasiPensiunDto, Long> implements CekMutasiDao {
    private CekMutasiRepository cekMutasiRepository;

    public CekMutasiDaoImpl(CekMutasiRepository cekMutasiRepository){
        super(cekMutasiRepository);
        this.cekMutasiRepository = cekMutasiRepository;
    }

    @Override
    public String isExist(String nip){
        return this.cekMutasiRepository.CufnCheckExistMutasi(nip);
    }
}
