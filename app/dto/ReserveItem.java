package dto;

public class ReserveItem {
    private int reserveId;
    private int isbn;
    private int readerId;
    private int noOfTimesBorrowed;
    private int avgBorrowTime;

    public int getReserveId() {
        return reserveId;
    }

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

    public int getNoOfTimesBorrowed() {
        return noOfTimesBorrowed;
    }

    public void setNoOfTimesBorrowed(int noOfTimesBorrowed) {
        this.noOfTimesBorrowed = noOfTimesBorrowed;
    }

    public int getAvgBorrowTime() {
        return avgBorrowTime;
    }

    public void setAvgBorrowTime(int avgBorrowTime) {
        this.avgBorrowTime = avgBorrowTime;
    }
}
