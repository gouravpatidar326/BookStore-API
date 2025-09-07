package com.gourav.BookStore.controller;

import com.gourav.BookStore.entity.Author;
import com.gourav.BookStore.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {


    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/getAll")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("getById/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id).orElse(null);
    }

    @PostMapping("/add-author")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PutMapping("update/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        return authorService.updateAuthor(id, authorDetails);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}