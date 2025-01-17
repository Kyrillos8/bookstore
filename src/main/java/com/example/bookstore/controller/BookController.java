package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public List<Book> getAllBooks() {
        if (bookService.getAllBooks().isEmpty()) {
            return null;
        }
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        if (bookService.getBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String createBook(@RequestBody Book book, @RequestHeader("Authorization") String token) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            return "Book title cannot be null or empty";
        }
        if (bookService.bookExistsByTitle(book.getTitle())) {
            return "Book with this title already exists";
        }

        // Extract username from token and set it as author of the book before saving
        String username = jwtUtil.extractUsername(token.substring(7));
        book.setAuthor(username);
        bookService.saveBook(book);
        return "Book created successfully";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (bookService.getBookById(id).isEmpty()) {
            return ResponseEntity.ok("There is no book by this id");
        }
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
