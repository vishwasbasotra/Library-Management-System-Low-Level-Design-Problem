package com.library.service;

import com.library.model.*;
import com.library.observer.ReservationObserver;
import java.util.*;

public class LendingService {
    private ReservationService resService;
    public LendingService(ReservationService rs) { this.resService = rs; }

    public void checkout(Book b, Patron p) {
        if (b.getStatus() == BookStatus.AVAILABLE) {
            b.setStatus(BookStatus.BORROWED);
            p.addRecord(new LendingRecord(b, p));
        }
    }

    public void returnBook(Book b) { resService.onBookAvailable(b); }
}
