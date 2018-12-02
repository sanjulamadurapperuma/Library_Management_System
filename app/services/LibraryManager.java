package services;

import dto.Book;
import dto.Borrow;
import dto.DVD;
import dto.ItemToDisplay;

import java.util.List;

public interface LibraryManager {
    void addBook(Book book);
    void addDVD(DVD dvd);
    String deleteLibraryItem(int isbn);
    List<ItemToDisplay> getAllLibraryItems();
    ItemToDisplay searchLibraryItem(int isbn);
    int getFreeSpaceBook();
    int getFreeSpaceDVD();
    String borrowLibraryItem(Borrow borrow);
    String returnLibraryItem(int isbn);

    List<Book> getAllBooks();
}
