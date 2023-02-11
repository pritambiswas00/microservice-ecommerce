package com.orderservice.orderservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="t_order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
        private  long id;

		private String orderNumber;

		//One to Many --> For each order item must be in the list
	    @OneToMany(cascade = CascadeType.ALL)
		private List<OrderItems> items;

}
