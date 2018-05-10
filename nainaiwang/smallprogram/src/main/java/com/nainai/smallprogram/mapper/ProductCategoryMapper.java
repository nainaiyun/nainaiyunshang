package com.nainai.smallprogram.mapper;

import com.nainai.smallprogram.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);

    /**
     * 查询分类
     * @param map
     * @return
     */
    @SelectProvider(type =ProductCategoryProvider.class, method = "findProductCategory")
    List<ProductCategory> findProductCategory(Map<String ,Object> map);
    class ProductCategoryProvider {
        public String findProductCategory(Map<String ,Object> map) {
            return new SQL(){{
                SELECT("*");
                FROM("product_category");
                if(map.get("id")!=null){
                    WHERE("id = #{id}");
                }
                if(map.get("name")!=null){
                    WHERE("name like  CONCAT('%',#{name},'%') ");
                }
                if(map.get("pid")!=null){
                    WHERE("pid = #{pid}");
                }
            }}.toString();
        }
    }
}