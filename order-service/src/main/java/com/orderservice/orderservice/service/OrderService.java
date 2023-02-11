package com.orderservice.orderservice.service;


import com.orderservice.orderservice.DTO.OrderItemsDTO;
import com.orderservice.orderservice.DTO.OrderRequest;
import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.model.OrderItems;
import com.orderservice.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
	   private final OrderRepository orderRepo;


	   ///Place order
	   public void placeOrder(OrderRequest orderRequest){
		      Order order = new Order();
			  order.setOrderNumber(UUID.randomUUID().toString());
			  List<OrderItems> orderedItems = orderRequest.getItems()
					  .stream()
					  .map(this::mapToDTO).toList();
			  order.setItems(orderedItems);
              orderRepo.save(order);
	   }

	   //Mapping each order item to create the order.
	   private OrderItems mapToDTO(OrderItemsDTO items) {
            OrderItems orderItems = new OrderItems();
			orderItems.setPrice(items.getPrice());
			orderItems.setQuantity(items.getQuantity());
			orderItems.setSkuCode(items.getSkuCode());
            return orderItems;
	   }
}
