package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchId, branchName;
    private List<Book> inventory = new ArrayList<>();

    public Branch(String id, String name) {
        this.branchId = id;
        this.branchName = name; // Fixed: was branchName (self-assign)
    }

    public void addBook(Book b) { inventory.add(b); }
    public void removeBook(Book b) { inventory.remove(b); }
    public List<Book> getInventory() { return inventory; }
    public String getBranchName() { return branchName; }
}