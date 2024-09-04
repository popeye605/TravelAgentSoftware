import java.io.Serializable;

class TicketDetailsBus implements Serializable {
    private String name;
    private String address;
    private String id;
    private String destination;
    private String departureTime;

    // Default constructor
    public TicketDetailsBus() {
    }

    // Parameterized constructor
    public TicketDetailsBus(String name, String address, String id, String destination, String departureTime) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Copy constructor
    public TicketDetailsBus(TicketDetailsBus other) {
        this.name = other.name;
        this.address = other.address;
        this.id = other.id;
        this.destination = other.destination;
        this.departureTime = other.departureTime;
    }

    // Getters and setters
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

    @Override
    public String toString() {
        return 
                "name: " + name + '\n' +
                "address: " + address + '\n' +
                "id: " + id + '\n' +
                "destination: " + destination + '\n' +
                "departureTime:" + departureTime + '\n';
    }
}