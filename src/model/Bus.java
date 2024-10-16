package model;

public class Bus {
    private int id;
    private String name;
    private String route;
    private String type; // AC or non-AC
    private int totalSeats;
    private int bookedSeats;
    private String departureTime;
    private String arrivalTime;

    public Bus() {}

    public Bus(String name, String route, String type, int totalSeats, int bookedSeats, String departureTime, String arrivalTime) {
        this.name = name;
        this.route = route;
        this.type = type;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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
    public String getRoute() {
        return route;
    }
    public void setRoute(String route) {
        this.route = route;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    public int getBookedSeats() {
        return bookedSeats;
    }
    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

	public int getAvailableSeats() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setAvailableSeats(int i) {
		// TODO Auto-generated method stub
		
	}
}
