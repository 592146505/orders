package com.roamer.orders.dao;

import com.roamer.orders.pojo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 订单数据操作接口
 *
 * @author roamer
 * @version V1.0
 * @date 2018/4/26
 */
public interface OrderRepository extends MongoRepository<Order, String>, OrderOperations {

    /**
     * 根据id查找订单
     *
     * @param id
     * @return
     */
    Order findById(String id);

    /**
     * 根据顾客获取订单个数
     *
     * @param customer
     * @return
     */
    int countByCustomer(String customer);

    /**
     * 根据下单类型和顾客姓名获取
     *
     * @param type
     * @param pattern
     * @return
     */
    @Query("{'type' : {'$eq' : ?0}, 'customer' : ?1}")
    List<Order> findByTypeAndCustomerLike(String type, Pattern pattern);
}
