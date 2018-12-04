package dto;

public class Reader {

    private int readerID;
    private String readerName;
    private String mobileNumber;
    private String email;

    public Reader() {
    }

    public Reader(int readerID, String readerName,
                  String mobileNumber, String email) {
        this.readerID = readerID;
        this.readerName = readerName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
