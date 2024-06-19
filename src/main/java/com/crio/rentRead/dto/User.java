package com.crio.rentRead.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

    private Set<Book> rentedBooks;

}
