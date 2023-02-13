package com.charter.communications.customer.portal.rewards.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.charter.communications.customer.portal.rewards.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

//	@Query(value="select o from Order o where Order.=?1")
	List<Order> findByCustomerId(Long customerId);
}
