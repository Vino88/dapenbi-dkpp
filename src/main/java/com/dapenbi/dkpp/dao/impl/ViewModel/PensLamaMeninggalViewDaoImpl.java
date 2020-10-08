package com.dapenbi.dkpp.dao.impl.ViewModel;

import com.dapenbi.dkpp.dao.ViewModel.PensLamaMeninggalViewDao;
import com.dapenbi.dkpp.dao.impl.BaseDaoImpl;
import com.dapenbi.dkpp.dto.ViewModelDto.PensiunLamaMeninggalViewDto;
import com.dapenbi.dkpp.model.ViewModel.PensiunLamaMeninggalView;
import com.dapenbi.dkpp.repository.ViewModelRepository.PensLamaMeninggalViewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PensLamaMeninggalViewDaoImpl extends BaseDaoImpl<PensiunLamaMeninggalView, PensiunLamaMeninggalViewDto, Long> implements PensLamaMeninggalViewDao {

    PensLamaMeninggalViewRepository pensLamaMeninggalViewRepository;

    public PensLamaMeninggalViewDaoImpl(PensLamaMeninggalViewRepository pensLamaMeninggalViewRepository) {
        super(pensLamaMeninggalViewRepository);
        this.pensLamaMeninggalViewRepository = pensLamaMeninggalViewRepository;
    }


    @Override
    public Page<PensiunLamaMeninggalView> findAllByBelumValidasi(String searchParam, Pageable pageable) {
        return pensLamaMeninggalViewRepository.findAllByBelumValidasi(searchParam,pageable);
    }

    @Override
    public List<PensiunLamaMeninggalView> findAllByBelumValidasi() {
        return pensLamaMeninggalViewRepository.findAllByBelumValidasi();
    }
}
