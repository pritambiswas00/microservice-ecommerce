package com.ecommercedemo.Products.Service.service;


import com.ecommercedemo.Products.Service.DTO.ProductRequest;
import com.ecommercedemo.Products.Service.DTO.ProductResponse;
import com.ecommercedemo.Products.Service.controller.ProductController;
import com.ecommercedemo.Products.Service.model.Product;
import com.ecommercedemo.Products.Service.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
     private final ProductRepository respository;
    public void createProduct(ProductRequest product){
           Product newProduct = Product.builder()
                   .name(product.getName())
                   .description(product.getDescription())
                   .price(product.getPrice()).build();

           respository.save(newProduct);
           log.info("Product {} saved successfully", newProduct.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = respository.findAll();
        return products.stream().map(this::createProductResponse).toList();

    }

    private ProductResponse createProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }

	public Optional<Product> getProduct(String productId) {
         Optional<Product> product = respository.findById(productId);
         return product;
	}
}
