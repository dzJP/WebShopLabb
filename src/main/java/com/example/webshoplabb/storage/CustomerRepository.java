package com.example.webshoplabb.storage;

import com.example.webshoplabb.shop.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);

    Optional<Customer> findByPassword(String password);

    Optional<Customer> findByNameAndPassword(String name, String password);

}
