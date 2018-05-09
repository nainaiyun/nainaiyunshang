package com.nainai.smallprogram.common;

/**
 * Created by haopeng yan on 2018/5/2
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public enum  Enum {
    PRODUCT_OFFER_TYPE1("卖盘", 1),
    PRODUCT_OFFER_TYPE2("买盘", 2),
    PRODUCT_OFFER_MODE1("自由报盘", 3),
    PRODUCT_OFFER_MODE2("保证金", 4),
    PRODUCT_OFFER_MODE3("委托报盘", 5),
    PRODUCT_OFFER_MODE4("仓单报盘", 6),
    PRODUCT_OFFER_SUB_MODE1("自由报盘", 7),
    PRODUCT_OFFER_SUB_MODE2("保证金", 8),
    PRODUCT_OFFER_SUB_MODE3("委托报盘", 9);

    private String name;
    private int index;

    private Enum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    public static String getName(int index) {
        for (Enum c : Enum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
