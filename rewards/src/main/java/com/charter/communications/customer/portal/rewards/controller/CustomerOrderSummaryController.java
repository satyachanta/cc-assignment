package com.charter.communications.customer.portal.rewards.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rest/order/summary")
public class CustomerOrderSummaryController {
	
  @GetMapping("/customer/all")
  List<?> all() {
    return null;//repository.findAll();
  }
  
  @GetMapping("/customer/{id}")
  Object one(@PathVariable Long id) {
    return null;
//    return repository.findById(id)
//      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

}
