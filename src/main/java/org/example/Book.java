package org.example;

public class Book {
    private final String Judul_buku;
    private final String Penulis;
    private final int Tahun;

    public Book(String judulBuku, String penulis, int tahun) {
        if (judulBuku == null || judulBuku.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul harus diisi");
        }

        if (penulis == null || penulis.trim().isEmpty()) {
            throw new IllegalArgumentException("Author harus diisi");
        }

        if (tahun < 2000 || tahun > 2100) {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
        }

        this.Judul_buku = judulBuku.trim();
        this.Penulis = penulis.trim();
        this.Tahun = tahun;
    }

    public String getJudul_buku() {
        return Judul_buku;
    }

    public String getPenulis() {
        return Penulis;
    }

    public int getTahun() {
        return Tahun;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d)", Judul_buku, Penulis, Tahun);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Tahun == book.Tahun &&
                Judul_buku.equals(book.Judul_buku) &&
                Penulis.equals(book.Penulis);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(Judul_buku, Penulis, Tahun);
    }
}
