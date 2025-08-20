package com.example.tourservice.controller;

import com.example.tourservice.dto.TourRequest;
import com.example.tourservice.dto.TourResponse;
import com.example.tourservice.service.S3Service;
import com.example.tourservice.service.TourService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourService service;
    private final S3Service s3Service;

    public TourController(TourService service, S3Service s3Service) {
        this.service = service;
        this.s3Service = s3Service;
    }

    @PostMapping("/tours")
    public ResponseEntity<TourResponse> create(@Valid @RequestBody TourRequest req) {
        TourResponse created = service.createTour(req);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<TourResponse>> list(@RequestParam(value = "location", required = false) String location) {
        if (location != null && !location.isBlank()) {
            return ResponseEntity.ok(service.searchByLocation(location));
        } else {
            return ResponseEntity.ok(service.listAll());
        }
    }

    @PostMapping("/tours/upload")
    public ResponseEntity<TourResponse> createWithImage(
            @RequestPart("tour") @Valid TourRequest req,
            @RequestPart("image") MultipartFile image) throws IOException {

        String imageUrl = s3Service.uploadFile(image);
        req.setImage(imageUrl);
        TourResponse created = service.createTour(req);
        return ResponseEntity.status(201).body(created);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TourResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
