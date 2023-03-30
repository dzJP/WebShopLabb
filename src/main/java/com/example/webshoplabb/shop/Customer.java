package com.example.webshoplabb.shop;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "customer")
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Result> results;
    public Customer() {
    }
    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
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

//    public List<Result> getResults() {
//        return results;
//    }
//
//    public void setResults(List<Result> results) {
//        this.results = results;
//    }

//    public void addResult(Result result) {
//        results.add(result);
//    }
}
