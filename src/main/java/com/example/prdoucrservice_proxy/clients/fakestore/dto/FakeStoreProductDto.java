package com.example.prdoucrservice_proxy.clients.fakestore.dto;

import com.example.prdoucrservice_proxy.clients.IClientProductDto;
import com.example.prdoucrservice_proxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto implements IClientProductDto {
    private Long id;
    private String title;
    private String description;
    private  double price;
    private String imageUrl;
    private String Category;
    private RatingDto rating;
}
