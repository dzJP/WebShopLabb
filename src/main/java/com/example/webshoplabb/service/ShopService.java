package com.example.webshoplabb.service;


import com.example.webshoplabb.shop.Customer;
import com.example.webshoplabb.shop.Product;
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

    public Product deleteProduct(int id) {
        productRepository.findById(id);
        productRepository.deleteById(id);
        return product;
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public Product findById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }



    public List <Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for(Product product:productRepository.findAll()) {
            products.add(product);
        }
        return products;
    }

    public List <Product> showProducts() {
        productRepository.save(new Product(1,"Tacos",59.90));
        productRepository.save(new Product(2,"Chicken",59.90));
        productRepository.save(new Product(3,"Eggs",29.90));
        productRepository.save(new Product(4,"Meat",59.90));
        productRepository.save(new Product(5,"Candy",9.90));
        productRepository.save(new Product(6,"Special",99.99));
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }

    public Customer getById(long id) {
        return customerRepository.findById(id).get();
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
}
