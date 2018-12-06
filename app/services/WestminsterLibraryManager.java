package services;

import dto.*;
import io.ebean.Ebean;
import models.BorrowModel;
import models.LibraryItemModel;
import models.ReaderModel;
import models.ReserveItemModel;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        if (itemModel != null) {
            if (borrowModel != null) {
                String dateBorrowed = borrowModel.getDateTimeBorrowed();
                DateTime dateTime = new DateTime();
                Map<String, Long> map = dateTime.getDateTimeDiff(dateBorrowed);
                if (itemModel.getItemType().equals("Book")) {
                    long maxDays = 7;
                    long dayDiff = map.get("elapsedDays") - maxDays;
                    if (dayDiff <= 0) {
                        return "You can borrow the Book in " + Math.abs(dayDiff) + " more days.";
                    } else {
                        return "overdue";
                    }
                } else if (itemModel.getItemType().equals("DVD")) {
                    long maxDays = 3;
                    long dayDiff = map.get("elapsedDays") - maxDays;
                    if (dayDiff <= 0) {
                        return "You can borrow the DVD in " + Math.abs(dayDiff) + " more days.";
                    } else {
                        return "overdue";
                    }
                }
                return "alreadyBorrowed";
            } else {
                BorrowModel borrowModel1 = new BorrowModel();
                borrowModel1.setIsbn(borrow.getIsbn());
                borrowModel1.setReaderId(borrow.getReaderId());
                DateTime date = new DateTime();
                borrowModel1.setDateTimeBorrowed(date.getTime());
                itemModel.setBorrowedStatus("Borrowed");
                Ebean.update(itemModel);
                Ebean.save(borrowModel1);
            }
        }
        return "available";
    }

    @Override
    public String returnLibraryItem(int isbn) {
        LibraryItemModel itemModel = LibraryItemModel.find.byId(isbn);
        BorrowModel borrowModel = BorrowModel.find.byId(isbn);
        double overdueFee = 0;
        long maxDays = 0;
        if (itemModel != null) {
            if (borrowModel != null) {
                String dateBorrowed = borrowModel.getDateTimeBorrowed();
                DateTime dateTime = new DateTime();
                Map<String, Long> map = dateTime.getDateTimeDiff(dateBorrowed);
                if (itemModel.getItemType().equals("Book")) {
                    maxDays = 7;
                } else {
                    maxDays = 3;
                }
                long dayDiff = map.get("elapsedDays") - maxDays;
                long hourDiff = map.get("elapsedHours");
                if (dayDiff <= 3) {
                    overdueFee = (dayDiff * 24 + hourDiff) * 0.2;
                } else {
                    long remainingTime = dayDiff - 3;
                    overdueFee = (3 * 24 * 0.2) + ((remainingTime * 24)+ hourDiff) * 0.5;
                }
                BorrowModel.find.ref(isbn).delete();
                itemModel.setBorrowedStatus("Available");
                double timeBorrowedInHours = map.get("elapsedDays") * 24 + map.get("elapsedHours");
                double avgTimeBorrowed = (itemModel.getAvgTimeBorrowed() + timeBorrowedInHours) / (itemModel.getNoOfTimesBorrowed() + 1);
                itemModel.setAvgTimeBorrowed(avgTimeBorrowed);
                itemModel.setNoOfTimesBorrowed(itemModel.getNoOfTimesBorrowed() + 1);
                Ebean.update(itemModel);
                if (overdueFee != 0) {
                    return "Please pay your overdue fee of £" + String.format("%.2f", overdueFee);
                }
            }
        } else {
            return "notAvailable";
        }
        return "available";
    }

    @Override
    public List<Borrow> getAllBorrowedItems() {
        List<BorrowModel> items = Ebean.find(BorrowModel.class).findList();
        List<Borrow> itemList = new ArrayList<>();
        for (BorrowModel item : items) {
            Borrow itemDisplay = getBorrowItemToDisplayDTOByModel(item);
            if (itemDisplay != null){
                itemList.add(itemDisplay);
            }
        }
        return itemList;
    }

    private Borrow getBorrowItemToDisplayDTOByModel(BorrowModel itemModel) {
        Borrow item = new Borrow();
        item.setIsbn(itemModel.getIsbn());
        item.setReaderId(itemModel.getReaderId());
        item.setDateTimeBorrowed(itemModel.getDateTimeBorrowed());

        LibraryItemModel libraryItemModel = LibraryItemModel.find.byId(itemModel.getIsbn());
        double overdueFee = 0;
        long maxDays = 0;
        if (libraryItemModel != null) {
                String dateBorrowed = itemModel.getDateTimeBorrowed();
                DateTime dateTime = new DateTime();
                Map<String, Long> map = dateTime.getDateTimeDiff(dateBorrowed);
                if (libraryItemModel.getItemType().equals("Book")) {
                    maxDays = 7;
                } else {
                    maxDays = 3;
                }
                long dayDiff = map.get("elapsedDays") - maxDays;
                long hourDiff = map.get("elapsedHours");
                if (dayDiff <= 3) {
                    overdueFee = (dayDiff * 24 + hourDiff) * 0.2;
                } else {
                    long remainingTime = dayDiff - 3;
                    overdueFee = (3 * 24 * 0.2) + ((remainingTime * 24)+ hourDiff) * 0.5;
                }

                if (overdueFee < 0){
                    return null;
                }
                if (overdueFee != 0) {
                    item.setCalculatedFee(overdueFee);
                }
                if(overdueFee == 0) {
                    return null;
                }
            }

        return item;
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
        item.setStatus(itemModel.getBorrowedStatus());
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
            item.setStatus(itemModel.getBorrowedStatus());
        }
        return item;
    }

    @Override
    public Borrow searchBorrowItem(int isbn) {
        Borrow item = null;
        BorrowModel itemModel = BorrowModel.find.byId(isbn);
        if (itemModel != null) {
            item = new Borrow();
            item.setIsbn(isbn);
            item.setReaderId(itemModel.getReaderId());
            item.setDateTimeBorrowed(itemModel.getDateTimeBorrowed());

            LibraryItemModel libraryItemModel = LibraryItemModel.find.byId(itemModel.getIsbn());
            double overdueFee = 0;
            long maxDays = 0;
            if (libraryItemModel != null) {
                String dateBorrowed = itemModel.getDateTimeBorrowed();
                DateTime dateTime = new DateTime();
                Map<String, Long> map = dateTime.getDateTimeDiff(dateBorrowed);
                if (libraryItemModel.getItemType().equals("Book")) {
                    maxDays = 7;
                } else {
                    maxDays = 3;
                }
                long dayDiff = map.get("elapsedDays") - maxDays;
                long hourDiff = map.get("elapsedHours");
                if (dayDiff <= 3) {
                    overdueFee = (dayDiff * 24 + hourDiff) * 0.2;
                } else {
                    long remainingTime = dayDiff - 3;
                    overdueFee = (3 * 24 * 0.2) + ((remainingTime * 24)+ hourDiff) * 0.5;
                }

                if (overdueFee < 0){
                    return null;
                }
                if (overdueFee != 0) {
                    item.setCalculatedFee(overdueFee);
                }
                if(overdueFee == 0) {
                    return null;
                }
            }
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

    public String reserveLibraryItem(ReserveItem reserve) {
        LibraryItemModel itemModel = LibraryItemModel.find.byId(reserve.getIsbn());
        double avgTimeBorrowed = itemModel.getAvgTimeBorrowed();
        BorrowModel borrowModel = BorrowModel.find.byId(reserve.getIsbn());
        String dateBorrowed = borrowModel.getDateTimeBorrowed();
        DateTime dateTime = new DateTime();
        Map<String, Long> map = dateTime.getDateTimeDiff(dateBorrowed);
        double currentlyBorrowedForHowLong = map.get("elapsedDays") * 24 + map.get("elapsedHours");
        if (avgTimeBorrowed == 0) {
            if (itemModel.getItemType().equals("Book")) {
                avgTimeBorrowed = 7 * 24;
            } else {
                avgTimeBorrowed = 3 * 24;
            }
        }
        double timeToWait = avgTimeBorrowed - currentlyBorrowedForHowLong; // for the first reserver
        int count = Ebean.find(ReserveItemModel.class).where().eq("isbn", reserve.getIsbn()).findCount();
        ReserveItemModel reserveItemModel = new ReserveItemModel();
        reserveItemModel.setIsbn(reserve.getIsbn());
        reserveItemModel.setReaderId(reserve.getReaderId());
        Ebean.save(reserveItemModel);
        DateTime newDate = new DateTime();
        DecimalFormat df = new DecimalFormat("#.00");
        if (timeToWait >= 0) {
            if (count == 0) {
                return df.format(newDate.getHoursInDays(timeToWait));
            } else {
                return df.format(newDate.getHoursInDays(timeToWait + (avgTimeBorrowed * count)));
            }
        } else { //already overdue
            return df.format(newDate.getHoursInDays(avgTimeBorrowed * count));
        }
    }
}
