package com.example.tourservice.dto;

import lombok.Data;

@Data
public class TourRequest {
    private String image;
    private String discountInPercentage;
    private String title;
    private String description;
    private String duration;
    private String actualPrice;
    private String discountedPrice;
    private String location;
}
