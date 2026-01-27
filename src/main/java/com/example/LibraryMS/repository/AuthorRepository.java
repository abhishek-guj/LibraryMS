package com.example.LibraryMS.repository;

import com.example.LibraryMS.entities.Author;
import com.example.LibraryMS.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
