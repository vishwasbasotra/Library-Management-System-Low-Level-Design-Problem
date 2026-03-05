package com.library.service;

import com.library.model.*;
import com.library.observer.ReservationObserver;
import java.util.*;

public class ReservationService implements ReservationObserver {
    private Map<String, Queue<Patron>> reservations = new HashMap<>();

    public void reserve(Book book, Patron patron) {
        reservations.computeIfAbsent(book.getIsbn(), k -> new LinkedList<>()).add(patron);
        book.setStatus(BookStatus.RESERVED);
    }

    @Override
    public void onBookAvailable(Book book) {
        Queue<Patron> q = reservations.get(book.getIsbn());
        if (q != null && !q.isEmpty()) {
            Patron p = q.poll();
            System.out.println("ALERT: Reserved book '" + book.getTitle() + "' is ready for " + p.getName());
        } else {
            book.setStatus(BookStatus.AVAILABLE);
        }
    }
}
