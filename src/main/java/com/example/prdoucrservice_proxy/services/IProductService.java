package com.example.prdoucrservice_proxy.services;

import com.example.prdoucrservice_proxy.dtos.ProductDto;
import com.example.prdoucrservice_proxy.models.Product;

public interface IProductService {
    String getAllProducts();

    Product getSingleProduct(Long productId);

    String addNewProduct(ProductDto product);

    String updateProduct(Long productId);

    String deleteProduct(Long productId);
}
