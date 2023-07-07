
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CheckOut extends JFrame implements ActionListener{
    Choice customer;
    JLabel roomnumber,checkin,checkout;
    JButton checkoutbutton,back;
    CheckOut(){
        setLayout(null);
        
        JLabel text=new JLabel("Check out");
        text.setBounds(300,20,100,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel id=new JLabel("Customer ID :");
        id.setBounds(10,60,120,30);
        id.setForeground(Color.BLACK);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        add(id);
        
        customer = new Choice();
        customer.setFont(new Font("Raleway", Font.BOLD, 16));
        customer.setBounds(150, 60, 200, 30);
        add(customer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("id_number"));
                roomnumber.setText(rs.getString("room"));
                checkin.setText(rs.getString("checkin"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 60, 20, 20);
        add(image);
        
        JLabel room=new JLabel("Room No :");
        room.setBounds(10,100,120,30);
        room.setForeground(Color.BLACK);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        add(room);
        
        roomnumber=new JLabel("");
        roomnumber.setBounds(150,100,200,30);
        roomnumber.setForeground(Color.BLACK);
        roomnumber.setFont(new Font("Tahoma",Font.BOLD,14));
        add(roomnumber);
        
        JLabel check=new JLabel("Check In :");
        check.setBounds(10,140,120,30);
        check.setForeground(Color.BLACK);
        check.setFont(new Font("Tahoma",Font.BOLD,14));
        add(check);
        
        checkin=new JLabel("");
        checkin.setBounds(150,140,220,30);
        checkin.setForeground(Color.BLACK);
        checkin.setFont(new Font("Tahoma",Font.BOLD,14));
        add(checkin);
        
        JLabel check1=new JLabel("Check Out :");
        check1.setBounds(10,180,120,30);
        check1.setForeground(Color.BLACK);
        check1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(check1);
        
        Date date=new Date();
        
        checkout=new JLabel(""+date);
        checkout.setBounds(150,180,220,30);
        checkout.setForeground(Color.BLACK);
        checkout.setFont(new Font("Tahoma",Font.BOLD,14));
        add(checkout);
        
        checkoutbutton = new JButton("Check Out");
        checkoutbutton.setBounds(20, 300, 120, 30);
        checkoutbutton.setFont(new Font("Consolas", Font.BOLD, 16));
        checkoutbutton.setBackground(Color.black);
        checkoutbutton.setForeground(Color.white);
        checkoutbutton.addActionListener(this);
        add(checkoutbutton);

        back = new JButton("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 16));
        back.setBounds(160, 300, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i8 = i7.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image1 = new JLabel(i9);
        image1.setBounds(400, 70, 350, 250);
        add(image1);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("id_number"));
                roomnumber.setText(rs.getString("room"));
                checkin.setText(rs.getString("checkin"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        getContentPane().setBackground(Color.white);
        setBounds(300, 200, 800, 400);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkoutbutton)
        {
            String query1="delete from customer where id_number='"+customer.getSelectedItem()+"'";
            String query2="update rooms set available='Available' where roono='"+roomnumber.getText()+"'";
            
            Conn c=new Conn();
            try{
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Check Out Done!!");
                setVisible(false);
                new Reception();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String args[])
    {
        new CheckOut();
    }
}
