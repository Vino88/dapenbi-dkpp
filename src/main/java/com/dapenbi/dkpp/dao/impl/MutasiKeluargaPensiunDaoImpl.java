package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.MutasiKeluargaPensiunDao;
import com.dapenbi.dkpp.dto.MutasiKeluargaPensiunDto;
import com.dapenbi.dkpp.model.MutasiKeluargaPensiun;
import com.dapenbi.dkpp.model.MutasiPensiun;
import com.dapenbi.dkpp.repository.MutasiKeluargaPensiunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MutasiKeluargaPensiunDaoImpl extends BaseDaoImpl<MutasiKeluargaPensiun, MutasiKeluargaPensiunDto, String> implements MutasiKeluargaPensiunDao {
    private MutasiKeluargaPensiunRepository mutasiKeluargaPensiunRepository;

    @Autowired
    public MutasiKeluargaPensiunDaoImpl(MutasiKeluargaPensiunRepository mutasiKeluargaPensiunRepository) {
        super(mutasiKeluargaPensiunRepository);
        this.mutasiKeluargaPensiunRepository = mutasiKeluargaPensiunRepository;
    }

    @Override
    public MutasiKeluargaPensiun findByNip(String nip) {
        return mutasiKeluargaPensiunRepository.findFirstByNip(nip);
    }

    @Override
    public List<MutasiKeluargaPensiun> findByIdMutasi(Long idMutasi) {
        MutasiPensiun mutasiPensiun = new MutasiPensiun(idMutasi);
        return mutasiKeluargaPensiunRepository.findAllByMutasiPensiun(mutasiPensiun);
    }

    @Override
    @Transactional
    public void deleteByMutasiPensiun(Long idMutasi) {
        MutasiPensiun mutasiPensiun = new MutasiPensiun(idMutasi);
        mutasiKeluargaPensiunRepository.deleteAllByMutasiPensiun(mutasiPensiun);
    }

    @Override
    public boolean deleteAllByIdMutasi(Long idMutasi) {
        MutasiPensiun mutasiPensiun = new MutasiPensiun(idMutasi);

        try {
            mutasiKeluargaPensiunRepository.deleteAllByIdMutasi(idMutasi);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Map cufnDeleteMutasiKeluarga(String idMutasi) {
        return mutasiKeluargaPensiunRepository.cufnDeleteMutasiKeluarga(idMutasi);
    }
}
