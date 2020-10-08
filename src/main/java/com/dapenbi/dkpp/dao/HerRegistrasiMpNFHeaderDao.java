package com.dapenbi.dkpp.dao;

import com.dapenbi.dkpp.dto.HerRegistrasiMpNFHeaderDto;
import com.dapenbi.dkpp.form.CuspHerRegistrasiNFProses;
import com.dapenbi.dkpp.form.CuspHerRegistrasiNFUpdate;
import com.dapenbi.dkpp.model.HerRegistrasiMpNFHeader;

import java.util.Map;

public interface HerRegistrasiMpNFHeaderDao extends BaseDao<HerRegistrasiMpNFHeader, HerRegistrasiMpNFHeaderDto, String> {

    Map CuspHerRegistrasiNFProses (CuspHerRegistrasiNFProses spDtoProses);
    Map CuspHerRegistrasiNFUpdate (CuspHerRegistrasiNFUpdate spDtoUpdate);
    HerRegistrasiMpNFHeader findFirstByTahunHer(String tahun);

}
