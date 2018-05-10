package com.nainai.smallprogram.mapper;

import com.nainai.smallprogram.domain.OrderSell;
import com.nainai.smallprogram.util.MapUtil;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderSellMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSell record);

    int insertSelective(OrderSell record);

    OrderSell selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSell record);

    int updateByPrimaryKey(OrderSell record);

    @Results(id = "orderSellResults", value = {
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "pay_deposit", property = "payDeposit"),
            @Result(column = "buyer_deposit_payment", property = "buyerDepositPayment"),
            @Result(column = "pay_deposit_time", property = "payDepositTime"),
            @Result(column = "buyer_deposit_clientid", property = "buyerDepositClientid"),
            @Result(column = "pay_retainage", property = "payRetainage"),
            @Result(column = "retainage_payment", property = "retainagePayment"),
            @Result(column = "retainage_clientid", property = "retainageClientid"),
            @Result(column = "contract_status", property = "contractStatus"),
            @Result(column = "seller_deposit", property = "sellerDeposit"),
            @Result(column = "seller_deposit_payment", property = "sellerDepositPayment"),
            @Result(column = "seller_deposit_clientid", property = "sellerDepositClientid"),
            @Result(column = "jiesuan_prove", property = "jiesuanProve"),
            @Result(column = "reduce_amount", property = "reduceAmount"),
            @Result(column = "reduce_remark", property = "reduceRemark"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "is_lock", property = "isLock"),
            @Result(column = "complate_prove", property = "complateProve")
    })
    @SelectProvider(type = OrderSellMapper.FindOrderSellProvider.class, method = "findOrderSell")
    List<Map<String, Object>> findOrderSell(Map map);

    class FindOrderSellProvider {
        public String findOrderSell(Map map) {
            return new SQL() {{
                SELECT("id ");
                SELECT("shop_id ");
                SELECT("offer_id ");
                SELECT("order_no ");
                SELECT("num ");
                SELECT("amount ");
                SELECT("user_id ");
                SELECT("pay_deposit ");
                SELECT("create_time ");
                FROM(" order_sell ");
                if (map.get("offerId") != null) {
                    WHERE("offer_id = #{offerId}");
                }
                if (map.get("limit") != null) {
                    ORDER_BY("create_time desc limit 2");
                } else {
                    GROUP_BY(" DATE_FORMAT(create_time,'%y%m/%d')");
                    ORDER_BY("create_time desc ");
                }
            }}.toString();
        }
    }

}