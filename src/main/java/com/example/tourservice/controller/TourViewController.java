package com.example.tourservice.controller;

import com.example.tourservice.repository.TourRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tours")
public class TourViewController {

    private final TourRepository tourRepository;

    public TourViewController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @GetMapping("/view")
    public String viewTours(Model model) {
        model.addAttribute("tours", tourRepository.findAll());
        return "tours"; // looks for src/main/resources/templates/tours.html
    }
}
