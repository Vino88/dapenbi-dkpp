package com.dapenbi.dkpp.form;

import java.util.Map;

public class MenuFormDto extends BaseFormDto{
    private Long idMenu;
    private Map active;
    private String userStamp;
    private String icon;
    private Long menuOrder;
    private Long parent;
    private String path;
    private Long sidebar;
    private String style;
    private String title;

    public Map getActive() {
        return active;
    }

    public void setActive(Map active) {
        this.active = active;
    }

    public void setIdMenu(Long idMenu){
        this.idMenu = idMenu;
    }

    public Long getIdMenu(){
        return this.idMenu;
    }

    public void setUserStamp(String userStamp){
        this.userStamp = userStamp;
    }

    public String getUserStamp(){
        return this.userStamp;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getIcon(){
        return this.icon;
    }

    public void setMenuOrder(Long menuOrder){
        this.menuOrder = menuOrder;
    }

    public Long getMenuOrder(){
        return this.menuOrder;
    }

    public void setParent(Long parent){
        this.parent = parent;
    }

    public Long getParent(){
        return this.parent;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public void setSidebar(Long sidebar){
        this.sidebar = sidebar;
    }

    public Long getSidebar(){
        return this.sidebar;
    }

    public void setStyle(String style){
        this.style = style;
    }

    public String getStyle(){
        return this.style;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
