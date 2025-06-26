package com.abooksapimvn.abooks.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RatingId implements Serializable {
    private String USERID;
    private String ISBN;
    
    public RatingId() {}
    
    public RatingId(String userid, String isbn) {
        this.USERID = userid;
        this.ISBN = isbn;
    }
}
