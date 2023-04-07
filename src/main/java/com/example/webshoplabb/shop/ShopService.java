package com.example.webshoplabb.shop;


import com.example.webshoplabb.storage.CustomerRepository;
import com.example.webshoplabb.storage.ProductRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

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
    Cart cart = new Cart();

    public ShopService() {
    }
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


    public void deleteProduct() {
        cart.getCartList().remove(0);
    }
//    public OrderItem deleteProduct(OrderItem orderItem) {
//        cart.getCartList().remove(orderItem);
//        return orderItem;
//    }
    public Cart getCart() {
        return this.cart;
    }

    public List<Product> showProductsInStore() {
        productRepository.save(new Product(1L, "Chicken", 50));
        productRepository.save(new Product(2L, "Beef", 60));
        productRepository.save(new Product(3L, "Fish", 70));
        productRepository.save(new Product(3L, "Apple", 10));
        productRepository.save(new Product(3L, "Banana", 5));
        return productRepository.findAll();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
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



    public Customer getByIdCustomer(long id) {
        return customerRepository.findById(id).get();
    }

    public Product getByIdProduct(Long id) {
        return productRepository.findById(id).get();
    }


    public void addOrder() {
    }
}

//    public Customer add(String name, String password) {
//        Optional<Customer> customer = customerRepository.findByName(name);
//        if (customer.isEmpty()) {
//            this.customer = customerRepository.save(new Customer(name, password));
//        } else {
//            this.customer = customer.get();
//        }
//        return this.customer;
//    }

//    public Product addProduct(String name, double price) {
//        Optional<Product> product = productRepository.findByName(name);
//        if (product.isEmpty()) {
//            this.product = productRepository.save(new Product(name, price));
//        } else {
//            this.product = product.get();
//        }
//        return this.product;
//    }

