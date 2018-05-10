package com.nainai.smallprogram.domain;

public class Slide {
    private Integer id;

    private String name;

    private String img;

    private String link;

    private String bgcolor;

    private Byte status;

    private Integer order;

    public Slide(Integer id, String name, String img, String link, String bgcolor, Byte status, Integer order) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.link = link;
        this.bgcolor = bgcolor;
        this.status = status;
        this.order = order;
    }

    public Slide() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor == null ? null : bgcolor.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}