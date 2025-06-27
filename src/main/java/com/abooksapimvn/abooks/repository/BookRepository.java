package com.abooksapimvn.abooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abooksapimvn.abooks.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

    @Query(name = "getBooksByPublisherAndYear")
    List<Book> getBooksByPublisherAndYear(String publisher, Integer year);

    @Query(name = "getBooksByPublishersAndYears")
    List<Book> getBooksByPublishersAndYears(@Param("publishers") List<String> publishers, @Param("years") List<String> years);
    @Query(name = "getBooksByBookAuthor")
    List<Book> getBooksByBookAuthor(String author);

}