import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class rocketGUI extends JFrame {
    private JLabel nameLabel, launchTimeLabel, destinationLabel;
    private JTextField nameTextField;
    private JComboBox<String> launchTimeComboBox, destinationComboBox;
    private JButton bookButton, displayBookedRocketsButton;

    private static final String[] launchTimes = {"9 am", "10 am", "11 am", "12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm"};
    private static final String[] destinations = {"Mars", "Venus", "Other Planets"};

    public rocketGUI() {
        setVisible(true);
        setSize(900, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Rocket Travel Booking");
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 40));

        launchTimeLabel = new JLabel("Launch Time:");
        launchTimeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        launchTimeComboBox = new JComboBox<>(launchTimes);
        launchTimeComboBox.setFont(new Font("Arial", Font.PLAIN, 40));

        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Arial", Font.PLAIN, 40));

        nameTextField = new JTextField(20);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 40));

        destinationComboBox = new JComboBox<>(destinations);
        destinationComboBox.setFont(new Font("Arial", Font.PLAIN, 40));

        bookButton = new JButton("      Launch Rocket      ");
        bookButton.setBackground(Color.white);
        bookButton.setFont(new Font("Arial", Font.PLAIN, 40));
        bookButton.setFocusPainted(false);
        bookButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
        
        displayBookedRocketsButton = new JButton(" Display Launched Rockets ");
        displayBookedRocketsButton.setBackground(Color.white);
        displayBookedRocketsButton.setFont(displayBookedRocketsButton.getFont().deriveFont(40.0f));
        displayBookedRocketsButton.setFocusPainted(false);
        displayBookedRocketsButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchRocket();
                saveToFile();
            }
        });

        displayBookedRocketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLaunchedRockets();
            }
        });

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(launchTimeLabel);
        inputPanel.add(launchTimeComboBox);
        inputPanel.add(destinationLabel);
        inputPanel.add(destinationComboBox);

        JPanel displayPanel = new JPanel();
        displayPanel.add(displayBookedRocketsButton);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(bookButton);

        add(inputPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.NORTH);
        add(submitPanel, BorderLayout.SOUTH);
    }

    private void launchRocket() {
        JOptionPane.showMessageDialog(this, "Rocket launched for " + nameTextField.getText() +
                " to " + destinationComboBox.getSelectedItem() +
                " at " + launchTimeComboBox.getSelectedItem());
    }

    private void saveToFile() {
        List<TicketDetailsRocket> rocketDetailsList = readFromFile();
        String name = nameTextField.getText();
        String launchTime = (String) launchTimeComboBox.getSelectedItem();
        String destination = (String) destinationComboBox.getSelectedItem();

        TicketDetailsRocket newRocket = new TicketDetailsRocket(name, launchTime, destination);
        rocketDetailsList.add(newRocket);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rockettravel.ser"))) {
            oos.writeObject(rocketDetailsList);
            JOptionPane.showMessageDialog(this, "Rocket travel details saved to file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<TicketDetailsRocket> readFromFile() {
        List<TicketDetailsRocket> rocketDetailsList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rockettravel.ser"))) {
            rocketDetailsList = (List<TicketDetailsRocket>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore if the file doesn't exist yet
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rocketDetailsList;
    }

    private void displayLaunchedRockets() {
    List<TicketDetailsRocket> ticketDetailsList = readFromFile();
    StringBuilder message = new StringBuilder("Booked Tickets:\n\n");

    if (ticketDetailsList.isEmpty()) {
        message.append("No tickets booked yet.");
    } else {
        for (TicketDetailsRocket ticket : ticketDetailsList) {
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
        j.setTitle("Rockets Launched history");
        j.setLocationRelativeTo(null);
    j.add(textArea);
    
    

    JOptionPane.showMessageDialog(this, j, "Booked Tickets", JOptionPane.PLAIN_MESSAGE);
}
}