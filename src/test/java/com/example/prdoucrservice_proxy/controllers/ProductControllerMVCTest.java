package com.example.prdoucrservice_proxy.controllers;

import com.example.prdoucrservice_proxy.models.Product;
import com.example.prdoucrservice_proxy.services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    IProductService productService;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getAllProducts() throws Exception{
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());

        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(products)));
    }
//    @Test
//    void createProduct() throws Exception{
//        Product productToCreate = new Product();
//        productToCreate.setTitle("Samsung");
//        productToCreate.setImageUrl("some image");
//        productToCreate.setDescription("Best Phone");
//
//        Product expectedProduct = new Product();
//        expectedProduct.setId(1L);
//        expectedProduct.setTitle("Samsung");
//       expectedProduct.setImageUrl("some image");
//        expectedProduct.setDescription("Best Phone");
//
//        when(productService.addNewProduct(any(Product.class))).thenReturn(expectedProduct);
//        mockMvc.perform(
//                post("/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(productToCreate)))
//                .andExpect(status().isOk())
//                .andExpect(content().string(objectMapper.writeValueAsString(expectedProduct)))
//                .andExpect((ResultMatcher) jsonPath("$.student.name", is("Satyaki")));
//    }
}
