package com.library.factory;

import com.library.model.Patron;

class Faculty extends Patron {
    public Faculty(String id, String name) {
        super(id, name);
    }
    @Override
    public int getMaxBorrowLimit() {
        return 10;
    }
}
