package com.roamer.orders.dao;

import com.roamer.orders.pojo.Order;

import java.util.List;

/**
 * 订单数据操作拓展接口
 *
 * @author roamer
 * @version V1.0
 * @date 2018/4/26
 */
public interface OrderOperations {

    /**
     * 根据顾客获取订单
     *
     * @param customer
     * @return
     */
    List<Order> findByCustomer(String customer);
}
