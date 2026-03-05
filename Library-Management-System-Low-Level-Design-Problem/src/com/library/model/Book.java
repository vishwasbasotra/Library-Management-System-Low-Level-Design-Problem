package com.library.model;

public class Book {
    private String isbn, title, author, genre;
    private BookStatus status;

    public Book(String isbn, String title, String author, String genre) {
        this.isbn = isbn; this.title = title; this.author = author;
        this.genre = genre; this.status = BookStatus.AVAILABLE;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + isbn + "] " + title + " (" + status + ")";
    }
}