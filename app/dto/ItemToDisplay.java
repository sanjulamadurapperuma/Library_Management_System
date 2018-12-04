package dto;

public class ItemToDisplay {
    private int itemISBN;
    private String itemTitle;
    private String itemType;
    private String status;

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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
