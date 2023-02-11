package com.orderservice.orderservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {
	//Sku Code
	private String skuCode;

	//product price
	private BigDecimal price;

	//Product Quantity
	private Integer quantity;
}
