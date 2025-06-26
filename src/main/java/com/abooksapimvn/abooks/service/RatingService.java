package com.abooksapimvn.abooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abooksapimvn.abooks.model.Rating;
import com.abooksapimvn.abooks.repository.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingByRatings(List<String> ratings) {
        return ratingRepository.findByRatings(ratings);
    }
}
