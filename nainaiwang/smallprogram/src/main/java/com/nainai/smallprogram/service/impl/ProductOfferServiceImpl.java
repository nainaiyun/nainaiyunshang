package com.nainai.smallprogram.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nainai.smallprogram.domain.ProductOffer;
import com.nainai.smallprogram.mapper.ProductOfferMapper;
import com.nainai.smallprogram.service.ProductOfferService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/4/19
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service("productOfferService")
public class ProductOfferServiceImpl implements ProductOfferService {
    @Autowired
    private ProductOfferMapper productOfferMapper;

    @Override
    public JSONObject deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public JSONObject insert(ProductOffer record) {
        return null;
    }

    @Override
    public JSONObject insertSelective(ProductOffer record) {

        return null;
    }

    @Override
    public JSONObject selectByPrimaryKey(Integer id) {
        JSONObject jsonObject = new JSONObject();
        PageHelper.startPage(1, 10);
        Optional<ProductOffer> optional = Optional.ofNullable(productOfferMapper.selectByPrimaryKey(id));
        optional.ifPresent(e -> jsonObject.put("productOffer", e));
        long count = PageHelper.count(() -> productOfferMapper.selectByPrimaryKey(id));
        jsonObject.put("count", count);
        return jsonObject;
    }



    @Override
    public JSONObject updateByPrimaryKeySelective(ProductOffer record) {
        return null;
    }

    @Override
    public JSONObject updateByPrimaryKey(ProductOffer record) {
        return null;
    }


    @Override
    public JSONObject selectAllByProductName(Integer pageNum, Integer pageSize,String productName) {
        JSONObject jsonObject = new JSONObject();
        Page page =PageHelper.startPage(pageNum, pageSize);
        Optional<List<Map<String, String>>> optional = Optional.ofNullable(productOfferMapper.selectAllByProductName(productName));
        optional.ifPresent(e -> jsonObject.put("productOffer", e));
        Integer count = Integer.parseInt(String.valueOf(page.getTotal()));
        Integer size =page.size();
        jsonObject.put("count", count);
        jsonObject.put("size", size);
        return jsonObject;
    }

    @Override
    public JSONObject findProductOffer(ProductOffer productOffer) {

        JSONObject jsonObject = new JSONObject();
        Optional<List<ProductOffer>> optional = Optional.ofNullable(productOfferMapper.findProductOffer(productOffer));
        optional.ifPresent(e -> jsonObject.put("productOffer", e));
        return jsonObject;
    }

}
//
//
//package com.nainai.smallprogram.mapper;
//
//        import com.nainai.smallprogram.domain.ProductOffer;
//        import org.apache.ibatis.annotations.Mapper;
//        import org.apache.ibatis.annotations.Select;
//        import org.apache.ibatis.annotations.SelectProvider;
//        import org.apache.ibatis.jdbc.SQL;
//
//        import java.util.List;
//        import java.util.Map;
//
//@Mapper
//public interface ProductOfferMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(ProductOffer record);
//
//    int insertSelective(ProductOffer record);
//
//    ProductOffer selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(ProductOffer record);
//
//    int updateByPrimaryKey(ProductOffer record);
//
//    /**
//     * 根据条件查询商品列表
//     * @return
//     */
//    @Select("select o.shop_id,p.id'product_id',o.id'offer_id',p.name'product_name'," +
//            "p.note'product_note' ,p.img,p.unit ,p.currency,o.price " +
//            "from product_offer o left join products p on o.product_id = p.id " +
//            "where  p.name like  CONCAT('%',#{0},'%') " +
//            "and status=1 order by create_time asc")
//    List<Map<String, String>> selectAllByProductName (String productName);
//
//
//    /**使用UserDaoProvider类的findUserById方法来生成sql */
//    @SelectProvider(type = com.nainai.smallprogram.mapper.ProductOfferMapper.ProductOfferProvider.class, method = "findProductOffer")
//    List<ProductOffer> findProductOffer(ProductOffer productOffer);
//    class ProductOfferProvider {
//        public String findProductOffer(ProductOffer productOffer) {
//            return new SQL(){{
//                SELECT("id,shop_id");
//                SELECT("price");
//                FROM("product_offer");
//                if(productOffer.getId()!=null){
//                    WHERE("id = #{id}");
//                }
//                if(productOffer.getProName()!=null){
//                    WHERE("pro_name like  CONCAT('%',#{proName},'%') ");
//                }
//                //从这个toString可以看出，其内部使用高效的StringBuilder实现SQL拼接
//            }}.toString();
//        }
//    }
//}
