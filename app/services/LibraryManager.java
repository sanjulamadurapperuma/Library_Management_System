package services;

import dto.Book;
import dto.DVD;
import dto.ItemToDisplay;

import java.util.List;

public interface LibraryManager {
    void addBook(Book book);
    void addDVD(DVD dvd);
    String deleteLibraryItem(int isbn);
    List<ItemToDisplay> getAllLibraryItems();
    ItemToDisplay searchLibraryItem(int isbn);
    int getFreeSpace();
    int getFreeSpaceBook();
    int getFreeSpaceDVD();

    List<Book> getAllBooks();
}
