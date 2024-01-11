package com.example.prdoucrservice_proxy.controllers;

import com.example.prdoucrservice_proxy.clients.IClientProductDto;
import com.example.prdoucrservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import com.example.prdoucrservice_proxy.dtos.ProductDto;
import com.example.prdoucrservice_proxy.models.Categories;
import com.example.prdoucrservice_proxy.models.Product;
import com.example.prdoucrservice_proxy.security.JwtObject;
import com.example.prdoucrservice_proxy.security.TokenValidator;
import com.example.prdoucrservice_proxy.services.IProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;
    TokenValidator tokenValidator;
    public ProductController(IProductService productService,TokenValidator tokenValidator){
        this.productService = productService;
        this.tokenValidator = tokenValidator;
    }
    @GetMapping("")
    public List<Product> getAllProducts(){

        return this.productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@Nullable @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken
            , @PathVariable("id") Long productId ) {
       try {
           JwtObject authTokenObj =null;
           if (authToken != null){
               Optional<JwtObject> authObject = tokenValidator.validateToken(authToken);
               if(authObject.isEmpty()){
                   //throw exception
               }
               authTokenObj = authObject.get();
           }
           MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
           headers.add("Accept","application/json");
           headers.add("Content-Type","application/json");
           headers.add("auth-token","heyaccess");
           Product product = productService.getSingleProduct(productId);
           //Product product = productService.getSingleProduct(productId,authTokenObj);
           ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers, HttpStatus.OK);
           return responseEntity;
       }catch(Exception e){
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product product = getProduct(productDto);
        Product saveProduct = this.productService.addNewProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(saveProduct,HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/{productId}")
    public Product patchProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return this.productService.updateProduct(productId, product);
    }
    private  Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription((productDto.getDescription()));
        product.setPrice((productDto.getPrice()));
        Categories category = new Categories();
        category.setName((productDto.getCategory()));
        product.setCategory(category);
        product.setImageUrl(productDto.getImageUrl());
        return product;
    }
}
