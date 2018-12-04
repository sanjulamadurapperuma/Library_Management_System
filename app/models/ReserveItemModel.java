package models;

import javax.persistence.*;

@Entity
@Table(name = "reserveItem")
public class ReserveItemModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "reserveId")
    private int reserveId;

    @Column(name = "isbn")
    private int isbn;

    @Column(name = "readerId")
    private int readerId;

    public int getReserveId() {
        return reserveId;
    }//Notice that there is no setter method for
    // Reserve ID - it is immutable, the reason
    // being it is auto-incremented in the database

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
