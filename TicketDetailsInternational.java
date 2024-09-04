import java.io.Serializable;

public class TicketDetailsInternational implements Serializable {
    private String name;
    private String address;
    private String passport;
    private String nationality;
    private String destination;
    private String departureTime;

    // Default constructor
    public TicketDetailsInternational() {
    }

    // Argument constructor
    public TicketDetailsInternational(String name, String address, String passport, String nationality, String destination, String departureTime) {
        this.name = name;
        this.address = address;
        this.passport = passport;
        this.nationality = nationality;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Copy constructor
    public TicketDetailsInternational(TicketDetailsInternational other) {
        this.name = other.name;
        this.address = other.address;
        this.passport = other.passport;
        this.nationality = other.nationality;
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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
                "\nPassport: " + passport +
                "\nNationality: " + nationality +
                "\nDestination: " + destination +
                "\nDeparture Time: " + departureTime;
    }
}
