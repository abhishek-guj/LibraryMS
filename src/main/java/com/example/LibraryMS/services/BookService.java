package com.example.LibraryMS.services;

import com.example.LibraryMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    //    @Autowired
    BookRepository bookRepository;

    @Autowired(required = true)
    public BookService(BookRepository repo) {
        this.bookRepository = repo;
    }
//
//
//    public List<Book> getAllBooks() {
////        List<Book> response = bookRepository.findAll();
//        List<Book> a = new ArrayList<>();
//        return a;
//    }
}
