package com.roamer.orders.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 订单
 *
 * @author roamer
 * @version V1.0
 * @date 2018/2/1
 */
@Data
@Document
public class Order implements Serializable {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 顾客名称
     */
    @Field("client")
    private String customer;

    /**
     * 方式
     */
    private String type;

}
