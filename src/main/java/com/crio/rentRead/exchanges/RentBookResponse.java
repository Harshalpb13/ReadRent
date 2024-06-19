package com.crio.rentRead.exchanges;

import com.crio.rentRead.dto.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;


@Data
@AllArgsConstructor
public class RentBookResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String role;

    private Set<Book> rentedBooks;

}
