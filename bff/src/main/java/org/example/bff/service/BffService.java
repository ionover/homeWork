package org.example.bff.service;

import org.example.bff.model.Order;
import org.example.bff.model.User;
import org.example.bff.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BffService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String USER_SERVICE_URL = "http://localhost:8081";
    private static final String ORDER_SERVICE_URL = "http://localhost:8082";

    public UserProfile getUserProfile(Long userId) {
        // Получаем данные пользователя
        User user = restTemplate.getForObject(
            USER_SERVICE_URL + "/api/users/" + userId, 
            User.class
        );

        // Получаем заказы пользователя
        ResponseEntity<List<Order>> ordersResponse = restTemplate.exchange(
            ORDER_SERVICE_URL + "/api/orders/by-user/" + userId,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Order>>() {}
        );
        List<Order> orders = ordersResponse.getBody();

        return new UserProfile(user, orders);
    }
}