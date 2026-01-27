package com.example.LibraryMS.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // if no annotation of column it takes it as itis
    private String name;
    private String location;

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    private List<Book> books=new ArrayList<>();


    public Library(){}
    public Library(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
