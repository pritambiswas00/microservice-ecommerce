package com.orderservice.orderservice.controller;


import com.orderservice.orderservice.DTO.OrderRequest;
import com.orderservice.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

	//Order Created
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest){
		   orderService.placeOrder(orderRequest);
		   return "Order Placed successfully";
	}
}
