package com.example.webshoplabb.shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public Cart() {
        this.cartItems = new ArrayList<>();
    }
    List<Cart> cartItems;

    public List<Cart> getCartItems() {
        return cartItems;
    }
}
