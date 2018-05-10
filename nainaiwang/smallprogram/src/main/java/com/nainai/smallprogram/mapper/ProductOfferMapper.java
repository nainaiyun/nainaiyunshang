package com.nainai.smallprogram.mapper;

import com.nainai.smallprogram.domain.ProductOffer;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;


@Mapper
public interface ProductOfferMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ProductOffer record);

    int insertSelective(ProductOffer record);

    ProductOffer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductOffer record);

    int updateByPrimaryKey(ProductOffer record);

    /**
     * 根据条件查询商品列表
     *
     * @return
     */
    @Results(id = "ProductOfferResults", value = {
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "classify_id", property = "classifyId"),
            @Result(column = "module_id", property = "moduleId"),
            @Result(column = "navigation_id", property = "navigationId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "sub_mode", property = "subMode"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "old_offer", property = "oldOffer"),
            @Result(column = "price_l", property = "priceL"),
            @Result(column = "price_r", property = "priceR"),
            @Result(column = "accept_area", property = "acceptArea"),
            @Result(column = "accept_day", property = "acceptDay"),
            @Result(column = "acc_type", property = "accType"),
            @Result(column = "offer_fee", property = "offerFee"),
            @Result(column = "is_del", property = "isDel"),
            @Result(column = "apply_time", property = "applyTime"),
            @Result(column = "finish_time", property = "finishTime"),
            @Result(column = "expire_time", property = "expireTime"),
            @Result(column = "admin_msg", property = "adminMsg"),
            @Result(column = "weight_type", property = "weightType"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "max_num", property = "maxNum"),
            @Result(column = "sell_num", property = "sellNum"),
            @Result(column = "jing_stepprice", property = "jingStepprice"),
            @Result(column = "offer_sort", property = "offerSort"),

            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_note", property = "productNote"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "attr_json", property = "attrJson"),


            @Result(column = "photos_id", property = "photosId"),
            @Result(column = "photos_img", property = "photosImg"),
            @Result(column = "true_name", property = "trueName"),

            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "price_vip", property = "priceVip"),

    })
    @Select("select o.shop_id,p.id'product_id',o.id'offer_id',p.name'product_name'," +
            "p.note'product_note' ,p.img,p.unit ,p.currency,o.price " +
            "from product_offer o left join products p on o.product_id = p.id " +
            "where  p.name like  CONCAT('%',#{0},'%') " +
            "and status=1 order by create_time asc")
    List<Map<String, String>> selectAllByProductName(String productName);


    /**
     * 根据条件查询报盘的列表
     *
     * @param map
     * @return
     */
    @ResultMap("ProductOfferResults")
    @SelectProvider(type = FindProductOfferProvider.class, method = "findProductOffer")
    List<Map<String, Object>> findProductOffer(Map map);

    class FindProductOfferProvider {
        public String findProductOffer(Map map) {
            return new SQL() {{
                SELECT("o.id 'offer_id' ");
                SELECT("o.shop_id ");
                SELECT("o.price ");
                SELECT("p.id 'product_id' ");
                SELECT("p.name 'product_name' ");
                SELECT("p.note 'product_note' ");
                SELECT("p.img ");
                SELECT("p.unit ");
                SELECT("o.price_vip");
                SELECT("p.currency");
                SELECT("p.note");
                FROM("product_offer o");
                LEFT_OUTER_JOIN("products p on o.product_id = p.id ");

                WHERE("date_format(expire_time,'%Y-%m-%d')> date_format(now(),'%Y-%m-%d') ");

                if (map.get("id") != null) {
                    WHERE("o.id = #{id}");
                }
                if (map.get("marketId") != null) {
                    WHERE("p.market_id =#{marketId}");
                }
                if (map.get("status") != null) {
                    WHERE("p.status like  CONCAT('%',#{status},'%') ");
                }
                if (map.get("proName") != null) {
                    WHERE("o.pro_name like  CONCAT('%',#{proName},'%') ");
                }
                if (map.get("name") != null) {
                    WHERE("p.name like  CONCAT('%',#{name},'%') ");
                }
                if (map.get("note") != null) {

                    WHERE("p.note like  CONCAT('%',#{note},'%') ");
                }


                ORDER_BY("o.apply_time desc");
            }}.toString();
        }
    }

    /**
     * 查询报盘的详情根据报盘id
     *
     * @param id
     * @return
     */
    @ResultMap("ProductOfferResults")
    @Select("select o.shop_id," +
            /**商品编号*/" p.id'product_id'," +
            /**报盘编号*/" o.id'offer_id'," +
            /**商品名称*/" p.name'product_name'," +
            /**商品详情*/" p.note'product_note'," +
            /**商品图片*/" p.img," +
            /**商品单位*/" p.unit ," +
            /**商品货币*/" p.currency," +
            /**报盘单价*/" o.price ," +
            /**会员单价*/" o.price_vip ," +
            /**商品产区*/" p.produce_area," +
            /**商品属性json*/" p.attr_json ," +
            /**报盘最高价*/" o.price_l," +
            /**报盘最低价*/" o.price_r," +
            /**报盘类型*/" o.type," +
            /**报盘模式*/"o.mode," +
            /**是否投保,0:未投保*/" o.insurance," +
            /**计重方式*/" o.weight_type," +
            /**是否拆分,1:可以;0:不可*/" o.divide," +
            /**最大数量*/" o.max_num," +
            /**已售数量*/" o.sell_num," +
            /**最小起订量*/" o.minimum," +
            /**交收时间*/" o.accept_day," +
            /**交收地点*/" o.accept_area," +
            /**到期时间*/" o.expire_time," +
            /**补充条款*/" o.other," +
            /**卖家名称*/" u.true_name," +
            /**创建时间*/" o.apply_time  " +
            "from product_offer o " +
            "left join products p " +
            "on o.product_id = p.id " +
            "left join user u " +
            "on o.user_id = u.id " +
            "where  o.id=#{0}")
    Map<String, Object> findProductOfferDetails(Integer id);

    /**
     * 查询大盘列表
     *
     * @return
     */
    @ResultMap("ProductOfferResults")
    @Select(" select o.id 'offer_id',s.id 'sell_id',p.id 'product_id',p.name 'product_name',p.attr_json," +
            "p.unit,p.currency,sell,o.price,o.price_vip,sum(num) 'sum',max(amount) 'max',min(amount) 'min' ," +
            " o.price_l,o.price_r " +
            " from product_offer o " +
            " inner join order_sell s " +
            " on o.id=s.offer_id " +
            " inner join products p " +
            " on o.product_id =p.id " +
            " group by o.id " +
            " order by s.create_time asc ")
    List<Map<String, Object>> findProductOfferStatistics();

}