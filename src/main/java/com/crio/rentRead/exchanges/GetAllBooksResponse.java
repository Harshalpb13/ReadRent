package com.crio.rentRead.exchanges;

import com.crio.rentRead.dto.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetAllBooksResponse {
    
    private List<Book> books;
    
}
