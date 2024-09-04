import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class seaGUI extends JFrame {
    private JLabel nameLabel, passportLabel, destinationLabel, departureTimeLabel;
    private JTextField nameTextField, passportTextField;
    private JComboBox<String> destinationComboBox, departureTimeComboBox;
    private JButton bookButton, displayBookedTicketsButton;

    private static final String[] destinations = {"Caribbean", "Mediterranean", "South Pacific", "Arctic", "Indian Ocean"};
    private static final String[] departureTimes = {"Morning", "Afternoon", "Evening", "Night"};

    public seaGUI() {
        
        setVisible(true);
        setSize(900, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("International Boat Travel Ticket Booking");
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(nameLabel.getFont().deriveFont(40.0f));
        passportLabel = new JLabel("Passport Number:");
        passportLabel.setFont(passportLabel.getFont().deriveFont(40.0f));
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(destinationLabel.getFont().deriveFont(40.0f));
        departureTimeLabel = new JLabel("Departure Time:");
        departureTimeLabel.setFont(departureTimeLabel.getFont().deriveFont(40.0f));

        nameTextField = new JTextField(20);
        nameTextField.setFont(nameTextField.getFont().deriveFont(40.0f));
        passportTextField = new JTextField(20);
        passportTextField.setFont(passportTextField.getFont().deriveFont(40.0f));

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
        inputPanel.add(passportLabel);
        inputPanel.add(passportTextField);
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
        List<TicketDetailsSea> ticketDetailsList = readFromFile();
        String name = nameTextField.getText();
        String passport = passportTextField.getText();
        String destination = (String) destinationComboBox.getSelectedItem();
        String departureTime = (String) departureTimeComboBox.getSelectedItem();

        TicketDetailsSea newTicket = new TicketDetailsSea(name, passport, destination, departureTime);
        ticketDetailsList.add(newTicket);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("seatravel.ser"))) {
            oos.writeObject(ticketDetailsList);
            JOptionPane.showMessageDialog(this, "Sea travel ticket details saved to file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static List<TicketDetailsSea> readFromFile() {
        List<TicketDetailsSea> ticketDetailsList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("seatravel.ser"))) {
            ticketDetailsList = (List<TicketDetailsSea>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore if the file doesn't exist yet
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ticketDetailsList;
    }

private void displayBookedTickets() {
    List<TicketDetailsSea> ticketDetailsList = readFromFile();
    StringBuilder message = new StringBuilder("Booked Tickets:\n\n");

    if (ticketDetailsList.isEmpty()) {
        message.append("No tickets booked yet.");
    } else {
        for (TicketDetailsSea ticket : ticketDetailsList) {
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
        j.setTitle("Travel by Sea history");
        j.setLocationRelativeTo(null);
    j.add(textArea);
    
    

    JOptionPane.showMessageDialog(this, j, "Booked Tickets", JOptionPane.PLAIN_MESSAGE);
}
}