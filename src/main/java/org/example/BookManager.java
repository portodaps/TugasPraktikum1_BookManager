package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Kelas untuk mengelola daftar buku.
 * Menyediakan fitur menambah, menghapus, mencari, dan menghitung jumlah buku.
 */
public class BookManager {
    private final List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    /**
     * Menambahkan buku ke dalam daftar.
     *
     * @param book buku yang akan ditambahkan
     * @throws IllegalArgumentException jika parameter book null
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Buku tidak boleh kosong");
        }
        books.add(book);
    }

    /**
     * Menghapus buku berdasarkan judul.
     *
     * @param judul judul buku
     * @return true jika buku berhasil dihapus, false jika tidak ditemukan
     * @throws IllegalArgumentException jika judul kosong atau null
     */
    public boolean removeBook(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return books.removeIf(b -> b.getJudul_buku().equalsIgnoreCase(judul.trim()));
    }

    /**
     * Mendapatkan semua buku dalam daftar.
     *
     * @return salinan daftar buku
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Mencari buku berdasarkan penulis.
     *
     * @param penulis nama penulis
     * @return daftar buku dari penulis yang dicari
     * @throws IllegalArgumentException jika nama penulis kosong atau null
     */
    public List<Book> findBooksByAuthor(String penulis) {
        if (penulis == null || penulis.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        return books.stream()
                .filter(b -> b.getPenulis().equalsIgnoreCase(penulis.trim()))
                .collect(Collectors.toList());
    }

    /**
     * Mencari buku berdasarkan tahun terbit.
     *
     * @param tahun tahun terbit buku
     * @return daftar buku pada tahun yang dicari
     * @throws IllegalArgumentException jika tahun tidak di antara 2000–2100
     */
    public List<Book> findBooksByYear(int tahun) {
        if (tahun < 2000 || tahun > 2100) {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
        }
        return books.stream()
                .filter(b -> b.getTahun() == tahun)
                .collect(Collectors.toList());
    }

    /**
     * Menghitung jumlah buku.
     *
     * @return jumlah buku
     */
    public int getBookCount() {
        return books.size();
    }

    /**
     * Mengecek apakah buku dengan judul tertentu ada di daftar.
     *
     * @param judul judul buku
     * @return true jika ada, false jika tidak
     * @throws IllegalArgumentException jika judul kosong atau null
     */
    public boolean containsBook(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return books.stream()
                .anyMatch(b -> b.getJudul_buku().equalsIgnoreCase(judul.trim()));
    }

    /**
     * Menghapus semua buku dari daftar.
     */
    public void clearAllBooks() {
        books.clear();
    }
}
