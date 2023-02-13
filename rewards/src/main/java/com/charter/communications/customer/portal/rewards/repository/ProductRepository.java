package com.charter.communications.customer.portal.rewards.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.charter.communications.customer.portal.rewards.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}