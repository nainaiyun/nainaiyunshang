package com.nainai.smallprogram.mapper;

import com.nainai.smallprogram.domain.ProductOffer;
import com.nainai.smallprogram.domain.Slide;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface SlideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Slide record);

    int insertSelective(Slide record);

    Slide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Slide record);

    int updateByPrimaryKey(Slide record);

    /**
     * 查询轮播图类表
     * @param map
     * @return
     */
    @SelectProvider(type = SlideProvider.class, method = "findSlide")
    List<Slide> findSlide(Map<String ,Object> map);
    class SlideProvider {
        public String findSlide(Map<String ,Object> map) {
            return new SQL(){{
                SELECT("id,name,img,link,bgcolor,status,`order`");
                FROM("slide");
                if(map.get("id")!=null){
                    WHERE("id = #{id}");
                }
                if(map.get("name")!=null){
                    WHERE("name like  CONCAT('%',#{name},'%') ");
                }
                if(map.get("status")!=null){
                    WHERE("status = #{status} ");
                }
            }}.toString();
        }
    }
}