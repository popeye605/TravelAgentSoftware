import java.io.Serializable;

public class TicketDetailsSea implements Serializable {
    private String name;
    private String passportNumber;
    private String destination;
    private String departureTime;

    // Constructors
    public TicketDetailsSea(String name, String passportNumber, String destination, String departureTime) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
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
                "\nPassportNumber : " +passportNumber+
                "\nDestination: " + destination +
                "\nDeparture Time: " + departureTime;
    }
}
