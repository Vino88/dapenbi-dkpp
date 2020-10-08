package com.dapenbi.dkpp.dao.impl;

import com.dapenbi.dkpp.dao.BaseDao;
import com.dapenbi.dkpp.model.BaseModel;
import com.dapenbi.dkpp.repository.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseDaoImpl<T extends BaseModel, D, ID> implements BaseDao<T, D, ID> {

    private BaseRepository baseRepository;

    public BaseDaoImpl(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T save(T model) {
        return (T) baseRepository.save(model);
    }

    public Iterable<T> save(Iterable<T> model) {
        return (Iterable<T>) baseRepository.save(model);
    }

    public Iterable findAll() {
        return baseRepository.findAll();
    }

    public Iterable findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    public Iterable findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    public Iterable findAll(String[] column, String searchParam, Pageable pageable) {
        return baseRepository.findAll(column, searchParam, pageable);
    }

    public Iterable findAllActive() {
        return baseRepository.findAllActive();
    }

    public Iterable findAllActive(Sort sort) {
        return baseRepository.findAllActive(sort);
    }

    public Iterable findAllActive(Pageable pageable) {
        return baseRepository.findAllActive(pageable);
    }

    public T findById(ID id) {
        return (T) baseRepository.findById(id).get();
    }

    public List<D> toListDto(List<T> listModel) {
        return (List<D>) listModel.stream().map(
                BaseModel::toDto
        ).collect(Collectors.toList());
    }

    public List getDropdownList(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, Boolean includeObject) {
        return baseRepository.selectDropdown(valueColumn, textColumn, filterColumns, searchParam, referenceValues, includeObject);
    }

    public List getDropdownList(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, String referenceValueType, Boolean includeObject) {
        return baseRepository.selectDropdown(valueColumn, textColumn, filterColumns, searchParam, referenceValues, referenceValueType, includeObject);
    }
}
