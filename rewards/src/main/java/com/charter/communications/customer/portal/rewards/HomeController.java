package com.charter.communications.customer.portal.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.charter.communications.customer.portal.rewards.repository.CustomerRepository;
import com.charter.communications.customer.portal.rewards.repository.OrderRepository;

@Controller
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderRepository orderRepository;
	
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("index", true);
        return "index";
    }
    
    @GetMapping("/customers")
    public String viewCustomerPage(Model model) {
    	model.addAttribute("customers", true);
        model.addAttribute("allCustomers", customerRepository.findAll());
        return "customers";
    }
    
    @GetMapping("/orders")
    public String viewOrderPage(Model model) {
    	model.addAttribute("orders", true);
        model.addAttribute("allOrders", orderRepository.findAll());
        return "orders";
    }
}
