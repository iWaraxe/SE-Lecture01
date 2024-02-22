package com.coherentsolution.section02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private final String libraryName;
    private List<Book> books;
    private List<Magazine> magazines;
    private int totalReadingHours;

    private DuplicateChecker duplicateChecker;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.magazines = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Cannot add a null book");
        }
        boolean isDuplicate = DuplicateChecker.isDuplicate(book.getName(), this.books);
        if (!isDuplicate) {
            books.add(book);
            totalReadingHours += book.getReadingHours();
        }
    }

    public void addMagazine(Magazine magazine) {
        if (magazine == null) {
            throw new IllegalArgumentException("Cannot add a null magazine");
        }
        magazines.add(magazine);
        totalReadingHours += magazine.getReadingHours();
    }

    public int getTotalReadingHours() {
        return totalReadingHours;
    }

    public List<? extends Item> getBooks() {
        return (List<? extends Item>) Collections.unmodifiableList(books);
    }

    public List<? extends Item> getMagazines() {
        return (List<? extends Item>) Collections.unmodifiableList(magazines);
    }

    public void setDuplicateChecker(DuplicateChecker duplicateChecker) {
        this.duplicateChecker = duplicateChecker;
    }

    // Methods to remove books and magazines are omitted for brevity
}

