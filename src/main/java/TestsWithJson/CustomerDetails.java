package TestsWithJson;

public class CustomerDetails {
    private String courseName;
    private String purchaseDate;
    private int amount;
    private String location;

    public String getCourseName() {
        return courseName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public int getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
