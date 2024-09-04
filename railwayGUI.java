import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class railwayGUI extends JFrame {
    private JLabel nameLabel, addressLabel, idLabel, destinationLabel, departureTimeLabel;
    private JTextField nameTextField, addressTextField, idTextField;
    private JComboBox<String> destinationComboBox, departureTimeComboBox;
    private JButton bookButton, displayBookedTicketsButton;

    private static final String[] departureTimes = {"9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm"};

    public railwayGUI() {
        setTitle("Railway Ticket Booking");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(nameLabel.getFont().deriveFont(30.0f));
        addressLabel = new JLabel("Address:");
        addressLabel.setFont(addressLabel.getFont().deriveFont(30.0f));
        idLabel = new JLabel("ID Number:");
        idLabel.setFont(idLabel.getFont().deriveFont(30.0f));
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(destinationLabel.getFont().deriveFont(30.0f));
        departureTimeLabel = new JLabel("Departure Time:");
        departureTimeLabel.setFont(departureTimeLabel.getFont().deriveFont(30.0f));

        nameTextField = new JTextField(20);
        nameTextField.setFont(nameTextField.getFont().deriveFont(40.0f));
        addressTextField = new JTextField(20);
        addressTextField.setFont(addressTextField.getFont().deriveFont(40.0f));
        idTextField = new JTextField(20);
        idTextField.setFont(idTextField.getFont().deriveFont(40.0f));

        String[] destinations = {"City A", "City B", "City C", "City D", "City E"};
        destinationComboBox = new JComboBox<>(destinations);
        destinationComboBox.setFont(destinationComboBox.getFont().deriveFont(40.0f));

        departureTimeComboBox = new JComboBox<>(departureTimes);
        departureTimeComboBox.setFont(departureTimeComboBox.getFont().deriveFont(40.0f));

        bookButton = new JButton("      Book Ticket     ");
        bookButton.setBackground(Color.white);
        bookButton.setFont(bookButton.getFont().deriveFont(40.0f));
        bookButton.setFocusPainted(false);
        bookButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        displayBookedTicketsButton = new JButton(" Display Booked Tickets ");
        displayBookedTicketsButton.setBackground(Color.white);
        displayBookedTicketsButton.setFont(displayBookedTicketsButton.getFont().deriveFont(40.0f));
        displayBookedTicketsButton.setFocusPainted(false);
        displayBookedTicketsButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));



        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTicket();
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
        inputPanel.setLayout(new GridLayout(7, 2, 10, 10));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTextField);
        inputPanel.add(idLabel);
        inputPanel.add(idTextField);
        inputPanel.add(destinationLabel);
        inputPanel.add(destinationComboBox);
        inputPanel.add(departureTimeLabel);
        inputPanel.add(departureTimeComboBox);

        JPanel displayPanel = new JPanel();
        displayPanel.add(displayBookedTicketsButton);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(bookButton);

        add(inputPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.NORTH);
        add(submitPanel, BorderLayout.SOUTH);
    }

    private void bookTicket() {
        JOptionPane.showMessageDialog(this, "Ticket booked for " + nameTextField.getText() +
                " to " + destinationComboBox.getSelectedItem() +
                " at " + departureTimeComboBox.getSelectedItem());
    }

    private void saveToFile() {
        List<TicketDetailsRailway> ticketDetailsList = readFromFile();
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String id = idTextField.getText();
        String destination = (String) destinationComboBox.getSelectedItem();
        String departureTime = (String) departureTimeComboBox.getSelectedItem();

        TicketDetailsRailway newTicket = new TicketDetailsRailway(name, address, id, destination, departureTime);
        ticketDetailsList.add(newTicket);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("railwaytickets.ser"))) {
            oos.writeObject(ticketDetailsList);
            JOptionPane.showMessageDialog(this, "Railway ticket details saved to file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<TicketDetailsRailway> readFromFile() {
        List<TicketDetailsRailway> ticketDetailsList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("railwaytickets.ser"))) {
            ticketDetailsList = (List<TicketDetailsRailway>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore if the file doesn't exist yet
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ticketDetailsList;
    }

    private void displayBookedTickets() {
    List<TicketDetailsRailway> ticketDetailsList = readFromFile();
    StringBuilder message = new StringBuilder("Booked Tickets:\n\n");

    if (ticketDetailsList.isEmpty()) {
        message.append("No tickets booked yet.");
    } else {
        for (TicketDetailsRailway ticket : ticketDetailsList) {
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
        j.setTitle("Railway travel history");
        j.setLocationRelativeTo(null);
    j.add(textArea);
    
    

    JOptionPane.showMessageDialog(this, j, "Booked Tickets", JOptionPane.PLAIN_MESSAGE);
}
}