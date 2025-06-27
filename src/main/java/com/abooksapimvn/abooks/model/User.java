package com.abooksapimvn.abooks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "abt_users")
@NamedQuery(name = "findAllByLocation",query="select u from User u where u.location in :locations")
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USERID")
    private Long userId;
    @Column(name="LOCATION")
    private String location;
    @Column(name="AGE")
    private Integer age;
}
