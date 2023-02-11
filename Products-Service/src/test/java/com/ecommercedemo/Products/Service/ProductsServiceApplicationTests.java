package com.ecommercedemo.Products.Service;

import com.ecommercedemo.Products.Service.DTO.ProductRequest;
import com.ecommercedemo.Products.Service.respository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductsServiceApplicationTests {

	///Docker Container for the test the Database whether it is working or not.
	@Container
	final static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));

	//For Initialize the Controller class for Test
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductRepository repository;

	///This will dynamically create the Database and set the Database URI when downloading the instance of the Database from docker registry.
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		   dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	private ProductRequest getProductRequest(){
		 return ProductRequest.builder().name("Pritam Product")
				        .description("Pritam making free of cost")
				        .price(BigDecimal.valueOf(12000))
				        .build();
	}

	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest request = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(request);
		System.out.println(productRequestString);
		mockMvc.perform(MockMvcRequestBuilders.post("/api1/product")
				                .contentType(MediaType.APPLICATION_JSON)
				                .content(productRequestString))
				.andExpect(status().isCreated());
	    }

   @Test
   void shouldGetAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api1/product").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
   }



}
