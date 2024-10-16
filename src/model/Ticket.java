package model;

public class Ticket {
    private int id;
    private int customerId;
    private int busId;

    public Ticket() {}

    public Ticket(int customerId, int busId) {
        this.customerId = customerId;
        this.busId = busId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getBusId() {
        return busId;
    }
    public void setBusId(int busId) {
        this.busId = busId;
    }

	public boolean isConfirmed() {
		// TODO Auto-generated method stub
		return false;
	}
}

