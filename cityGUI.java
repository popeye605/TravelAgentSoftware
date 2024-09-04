import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.SystemColor.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class cityGUI extends JFrame {
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5;
    
    cityGUI(){
    
        setSize(900, 900); // set frames size in pixels
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4= new JPanel();
        
        l1 = new JLabel("How would you like to travel");
        l1.setFont(l1.getFont().deriveFont(40.0f));
        
        
        b1 = new JButton("      By air      ");
        b1.setBackground(Color.white);
        //b1.setSize(50, 50);

        b1.setFont(b1.getFont().deriveFont(40.0f));
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
        
        
        b2 = new JButton("      By railway      ");
        b2.setBackground(Color.white);
        //b1.setSize(50, 50);

        b2.setFont(b2.getFont().deriveFont(40.0f));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
        
        
        
        
        b3 = new JButton("      By road     ");
        b3.setBackground(Color.white);
        //b1.setSize(50, 50);

        b3.setFont(b3.getFont().deriveFont(40.0f));
        b3.setFocusPainted(false);
        b3.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
        
        cityGUI.MyActionListener a = new cityGUI.MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        
        
        p.setLayout(new FlowLayout());
        p.add(l1);
        
        p2.setLayout(new GridLayout(3,1));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        
        add(p, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        
        
    }
    
    
    
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("      By air      ")){
              airportGUI p1 = new airportGUI();
              
              //  JOptionPane.showInputDialog(p1);
                
            }
            if(ae.getActionCommand().equals("      By railway      ")){
              railwayGUI p1 = new railwayGUI();
              
              //  JOptionPane.showInputDialog(p1);
                
            }
            if(ae.getActionCommand().equals("      By road     ")){
              busGUI p1 = new busGUI();
              
              //  JOptionPane.showInputDialog(p1);
                
            }
        }}}
