package com.library.service;

import com.library.model.*;

public class BranchService {
    public void transferBook(Book book, Branch fromBranch, Branch toBranch) {
        // Use getInventory() instead of localInventory
        if (fromBranch.getInventory().contains(book)) {
            fromBranch.removeBook(book);
            toBranch.addBook(book);
            System.out.println("LOG: Transferred '" + book.getTitle() + "' from "
                    + fromBranch.getBranchName() + " to " + toBranch.getBranchName());
        } else {
            System.out.println("LOG: Transfer failed. Book not in source branch.");
        }
    }
}