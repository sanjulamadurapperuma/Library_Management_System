package dto;

public class BorrowItem {
    private int isbn;
    private int readerId;
    private String dateTimeBorrowed;
    private double calculatedFee;

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

    public double getCalculatedFee() {
        return calculatedFee;
    }

    public void setCalculatedFee(double calculatedFee) {
        this.calculatedFee = calculatedFee;
    }
}
