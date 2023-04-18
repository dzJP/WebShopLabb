package com.example.webshoplabb.shop;


import com.example.webshoplabb.storage.CustomerRepository;
import com.example.webshoplabb.storage.OrderRepository;
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
    @Autowired
    OrderRepository orderRepository;
    Customer customer;
    Product product;
    Cart cart = new Cart();
    CustomerOrder customerOrder = new CustomerOrder();

    public ShopService() {}
    public void addOrder() {}

    public Customer add(String name, String password) {
        Optional<Customer> customer = customerRepository.findByName(name);
        customerRepository.save(new Customer(name, password));
        return this.customer;
    }
    public Product addProduct(String name, double price) {
        Optional<Product> product = productRepository.findByName(name);
        productRepository.save(new Product(name, price));
        return this.product;
    }
    public void addToCart(Long id, int amount) {
        Product product = getByIdProduct(id);
            cart.getCartList().add(new OrderItem(product, amount));
    }
    public void addIntoOrder() {
        customer.addOrder(new CustomerOrder(getCart().getCartList(),customer));
        customer = customerRepository.save(customer);
    }
    public void saveOrder(CustomerOrder customerOrder) {
        customerOrder = orderRepository.save(customerOrder);
    }
    public List<Product> showProductsInStore() {
        productRepository.save(new Product(1L, "Chicken", 50));
        productRepository.save(new Product(2L, "Beef", 60));
        productRepository.save(new Product(3L, "Fish", 70));
        productRepository.save(new Product(4L, "Apple", 10));
        productRepository.save(new Product(5L, "Banana", 5));
        return productRepository.findAll();
    }
    public void deleteProduct() {
        cart.getCartList().remove(0);
    }
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }

    public Product getByIdProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public Product findByName(String name) {
        Optional<Product> productOptional = productRepository.findByName(name);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }

    public Product getByNameProduct(String name) {
        return productRepository.findByName(name).get();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Cart getCart() {
        return this.cart;
    }
    public List<CustomerOrder> getCustomerOrders() {
        return customer.getCustomerOrders();
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

}
