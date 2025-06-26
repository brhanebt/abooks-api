package com.abooksapimvn.abooks.controller;

import org.springframework.web.bind.annotation.RestController;

import com.abooksapimvn.abooks.model.Book;
import com.abooksapimvn.abooks.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1")
public class BookController {
    @Autowired
    private BookService bookService;

        
    @GetMapping("books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();

    }

    @GetMapping("books/{booIsbn}")
    public Book getABook(@PathVariable String booIsbn) {
        return bookService.getABook(booIsbn);
    }
    
    //Get books by publisher and year
    //Example: http://localhost:8081/api/v1/books/Penguin Books Ltd/2001
    @GetMapping("books/{publisher}/{year}")
    public List<Book> getBooksByPublisherAndYear(@PathVariable String publisher, @PathVariable Integer year) {
        return bookService.getBooksByPublisherAndYear(publisher, year);
    }

    // Get books by multiple publishers and in different years
    //Example: http://localhost:8081/api/v1/books/publishers/years?p=Penguin%20Books%20Ltd&p=Ballantine%20Books&y=2001&y=1969
    @GetMapping("books/publishers/years")
    public List<Book> getBooksByPublishersAndYears(@RequestParam("p") List<String> publishers, @RequestParam("y") List<String> years) {
        return bookService.getBooksByPublishersAndYears(publishers,years);
    }
    
    

}
