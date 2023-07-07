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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice customer;
    JTextField roomfield, availfield, cleanfield, paidfield, pendingfield;
    JButton check, update, back;

    UpdateRoom() {
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setForeground(Color.red);
        text.setBounds(30, 20, 250, 30);
        add(text);

        JLabel id = new JLabel("Customer ID : ");
        id.setFont(new Font("Raleway", Font.BOLD, 16));
        id.setBounds(30, 80, 150, 30);
        add(id);

        customer = new Choice();
        customer.setFont(new Font("Raleway", Font.BOLD, 16));
        customer.setBounds(200, 80, 200, 30);
        add(customer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("id_number"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel room = new JLabel("Room Number : ");
        room.setFont(new Font("Raleway", Font.BOLD, 16));
        room.setBounds(30, 120, 150, 30);
        add(room);

        roomfield = new JTextField();
        roomfield.setFont(new Font("Raleway", Font.BOLD, 16));
        roomfield.setBounds(200, 120, 200, 30);
        add(roomfield);

        JLabel avail = new JLabel("Availability : ");
        avail.setFont(new Font("Raleway", Font.BOLD, 16));
        avail.setBounds(30, 160, 150, 30);
        add(avail);

        availfield = new JTextField();
        availfield.setFont(new Font("Raleway", Font.BOLD, 16));
        availfield.setBounds(200, 160, 200, 30);
        add(availfield);

        JLabel clean = new JLabel("Cleaning Status : ");
        clean.setFont(new Font("Raleway", Font.BOLD, 16));
        clean.setBounds(30, 200, 150, 30);
        add(clean);

        cleanfield = new JTextField();
        cleanfield.setFont(new Font("Raleway", Font.BOLD, 16));
        cleanfield.setBounds(200, 200, 200, 30);
        add(cleanfield);

        check = new JButton("Check");
        check.setBounds(20, 300, 90, 30);
        check.setFont(new Font("Consolas", Font.BOLD, 16));
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setFont(new Font("Consolas", Font.BOLD, 16));
        update.setBounds(140, 300, 90, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 16));
        back.setBounds(260, 300, 90, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430, 30, 500, 400);
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = customer.getSelectedItem();
            String query = "select * from customer where id_number ='" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    roomfield.setText(rs.getString("room"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from rooms where roono='" + roomfield.getText() + "'");
                while (rs2.next()) {
                    availfield.setText(rs2.getString("available"));
                    cleanfield.setText(rs2.getString("clean_stat"));

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == update) {
            String number = customer.getSelectedItem();
            String room = roomfield.getText();
            String availablity = availfield.getText();
            String clean = cleanfield.getText();
            

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update rooms set available='" + availablity + "',clean_stat='" + clean + "' where roono='"+room+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String args[]) {
        new UpdateRoom();
    }
}
