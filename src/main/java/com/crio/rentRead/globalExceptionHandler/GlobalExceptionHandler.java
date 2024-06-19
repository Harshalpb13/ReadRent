package com.crio.rentRead.globalExceptionHandler;

import com.crio.rentRead.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(BookNotFoundException.class)
    ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(401).body(message);
    }

    @ExceptionHandler(UserNotRegisteredException.class)
    ResponseEntity<String> handleUserNotRegisteredException(UserNotRegisteredException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(BookNotAvailableException.class)
    ResponseEntity<String> handleBookNotAvailableException(BookNotAvailableException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    
    @ExceptionHandler(RentalException.class)
    ResponseEntity<String> handleRentalException(RentalException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(BookNotRentedException.class)
    ResponseEntity<String> handleBookNotRentedException(BookNotRentedException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }
}
