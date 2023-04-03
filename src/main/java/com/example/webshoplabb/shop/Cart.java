package com.example.webshoplabb.shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List <OrderItem> cart = new ArrayList<>();

    public Cart() {
    }

    public List<OrderItem> getCartList() {
        return cart;
    }

}
