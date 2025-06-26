package com.abooksapimvn.abooks.model;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "abt_amazonbooks")
@NamedQuery(name = "getBooksByPublisherAndYear", query = "Select b from Book b where b.YearOfPublication=:year and b.publisher=:publisher")
@NamedQuery(name = "getBooksByPublishersAndYears", query = "Select b from Book b where b.YearOfPublication in :years and b.publisher in :publishers")
public class Book {
    @Id
    private String Isbn;
    @Column(name = "bookTitle")
    private String bookTitle;
    @Column(name = "bookAuthor")
    private String bookAuthor;
    @Column(name = "YearOfPublication")
    private String YearOfPublication;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "ImageURLS")
    private String ImageURLS;
    @Column(name = "ImageURLM")
    private String ImageURLM;
    @Column(name = "ImageURLL")
    private String ImageURLL;
}
