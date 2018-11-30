package dto;

import services.DateTime;

public abstract class LibraryItem {

    private int itemISBN;
    private String itemTitle;
    private String itemSector;
    private DateTime publicationDate;
    private DateTime dateTimeBorrowed;
    private Reader reader;

    public int getItemISBN() {
        return itemISBN;
    }

    public void setItemISBN(int itemISBN) {
        this.itemISBN = itemISBN;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemSector() {
        return itemSector;
    }

    public void setItemSector(String itemSector) {
        this.itemSector = itemSector;
    }

    public DateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(DateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public DateTime getDateTimeBorrowed() {
        return dateTimeBorrowed;
    }

    public void setDateTimeBorrowed(DateTime dateTimeBorrowed) {
        this.dateTimeBorrowed = dateTimeBorrowed;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
