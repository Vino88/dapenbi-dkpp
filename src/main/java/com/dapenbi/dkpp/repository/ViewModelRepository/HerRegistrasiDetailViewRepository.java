package com.dapenbi.dkpp.repository.ViewModelRepository;

import com.dapenbi.dkpp.repository.BaseRepository;
import com.dapenbi.dkpp.model.ViewModel.HerRegistrasiDetailView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface HerRegistrasiDetailViewRepository extends BaseRepository<HerRegistrasiDetailView, Long> {
    @Query(
            value = "select herDetail from HerRegistrasiDetailView herDetail where herDetail.tahunHer = ?1 or (herDetail.nip like ?2 or lower(herDetail.namaPeserta) like lower(?2) or herDetail.tahunHer like ?2)"
    )
    Page<HerRegistrasiDetailView> findByTahunHer(String tahunHer, String searchParam , Pageable pageable);
}
