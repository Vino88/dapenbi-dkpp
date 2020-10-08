package com.dapenbi.dkpp.dao;


import com.dapenbi.dkpp.dto.UploadRekVersiMandiriDto;
import com.dapenbi.dkpp.model.UploadRekVersiMandiri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UploadRekVersiMandiriDao extends BaseDao<UploadRekVersiMandiri, UploadRekVersiMandiriDto, String> {
    void deleteAll();
}