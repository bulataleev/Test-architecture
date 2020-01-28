package TestsWithJson;

public class CustomerDetails {
    private String courseName;
    private String purchaseDate;
    private int Amount;
    private String Location;

    public String getCourseName() {
        return courseName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public int getAmount() {
        return Amount;
    }

    public String getLocation() {
        return Location;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void setLocation(String location) {
        Location = location;
    }


}
