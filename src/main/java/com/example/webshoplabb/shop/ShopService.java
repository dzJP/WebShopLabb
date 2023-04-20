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
    Product product;
    Customer customer;
    CustomerOrder customerOrder;
    Cart cart = new Cart();
    public ShopService() {}

    public Customer addNewUser(String name, String password, boolean admin) {
        Optional<Customer> customerOptional = customerRepository.findByName(name);
        if (customerOptional != customerRepository.findByName(name))
            System.out.println("This user already exists.");
        else {
            customer = customerRepository.save(new Customer(name, password,admin));
            System.out.println("User saved successfully.");
        }
        return customer;
    }
    public Customer login(String name, String password) {
        Optional<Customer> customerOptional = customerRepository.findByNameAndPassword(name,password);
        if (customerOptional != customerRepository.findByNameAndPassword(name, password))
            System.out.println("Logged in successfully.");
        else {
            System.out.println("Invalid info.");
        }
        return customer;
    }

    public Boolean isAdmin() {
        return customer.isAdmin();
    }
    public Product addProduct(String name, double price, Category category ) {
        Optional<Product> product = productRepository.findByName(name);
        productRepository.save(new Product(name, price, category));
        return this.product;
    }
    public void addToCart(Long id, int amount) {
        Product product = getByIdProduct(id);
            cart.getCartList().add(new OrderItem(product, amount));
    }
    public void createOrderFromCart() {
        customer.getCustomerOrders().add(new CustomerOrder(getCart().getCartList(),customer));
        customer = customerRepository.save(customer);
    }
    public List<Product> showProductsInStore() {
        productRepository.save(new Product(1L, "Chicken", 50, Category.MAT));
        productRepository.save(new Product(2L, "Beef", 60, Category.MAT));
        productRepository.save(new Product(3L, "Fish", 70, Category.MAT));
        productRepository.save(new Product(4L, "Apple", 10, Category.MAT));
        productRepository.save(new Product(5L, "Banana", 5, Category.MAT));
        return productRepository.findAll();
    }
    public void deleteProduct() {
        cart.getCartList().remove(0);
    }
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }
    public Product getByIdProduct(Long id) {
        return productRepository.findById(id).get();
    }
    public CustomerOrder getByIdOrder(Long id) {
        return orderRepository.findById(id).get();
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
    public Cart getCart() {
        return this.cart;
    }
    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public List<CustomerOrder> getCustomerOrders() {
        return customer.getCustomerOrders();
    }
    public List<CustomerOrder> getAllCustomerOrders() {
        return orderRepository.findAll();
    }
}
