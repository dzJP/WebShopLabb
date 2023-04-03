package com.example.webshoplabb.shop;


import com.example.webshoplabb.storage.CustomerRepository;
import com.example.webshoplabb.storage.ProductRepository;
import org.aspectj.weaver.ast.Or;
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

    Cart cart;

    public ShopService() {
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

    public List <Product> showShopProducts() {
        productRepository.save(new Product(1L,"Tacos",59.90));
        productRepository.save(new Product(2L,"Chicken",59.90));
        productRepository.save(new Product(3L,"Eggs",29.90));
        productRepository.save(new Product(4L,"Meat",59.90));
        productRepository.save(new Product(5L,"Candy",9.90));
        productRepository.save(new Product(6L,"Special",99.99));
        return productRepository.findAll();
    }

    public Product deleteProduct(Long id) {
        productRepository.findById(id);
        productRepository.deleteById(id);
        return product;
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(long id) {
        return customerRepository.findById(id).get();
    }

    public Product getByIdProduct(Long id){
        return productRepository.findById(id).get();
    }

    public Cart getCart() {
        return this.cart;
    }

    public Cart addToCart(Long id, int amount) {
        Product product = getByIdProduct(id);
        cart.getCartList().add(new OrderItem(product,amount));
        return cart;
    }
}

