package com.nainai.smallprogram.mapper;

import com.nainai.smallprogram.domain.Bid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bid record);

    int insertSelective(Bid record);

    Bid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bid record);

    int updateByPrimaryKey(Bid record);
}