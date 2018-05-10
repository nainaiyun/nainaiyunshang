package com.nainai.smallprogram.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ProductOffer {

    /*报盘id*/private Integer id;
    /*店铺id*/private String shopId;
    /*店铺分类id*/private String classifyId;
    /*店铺模块id*/private String moduleId;
    /*店铺导航id*/private String navigationId;
    /*报盘编号*/private String offerNo;
    /*用户编号*/private Integer userId;
    /*报盘类型：1：卖盘，2：买盘*/private Integer type;
    /*报盘模式：1：自由，2：保证金，3，委托，4:仓单*/private Integer mode;
    /*默认0,1：竞价，2：一口价*/private Byte subMode;
    /*商品id*/private Integer productId;
    /*商品名*/private String proName;
    /*原来的offer的id，对于竞价和一口价报盘有效*/private Integer oldOffer;
    /*商品单价*/private BigDecimal price;
    /*采购最低价*/private BigDecimal priceL;
    /*采购最高价*/private BigDecimal priceR;
    /*是否拆分，1：可以，0：不可*/private Integer divide;
    /*最小起订量*/private BigDecimal minimum;
    /**/private BigDecimal minstep;
    /*交收地点*/private String acceptArea;
    /*交收时间*/private Integer acceptDay;
    /*支付方式*/private String accType;
    /*报盘费率*/private BigDecimal offerFee;
    /*签字照片，委托报盘为委托书照片*/private String sign;
    /*审核状态*/private Integer status;
    /*0:正常，1：删除*/private Integer isDel;
    /*申请时间*/private Date applyTime;
    /*审核时间*/private Date finishTime;
    /*绑定的客服Id*/private Date expireTime;
    /**/private Integer kefu;
    /**/private String risk;
    /*是否投保*/private Integer insurance;
    /**/private String adminMsg;
    /**/private String other;
    /*计重方式*/private String weightType;
    /**/private Date startTime;
    /**/private Date endTime;
    /**/private BigDecimal maxNum;
    /*已售数量*/private BigDecimal sellNum;
    /*竞价交易的报价递增价格*/private BigDecimal jingStepprice;
    /**/private Integer offerSort;
    /*0:场外竞价，1：场内竞价*/private Byte jingjiaMode;
    /*场内竞价口令*/private String jingjiaPass;
    /*会员价格*/private BigDecimal priceVip;

    public ProductOffer(Integer id, String shopId, String classifyId, String moduleId, String navigationId, String offerNo, Integer userId, Integer type, Integer mode, Byte subMode, Integer productId, String proName, Integer oldOffer, BigDecimal price, BigDecimal priceL, BigDecimal priceR, Integer divide, BigDecimal minimum, BigDecimal minstep, String acceptArea, Integer acceptDay, String accType, BigDecimal offerFee, String sign, Integer status, Integer isDel, Date applyTime, Date finishTime, Date expireTime, Integer kefu, String risk, Integer insurance, String adminMsg, String other, String weightType, Date startTime, Date endTime, BigDecimal maxNum, BigDecimal sellNum, BigDecimal jingStepprice, Integer offerSort, Byte jingjiaMode, String jingjiaPass,BigDecimal priceVip) {
        this.id = id;
        this.shopId = shopId;
        this.classifyId = classifyId;
        this.moduleId = moduleId;
        this.navigationId = navigationId;
        this.offerNo = offerNo;
        this.userId = userId;
        this.type = type;
        this.mode = mode;
        this.subMode = subMode;
        this.productId = productId;
        this.proName = proName;
        this.oldOffer = oldOffer;
        this.price = price;
        this.priceL = priceL;
        this.priceR = priceR;
        this.divide = divide;
        this.minimum = minimum;
        this.minstep = minstep;
        this.acceptArea = acceptArea;
        this.acceptDay = acceptDay;
        this.accType = accType;
        this.offerFee = offerFee;
        this.sign = sign;
        this.status = status;
        this.isDel = isDel;
        this.applyTime = applyTime;
        this.finishTime = finishTime;
        this.expireTime = expireTime;
        this.kefu = kefu;
        this.risk = risk;
        this.insurance = insurance;
        this.adminMsg = adminMsg;
        this.other = other;
        this.weightType = weightType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxNum = maxNum;
        this.sellNum = sellNum;
        this.jingStepprice = jingStepprice;
        this.offerSort = offerSort;
        this.jingjiaMode = jingjiaMode;
        this.jingjiaPass = jingjiaPass;
        this.priceVip =priceVip;
    }

    public ProductOffer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOfferNo() {
        return offerNo;
    }

    public void setOfferNo(String offerNo) {
        this.offerNo = offerNo == null ? null : offerNo.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Byte getSubMode() {
        return subMode;
    }

    public void setSubMode(Byte subMode) {
        this.subMode = subMode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Integer getOldOffer() {
        return oldOffer;
    }

    public void setOldOffer(Integer oldOffer) {
        this.oldOffer = oldOffer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceL() {
        return priceL;
    }

    public void setPriceL(BigDecimal priceL) {
        this.priceL = priceL;
    }

    public BigDecimal getPriceR() {
        return priceR;
    }

    public void setPriceR(BigDecimal priceR) {
        this.priceR = priceR;
    }

    public Integer getDivide() {
        return divide;
    }

    public void setDivide(Integer divide) {
        this.divide = divide;
    }

    public BigDecimal getMinimum() {
        return minimum;
    }

    public void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }

    public BigDecimal getMinstep() {
        return minstep;
    }

    public void setMinstep(BigDecimal minstep) {
        this.minstep = minstep;
    }

    public String getAcceptArea() {
        return acceptArea;
    }

    public void setAcceptArea(String acceptArea) {
        this.acceptArea = acceptArea == null ? null : acceptArea.trim();
    }

    public Integer getAcceptDay() {
        return acceptDay;
    }

    public void setAcceptDay(Integer acceptDay) {
        this.acceptDay = acceptDay;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType == null ? null : accType.trim();
    }

    public BigDecimal getOfferFee() {
        return offerFee;
    }

    public void setOfferFee(BigDecimal offerFee) {
        this.offerFee = offerFee;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getKefu() {
        return kefu;
    }

    public void setKefu(Integer kefu) {
        this.kefu = kefu;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk == null ? null : risk.trim();
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public String getAdminMsg() {
        return adminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.adminMsg = adminMsg == null ? null : adminMsg.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType == null ? null : weightType.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(BigDecimal maxNum) {
        this.maxNum = maxNum;
    }

    public BigDecimal getSellNum() {
        return sellNum;
    }

    public void setSellNum(BigDecimal sellNum) {
        this.sellNum = sellNum;
    }

    public BigDecimal getJingStepprice() {
        return jingStepprice;
    }

    public void setJingStepprice(BigDecimal jingStepprice) {
        this.jingStepprice = jingStepprice;
    }

    public Integer getOfferSort() {
        return offerSort;
    }

    public void setOfferSort(Integer offerSort) {
        this.offerSort = offerSort;
    }

    public Byte getJingjiaMode() {
        return jingjiaMode;
    }

    public void setJingjiaMode(Byte jingjiaMode) {
        this.jingjiaMode = jingjiaMode;
    }

    public String getJingjiaPass() {
        return jingjiaPass;
    }

    public void setJingjiaPass(String jingjiaPass) {
        this.jingjiaPass = jingjiaPass == null ? null : jingjiaPass.trim();
    }

    public BigDecimal getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(BigDecimal priceVip) {
        this.priceVip = priceVip;
    }
}