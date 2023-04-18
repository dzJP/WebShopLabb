package com.example.webshoplabb.shop;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderItem {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    private int amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public OrderItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public OrderItem() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
