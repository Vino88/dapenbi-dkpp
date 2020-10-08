package com.dapenbi.dkpp.dto.component;

public class BreadcrumbHolderComponentDto extends BaseComponentDto {

    private String path;

    private String title;

    public BreadcrumbHolderComponentDto(String path, String title) {
        this.path = path;
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
