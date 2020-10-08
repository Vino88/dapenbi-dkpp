package com.dapenbi.dkpp.dto.component;

public class CardComponentDto extends BaseComponentDto {

    private String iconTitle;

    private String title;

    private String description;

    private String subtitle;

    private String cardStyle;

    private String textTitleStyle;

    private String textDescStyle;

    private String textSubStyle;

    private int smSize;

    private int mdSize;

    private int lgSize;

    public CardComponentDto() {
    }

    public CardComponentDto(String iconTitle, String title, String description, String subtitle) {
        this.iconTitle = iconTitle;
        this.title = title;
        this.description = description;
        this.subtitle = subtitle;
        this.cardStyle = "";
        this.textTitleStyle = "";
        this.textDescStyle = "";
        this.textSubStyle = "";
        this.smSize = 4;
        this.mdSize = 2;
        this.mdSize = 3;
    }

    public CardComponentDto(String iconTitle, String title, String description, String subtitle, String cardStyle, String textTitleStyle, String textDescStyle, String textSubStyle) {
        this.iconTitle = iconTitle;
        this.title = title;
        this.description = description;
        this.subtitle = subtitle;
        this.cardStyle = cardStyle;
        this.textTitleStyle = textTitleStyle;
        this.textDescStyle = textDescStyle;
        this.textSubStyle = textSubStyle;
        this.smSize = 4;
        this.mdSize = 2;
        this.mdSize = 3;
    }

    public String getIconTitle() {
        return iconTitle;
    }

    public void setIconTitle(String iconTitle) {
        this.iconTitle = iconTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getCardStyle() {
        return cardStyle;
    }

    public void setCardStyle(String cardStyle) {
        this.cardStyle = cardStyle;
    }

    public String getTextTitleStyle() {
        return textTitleStyle;
    }

    public void setTextTitleStyle(String textTitleStyle) {
        this.textTitleStyle = textTitleStyle;
    }

    public String getTextDescStyle() {
        return textDescStyle;
    }

    public void setTextDescStyle(String textDescStyle) {
        this.textDescStyle = textDescStyle;
    }

    public String getTextSubStyle() {
        return textSubStyle;
    }

    public void setTextSubStyle(String textSubStyle) {
        this.textSubStyle = textSubStyle;
    }

    public int getSmSize() {
        return smSize;
    }

    public void setSmSize(int smSize) {
        this.smSize = smSize;
    }

    public int getMdSize() {
        return mdSize;
    }

    public void setMdSize(int mdSize) {
        this.mdSize = mdSize;
    }

    public int getLgSize() {
        return lgSize;
    }

    public void setLgSize(int lgSize) {
        this.lgSize = lgSize;
    }
}
