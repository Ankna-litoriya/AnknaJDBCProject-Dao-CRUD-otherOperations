package model;

public class Customer {
    private int id;
    private String name;
    private String contactDetails;

    public Customer() {}

    public Customer(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContactDetails() {
        return contactDetails;
    }
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}

