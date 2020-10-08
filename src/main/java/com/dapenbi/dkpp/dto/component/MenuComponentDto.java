package com.dapenbi.dkpp.dto.component;

import java.util.ArrayList;

public class MenuComponentDto extends BaseComponentDto {
    String title;

    String icon;

    String path;

    String style;

    ArrayList<MenuComponentDto> children;

    public MenuComponentDto() {
    }

    public MenuComponentDto(String title, ArrayList<MenuComponentDto> children) {
        this.title = title;
        this.icon = "";
        this.path = "";
        this.style = "";
        this.children = children;
    }

    /**
     * @param title
     * @param icon
     * @param path
     */
    public MenuComponentDto(String title, String icon, String path) {
        this.title = title;
        this.icon = icon;
        this.path = path;
        this.style = "";
    }

    /**
     * @param title
     * @param icon
     * @param path
     * @param style
     */
    public MenuComponentDto(String title, String icon, String path, String style) {
        this.title = title;
        this.icon = icon;
        this.path = path;
        this.style = style;
    }

    /**
     * @param title
     * @param icon
     * @param path
     * @param roles
     */
    public MenuComponentDto(String title, String icon, String path, ArrayList<String> roles) {
        this.title = title;
        this.icon = icon;
        this.path = path;
        this.style = "text-success";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
