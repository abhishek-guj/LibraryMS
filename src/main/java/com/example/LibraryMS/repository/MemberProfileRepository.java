package com.example.LibraryMS.repository;

import com.example.LibraryMS.entities.Book;
import com.example.LibraryMS.entities.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long> {
}
