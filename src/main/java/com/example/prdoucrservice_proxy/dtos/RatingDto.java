package com.example.prdoucrservice_proxy.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RatingDto {
    private double rating;
    private double count;
}
