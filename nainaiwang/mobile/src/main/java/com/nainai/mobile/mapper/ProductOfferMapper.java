package com.nainai.mobile.mapper;

import com.nainai.mobile.domain.ProductOffer;

public interface ProductOfferMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductOffer record);

    int insertSelective(ProductOffer record);

    ProductOffer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductOffer record);

    int updateByPrimaryKey(ProductOffer record);
}