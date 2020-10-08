package com.dapenbi.dkpp.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface BaseDao<T, D, ID> {

    T save(T model);

    Iterable<T> save(Iterable<T> model);

    Iterable<T> findAll(String[] column, String value, Pageable pageable);

    Iterable<T> findAll();

    Iterable<T> findAll(Sort sort);

    Iterable<T> findAll(Pageable pageable);

    Iterable<T> findAllActive();

    Iterable<T> findAllActive(Sort sort);

    Iterable<T> findAllActive(Pageable pageable);

    T findById(ID id);

    List getDropdownList(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, Boolean includeObject);

    List getDropdownList(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, String referenceValueType, Boolean includeObject);
}
