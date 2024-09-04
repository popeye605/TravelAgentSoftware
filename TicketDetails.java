import java.io.Serializable;


public class TicketDetails implements Serializable {
    private String name;
    private String address;
    private String destination;
    private String departureTime;

    // Default Constructor
    public TicketDetails() {
        
    }

    // Parameterized Constructor
    public TicketDetails(String name, String address, String destination, String departureTime) {
        this.name = name;
        this.address = address;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Copy Constructor
    public TicketDetails(TicketDetails other) {
        this.name = other.name;
        this.address = other.address;
        this.destination = other.destination;
        this.departureTime = other.departureTime;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    // toString method
    @Override
    public String toString() {
        return "Name: " + name +
                "\nAddress: " + address +
                "\nDestination: " + destination +
                "\nDeparture Time: " + departureTime;
    }
}