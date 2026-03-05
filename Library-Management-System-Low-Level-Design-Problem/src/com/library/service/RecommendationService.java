package com.library.service;

import com.library.model.*;
import com.library.observer.ReservationObserver;
import java.util.*;
import java.util.stream.Collectors;

public class RecommendationService {
    public List<Book> recommend(Patron p, List<Book> inventory) {
        String favGenre = p.getHistory().stream()
                .collect(Collectors.groupingBy(r -> r.getBook().getGenre(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("");

        return inventory.stream()
                .filter(b -> b.getGenre().equals(favGenre) && b.getStatus() == BookStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
