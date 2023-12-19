package com.example.prdoucrservice_proxy.services;

import com.example.prdoucrservice_proxy.dtos.ProductDto;
import com.example.prdoucrservice_proxy.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(ProductDto product);

    String updateProduct(Long productId);

    String deleteProduct(Long productId);
}
