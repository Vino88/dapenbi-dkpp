package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.dto.component.Select2Default;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    Page<T> findAll(String[] column, String searchParam, Pageable pageable);

    Iterable<T> findAllActive();

    Iterable<T> findAllActive(Sort sort);

    Page<T> findAllActive(Pageable pageable);

    Iterable<T> findAllActive(Iterable<ID> ids);

    T findOneActive(ID id);

    long countActive();

    boolean existActive(ID id);

    List<Select2Default> selectDropdown(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, Boolean includeObject);

    List<Select2Default> selectDropdown(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, String referenceValueType, Boolean includeObject);

    Map callStoredProcedure(String spName, Map<String, Object> inParam, List<String> outParam);

    void callStoredProcedure(String spName, Map<String, Object> inParam);
}
