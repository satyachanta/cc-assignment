package com.charter.communications.customer.portal.rewards.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "customer_id")
	private Customer customer;
    
	@Column(nullable = false)
	private Date createdDate;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> items = new ArrayList<>();
	
	public double getTotal() {
	    double sum = 0.0;
	    for (OrderItem item : items) {
	        sum += item.getSubTotal();
	    }
	    return sum;
	}
	
	public List<OrderItem> getItems() {
	    return items;
	}
}
