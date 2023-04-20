package com.example.webshoplabb;

import com.example.webshoplabb.shop.Customer;
import com.example.webshoplabb.shop.ShopService;
import com.example.webshoplabb.storage.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {

    @Test
    public void setUpNewCustomer() {
        System.out.println("running a test..");
        Customer customer1 = new Customer("name","password");
        System.out.println("Name: " + customer1.getName() +
                "\nPassword: " + customer1.getPassword());
    }

}
