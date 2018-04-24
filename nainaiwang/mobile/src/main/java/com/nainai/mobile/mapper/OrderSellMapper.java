package com.nainai.mobile.mapper;

import com.nainai.mobile.domain.OrderSell;

public interface OrderSellMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSell record);

    int insertSelective(OrderSell record);

    OrderSell selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSell record);

    int updateByPrimaryKey(OrderSell record);
}