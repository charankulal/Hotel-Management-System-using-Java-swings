package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener{
    JButton next;
    HotelManagementSystem(){
        setLayout(null);

        setSize(1366,565);
        setLocation(100,100);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,480,700,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.BOLD,40));
        image.add(text);
        
        next=new JButton("Next");
        next.setBounds(1150,480,100,30);
        next.setBackground(Color.PINK);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        image.add(next);
        text.setFont(new Font("serif",Font.BOLD,40));
        
        setVisible(true);
        
        while(true)
        {
            text.setVisible(false);
            try{
                Thread.sleep(500);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
       
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login().setVisible(true);
    }
    

    public static void main(String[] args) {
        HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();
    }
    
}
