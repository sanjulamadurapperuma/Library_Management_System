package services;

import dto.*;
import io.ebean.Ebean;
import models.BorrowModel;
import models.LibraryItemModel;
import models.ReaderModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WestminsterLibraryManager implements LibraryManager {
    @Override
    public void addBook(Book book) {
        try {
            LibraryItemModel bookModel = new LibraryItemModel();
            bookModel.setIsbn(book.getItemISBN());
            bookModel.setTitle(book.getItemTitle());
            bookModel.setSector(book.getItemSector());
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf1.parse(book.getPublicationDate());
            java.sql.Date publicationDate = new java.sql.Date(date.getTime());
            bookModel.setPublicationDate(publicationDate);
            bookModel.setAuthor(book.getAuthor());
            bookModel.setPublisher(book.getPublisher());
            bookModel.setNumberOfPages(book.getNumberOfPages());
            bookModel.setItemType("Book");
            bookModel.setBorrowedStatus("Available");
            Ebean.save(bookModel);
        } catch (ParseException e) {
            System.out.println("Error occurred while parsing Date");
        }
    }

    @Override
    public void addDVD(DVD dvd) {
        try {
            LibraryItemModel dvdModel = new LibraryItemModel();
            dvdModel.setIsbn(dvd.getItemISBN());
            dvdModel.setTitle(dvd.getItemTitle());
            dvdModel.setSector(dvd.getItemSector());
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf1.parse(dvd.getPublicationDate());
            java.sql.Date publicationDate = new java.sql.Date(date.getTime());
            dvdModel.setPublicationDate(publicationDate);
            dvdModel.setLanguages(dvd.getLanguages());
            dvdModel.setSubtitles(dvd.getSubtitles());
            dvdModel.setProducer(dvd.getProducer());
            dvdModel.setActors(dvd.getActors());
            dvdModel.setItemType("DVD");
            dvdModel.setBorrowedStatus("Available");
            Ebean.save(dvdModel);
        } catch (ParseException e) {
            System.out.println("Error occurred while parsing Date");
        }
    }

    @Override
    public String deleteLibraryItem(int isbn) {
        String itemType = null;
        LibraryItemModel itemModel = LibraryItemModel.find.byId(isbn);
        if (itemModel != null) {
            itemType = itemModel.getItemType();
            LibraryItemModel.find.ref(isbn).delete();
        }
        return itemType;
    }


    @Override
    public String borrowLibraryItem(Borrow borrow){
        LibraryItemModel itemModel = LibraryItemModel.find.byId(borrow.getIsbn());
        BorrowModel borrowModel = BorrowModel.find.byId(borrow.getIsbn());
        if(borrowModel != null ){
            return "alreadyBorrowed";
        } else if (itemModel != null){
            BorrowModel borrowModel1 = new BorrowModel();
            borrowModel1.setIsbn(borrow.getIsbn());
            System.out.println("readerid " + borrow.getReaderId());
            borrowModel1.setReaderId(borrow.getReaderId());
            DateTime date = new DateTime();
            borrowModel1.setDateTimeBorrowed(date.getTime());
            itemModel.setBorrowedStatus("Borrowed");
            Ebean.update(itemModel);
            Ebean.save(borrowModel1);

        }
        return "available";
    }

    @Override
    public String returnLibraryItem(int isbn) {
        LibraryItemModel itemModel = LibraryItemModel.find.byId(isbn);
        BorrowModel borrowModel = BorrowModel.find.byId(isbn);
        if (itemModel != null) {
            if (borrowModel != null) {
                BorrowModel.find.ref(isbn).delete();
                itemModel.setBorrowedStatus("Available");
                Ebean.update(itemModel);
            }
        } else {
            return "notAvailable";
        }
        return "available";
    }

    @Override
    public List<ItemToDisplay> getAllLibraryItems() {
        List<LibraryItemModel> items = Ebean.find(LibraryItemModel.class).findList();
        List<ItemToDisplay> itemList = new ArrayList<>();
        for (LibraryItemModel item : items) {
            ItemToDisplay itemDisplay = getItemToDisplayDTOByModel(item);
            itemList.add(itemDisplay);
        }
        return itemList;
    }

    private ItemToDisplay getItemToDisplayDTOByModel(LibraryItemModel itemModel) {
        ItemToDisplay item = new ItemToDisplay();
        item.setItemISBN(itemModel.getIsbn());
        item.setItemTitle(itemModel.getTitle());
        item.setItemType(itemModel.getItemType());
        return item;
    }

    @Override
    public ItemToDisplay searchLibraryItem(int isbn) {
        ItemToDisplay item = null;
        LibraryItemModel itemModel = LibraryItemModel.find.byId(isbn);
        if (itemModel != null) {
            item = new ItemToDisplay();
            item.setItemISBN(isbn);
            item.setItemTitle(itemModel.getTitle());
            item.setItemType(itemModel.getItemType());
        }
        return item;
    }

    @Override
    public int getFreeSpaceBook() {
        int count = Ebean.find(LibraryItemModel.class).where().eq("type", "Book").findCount();
        return 100 - count;
    }

    @Override
    public int getFreeSpaceDVD() {
        int count = Ebean.find(LibraryItemModel.class).where().eq("type", "DVD").findCount();
        return 50 - count;
    }

    @Override
    public List<Book> getAllBooks() {
        List<LibraryItemModel> bookModels = Ebean.find(LibraryItemModel.class).findList();

        List<Book> books = new ArrayList<>();

        for (LibraryItemModel bookModel : bookModels) {
            Book book = getBookDTObyModel(bookModel);
            books.add(book);
        }

        return books;
    }

    private Book getBookDTObyModel(LibraryItemModel bookModel) {
        Book book = new Book();
        book.setItemTitle(bookModel.getTitle());
        book.setItemISBN(bookModel.getIsbn());

        //Reader reader = getReaderDTObyModel(bookModel.getReader());
        //book.setReader(reader);

        //TODO: write a method to get author list.

        return book;
    }

    private Reader getReaderDTObyModel(ReaderModel readerModel) {
        Reader reader = new Reader();
        reader.setReaderName(readerModel.getName());
        reader.setReaderID(readerModel.getId());
        reader.setMobileNumber(readerModel.getMobileNumber());
        reader.setEmail(readerModel.getEmail());

        return reader;
    }
}
