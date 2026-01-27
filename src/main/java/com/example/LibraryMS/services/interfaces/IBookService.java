package com.example.LibraryMS.services.interfaces;

import com.example.LibraryMS.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookService {
    //
    @Transactional
    List<Book> getAllBooks();

    Book findBookById(Long id);

    Page<Book> listBooks(int page, int size, String sortBy, String direction);

    //
    // ??? later pass dto here
    List<Book> getAllBooksWithFilters();

    @Transactional
    Book createBook(Book book);

    @Transactional
    Book updateBook(Long id, Book book);
}
