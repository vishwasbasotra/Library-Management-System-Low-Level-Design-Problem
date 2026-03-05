package com.library.factory;

import com.library.model.Patron;

public class PatronFactory {
    public static Patron create(String type, String id, String name) {
        if (type.equalsIgnoreCase("STUDENT")) return new Student(id, name);
        if (type.equalsIgnoreCase("FACULTY")) return new Faculty(id, name);
        throw new IllegalArgumentException("Unknown Type");
    }
}