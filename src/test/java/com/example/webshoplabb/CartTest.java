package com.example.webshoplabb;

import com.example.webshoplabb.shop.Cart;
import com.example.webshoplabb.shop.OrderItem;
import com.example.webshoplabb.shop.Product;
import com.example.webshoplabb.shop.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CartTest {
    @Autowired
    ShopService shopService;
    @BeforeEach
    public void beforeClass() {
        Product exampleproduct1 = Mockito.mock(Product.class);
        Product exampleproduct2 = Mockito.mock(Product.class);
        shopService.addProduct(exampleproduct1.getName(), exampleproduct1.getPrice());
        shopService.addProduct(exampleproduct2.getName(),exampleproduct1.getPrice());
        shopService.addToCart(1L,1);
        shopService.addToCart(2L,1);
    }
    @Test
    public void shouldAddToCart() {
        assertEquals(2,shopService.getCart().getCartList().size());
    }

    @Test
    public void shouldRemoveFromCart() {
        shopService.getCart().getCartList().remove(0);
        assertEquals(1,shopService.getCart().getCartList().size());
    }

}
