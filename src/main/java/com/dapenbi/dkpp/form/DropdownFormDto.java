package com.dapenbi.dkpp.form;

import com.dapenbi.dkpp.util.StringUtil;

import java.util.List;
import java.util.Map;

public class DropdownFormDto {

    private String valueColumn;

    private String textColumn;

    private String searchParam;

    private List<Map<String, String>> referenceValue;

    private String referenceValueType;

    private Boolean includeObject;

    public String getValueColumn() {
        return valueColumn;
    }

    public void setValueColumn(String valueColumn) {
        this.valueColumn = valueColumn;
    }

    public String getTextColumn() {
        return textColumn;
    }

    public void setTextColumn(String textColumn) {
        this.textColumn = textColumn;
    }

    public String getSearchParam() {
        return StringUtil.nullToEmpty(searchParam);
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public List<Map<String, String>> getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(List<Map<String, String>> referenceValue) {
        this.referenceValue = referenceValue;
    }

    public Boolean getIncludeObject() {
        return includeObject;
    }

    public void setIncludeObject(Boolean includeObject) {
        this.includeObject = includeObject;
    }

    public String getReferenceValueType() {
        return referenceValueType;
    }

    public void setReferenceValueType(String referenceValueType) {
        this.referenceValueType = referenceValueType;
    }
}
