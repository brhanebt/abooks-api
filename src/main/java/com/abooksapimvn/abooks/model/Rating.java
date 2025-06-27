package com.abooksapimvn.abooks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "abt_ratings")
@NamedQuery(name = "getRatingByRatings", query = "Select r from Rating r where r.BOOKRATING in :ratings ")
public class Rating {

    @EmbeddedId
    private RatingId id;
    
    private String BOOKRATING;
}