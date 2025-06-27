package com.abooksapimvn.abooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abooksapimvn.abooks.model.Book;
import com.abooksapimvn.abooks.repository.BookRepository;
import com.abooksapimvn.abooks.exception.BookNotFoundException;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book getABook(String isbn){
        return bookRepository.findById(isbn)
            .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByPublisherAndYear(String publisher, Integer year) {
        return bookRepository.getBooksByPublisherAndYear(publisher,year);
    }

    public List<Book> getBooksByPublishersAndYears(List<String> publishers, List<String> years) {
        return bookRepository.getBooksByPublishersAndYears(publishers,years);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.getBooksByBookAuthor(author);
    }
}