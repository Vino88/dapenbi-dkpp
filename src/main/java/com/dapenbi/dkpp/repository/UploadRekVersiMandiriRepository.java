package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.model.UploadRekVersiMandiri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

	
public interface UploadRekVersiMandiriRepository extends BaseRepository<UploadRekVersiMandiri, String> {
    void deleteAll();
}