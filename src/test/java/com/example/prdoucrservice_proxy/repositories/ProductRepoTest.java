package com.example.prdoucrservice_proxy.repositories;

import com.example.prdoucrservice_proxy.models.Categories;
import com.example.prdoucrservice_proxy.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepoTest {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @Test
    @Transactional
    void saveProductAndCategory() {
        Categories categories = new Categories();
        categories.setName("ElectronicsAndMobiles");
        categories.setDescription("Electronics Products Mobiles");
        categoryRepo.save(categories);

        Product product = new Product();
        product.setTitle("Mobile");
        product.setDescription("Mobile");
        product.setCategory(categories);
        productRepo.save(product);

    }
    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductAndCategory2(){
        Categories category = categoryRepo.findById(2L);
//        Product product = new Product();
//        product.setPrice(1012);
//        product.setImageUrl("hiii");
//        product.setCategory(category);
//        Product savedProduct = productRepo.save(product);
//
//         product = new Product();
//        product.setPrice(103);
//        product.setImageUrl("hiii");
//        product.setCategory(category);
//        productRepo.save(product);


    }
}