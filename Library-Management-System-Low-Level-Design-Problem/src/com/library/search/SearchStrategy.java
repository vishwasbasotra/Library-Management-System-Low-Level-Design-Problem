package com.library.search;
import com.library.model.Book;
import java.util.*;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String query);
}
