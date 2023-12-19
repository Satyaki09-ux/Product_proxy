package com.example.prdoucrservice_proxy.services;

import com.example.prdoucrservice_proxy.dtos.ProductDto;
import com.example.prdoucrservice_proxy.models.Categories;
import com.example.prdoucrservice_proxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ProductService implements IProductService {
    private RestTemplateBuilder restTemplateBuilder;
    public ProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public String getAllProducts(){
        return null;
    }
    @Override
    public Product getSingleProduct(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
       ProductDto productDto =  restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,productId).getBody();
       Product product = getProduct(productDto);
       return product ;
    }

    @Override
    public String addNewProduct(ProductDto product) {
        return null;
    }
    @Override
    public String updateProduct(Long productId){
        return null;
    }
    @Override
    public String deleteProduct(Long productId){
        return null;
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
