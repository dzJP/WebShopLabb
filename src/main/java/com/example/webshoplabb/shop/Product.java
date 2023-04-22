package com.example.webshoplabb.shop;

import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;
    private Category category;

    public Product() {
    }

    public Product(String name, double price, Category category) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, double price, Category category) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}