package com.example.webshoplabb.shop;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    Customer customer;


    public CustomerOrder(Customer customer) {
        this.customer = customer;
    }

    public CustomerOrder() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
