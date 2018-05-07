package com.roamer.orders.dao;

import com.roamer.orders.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单数据操作现实
 *
 * @author roamer
 * @version V1.0
 * @date 2018/4/26
 */
@Repository
public class OrderRepositoryImpl implements OrderOperations {

    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Order> findByCustomer(String customer) {
        return mongo.find(Query.query(
                Criteria.where("customer").is(customer)),Order.class);
    }
}
