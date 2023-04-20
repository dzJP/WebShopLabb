package com.example.webshoplabb.shop;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.util.List;

@Entity
public class CustomerOrder {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<OrderItem> cart;
    @ManyToOne
    Customer customer;
    Boolean sending;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public CustomerOrder(List<OrderItem> cart, Customer customer) {
        this.customer = customer;
        this.cart = cart;
        this.sending = false;
    }
    public CustomerOrder() {}

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public List<OrderItem> getCart() {
        return cart;
    }
    public void setCart(List<OrderItem> cart) {
        this.cart = cart;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getSending() {
        return sending;
    }

    public void setSending(Boolean sending) {
        this.sending = sending;
    }
}
