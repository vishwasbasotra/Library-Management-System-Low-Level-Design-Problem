package com.library.observer;

import com.library.model.Book;

public interface ReservationObserver {
    void onBookAvailable(Book book);
}
