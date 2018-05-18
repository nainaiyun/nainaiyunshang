package com.nainai.user.mapper;

import com.nainai.user.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Results( id = "UserResults",value = {
            @Result(column = "agent_pass", property = "agentPass")
    })
    @Select("select  * from user where username=#{username}")
    User selectUserByUserName(String username);


    @Select("select  * from user where mobile=#{mobile}")
    @ResultMap("UserResults")
    User selectUserByMobile(String mobile);


    @Select("select  * from user where open_id=#{openId}")
    @ResultMap("UserResults")
    User selectUserByOpenId(String openId);
}