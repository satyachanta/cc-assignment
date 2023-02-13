package com.charter.communications.customer.portal.rewards.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.charter.communications.customer.portal.rewards.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}