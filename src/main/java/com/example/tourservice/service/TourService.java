package com.example.tourservice.service;

import com.example.tourservice.dto.TourRequest;
import com.example.tourservice.dto.TourResponse;
import com.example.tourservice.entity.Tour;
import com.example.tourservice.exception.ResourceNotFoundException;
import com.example.tourservice.repository.TourRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {

    private final TourRepository repo;

    public TourService(TourRepository repo) {
        this.repo = repo;
    }

    public TourResponse createTour(TourRequest req) {
        Tour t = new Tour();
        t.setImage(req.getImage());
        t.setDiscountInPercentage(req.getDiscountInPercentage());
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        t.setDuration(req.getDuration());
        t.setActualPrice(req.getActualPrice());
        t.setDiscountedPrice(req.getDiscountedPrice());
        t.setLocation(req.getLocation());
        Tour saved = repo.save(t);
        return map(saved);
    }

    public List<TourResponse> listAll() {
        return repo.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    public TourResponse getById(Long id) {
        Tour t = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tour not found: " + id));
        return map(t);
    }

    public List<TourResponse> searchByLocation(String location) {
        return repo.findByLocationIgnoreCaseContaining(location).stream().map(this::map).collect(Collectors.toList());
    }

    private TourResponse map(Tour t) {
        TourResponse r = new TourResponse();
        r.setId(t.getId());
        r.setImage(t.getImage());
        r.setDiscountInPercentage(t.getDiscountInPercentage());
        r.setTitle(t.getTitle());
        r.setDescription(t.getDescription());
        r.setDuration(t.getDuration());
        r.setActualPrice(t.getActualPrice());
        r.setDiscountedPrice(t.getDiscountedPrice());
        r.setLocation(t.getLocation());
        return r;
    }
}
