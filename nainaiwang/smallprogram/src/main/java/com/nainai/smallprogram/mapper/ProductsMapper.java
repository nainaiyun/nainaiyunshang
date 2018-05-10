package com.nainai.smallprogram.mapper;

import com.nainai.smallprogram.domain.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Products record);

    int insertSelective(Products record);

    Products selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Products record);

    int updateByPrimaryKey(Products record);

    /**
     * 查询商品的图片根据商品id
     * @param map
     * @return
     */
    @Results(id = "ProductsResults" ,value = {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "cate_id", property = "cateId"),
            @Result(column = "market_id", property = "marketId"),
            @Result(column = "produce_area", property = "produceArea"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "classify_id", property = "classifyId"),
            @Result(column = "module_id", property = "moduleId"),
            @Result(column = "navigation_id", property = "navigationId"),
            @Result(column = "attr_json", property = "attrJson"),


            @Result(column = "product_id", property = "productId"),
            @Result(column = "photos_id", property = "photosId"),
            @Result(column = "photos_img", property = "photosImg"),
    })
    @SelectProvider(type = ProductsMapper.FindProductsPhotosProvider.class, method = "findProductsPhotos")
    List<Map<String,Object>> findProductsPhotos(Map map);
    class FindProductsPhotosProvider{
        public String findProductsPhotos(Map map) {
            return new SQL() {{
                SELECT("p.id 'product_id',i.id 'photos_id',i.img 'photos_img'");
                FROM("products p");
                RIGHT_OUTER_JOIN("product_photos i on p.id=i.products_id ");
                if (map.get("productId") != null) {
                    WHERE("p.id=#{productId}");
                }
                ORDER_BY("i.id desc");
            }}.toString();
        }
    }
}