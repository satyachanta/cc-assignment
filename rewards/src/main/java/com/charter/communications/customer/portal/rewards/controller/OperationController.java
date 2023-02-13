package com.charter.communications.customer.portal.rewards.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.communications.customer.portal.rewards.entities.Customer;
import com.charter.communications.customer.portal.rewards.entities.Order;
import com.charter.communications.customer.portal.rewards.entities.OrderItem;
import com.charter.communications.customer.portal.rewards.entities.Product;
import com.charter.communications.customer.portal.rewards.repository.CustomerRepository;
import com.charter.communications.customer.portal.rewards.repository.OrderRepository;
import com.charter.communications.customer.portal.rewards.repository.ProductRepository;

@RestController
@RequestMapping("/v1/rest/data-ops")
public class OperationController {


	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	  @GetMapping("/customer/all")
	  List<?> allCustomer() {
		  return customerRepository.findAll();
	  }
	  
	  @GetMapping("/product/all")
	  List<?> allProducts() {
		  return productRepository.findAll();
	  }
	  
	  @GetMapping("/customer/{id}/order/add")
	  List<Order> save(@PathVariable Long id) {
		Customer c = customerRepository.findById(id).get();
		List<Product> allProducts = productRepository.findAll();
		
		List<Order> orders = new ArrayList<>();
		Order o1 = new Order();
		o1.setCustomer(c);
		
		List<OrderItem> orderItems= allProducts.stream().map(pr->{
			OrderItem orderItem =  new OrderItem();
			orderItem.setOrder(o1);
			orderItem.setProduct(pr);
			orderItem.setQuantity(1);
			orderItem.setPrice(pr.getPrice());
			return orderItem;
		}).collect(Collectors.toList());
		
		o1.setCreatedDate(new Date());
		o1.setItems(orderItems);
		orders.add(o1);
		
		Order o2 = new Order();
		o2.setCustomer(c);
		List<OrderItem> orderItems2= allProducts.stream().filter(pr->pr.getId()>12).map(pr->{
			OrderItem orderItem =  new OrderItem();
			orderItem.setOrder(o2);
			orderItem.setProduct(pr);
			orderItem.setQuantity(2);
			orderItem.setPrice(pr.getPrice());
			return orderItem;
		}).collect(Collectors.toList());
		
		o2.setCreatedDate(new Date());
		o2.setItems(orderItems2);
		
		Order o3 = new Order();
		o3.setCustomer(c);
		List<OrderItem> orderItems3 = allProducts.stream().filter(pr->pr.getId()<13).map(pr->{
			OrderItem orderItem =  new OrderItem();
			orderItem.setOrder(o3);
			orderItem.setProduct(pr);
			orderItem.setQuantity(1);
			orderItem.setPrice(pr.getPrice());
			return orderItem;
		}).collect(Collectors.toList());
		
		o3.setCreatedDate(new Date());
		o3.setItems(orderItems3);
		
		orders.add(o1);
		orders.add(o2);
		orders.add(o3);
		return orderRepository.saveAll(orders);
	  }
}
