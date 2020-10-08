package com.dapenbi.dkpp.dto.component;

public class SortableListComponentDto extends BaseComponentDto {

    private String tag;

    private String tagStyle;

    private String value;

    public SortableListComponentDto() {
    }

    public SortableListComponentDto(String tag, String tagStyle, String value) {
        this.tag = tag;
        this.tagStyle = tagStyle;
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagStyle() {
        return tagStyle;
    }

    public void setTagStyle(String tagStyle) {
        this.tagStyle = tagStyle;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
