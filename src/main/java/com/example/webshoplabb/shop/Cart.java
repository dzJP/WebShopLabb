package com.example.webshoplabb.shop;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class Cart {
    public List <OrderItem> cart = new ArrayList<>();


    public Cart() {
    }

    public List<OrderItem> getCartList() {
        return cart;
    }

    public Double getTotalCostOfProductsInCart() {
        Double sum = 0.0;
        for (OrderItem orderItem : cart) {
            sum += (int) (orderItem.getProduct().getPrice()) * orderItem.getAmount();
        }
        return sum;
    }

}
