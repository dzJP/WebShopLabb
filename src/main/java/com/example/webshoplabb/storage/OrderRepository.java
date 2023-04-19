package com.example.webshoplabb.storage;

import com.example.webshoplabb.shop.CustomerOrder;
import com.example.webshoplabb.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {

    Optional<CustomerOrder> findById(Long id);

}
