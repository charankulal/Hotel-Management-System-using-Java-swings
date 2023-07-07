package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheckout extends JFrame implements ActionListener {

    Choice customer;
    JTextField roomfield, namefield, checkinfield, paidfield, pendingfield;
    JButton check, update, back;

    UpdateCheckout() {
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setForeground(Color.red);
        text.setBounds(90, 20, 200, 30);
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

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(30, 160, 150, 30);
        add(name);

        namefield = new JTextField();
        namefield.setFont(new Font("Raleway", Font.BOLD, 16));
        namefield.setBounds(200, 160, 200, 30);
        add(namefield);

        JLabel checkin = new JLabel("Checkin Time : ");
        checkin.setFont(new Font("Raleway", Font.BOLD, 16));
        checkin.setBounds(30, 200, 150, 30);
        add(checkin);

        checkinfield = new JTextField();
        checkinfield.setFont(new Font("Raleway", Font.BOLD, 12));
        checkinfield.setBounds(200, 200, 200, 30);
        add(checkinfield);

        JLabel paid = new JLabel("Amount Paid : ");
        paid.setFont(new Font("Raleway", Font.BOLD, 16));
        paid.setBounds(30, 240, 150, 30);
        add(paid);

        paidfield = new JTextField();
        paidfield.setFont(new Font("Raleway", Font.BOLD, 16));
        paidfield.setBounds(200, 240, 200, 30);
        add(paidfield);

        JLabel pending = new JLabel("Pending Amount : ");
        pending.setFont(new Font("Raleway", Font.BOLD, 16));
        pending.setBounds(30, 280, 150, 30);
        add(pending);

        pendingfield = new JTextField();
        pendingfield.setFont(new Font("Raleway", Font.BOLD, 16));
        pendingfield.setBounds(200, 280, 200, 30);
        add(pendingfield);

        check = new JButton("Check");
        check.setBounds(20, 340, 90, 30);
        check.setFont(new Font("Consolas", Font.BOLD, 16));
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setFont(new Font("Consolas", Font.BOLD, 16));
        update.setBounds(140, 340, 90, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 16));
        back.setBounds(260, 340, 90, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
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
                    namefield.setText(rs.getString("name"));
                    checkinfield.setText(rs.getString("checkin"));
                    paidfield.setText(rs.getString("deposit"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from rooms where roono='" + roomfield.getText() + "'");
                while (rs2.next()) {
                    String rate = rs2.getString("price");
                    int amounttobepaid = Integer.parseInt(rate) - Integer.parseInt(paidfield.getText());
                    pendingfield.setText("" + amounttobepaid);

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == update) {
            String number = customer.getSelectedItem();
            String room = roomfield.getText();
            String name = namefield.getText();
            String checkin = checkinfield.getText();
            String deposit = paidfield.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room='" + room + "',name='" + name + "',checkin='" + checkin + "',deposit='" + deposit + "' where id_number='"+number+"'");

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
        new UpdateCheckout();
    }
}
