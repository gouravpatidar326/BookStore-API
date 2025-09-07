package com.gourav.BookStore.service;

import com.gourav.BookStore.entity.Author;
import com.gourav.BookStore.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            author.setName(authorDetails.getName());
            author.setBio(authorDetails.getBio());
            author.setBirthdate(authorDetails.getBirthdate());
            // No need to set books here as it's managed via Book entity
            return authorRepository.save(author);
        } else {
            return null;
        }
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
