package com.orderservice.orderservice.DTO;

import com.orderservice.orderservice.model.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	  //Items list
	  private List<OrderItemsDTO> items;




}
