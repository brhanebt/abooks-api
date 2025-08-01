package com.abooksapimvn.abooks.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abooksapimvn.abooks.model.Rating;
import com.abooksapimvn.abooks.service.RatingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v1")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("ratings")
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }
    

    // Multiple ratings by rating value
    // Example:- /api/v1/ratings/ratingId?r=9&r=5
    @GetMapping("ratings/ratingId")
    public ResponseEntity<List<Rating>> getRatings(@RequestParam("r") List<String> ratings) {
        return ResponseEntity.ok().body(ratingService.getRatingByRatings(ratings));
    }
}
