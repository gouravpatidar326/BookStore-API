package com.gourav.BookStore.repo;

import com.gourav.BookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}