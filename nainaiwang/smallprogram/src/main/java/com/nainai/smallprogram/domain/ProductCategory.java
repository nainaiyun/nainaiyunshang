package com.nainai.smallprogram.domain;

public class ProductCategory {
    /*分类id*/private Integer id;
    /**/private String code;
    /*分类名称*/private String name;
    /*下级分类统称*/private String childname;
    /*商品计量单位，向下继承*/private String unit;
    /*预付款比率，0到100之间*/private Integer percent;
    /*父类id*/private Integer pid;
    /*关联的属性，多个已，相隔*/private String attrs;
    /**/private Integer sort;
    /*状态,0：关闭，1：开启*/private Integer status;
    /*备注*/private String note;
    /*0:正常，1：删除*/private Integer isDel;
    /*图片链接*/private String img;
    /**/private String riskData;

    public ProductCategory(Integer id, String code, String name, String childname, String unit, Integer percent, Integer pid, String attrs, Integer sort, Integer status, String note, Integer isDel, String img, String riskData) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.childname = childname;
        this.unit = unit;
        this.percent = percent;
        this.pid = pid;
        this.attrs = attrs;
        this.sort = sort;
        this.status = status;
        this.note = note;
        this.isDel = isDel;
        this.img = img;
        this.riskData = riskData;
    }

    public ProductCategory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname == null ? null : childname.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs == null ? null : attrs.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getRiskData() {
        return riskData;
    }

    public void setRiskData(String riskData) {
        this.riskData = riskData == null ? null : riskData.trim();
    }
}