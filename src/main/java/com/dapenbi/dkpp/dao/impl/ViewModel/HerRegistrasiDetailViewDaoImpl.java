package com.dapenbi.dkpp.dao.impl.ViewModel;

import com.dapenbi.dkpp.dao.ViewModel.HerRegistrasiDetailViewDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.ViewModelDto.HerRegistrasiDetailViewDto;
import com.dapenbi.dkpp.model.ViewModel.HerRegistrasiDetailView;
import com.dapenbi.dkpp.repository.ViewModelRepository.HerRegistrasiDetailViewRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
public class HerRegistrasiDetailViewDaoImpl extends BaseDaoImpl<HerRegistrasiDetailView, HerRegistrasiDetailViewDto, Long> implements HerRegistrasiDetailViewDao {

    private HerRegistrasiDetailViewRepository herDetailRepository;

    public HerRegistrasiDetailViewDaoImpl(HerRegistrasiDetailViewRepository herDetailRepository) {
        super(herDetailRepository);
        this.herDetailRepository = herDetailRepository;
    }

    @Override
    public Page<HerRegistrasiDetailView> findByTahunHer(String tahunHer, String searchParam, Pageable pageable) {
        return herDetailRepository.findByTahunHer(tahunHer, searchParam , pageable);
    }
}
