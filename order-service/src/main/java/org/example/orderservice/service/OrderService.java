package org.example.orderservice.service;

import org.example.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final Map<Long, Order> orders = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Order createOrder(Order order) {
        Long id = idGenerator.getAndIncrement();
        order.setId(id);
        orders.put(id, order);
        return order;
    }

    public List<Order> getOrdersByUserId(Long userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}