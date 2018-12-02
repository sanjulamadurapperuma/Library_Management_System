package dto;

import services.DateTime;

public class Borrow {
    private int isbn;
    private int readerId;
    private String dateTimeBorrowed;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getDateTimeBorrowed() {
        return dateTimeBorrowed;
    }

    public void setDateTimeBorrowed(String dateTimeBorrowed) {
        this.dateTimeBorrowed = dateTimeBorrowed;
    }
}
