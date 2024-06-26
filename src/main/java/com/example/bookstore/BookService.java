package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateBookById(Long id,Book details){
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundُError("Book is not found" + id));
        book.setName(details.getName());
        book.setAuthor(details.getAuthor());
        book.setIsbn(details.getIsbn());
        return bookRepository.save(book);
    }
    public void deleteBook(Long id){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundُError("Book is not found" + id);
        }
        bookRepository.deleteById(id);
    }

}
