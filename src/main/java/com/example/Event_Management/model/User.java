package com.example.Event_Management.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;

    @OneToMany
    @JsonManagedReference(value = "user_id")
    private List<Bookings> books;

    public User(long id, String name, String email, List<Bookings> books) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.books = books;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Bookings> getBooks() {
        return books;
    }

    public void setBooks(List<Bookings> books) {
        this.books = books;
    }
}
