import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class galaxyGUI extends JFrame {
    JButton byRocketButton, byTeleportationButton;
    JLabel travelLabel;

    public galaxyGUI() {
        setSize(900, 900); // set frame size in pixels
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);

        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        travelLabel = new JLabel("                        How would you like to travel");
        travelLabel.setFont(travelLabel.getFont().deriveFont(40.0f));

        byRocketButton = new JButton("   By Rocket   ");
        byRocketButton.setBackground(Color.white);
        byRocketButton.setFont(byRocketButton.getFont().deriveFont(40.0f));
        byRocketButton.setFocusPainted(false);
        byRocketButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        byTeleportationButton = new JButton("By Teleportation");
        byTeleportationButton.setBackground(Color.white);
        byTeleportationButton.setFont(byTeleportationButton.getFont().deriveFont(40.0f));
        byTeleportationButton.setFocusPainted(false);
        byTeleportationButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));

        galaxyGUI.MyActionListener actionListener = new galaxyGUI.MyActionListener();
        byRocketButton.addActionListener(actionListener);
        byTeleportationButton.addActionListener(actionListener);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(travelLabel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(byRocketButton);
        buttonPanel.add(byTeleportationButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("   By Rocket   ")) {
                rocketGUI r = new rocketGUI();
            }
            else if (ae.getActionCommand().equals("By Teleportation")) {
                teleportationGUI t = new teleportationGUI();
            }
        }
    }
}
