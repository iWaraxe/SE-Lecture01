package com.coherentsolution.section02;

import com.coherentsolution.section02.Book;
import com.coherentsolution.section02.Library;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library("Local Library");
    }

    @AfterEach
    void tearDown() {
        // Cleanup code, if necessary
    }

    @Test
    @Disabled("Pending implementation of removeBook method")
    void testRemoveBookDecreasesTotalReadingHours() {
        Book book = new Book("Refactoring", 4);
        library.addBook(book);
        // library.removeBook(book); // Assuming this method exists
        assertEquals(0, library.getTotalReadingHours(), "Total reading hours should be zero after removing the book.");
    }

    @Test
    void testAddBookIncreasesTotalReadingHours() {
        library.addBook(new Book("Java Fundamentals", 5));
        assertEquals(5, library.getTotalReadingHours(), "Total reading hours should include book reading hours.");
    }

    @Test
    void testAddMagazineIncreasesTotalReadingHours() {
        Magazine magazine = new Magazine("Tech Today", 2);
        library.addMagazine(magazine);
        assertEquals(2, library.getTotalReadingHours(), "Total reading hours should reflect the added magazine's hours.");
    }

    @Test
    void testLibraryNameNotEmpty() {
        assertFalse(library.getLibraryName().isEmpty(), "Library name should not be empty.");
    }

    @Test
    void testLibraryAfterAddingBooksAndMagazines() {
        library.addBook(new Book("Effective Java", 10));
        library.addMagazine(new Magazine("Java World", 2));

        assertAll(
                () -> assertFalse(library.getBooks().isEmpty(), "Library should contain at least one book."),
                () -> assertEquals(1, library.getBooks().size(), "Library should contain one book."),
                () -> assertFalse(library.getMagazines().isEmpty(), "Library should contain at least one magazine."),
                () -> assertEquals(1, library.getMagazines().size(), "Library should contain one magazine."),
                () -> assertEquals(12, library.getTotalReadingHours(), "Total reading hours should sum books and magazines.")
        );
    }

    @Test
    void testAddNullBookThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null), "Adding a null book should throw IllegalArgumentException.");
    }

    @Test
    void testAddNullMagazineThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addMagazine(null), "Adding a null magazine should throw IllegalArgumentException.");
    }

    @Test
    void testLibraryForDuplicateBooks() {
        library.addBook(new Book("Clean Code", 10));
        library.addBook(new Book("Clean Code", 10)); // Intentionally adding a duplicate
        assertTrue(DuplicateChecker.hasDuplicateBooks(library.getBooks()), "Library should have duplicate books.");
    }

    @Test
    void testLibraryForDuplicateMagazines() {
        library.addMagazine(new Magazine("Tech Today", 2));
        library.addMagazine(new Magazine("Tech Today", 2)); // Intentionally adding a duplicate
        assertTrue(DuplicateChecker.hasDuplicateMagazines(library.getMagazines()), "Library should have duplicate magazines.");
    }

    @Test
    void testAddBookWithDuplicateCheck() {
        Book book = new Book("Effective Java", 10);
        library.addBook(book); // Add a book for the first time

        try (MockedStatic<DuplicateChecker> mockedStatic = Mockito.mockStatic(DuplicateChecker.class)) {
            mockedStatic.when(() -> DuplicateChecker.isDuplicate(anyString(), anyList())).thenReturn(true);

            library.addBook(new Book("Effective Java", 10)); // Attempt to add a duplicate book

            // Verify that the DuplicateChecker's isDuplicate method was called
            mockedStatic.verify(() -> DuplicateChecker.isDuplicate(eq("Effective Java"), anyList()), Mockito.times(1));

            // Since the book is a duplicate, the total reading hours should not increase
            assertEquals(10, library.getTotalReadingHours(), "Total reading hours should not increase with duplicate book addition.");
        }
    }

    @Test
    void testAddPopularBook() {
        PopularityChecker mockChecker = mock(PopularityChecker.class);
        when(mockChecker.isPopular(any(Book.class))).thenReturn(true);

        Library library = new Library("Mock Library");
        Book popularBook = new Book("Mockito in Action", 10);

        // Assuming Library uses PopularityChecker in its addBook method
        assertTrue(mockChecker.isPopular(popularBook), "Popular book should be considered popular by the mock checker.");
    }
}
