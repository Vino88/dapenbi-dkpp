package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.PmbyAngsuranLebihBayarDetDto;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarDet;
import com.dapenbi.dkpp.model.PmbyAngsuranLebihBayarHead;
import org.springframework.stereotype.Service;


public interface PmbyAngsuranLebihBayarDetDao extends BaseDao<PmbyAngsuranLebihBayarDet, PmbyAngsuranLebihBayarDetDto,Long> {

    Iterable<PmbyAngsuranLebihBayarDet>findAllByPmbyAngsuranLebihBayarHead(PmbyAngsuranLebihBayarHead pmbyAngsuranLebihBayarHead);
}
