package com.charter.communications.customer.portal.rewards.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.communications.customer.portal.rewards.entities.Order;
import com.charter.communications.customer.portal.rewards.repository.OrderRepository;

@RestController
@RequestMapping("/v1/rest/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

  @GetMapping("/all")
  List<Order> allOrder() {
    return orderRepository.findAll();
  }
  
  @GetMapping("/{id}")
  Optional<Order> get(@PathVariable Long id) {
    return orderRepository.findById(id);
  }
	  
  @GetMapping("/customer/{id}")
  List<Order> allOrderByCustomer(@PathVariable Long id) {
    return orderRepository.findByCustomerId(id);
  }
}
