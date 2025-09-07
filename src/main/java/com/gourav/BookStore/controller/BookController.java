package com.gourav.BookStore.controller;

import com.gourav.BookStore.entity.Book;
import com.gourav.BookStore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("getById/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElse(null);
    }

    @PostMapping("/addBook")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existingBook = bookService.getBookById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPrice(book.getPrice());
            existingBook.setPublicationDate(book.getPublicationDate());
            existingBook.setAuthor(book.getAuthor());
            return bookService.saveBook(existingBook);
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}