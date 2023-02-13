package com.charter.communications.customer.portal.rewards.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(nullable = false)
  private Integer quantity;
  
  @Column(nullable = false)
  private Double price;
  
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
	  
  public double getSubTotal() {
	return price * quantity;
  }
}
