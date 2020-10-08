package com.dapenbi.dkpp.dto.component;

public class AlertMessageComponentDto extends BaseComponentDto {

    private String style;

    private String message;

    public AlertMessageComponentDto() {
    }

    public AlertMessageComponentDto(String style, String message) {
        this.style = style;
        this.message = message;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
