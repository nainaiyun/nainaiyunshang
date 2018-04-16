package com.nainai.user.mapper;

import com.nainai.user.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select  * from user where username=#{username}")
    @Results({
            @Result(column = "agent_pass", property = "agentPass")
    })
    User selectUserByUserName(String username);

}