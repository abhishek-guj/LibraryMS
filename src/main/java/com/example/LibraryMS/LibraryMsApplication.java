package com.example.LibraryMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.LibraryMS.repository"})
@EnableJpaRepositories(basePackages = "com.example.LibraryMS.repository")
public class LibraryMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryMsApplication.class, args);
    }

}
