package com.roamer.orders.config;

import com.mongodb.Mongo;
import com.mongodb.MongoCredential;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Mongo配置
 * 使用@EnableMongoRepositories，启用了Spring Data的自动化Mongo Repository生成功能
 *
 * @author roamer
 * @version V1.0
 * @date 2018/2/1
 */
@Configuration
@ComponentScan(basePackages = "com.roamer.orders.dao")
@EnableMongoRepositories(basePackages = "com.roamer.orders.dao")
public class MongoConfig {

    /**
     * MongoDB连接工厂
     * MongoFactoryBean声明了一个Mongo实例,
     * 这个bean将Spring Data MongoDB与数据库本身连接了起来
     *
     * @return
     */
    @Bean
    public MongoClientFactoryBean mongo() {
//        MongoCredential[] credentials = new MongoCredential[]{MongoCredential.createCredential("roamerdb", "OrdersDB", "Wsc3233993".toCharArray())};
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
//        mongo.setCredentials(credentials);
        mongo.setHost("127.0.0.1");
        return mongo;
    }

    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "OrdersDB");
    }

}
