package org.example.bff.model;

import java.util.List;

public class UserProfile {
    private User user;
    private List<Order> orders;

    public UserProfile() {}

    public UserProfile(User user, List<Order> orders) {
        this.user = user;
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}