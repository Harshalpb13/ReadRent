package com.crio.rentRead.repositories;

import com.crio.rentRead.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    
}
