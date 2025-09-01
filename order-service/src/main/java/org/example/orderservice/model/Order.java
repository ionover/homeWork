package org.example.orderservice.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private String currency;
    private List<String> items;

    public Order() {}

    public Order(Long id, Long userId, BigDecimal amount, String currency, List<String> items) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}