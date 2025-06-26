package com.abooksapimvn.abooks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "abt_ratings")
public class Rating {

    @EmbeddedId
    private RatingId id;
    
    private String BOOKRATING;
}