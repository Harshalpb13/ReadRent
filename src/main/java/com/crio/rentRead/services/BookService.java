package com.crio.rentRead.services;

import com.crio.rentRead.dto.Book;
import com.crio.rentRead.exceptions.*;
import com.crio.rentRead.exchanges.*;
import org.springframework.security.core.userdetails.UserDetails;

public interface BookService {

    Book createBook(CreateBookRequest createBookRequest);

    RentBookResponse rentBook(int bookId, UserDetails userDetails) throws UserNotFoundException, BookNotFoundException, BookNotAvailableException, RentalException;

    ReturnBookResponse returnBook(int bookId, UserDetails userDetails) throws UserNotFoundException, BookNotFoundException, BookNotRentedException;

    Book updateBook(int bookId, UpdateBookRequest updateBookRequest) throws BookNotFoundException;

    GetAllBooksResponse findAllBooks();

    String deleteBook(int bookId) throws BookNotFoundException;
    
}
