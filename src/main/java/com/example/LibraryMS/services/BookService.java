package com.example.LibraryMS.services;

import com.example.LibraryMS.entities.Book;
import com.example.LibraryMS.repository.BookRepository;
import com.example.LibraryMS.services.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService implements IBookService {

//    @Autowired(required = true)
//    MemberRepository memberRepository;

    @Autowired(required = true)
    BookRepository bookRepository;
//    @Autowired(required = true)
//    public BookService(BookRepository repo) {
//        this.bookRepository = repo;
//    }

    //
    @Transactional
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }

    @Override
    public Page<Book> listBooks(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return bookRepository.findAll(pageable);

    }

    //
    // ??? later pass dto here
    @Override
    public List<Book> getAllBooksWithFilters() {
//        Specification<Book> spec = com.roima.utils.BookSpecs.withParams(Book);
//        List<Book> filteredBooks = bookRepository.findAll(spec);
        List<Book> filteredBooks = bookRepository.findAll();
        return filteredBooks;
    }


    @Transactional
    @Override
    public Book createBook(Book book) {

        // using entity manager
        // ??? need to configure entity manager
        // entityManager.persist(book);

        // return entityMapper.toBookDTO(book);
        return new Book();
    }

    @Transactional
    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook == null) {
            return null;
        }

        // Update fields
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setLibrary(book.getLibrary());
        existingBook.setTitle(book.getTitle());
        existingBook.setPublicationYear(book.getPublicationYear());

        Book updatedBook = bookRepository.save(existingBook);
        return updatedBook;
    }
}
