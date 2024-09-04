import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class internationalAirportGUI extends JFrame {
    private JLabel nameLabel, addressLabel, passportLabel, nationalityLabel, destinationLabel, departureTimeLabel;
    private JTextField nameTextField, addressTextField, passportTextField, nationalityTextField;
    private JComboBox<String> destinationComboBox, departureTimeComboBox;
    private JButton bookButton, displayTicketsButton;

    private static final String[] departureTimes = {"Morning", "Afternoon", "Evening", "Night"};

    public internationalAirportGUI() {
        setTitle("Airplane Ticket Booking");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(nameLabel.getFont().deriveFont(30.0f));
        addressLabel = new JLabel("Address:");
        addressLabel.setFont(addressLabel.getFont().deriveFont(30.0f));
        passportLabel = new JLabel("Passport Number:");
        passportLabel.setFont(passportLabel.getFont().deriveFont(30.0f));
        nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setFont(nationalityLabel.getFont().deriveFont(30.0f));
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(destinationLabel.getFont().deriveFont(30.0f));
        departureTimeLabel = new JLabel("Departure Time:");
        departureTimeLabel.setFont(departureTimeLabel.getFont().deriveFont(30.0f));

        nameTextField = new JTextField(20);
        nameTextField.setFont(nameTextField.getFont().deriveFont(40.0f));
        addressTextField = new JTextField(20);
        addressTextField.setFont(addressTextField.getFont().deriveFont(40.0f));
        passportTextField = new JTextField(20);
        passportTextField.setFont(passportTextField.getFont().deriveFont(40.0f));
        nationalityTextField = new JTextField(20);
        nationalityTextField.setFont(nationalityTextField.getFont().deriveFont(40.0f));

        String[] destinations = {"New York", "London", "Tokyo", "Paris", "Sydney"};
        destinationComboBox = new JComboBox<>(destinations);
        destinationComboBox.setFont(destinationComboBox.getFont().deriveFont(40.0f));

        departureTimeComboBox = new JComboBox<>(departureTimes);
        departureTimeComboBox.setFont(departureTimeComboBox.getFont().deriveFont(40.0f));

        bookButton = new JButton("      Book Ticket     ");
        bookButton.setBackground(Color.white);
        bookButton.setFont(bookButton.getFont().deriveFont(40.0f));
        bookButton.setFocusPainted(false);
        bookButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTicket();
                saveToFile();
            }
        });

        displayTicketsButton = new JButton("Display Booked Tickets");
        displayTicketsButton.setBackground(Color.white);
        displayTicketsButton.setFont(displayTicketsButton.getFont().deriveFont(40.0f));
        displayTicketsButton.setFocusPainted(false);
        displayTicketsButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        displayTicketsButton.addActionListener(new ActionListener() {
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
        inputPanel.add(passportLabel);
        inputPanel.add(passportTextField);
        inputPanel.add(nationalityLabel);
        inputPanel.add(nationalityTextField);
        inputPanel.add(destinationLabel);
        inputPanel.add(destinationComboBox);
        inputPanel.add(departureTimeLabel);
        inputPanel.add(departureTimeComboBox);

        JPanel displayPanel = new JPanel();
        displayPanel.add(displayTicketsButton);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(bookButton);

        add(inputPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.NORTH);
        add(submitPanel, BorderLayout.SOUTH);
    }

    private void bookTicket() {
        JOptionPane.showMessageDialog(this, "Ticket booked for " + nameTextField.getText() + " to "
                + destinationComboBox.getSelectedItem() + " at " + departureTimeComboBox.getSelectedItem());
    }

    private void saveToFile() {
        List<TicketDetailsInternational> ticketDetailsList2 = readFromFile();
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String passport = passportTextField.getText();
        String nationality = nationalityTextField.getText();
        String destination = (String) destinationComboBox.getSelectedItem();
        String departureTime = (String) departureTimeComboBox.getSelectedItem();

        TicketDetailsInternational newTicket = new TicketDetailsInternational(name, address, passport, nationality, destination, departureTime);
        ticketDetailsList2.add(newTicket);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("InternationalTickets.ser"))) {
            oos.writeObject(ticketDetailsList2);
            JOptionPane.showMessageDialog(this, "Ticket details saved to file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<TicketDetailsInternational> readFromFile() {
        List<TicketDetailsInternational> ticketDetailsList2 = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("InternationalTickets.ser"))) {
            ticketDetailsList2 = (List<TicketDetailsInternational>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore if the file doesn't exist yet
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ticketDetailsList2;
    }

    private void displayBookedTickets() {
    List<TicketDetailsInternational> ticketDetailsList2;
        ticketDetailsList2 = readFromFile();
    StringBuilder message = new StringBuilder("Booked Tickets:\n\n");

    if (ticketDetailsList2.isEmpty()) {
        message.append("No tickets booked yet.");
    } else {
        for (TicketDetailsInternational ticket : ticketDetailsList2) {
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
        j.setTitle("International Travel history");
        j.setLocationRelativeTo(null);
    j.add(textArea);
    
    

    JOptionPane.showMessageDialog(this, j, "Booked Tickets", JOptionPane.PLAIN_MESSAGE);
}
}