package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1", "Genre1");
        library.addBook(book);
        assertEquals(1, library.displayAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1", "Genre1");
        library.addBook(book);
        assertTrue(library.removeBook("Title1"));
        assertFalse(library.removeBook("NonExistentTitle"));
    }

    @Test
    public void testSearchBooks() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "Genre1");
        Book book2 = new Book("Title2", "Author2", "Genre2");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> result = library.searchBooks("Title1");
        assertEquals(1, result.size());
        assertEquals(book1, result.get(0));
    }

    @Test
    public void testListBooksByGenre() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "Genre1");
        Book book2 = new Book("Title2", "Author2", "Genre1");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> result = library.listBooksByGenre("Genre1");
        assertEquals(2, result.size());
    }

    @Test
    public void testDisplayAllBooks() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "Genre1");
        Book book2 = new Book("Title2", "Author2", "Genre2");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> result = library.displayAllBooks();
        assertEquals(2, result.size());
    }
}

