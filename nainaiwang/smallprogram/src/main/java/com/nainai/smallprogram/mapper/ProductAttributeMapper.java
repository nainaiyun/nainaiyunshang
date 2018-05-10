package com.nainai.smallprogram.mapper;

import com.nainai.smallprogram.domain.ProductAttribute;
import com.nainai.smallprogram.util.MapUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProductAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttribute record);

    int insertSelective(ProductAttribute record);

    ProductAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductAttribute record);

    int updateByPrimaryKeyWithBLOBs(ProductAttribute record);

    int updateByPrimaryKey(ProductAttribute record);


    @SelectProvider(type = ProductAttributeMapper.ProductAttributeProvider.class, method = "findProductAttributeById")
    List<ProductAttribute> findProductAttributeById(LinkedHashMap<String, Integer> map);

    class ProductAttributeProvider {
        public String findProductAttributeById(LinkedHashMap<String, Integer> map) {
            return new SQL() {{
                SELECT("*");
                FROM("product_attribute");
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    String i = entry.getKey();
                    if (map.get("" + i + "") != null) {
                        WHERE("id = #{" + i + "}");
                    }
                    Map.Entry<String, Integer> lastMap = MapUtil.getTail(map);
                    if (!entry.getKey().equals(lastMap.getKey())) {
                        OR();
                    }
                }
                AND();
                WHERE("status=1");
                ORDER_BY("sort asc");
            }}.toString();
        }
    }

}