package com.ecommercedemo.Products.Service.respository;

import com.ecommercedemo.Products.Service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
