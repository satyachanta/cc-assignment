package com.charter.communications.customer.portal.rewards.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.communications.customer.portal.rewards.entities.Customer;
import com.charter.communications.customer.portal.rewards.entities.Order;
import com.charter.communications.customer.portal.rewards.repository.CustomerRepository;
import com.charter.communications.customer.portal.rewards.repository.OrderRepository;

@RestController
@RequestMapping("/v1/rest/rewards")
public class RewardsController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderRepository orderRepository;

  
  @GetMapping("/order/{id}")
  ResponseEntity<Integer> get(@PathVariable Long id) {
	Optional<Order> order = orderRepository.findById(id);
	if(order.isPresent()) {
		List<Order> orderList = Arrays.asList(order.get());
		return ResponseEntity.ok().body(this.getRewardPoints(orderList));
	} else {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
  }
	  
  @GetMapping("/customer/{id}")
  ResponseEntity<Integer> allOrderByCustomer(@PathVariable Long id) {
	Optional<Customer> customer = customerRepository.findById(id);
	if(customer.isPresent()) {
	    List<Order> orders = orderRepository.findByCustomerId(id);
		return ResponseEntity.ok().body(this.getRewardPoints(orders));
	} else {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
  }
  
  
  public Integer getRewardPoints(List<Order> orders) {
	  return orders.stream()
			  .filter(o->o.getTotal()>50)
			  .map(o->{
				  int points = 0 ;
				  double val = o.getTotal()-50.0;
				  if(val>50.0) {
					  double val1 = val - 50;
					  points = (2 * (int) val1) + 50;
				  } else {
					  points = (int) val;
				  }
				  return points;
			  })
			  .reduce(0, Integer::sum);
  }
  
}
