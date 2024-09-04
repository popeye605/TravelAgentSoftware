import java.io.Serializable;

public class TicketDetailsRocket implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String launchTime;
    private String destination;

    public TicketDetailsRocket(String name, String launchTime, String destination) {
        this.name = name;
        this.launchTime = launchTime;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public String getLaunchTime() {
        return launchTime;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nLaunch Time: " + launchTime + "\nDestination: " + destination;
    }
}