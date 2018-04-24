package com.nainai.mobile.mapper;

import com.nainai.mobile.domain.ProductOffer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductOfferMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductOffer record);

    int insertSelective(ProductOffer record);

    ProductOffer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductOffer record);

    int updateByPrimaryKey(ProductOffer record);

    @Select("select * from product_offer ")
    List<ProductOffer> selectAllProductOffer();
}