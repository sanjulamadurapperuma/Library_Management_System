package dto;

public abstract class LibraryItem {

    private int itemISBN;
    private String itemTitle;
    private String itemSector;
    private String publicationDate;

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

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
