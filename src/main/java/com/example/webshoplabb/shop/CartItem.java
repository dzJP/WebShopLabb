package com.example.webshoplabb.shop;

import jakarta.persistence.*;

@Entity(name = "cartitem")
@Table
public class CartItem {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
