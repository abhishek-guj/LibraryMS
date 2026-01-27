package com.example.LibraryMS.controller;


import com.example.LibraryMS.entities.Book;
import com.example.LibraryMS.repository.BookRepository;
import com.example.LibraryMS.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
    @GetMapping("/")
    public String getAllBooks(){
        return "asasdasd";
    }

    @GetMapping("/a")
    public List<Book> getHealth() {

        return bookService.getAllBooks();

    }
}
