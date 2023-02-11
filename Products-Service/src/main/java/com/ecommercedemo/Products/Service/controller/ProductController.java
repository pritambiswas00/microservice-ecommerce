package com.ecommercedemo.Products.Service.controller;


import com.ecommercedemo.Products.Service.DTO.ProductRequest;
import com.ecommercedemo.Products.Service.DTO.ProductResponse;
import com.ecommercedemo.Products.Service.model.Product;
import com.ecommercedemo.Products.Service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api1/product")
@RequiredArgsConstructor
public class ProductController {
     private final ProductService productService;
     @PostMapping("/addProduct")
     @ResponseStatus(HttpStatus.CREATED)
      public void createProduct(@RequestBody ProductRequest productRequest) {
              productService.createProduct(productRequest);
      }

      @GetMapping("/getAllProducts")
      @ResponseStatus(HttpStatus.OK)
      public List<ProductResponse> getAllProducts(){
           return productService.getAllProducts();
      }


}
