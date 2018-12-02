package services;

import dto.Book;
import dto.DVD;

import java.util.List;

public interface LibraryManager {
    void addBook(Book book);
    void addDVD(DVD dvd);
    String deleteLibraryItem(int isbn);

    List<Book> getAllBooks();
}
