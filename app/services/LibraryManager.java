package services;

import dto.*;

import java.util.List;

public interface LibraryManager {
    //Add a new Book
    void addBook(Book book);

    //Add a new DVD
    void addDVD(DVD dvd);

    //Delete a Library Item
    String deleteLibraryItem(int isbn);

    //Get all Borrowed Items from
    // the BorrowModel table
    List<BorrowItem> getAllBorrowedItems();

    //Get all the Library Items present in the table
    List<ItemToDisplay> getAllLibraryItems();

    //Search all items in the Library Items table
    ItemToDisplay searchLibraryItem(int isbn);

    //Search all items in the Borrow Model table
    BorrowItem searchBorrowItem(int isbn);

    //Get the number of free spaces left for
    // Books in the Library
    int getFreeSpaceBook();

    //Get the number of free spaces left for
    // DVD in the Library
    int getFreeSpaceDVD();

    //Borrow Library Item
    String borrowLibraryItem(BorrowItem borrow);

    //Return Library Item
    String returnLibraryItem(int isbn);

    //Reserve Library Item
    String reserveLibraryItem(ReserveItem reserveItem);

    //Get list of all Books in Library Item table
    List<Book> getAllBooks();
}
