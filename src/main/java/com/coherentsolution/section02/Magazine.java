package com.coherentsolution.section02;

public class Magazine implements Item {

    private String name;
    private int readingHours;

    public Magazine(String name, int readingHours) {
        this.name = name;
        this.readingHours = readingHours;
    }

    public String getName() {
        return name;
    }

    public int getReadingHours() {
        return readingHours;
    }
}
