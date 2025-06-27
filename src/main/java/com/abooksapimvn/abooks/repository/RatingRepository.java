package com.abooksapimvn.abooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abooksapimvn.abooks.model.Rating;
import com.abooksapimvn.abooks.model.RatingId;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId>{
    @Query(name = "getRatingByRatings")
    List<Rating> findByRatings(List<String> ratings);
}
