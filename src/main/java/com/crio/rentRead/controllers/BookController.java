package com.crio.rentRead.controllers;

import com.crio.rentRead.dto.Book;
import com.crio.rentRead.exceptions.*;
import com.crio.rentRead.exchanges.*;
import com.crio.rentRead.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(BookController.BOOK_API_ENDPOINT)
public class BookController {
    public static final String BOOK_API_ENDPOINT = "/books";

    @Autowired
    private BookService bookService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        Book book = bookService.createBook(createBookRequest);
        return ResponseEntity.ok().body(book);
    }

    // @AuthenticationPrincipal: This annotation provides the details of the currently authenticated user
    @PostMapping("/{bookId}/rent") 
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<RentBookResponse> rentBook(@PathVariable (value = "bookId") int bookId, @AuthenticationPrincipal UserDetails userDetails) throws UserNotFoundException, BookNotFoundException, BookNotAvailableException, RentalException {
        RentBookResponse rentBookResponse = bookService.rentBook(bookId, userDetails);
        return ResponseEntity.ok().body(rentBookResponse);
    }

    @PostMapping("/{bookId}/return")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReturnBookResponse> returnBook(@PathVariable (value = "bookId") int bookId, @AuthenticationPrincipal UserDetails userDetails) throws UserNotFoundException, BookNotFoundException, BookNotRentedException {
        ReturnBookResponse returnBookResponse = bookService.returnBook(bookId, userDetails);
        return ResponseEntity.ok().body(returnBookResponse);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        GetAllBooksResponse getAllBooksResponse = bookService.findAllBooks();
        return ResponseEntity.ok().body(getAllBooksResponse);
    }

    @PutMapping("/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "bookId") int bookId, @Valid @RequestBody UpdateBookRequest updateBookRequest) throws BookNotFoundException {
        Book book = bookService.updateBook(bookId, updateBookRequest);
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "bookId") int bookId) throws BookNotFoundException {
        String response = bookService.deleteBook(bookId);
        return ResponseEntity.ok().body(response);
    }

}
