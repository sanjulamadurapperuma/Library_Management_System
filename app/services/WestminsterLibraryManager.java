package services;

import dto.Book;
import dto.Reader;
import io.ebean.Ebean;
import models.AuthorModel;
import models.BookModel;
import models.ReaderModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WestminsterLibraryManager implements LibraryManager {
    @Override
    public void addBook(Book book) {
        try {
            BookModel bookModel = new BookModel();
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
            Ebean.save(bookModel);
        } catch (ParseException e) {
            System.out.println("Error occurred while parsing Date");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<BookModel> bookModels = Ebean.find(BookModel.class).findList();

        List<Book> books = new ArrayList<>();

        for (BookModel bookModel : bookModels) {
            Book book = getBookDTObyModel(bookModel);
            books.add(book);
        }

        return books;
    }

    private Book getBookDTObyModel(BookModel bookModel) {
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
