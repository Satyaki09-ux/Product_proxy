package com.example.prdoucrservice_proxy.services;

import com.example.prdoucrservice_proxy.clients.IClientProductDto;
import com.example.prdoucrservice_proxy.dtos.ProductDto;
import com.example.prdoucrservice_proxy.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

   // Product addNewProduct(IClientProductDto product);

    Product addNewProduct(Product product);

    Product updateProduct(Long productId, Product product);

    String deleteProduct(Long productId);
}
