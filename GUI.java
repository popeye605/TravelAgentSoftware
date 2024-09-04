
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends JFrame{
    JButton b1;
    JLabel l1;
    GUI ()
    {
        setSize(900, 900); // set frames size in pixels
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        
        
        
        
        b1 = new JButton("Ready to go on a journey that will change your life! Lets Travel");
        b1.setBackground(Color.white);
        b1.setFont(b1.getFont().deriveFont(35.0f));
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
        
MyActionListener a = new MyActionListener();
 b1.addActionListener(a);
add(b1);

    }
    
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("Ready to go on a journey that will change your life! Lets Travel")){
              travel_type p1 = new travel_type();
                
            }
        }}}


