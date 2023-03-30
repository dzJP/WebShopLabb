package com.example.webshoplabb.shop;


import com.example.webshoplabb.storage.CustomerRepository;
import com.example.webshoplabb.storage.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class ShopService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    Customer customer;
    Product product;

    public ShopService() {
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Customer add(String name, String password) {
        Optional<Customer> customer = customerRepository.findByName(name);
        if (customer.isEmpty()) {
            this.customer = customerRepository.save(new Customer(name, password));
        } else {
            this.customer = customer.get();
        }
        return this.customer;
    }

    public Product addProduct(int id, String name, double price) {
        Product product = new Product(1,"banana",10.0);
        return productRepository.save(product);
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Customer getById(long id) {
        return customerRepository.findById(id).get();
    }

    public Product findById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }
}
