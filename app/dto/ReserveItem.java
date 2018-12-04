package dto;

public class ReserveItem {
    private int reserveId;
    private int isbn;
    private int readerId;

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
}
