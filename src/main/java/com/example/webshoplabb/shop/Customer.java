package com.example.webshoplabb.shop;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private boolean admin;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrders;

    public Customer() {
    }
    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
        this.customerOrders = new ArrayList<>();
    }
    public Customer(String name, String password, boolean admin) {
        this.name = name;
        this.password = password;
        this.admin = admin;
        this.customerOrders = new ArrayList<>();
    }
    public Customer(Long id, List<CustomerOrder> customerOrders) {
        this.id = id;
        this.customerOrders = customerOrders;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void addOrder(CustomerOrder customerOrder){
        customerOrders.add(customerOrder);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }
    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

}
