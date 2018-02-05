package com.roamer.orders.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 订单
 * @author roamer
 * @version V1.0
 * @date 2018/2/1
 */
@Document
public class Order implements Serializable{

    @Id
    private String id;


}
