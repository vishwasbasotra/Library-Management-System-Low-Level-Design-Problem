package com.library.search;

import com.library.model.Book;
import java.util.*;
import java.util.stream.Collectors;

public class AuthorSearch implements SearchStrategy {
    public List<Book> search(List<Book> b, String q) {
        return b.stream().filter(x -> x.getAuthor().equalsIgnoreCase(q)).collect(Collectors.toList());
    }
}
