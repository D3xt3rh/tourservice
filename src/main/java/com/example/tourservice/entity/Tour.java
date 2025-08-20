package com.example.tourservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tours")
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String discountInPercentage;
    private String title;
    private String description;
    private String duration;
    private String actualPrice;
    private String discountedPrice;
    private String location;
}
