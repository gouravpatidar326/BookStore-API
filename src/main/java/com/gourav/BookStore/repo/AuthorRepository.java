package com.gourav.BookStore.repo;

import com.gourav.BookStore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
