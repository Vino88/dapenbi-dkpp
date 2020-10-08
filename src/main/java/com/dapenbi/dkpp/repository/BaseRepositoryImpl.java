package com.dapenbi.dkpp.repository;

import com.dapenbi.dkpp.dto.component.Select2Default;
import com.dapenbi.dkpp.model.BaseModel;
import com.dapenbi.dkpp.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final JpaEntityInformation<T, ?> entityInformation;

    private final EntityManager em;

    private final Class<T> domainClass;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.domainClass = domainClass;
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, em);
    }

    @Override
    public Iterable<T> findAllActive() {
        return super.findAll(Specification.where(new IsStatusActive()));
    }

    @Override
    public Iterable<T> findAllActive(Sort sort) {
        return super.findAll(new IsStatusActive(), sort);
    }

    @Override
    public Page<T> findAllActive(Pageable pageable) {
        return super.findAll(new IsStatusActive(), pageable);
    }

    @Override
    public Iterable<T> findAllActive(Iterable<ID> ids) {
        return super.findAllById(ids);
    }

    @Override
    public T findOneActive(ID id) {
        return null;
    }

    @Override
    public long countActive() {
        return 0;
    }

    @Override
    public boolean existActive(ID id) {
        return false;
    }

    public List<Select2Default> selectDropdown(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, Boolean includeObject) {
        Specification specification = null;

        specification = specificationFilter(filterColumns, searchParam);

        specification = specification == null ? new IsStatusActive() : specification.and(new IsStatusActive());

        if (referenceValues != null) {
            for (Map<String, String> referenceValue : referenceValues) {
                String referenceColumn = referenceValue.get("column") == null ? "id" : referenceValue.get("column");
                if (specification == null) {
                    specification = new FilterAll<T>(referenceColumn, referenceValue.get("value"), referenceValue.get("table"));
                } else {
                    specification = specification.and(new FilterAll<T>(referenceColumn, referenceValue.get("value"), referenceValue.get("table")));
                }
            }
        }

        List<T> list = super.findAll(specification);

        List<Select2Default> selectList = new ArrayList<>();

        try {
            Method fieldValue = entityInformation.getJavaType().getMethod("get" + StringUtils.capitalize(valueColumn));

            Map<String, Method> fieldTexts = new HashMap<>();

            Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
            Matcher matcher = pattern.matcher(textColumn);
            while (matcher.find()) {
                fieldTexts.put(matcher.group(), entityInformation.getJavaType().getMethod("get" + StringUtils.capitalize(matcher.group(1))));
            }

            selectList = list.stream().map((l) -> {
                try {
                    String value = fieldValue.invoke(l).toString();
                    String text = textColumn;
                    for (Map.Entry<String, Method> entry : fieldTexts.entrySet()) {
                        text = StringUtil.toString(text).replace(entry.getKey(), StringUtil.toString(entry.getValue().invoke(l)));
                    }
                    if (includeObject) {
                        Method toDto = entityInformation.getJavaType().getMethod("toDto");
                        return new Select2Default(value, text, toDto.invoke(l));
                    } else {
                        return new Select2Default(value, text);
                    }
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }

                return new Select2Default("", "");
            }).collect(Collectors.toList());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return selectList;
    }

    public List<Select2Default> selectDropdown(String valueColumn, String textColumn, List<String> filterColumns, String searchParam, List<Map<String, String>> referenceValues, String referenceValueType, Boolean includeObject) {
        Specification specification = null;

        specification = specificationFilter(filterColumns, searchParam);

        specification = specification == null ? new IsStatusActive() : specification.and(new IsStatusActive());

        if (referenceValues != null) {
            int length = referenceValues.size();
            int ctr = 0;
            for (Map<String, String> referenceValue : referenceValues) {
                String referenceColumn = referenceValue.get("column") == null ? "id" : referenceValue.get("column");
                if (specification == null) {
                    specification = new FilterAll<T>(referenceColumn, referenceValue.get("value"), referenceValue.get("table"));
                } else {
                    if(ctr == 0)
                        specification = specification.and(new FilterAll<T>(referenceColumn, referenceValue.get("value"), referenceValue.get("table")));
                    else
                        specification = specification.or(new FilterAll<T>(referenceColumn, referenceValue.get("value"), referenceValue.get("table")));
                }

                ctr++;
            }
        }

        List<T> list = super.findAll(specification);

        List<Select2Default> selectList = new ArrayList<>();

        try {
            Method fieldValue = entityInformation.getJavaType().getMethod("get" + StringUtils.capitalize(valueColumn));

            Map<String, Method> fieldTexts = new HashMap<>();

            Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
            Matcher matcher = pattern.matcher(textColumn);
            while (matcher.find()) {
                fieldTexts.put(matcher.group(), entityInformation.getJavaType().getMethod("get" + StringUtils.capitalize(matcher.group(1))));
            }

            selectList = list.stream().map((l) -> {
                try {
                    String value = fieldValue.invoke(l).toString();
                    String text = textColumn;
                    for (Map.Entry<String, Method> entry : fieldTexts.entrySet()) {
                        text = StringUtil.toString(text).replace(entry.getKey(), StringUtil.toString(entry.getValue().invoke(l)));
                    }
                    if (includeObject) {
                        Method toDto = entityInformation.getJavaType().getMethod("toDto");
                        return new Select2Default(value, text, toDto.invoke(l));
                    } else {
                        return new Select2Default(value, text);
                    }
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }

                return new Select2Default("", "");
            }).collect(Collectors.toList());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return selectList;
    }

    private StoredProcedureQuery generateSP(String spName, Map<String, Object> inParams) {
        StoredProcedureQuery sp = this.em.createNamedStoredProcedureQuery(spName);

        inParams.keySet().forEach(p -> sp.setParameter(p, inParams.get(p)));
        sp.execute();

        return sp;
    }

    public Map callStoredProcedure(String spName, Map<String, Object> inParams, List<String> outParams) {
        Map<String, Object> outResult = new HashMap<>();
         StoredProcedureQuery sp = this.generateSP(spName, inParams);

        outParams.forEach(p -> outResult.put(p, sp.getOutputParameterValue(p)));

        return outResult;
    }

    public void callStoredProcedure(String spName, Map<String, Object> inParams) {
        StoredProcedureQuery sp = this.generateSP(spName, inParams);
    }

    public Specification specificationFilter(List<String> filterColumns, String searchParam) {
        Specification specification = null;

        if (filterColumns != null) {
            for (String filterColumn : filterColumns) {
                if (specification == null) {
                    specification = new FilterAll<T>(filterColumn, searchParam);
                } else {
                    specification = specification.or(new FilterAll<T>(filterColumn, searchParam));
                }
            }
        }
        return specification;
    }

    public Page<T> findAll(String[] filterColumns, String searchParam, Pageable pageable) {
        Specification specification = null;

        for (String filterColumn : filterColumns) {
            if (specification == null) {
                specification = new FilterAll<T>(filterColumn, searchParam);
            } else {
                specification = specification.or(new FilterAll<T>(filterColumn, searchParam));
            }
        }

        return super.findAll(specification, pageable);
    }

    private static final class IsStatusActive<T> implements Specification<T> {
        @Override
        public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            return cb.equal(root.get("isActive"), true);
        }
    }

    private static final class FilterAll<T> implements Specification<T> {

        private String column;
        private String value;
        private String referenceTable;

        public FilterAll(String column, String value) {
            this.column = column;
            this.value = value;
        }

        public FilterAll(String column, String value, String referenceTable) {
            this.column = column;
            this.value = value;
            this.referenceTable = referenceTable;
        }

        public Predicate generatePredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, Class modelClass, Constructor ctor) {
            try {
                Class referenceColumnType = modelClass.getDeclaredField(this.column).getType();

                if (Number.class.isAssignableFrom(referenceColumnType)) {
                    Number value = (Number) referenceColumnType.getMethod("valueOf", String.class).invoke(null, this.value);

                    if (this.referenceTable == null) {
                        return cb.equal(
                                root.get(this.column)
                                , value);
                    } else {
                        if (this.column.equals("id")) {
                            Object o = ctor.newInstance();
                            modelClass.getMethod("set" + StringUtils.capitalize(this.column), referenceColumnType).invoke(o, value);

                            return cb.equal(
                                    root.get(this.referenceTable)
                                    , o);
                        } else {
                            return cb.equal(
                                    root.get(this.referenceTable).get(this.column)
                                    , value);
                        }
                    }
                } else {
                    String value = this.value.toLowerCase();

                    if (this.referenceTable == null) {
                        return cb.like(
                                cb.lower(
                                        root.get(this.column)
                                ), value);
                    } else {
                        if (this.column.equals("id")) {
                            Object o = ctor.newInstance();
                            modelClass.getMethod("set" + StringUtils.capitalize(this.column), referenceColumnType).invoke(o, value);

                            return cb.equal(
                                    root.get(this.referenceTable)
                                    , o);
                        } else {
                            return cb.like(
                                    cb.lower(
                                            root.get(this.referenceTable).get(this.column)
                                    ), value);
                        }
                    }
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException | InstantiationException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            if (!StringUtil.isNullOrEmpty(this.referenceTable) && BaseModel.class.isAssignableFrom(root.get(this.referenceTable).getModel().getBindableJavaType())) {
                Class modelClass = root.get(this.referenceTable).getModel().getBindableJavaType();
                Constructor ctor = modelClass.getConstructors()[0];

                return this.generatePredicate(root, query, cb, modelClass, ctor);
            } else {
                Class modelClass = root.getModel().getBindableJavaType();
                Constructor ctor = modelClass.getConstructors()[0];

                return this.generatePredicate(root, query, cb, modelClass, ctor);
            }
        }
    }
}
