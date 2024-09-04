import java.io.Serializable;

public class TicketDetailsRailway implements Serializable {
    private String name;
    private String address;
    private String id;
    private String destination;
    private String departureTime;

    // Default constructor
    public TicketDetailsRailway() {
    }

    // Argument constructor
    public TicketDetailsRailway(String name, String address, String id, String destination, String departureTime) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Copy constructor
    public TicketDetailsRailway(TicketDetailsRailway other) {
        this.name = other.name;
        this.address = other.address;
        this.id = other.id;
        this.destination = other.destination;
        this.departureTime = other.departureTime;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    // toString method
    @Override
    public String toString() {
        return "Name: " + name +
                "\nAddress: " + address +
                "\nId: " + id +
                "\nDestination: " + destination +
                "\nDeparture Time: " + departureTime;
    }
}