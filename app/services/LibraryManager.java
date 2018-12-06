package services;

import dto.*;

import java.util.List;
import java.util.Map;

public interface LibraryManager {
    void addBook(Book book);
    void addDVD(DVD dvd);
    String deleteLibraryItem(int isbn);

    List<Borrow> getAllBorrowedItems();

    List<ItemToDisplay> getAllLibraryItems();
    ItemToDisplay searchLibraryItem(int isbn);

    Borrow searchBorrowItem(int isbn);

    int getFreeSpaceBook();
    int getFreeSpaceDVD();
    String borrowLibraryItem(Borrow borrow);
    String returnLibraryItem(int isbn);
    String reserveLibraryItem(ReserveItem reserveItem);

    List<Book> getAllBooks();
}
