package com.example.LibraryMS.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    name, email, and membership date.
    private String name;
    private String email;
    private Date membershipDate;

    @OneToMany
    private List<Book> borrowedBook=new ArrayList<>();

    @OneToOne
    private MemberProfile profile;

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public List<Book> getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(List<Book> borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public MemberProfile getProfile() {
        return profile;
    }

    public void setProfile(MemberProfile profile) {
        this.profile = profile;
    }
}
