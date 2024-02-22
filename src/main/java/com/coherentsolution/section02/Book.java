package com.coherentsolution.section02;

public class Book implements Item {

    private String name;
    private int readingHours;

    public Book(String title, int readingHours) {
        this.name = title;
        this.readingHours = readingHours;
    }

    public String getName() {
        return name;
    }

    public int getReadingHours() {
        return readingHours;
    }
}
