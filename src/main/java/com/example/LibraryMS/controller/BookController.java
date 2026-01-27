package com.example.LibraryMS.controller;


import com.example.LibraryMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BookController {
//    @Autowired
//    BookRepository bookRepository;


    @GetMapping("/")
//    public List<Book> getHealth() {
    public String getHealth() {
//        Book b = new Book();
//        return bookService.getAllBooks();
        return "asada";
    }
}
