package com.nainai.mobile.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Products {
    private Integer id;

    private Integer userId;

    private String shopId;

    private String classifyId;

    private String moduleId;

    private String navigationId;

    private String name;

    private Integer marketId;

    private Integer cateId;

    private String attribute;

    private String unit;

    private String produceArea;

    private Integer currency;

    private BigDecimal quantity;

    private BigDecimal freeze;

    private BigDecimal sell;

    private Date createTime;

    private Integer sort;

    private String note;

    private String img;

    public Products(Integer id, Integer userId, String shopId, String classifyId, String moduleId, String navigationId, String name, Integer marketId, Integer cateId, String attribute, String unit, String produceArea, Integer currency, BigDecimal quantity, BigDecimal freeze, BigDecimal sell, Date createTime, Integer sort, String note, String img) {
        this.id = id;
        this.userId = userId;
        this.shopId = shopId;
        this.classifyId = classifyId;
        this.moduleId = moduleId;
        this.navigationId = navigationId;
        this.name = name;
        this.marketId = marketId;
        this.cateId = cateId;
        this.attribute = attribute;
        this.unit = unit;
        this.produceArea = produceArea;
        this.currency = currency;
        this.quantity = quantity;
        this.freeze = freeze;
        this.sell = sell;
        this.createTime = createTime;
        this.sort = sort;
        this.note = note;
        this.img = img;
    }

    public Products() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(String navigationId) {
        this.navigationId = navigationId == null ? null : navigationId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getProduceArea() {
        return produceArea;
    }

    public void setProduceArea(String produceArea) {
        this.produceArea = produceArea == null ? null : produceArea.trim();
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getFreeze() {
        return freeze;
    }

    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}