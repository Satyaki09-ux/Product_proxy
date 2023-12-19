package com.example.prdoucrservice_proxy.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private  double price;
    private String imageUrl;
   private String Category;
    private RatingDto rating;
}
