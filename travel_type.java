import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.SystemColor.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class travel_type extends JFrame {
      JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5;
    travel_type()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        
        
        JPanel p = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4= new JPanel();
        
        //JPanel p5= new JPanel();
        
        //JPanel p6= new JPanel();
        
        l2 = new JLabel("       ");
        
        
        
        p.setLayout(new GridLayout(3,1));
        
        l1 = new JLabel("                               Choose your travel!!");
        l1.setFont(l1.getFont().deriveFont(40.0f));
        l2.setFont(l2.getFont().deriveFont(40.0f));
        
        
        
        
        
        
        JPanel p2 = new JPanel();
        
        //p2.setLayout(new FlowLayout());

        
        
        b1 = new JButton("    Inter National    ");
        b1.setBackground(Color.white);
        //b1.setSize(50, 50);

        b1.setFont(b1.getFont().deriveFont(40.0f));
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
        
        
        
        
        b3 = new JButton("    Inter City    ");
        b3.setBackground(Color.white);
        //b3.setSize(50, 50);
        b3.setFont(b3.getFont().deriveFont(40.0f));
        b3.setFocusPainted(false);
        b3.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
        
        
        
        b2 = new JButton("    !! Inter Galactic !!    ");
        b2.setBackground(Color.white);
        //b2.setSize(50, 50);

        b2.setFont(b2.getFont().deriveFont(40.0f));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
        
        p2.setPreferredSize(new Dimension(200,200));
        p2.setLayout(new GridLayout(8,1));
        
        
        l3 = new JLabel("             !!Do you want to travel to another Country!!");
        l3.setFont(l3.getFont().deriveFont(40.0f));
         l4 = new JLabel("              !!Do you want to travel to another City!!");
        l4.setFont(l4.getFont().deriveFont(40.0f));
         l5 = new JLabel("              !!Do you want to travel to Outer Space!!");
        l5.setFont(l5.getFont().deriveFont(40.0f));
        
        
        p2.add(l1);
        p2.add(l4);
        p2.add(b3);
        p2.add(l3);
        p2.add(b1);
        p2.add(l5);
        p2.add(b2);
        //p2.add(l2, BorderLayout.NORTH);
        
        
        travel_type.MyActionListener a = new travel_type.MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        
        
        
        
        //p2.add(l4);
        //p3.add(l3);
        //p4.add(l3);
        
        
        add(p, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.WEST);
        add(p4, BorderLayout.EAST);
        //add(p5, BorderLayout.SOUTH);

    }
    
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("    Inter City    ")){
              cityGUI p1 = new cityGUI();
              
              //  JOptionPane.showInputDialog(p1);
                
            }
            if(ae.getActionCommand().equals("    Inter National    ")){
              internationalGUI p1 = new internationalGUI();
              
              //  JOptionPane.showInputDialog(p1);
                
            }
            if(ae.getActionCommand().equals("    !! Inter Galactic !!    ")){
              galaxyGUI p1 = new galaxyGUI();
              
              //  JOptionPane.showInputDialog(p1);
                
            }
        }}}