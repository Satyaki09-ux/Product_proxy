package com.example.prdoucrservice_proxy.services;

import com.example.prdoucrservice_proxy.clients.fakestore.client.FakeStoreClient;
import com.example.prdoucrservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FakeStoreProductServiceTest {
    @Autowired
    FakeStoreClient fakeStoreClient;
    @Test
    public void Test_FakeStoreClient(){
        List<FakeStoreProductDto> result = fakeStoreClient.getAllProducts();
        assertNotNull(result);

    }

}