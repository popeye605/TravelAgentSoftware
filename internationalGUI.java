import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class internationalGUI extends JFrame {
    JButton byAirButton, bySeaButton;
    JLabel travelLabel;

    internationalGUI() {

        setSize(900, 900); // set frame size in pixels
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        travelLabel = new JLabel("                        How would you like to travel");
        travelLabel.setFont(travelLabel.getFont().deriveFont(40.0f));

        byAirButton = new JButton("      By Air      ");
        byAirButton.setBackground(Color.white);
        byAirButton.setFont(byAirButton.getFont().deriveFont(40.0f));
        byAirButton.setFocusPainted(false);
        byAirButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        bySeaButton = new JButton("      By Sea      ");
        bySeaButton.setBackground(Color.white);
        bySeaButton.setFont(bySeaButton.getFont().deriveFont(40.0f));
        bySeaButton.setFocusPainted(false);
        bySeaButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        internationalGUI.MyActionListener actionListener = new internationalGUI.MyActionListener();
        byAirButton.addActionListener(actionListener);
        bySeaButton.addActionListener(actionListener);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(travelLabel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(byAirButton);
        buttonPanel.add(bySeaButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("      By Air      ")) {
                internationalAirportGUI AirportGUI = new internationalAirportGUI();
            }
            else if (ae.getActionCommand().equals("      By Sea      ")) {
                seaGUI s = new seaGUI();
            }
        }
    }
}
