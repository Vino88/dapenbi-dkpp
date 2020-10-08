package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.MutasiPerubahanFprFsDto;
import com.dapenbi.dkpp.form.CuspMutasiPerubahanFprFsSPDto;
import com.dapenbi.dkpp.form.CuspMutasiPrbhnFrsFsUpdSPDto;
import com.dapenbi.dkpp.model.MutasiPerubahanFprFs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MutasiPerubahanFprFsDao extends BaseDao<MutasiPerubahanFprFs, MutasiPerubahanFprFsDto, Long> {

    public Map processCuspMutasiPerubahanFprFs(CuspMutasiPerubahanFprFsSPDto spDto);

    public Map processCuspMutasiPrbhnFprFsUpd(CuspMutasiPrbhnFrsFsUpdSPDto spDto);
}