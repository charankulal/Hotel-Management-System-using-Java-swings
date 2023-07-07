package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainDashboard extends JFrame implements ActionListener {

    MainDashboard() {
        setLayout(null);
        setBounds(0, 0, 1920, 1080);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1080);
        add(image);

        JLabel text = new JLabel("THE MORNING-STAR GROUP WELCOMES YOU");
        text.setBounds(200, 120, 1100, 50);
        text.setFont(new Font("Algerian", Font.BOLD, 50));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar menu=new JMenuBar();
        menu.setBounds(0,0,1920,30);
        image.add(menu);
        
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        menu.add(hotel);
        
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        menu.add(admin);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
           
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD ROOMS"))
        {
            
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DRIVERS"))
        {
            
            new AddDriver().setVisible(true);
        }else if(ae.getActionCommand().equals("RECEPTION"))
        {
            
            new Reception().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new MainDashboard();
    }

}
