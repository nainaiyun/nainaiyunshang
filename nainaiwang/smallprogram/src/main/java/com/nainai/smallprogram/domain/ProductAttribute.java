package com.nainai.smallprogram.domain;

public class ProductAttribute {
    /*属性编号*/private Integer id;
    /*属性名称*/private String name;
    /*状态*/private Integer status;
    /*类型：1：输入框，2：单选，3：多选*/private Integer type;
    /*排序*/private Integer sort;
    /*备注*/private String note;
    /*可选的值，可以为空，多个以，相隔*/private String value;

    public ProductAttribute(Integer id, String name, Integer status, Integer type, Integer sort, String note) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.type = type;
        this.sort = sort;
        this.note = note;
    }

    public ProductAttribute(Integer id, String name, Integer status, Integer type, Integer sort, String note, String value) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.type = type;
        this.sort = sort;
        this.note = note;
        this.value = value;
    }

    public ProductAttribute() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}