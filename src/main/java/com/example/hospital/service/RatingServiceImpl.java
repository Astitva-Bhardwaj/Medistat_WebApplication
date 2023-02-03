package com.example.hospital.service;

import com.example.hospital.model.user.Rating;
import com.example.hospital.repository.rating.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RatingServiceImpl {

    @Autowired
    RatingRepository ratingRepository;

    public void addRating(Rating rating)
    {
        log.info("RatingServiceImpl -- addRating");
        ratingRepository.save(rating);
    }
}
