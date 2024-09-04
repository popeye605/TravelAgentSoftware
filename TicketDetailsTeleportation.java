import java.io.Serializable;

public class TicketDetailsTeleportation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String teleportTime;
    private String destination;

    // Constructor
    public TicketDetailsTeleportation(String name, String teleportTime, String destination) {
        this.name = name;
        this.teleportTime = teleportTime;
        this.destination = destination;
    }

    // Copy Constructor
    public TicketDetailsTeleportation(TicketDetailsTeleportation other) {
        this.name = other.name;
        this.teleportTime = other.teleportTime;
        this.destination = other.destination;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getTeleportTime() {
        return teleportTime;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nTeleport Time: " + teleportTime + "\nDestination: " + destination;
    }
}