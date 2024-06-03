package com.example.bookstore;

public class BookNotFoundُError extends RuntimeException{
    public BookNotFoundُError(String message){
        super(message);
    }
}
