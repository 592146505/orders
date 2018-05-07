package com.roamer.orders.dao;

import com.roamer.orders.config.MongoConfig;
import com.roamer.orders.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void repositoryShouldNotNull() {
        assertNotNull(orderRepository);
    }

    @Test
    public void findById() {
        Order order = orderRepository.findById("5ae16885a7cdda38344b4fa7");
        assertNotNull(order);
        assertEquals("cs", order.getCustomer());
    }

    @Test
    public void findByCustomer() {
        List<Order> orders = orderRepository.findByCustomer("cs");
        assertEquals(2, orders.size());
        assertEquals("5ae16885a7cdda38344b4fa7", orders.get(0).getId());
    }

    @Test
    public void countByCustomer() {
        int count = orderRepository.countByCustomer("cs");
        assertEquals(2, count);
    }

    @Test
    public void findByTypeAndCustomerLike() {
        Pattern pattern = Pattern.compile("^cs.*$", Pattern.CASE_INSENSITIVE);
        List<Order> orders = orderRepository.findByTypeAndCustomerLike("WEB",pattern);
        assertEquals(3, orders.size());
    }
}