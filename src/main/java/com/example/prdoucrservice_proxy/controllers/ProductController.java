package com.example.prdoucrservice_proxy.controllers;

import com.example.prdoucrservice_proxy.models.Product;
import com.example.prdoucrservice_proxy.services.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;
    public ProductController(IProductService productService){
        this.productService = productService;
    }
    @GetMapping("")
    public String getAllProducts(){
        return "Getting all the products";
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId ) {
        Product product = productService.getSingleProduct(productId);
        return product;
    }
}
