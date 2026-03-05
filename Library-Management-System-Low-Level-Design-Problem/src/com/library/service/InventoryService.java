package com.library.service;

import com.library.model.*;
import com.library.exception.BookNotFoundException;
import java.util.*;

public class InventoryService {
    private List<Book> allBooks = new ArrayList<>();

    public void addBook(Book b) { allBooks.add(b); }
    public List<Book> getAll() { return allBooks; }

    public Book findByIsbn(String isbn) throws BookNotFoundException {
        return allBooks.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found: " + isbn));
    }
}
