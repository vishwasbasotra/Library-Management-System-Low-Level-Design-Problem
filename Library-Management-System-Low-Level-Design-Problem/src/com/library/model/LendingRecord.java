package com.library.model;

import java.time.LocalDate;

public class LendingRecord {
    private Book book;
    private Patron patron;
    private LocalDate date;

    public LendingRecord(Book book, Patron patron) {
        this.book = book; this.patron = patron; this.date = LocalDate.now();
    }
    public Book getBook() { return book; }
}
