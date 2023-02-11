package com.orderservice.orderservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="t_order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {
	//Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	//Sku Code
	private String skuCode;

	//product price
	private BigDecimal price;

	//Product Quantity
	private Integer quantity;

}
