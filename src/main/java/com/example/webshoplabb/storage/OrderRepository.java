package com.example.webshoplabb.storage;

import com.example.webshoplabb.shop.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
}
