package com.library.factory;

import com.library.model.*;

class Student extends Patron {
    public Student(String id, String name) { super(id, name); }
    @Override public int getMaxBorrowLimit() { return 5; }
}
