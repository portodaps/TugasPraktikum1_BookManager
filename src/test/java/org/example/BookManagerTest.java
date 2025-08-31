package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book book = new Book("Pemrograman", "Andi", 2026);
        bookManager.addBook(book);

        assertEquals(1, bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book book = new Book("Basis Data", "Erlangga", 2021);
        bookManager.addBook(book);

        boolean removed = bookManager.removeBook("Basis Data");

        assertTrue(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        boolean removed = bookManager.removeBook("Buku Ga Ada");

        assertFalse(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test mencari buku berdasarkan penulis")
    void testFindBooksByAuthor() {
        Book book1 = new Book("Pemrograman", "Andi", 2020);
        Book book2 = new Book("Java OOP", "Andi", 2022);
        Book book3 = new Book("Basis Data", "Budi", 2021);

        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        List<Book> result = bookManager.findBooksByAuthor("Andi");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getPenulis().equals("Andi")));
    }

    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        Book book1 = new Book("Pemrograman", "Andi", 2020);
        Book book2 = new Book("Basis Data", "Budi", 2021);

        bookManager.addBook(book1);
        bookManager.addBook(book2);

        List<Book> allBooks = bookManager.getAllBooks();

        assertEquals(2, allBooks.size());
        assertTrue(allBooks.contains(book1));
        assertTrue(allBooks.contains(book2));
    }

    @Test
    @DisplayName("Test mencari buku berdasarkan tahun")
    void testFindBooksByYear() {
        Book book1 = new Book("Pemrograman", "Andi", 2020);
        Book book2 = new Book("Java OOP", "Andi", 2022);

        bookManager.addBook(book1);
        bookManager.addBook(book2);

        List<Book> result = bookManager.findBooksByYear(2022);

        assertEquals(1, result.size());
        assertEquals("Java OOP", result.get(0).getJudul_buku());
    }
}
