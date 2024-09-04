import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class teleportationGUI extends JFrame {
    private JLabel nameLabel, teleportTimeLabel, destinationLabel;
    private JTextField nameTextField;
    private JComboBox<String> teleportTimeComboBox, destinationComboBox;
    private JButton teleportButton, displayBookedTicketsButton;

    private static final String[] teleportTimes = {"9 am", "10 am", "11 am", "12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm"};
    private static final String[] destinations = {"Earth", "Moon", "Mars", "Venus"};

    public teleportationGUI() {
        
        setVisible(true);
        setSize(900, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Teleportation Travel Booking");
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 40));

        teleportTimeLabel = new JLabel("Teleport Time:");
        teleportTimeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        teleportTimeComboBox = new JComboBox<>(teleportTimes);
        teleportTimeComboBox.setFont(new Font("Arial", Font.PLAIN, 40));

        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Arial", Font.PLAIN, 40));

        nameTextField = new JTextField(20);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 40));

        destinationComboBox = new JComboBox<>(destinations);
        destinationComboBox.setFont(new Font("Arial", Font.PLAIN, 40));

        teleportButton = new JButton("    Teleport    ");
        teleportButton.setBackground(Color.white);
        teleportButton.setFont(new Font("Arial", Font.PLAIN, 40));
        teleportButton.setFocusPainted(false);
        teleportButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        displayBookedTicketsButton = new JButton(" Display Booked Tickets ");
        displayBookedTicketsButton.setBackground(Color.white);
        displayBookedTicketsButton.setFont(new Font("Arial", Font.PLAIN, 40));
        displayBookedTicketsButton.setFocusPainted(false);
        displayBookedTicketsButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        teleportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teleport();
                saveToFile();
            }
        });

        displayBookedTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBookedTickets();
            }
        });

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(teleportTimeLabel);
        inputPanel.add(teleportTimeComboBox);
        inputPanel.add(destinationLabel);
        inputPanel.add(destinationComboBox);

        JPanel displayPanel = new JPanel();
        displayPanel.add(displayBookedTicketsButton);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(teleportButton);

        add(inputPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.NORTH);
        add(submitPanel, BorderLayout.SOUTH);
    }

    private void teleport() {
        JOptionPane.showMessageDialog(this, "Teleporting " + nameTextField.getText() +
                " to " + destinationComboBox.getSelectedItem() +
                " at " + teleportTimeComboBox.getSelectedItem());
    }

    private void saveToFile() {
        List<TicketDetailsTeleportation> ticketDetailsList = readFromFile();
        String name = nameTextField.getText();
        String teleportTime = (String) teleportTimeComboBox.getSelectedItem();
        String destination = (String) destinationComboBox.getSelectedItem();

        TicketDetailsTeleportation newTicket = new TicketDetailsTeleportation(name, teleportTime, destination);
        ticketDetailsList.add(newTicket);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teleportation.ser"))) {
            oos.writeObject(ticketDetailsList);
            JOptionPane.showMessageDialog(this, "Teleportation ticket details saved to file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<TicketDetailsTeleportation> readFromFile() {
        List<TicketDetailsTeleportation> ticketDetailsList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teleportation.ser"))) {
            ticketDetailsList = (List<TicketDetailsTeleportation>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore if the file doesn't exist yet
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ticketDetailsList;
    }

    private void displayBookedTickets() {
    List<TicketDetailsTeleportation> ticketDetailsList = readFromFile();
    StringBuilder message = new StringBuilder("Booked Tickets:\n\n");

    if (ticketDetailsList.isEmpty()) {
        message.append("No tickets booked yet.");
    } else {
        for (TicketDetailsTeleportation ticket : ticketDetailsList) {
            message.append(ticket).append("\n\n");
        }
    }

    JTextArea textArea = new JTextArea(message.toString());
    textArea.setFont(new Font("Arial", Font.PLAIN, 20));
    textArea.setEditable(false);
    JFrame j = new JFrame();
    j.setVisible(true);
        j.setSize(900, 900);
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setTitle("Teleportation history");
        j.setLocationRelativeTo(null);
    j.add(textArea);
    
    

    JOptionPane.showMessageDialog(this, j, "Booked Tickets", JOptionPane.PLAIN_MESSAGE);
}
}
