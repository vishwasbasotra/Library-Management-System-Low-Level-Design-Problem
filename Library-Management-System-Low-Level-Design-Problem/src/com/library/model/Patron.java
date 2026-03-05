package com.library.model;

import java.util.*;

public abstract class Patron {
    private String id, name;
    private List<LendingRecord> history = new ArrayList<>();

    public Patron(String id, String name) {
        this.id = id; this.name = name;
    }
    public abstract int getMaxBorrowLimit();
    public void addRecord(LendingRecord record) {
        history.add(record);
    }
    public List<LendingRecord> getHistory() {
        return history;
    }
    public String getName() {
        return name;
    }
}