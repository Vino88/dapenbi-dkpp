package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.UploadMutasiFprFsDto;
import com.dapenbi.dkpp.form.CuspInsertFaktorFprFsSPDto;
import com.dapenbi.dkpp.model.UploadMutasiFprFs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface UploadMutasiFprFsDao extends BaseDao<UploadMutasiFprFs, UploadMutasiFprFsDto, Long> {

    Map processCuspInsertFaktorFprFs(CuspInsertFaktorFprFsSPDto spDto);

}