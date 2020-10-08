package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PembayaranMpDetailMpDto;
import com.dapenbi.dkpp.model.PembayaranMp;
import com.dapenbi.dkpp.model.PembayaranMpDetailMp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PembayaranMpDetailMpDao extends BaseDao<PembayaranMpDetailMp, PembayaranMpDetailMpDto,Long > {
   Page<PembayaranMpDetailMp> findAllByIdPembayaranSearch(Long idPembayaran, String searchParam, Pageable pageable);

   Page<PembayaranMpDetailMp> findAllByIdPembayaranSearchNull(Long idPembayaran, Pageable pageable);
}
