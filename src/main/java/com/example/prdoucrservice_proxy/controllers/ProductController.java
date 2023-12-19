package com.example.prdoucrservice_proxy.controllers;

import com.example.prdoucrservice_proxy.dtos.ProductDto;
import com.example.prdoucrservice_proxy.models.Product;
import com.example.prdoucrservice_proxy.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;
    public ProductController(IProductService productService){
        this.productService = productService;
    }
    @GetMapping("")
    public List<Product> getAllProducts(){

        return this.productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId ) {
       try {
           MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
           headers.add("Accept","application/json");
           headers.add("Content-Type","application/json");
           headers.add("auth-token","heyaccess");
           Product product = productService.getSingleProduct(productId);
           ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers, HttpStatus.OK);
           return responseEntity;
       }catch(Exception e){
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product product = this.productService.addNewProduct(productDto);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,HttpStatus.OK);
        return responseEntity;
    }
}
