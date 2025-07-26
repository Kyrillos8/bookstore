package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
        List<Book> books = bookService.getAllBooks();
        return books.isEmpty() ? Collections.emptyList() : books;
    }

    @GetMapping("/myBooks")
    public ResponseEntity<List<Book>> getMyBooks(@RequestHeader("Authorization") String token) {
        try {
            String author = jwtUtil.extractUsername(token.substring(7));
            List<Book> myBooks = bookService.getMyBooks(author);
            return myBooks.isEmpty()
                    ? ResponseEntity.noContent().build()
                    : ResponseEntity.ok(myBooks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        var book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
    public ResponseEntity<Object> deleteBook(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        try {
            String username = jwtUtil.extractUsername(token.substring(7));
            var book = bookService.getBookById(id);

            if (book.isEmpty() || !book.get().getAuthor().equals(username)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot delete this book");
        }
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
}