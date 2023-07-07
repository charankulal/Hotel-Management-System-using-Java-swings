package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox idbox;
    JTextField numberfield, namefield, depositfield, countryfield;
    JRadioButton rmale, rfemale;
    Choice roomchoice;
    JLabel checkintime;
    JButton add, back;

    AddCustomer() {
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(270, 10, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JLabel id = new JLabel("ID : ");
        id.setBounds(30, 60, 100, 25);
        id.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(id);

        String idstr[] = {"Aadhar Card", "Passport", "Driving License", "Voter-ID", "PAN card"};
        idbox = new JComboBox(idstr);
        idbox.setBounds(200, 60, 150, 25);
        idbox.setBackground(Color.white);
        idbox.setFont(new Font("Consolas", Font.PLAIN, 16));
        add(idbox);

        JLabel number = new JLabel("Number : ");
        number.setBounds(30, 100, 100, 25);
        number.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(number);

        numberfield = new JTextField();
        numberfield.setBounds(200, 100, 150, 25);
        numberfield.setBackground(Color.white);
        numberfield.setFont(new Font("Consolas", Font.PLAIN, 16));
        add(numberfield);

        JLabel name = new JLabel("Name : ");
        name.setBounds(30, 140, 150, 25);
        name.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(name);

        namefield = new JTextField();
        namefield.setBounds(200, 140, 150, 25);
        namefield.setBackground(Color.white);
        namefield.setFont(new Font("Consolas", Font.PLAIN, 16));
        add(namefield);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(30, 180, 150, 25);
        gender.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(200, 180, 70, 30);
        rmale.setBackground(Color.white);
        rmale.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270, 180, 90, 30);
        rfemale.setBackground(Color.white);
        rfemale.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(rfemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rmale);
        genderGroup.add(rfemale);

        JLabel country = new JLabel("Country : ");
        country.setBounds(30, 220, 150, 25);
        country.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(country);

        countryfield = new JTextField();
        countryfield.setBounds(200, 220, 150, 25);
        countryfield.setBackground(Color.white);
        countryfield.setFont(new Font("Consolas", Font.PLAIN, 16));
        add(countryfield);

        JLabel allocatedRoom = new JLabel("Allocated Room No : ");
        allocatedRoom.setBounds(30, 260, 150, 25);
        allocatedRoom.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(allocatedRoom);

        roomchoice = new Choice();

        try {
            Conn c = new Conn();
            String query = "select * from rooms where available='Available'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                roomchoice.add(rs.getString("roono"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        roomchoice.setBounds(200, 260, 150, 30);
        add(roomchoice);

        JLabel checkin = new JLabel("Check In Time : ");
        checkin.setBounds(30, 300, 150, 25);
        checkin.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(checkin);

        Date date = new Date();

        checkintime = new JLabel("" + date);
        checkintime.setBounds(180, 300, 250, 25);
        checkintime.setBackground(Color.white);
        checkintime.setFont(new Font("Consolas", Font.PLAIN, 12));
        add(checkintime);

        JLabel deposit = new JLabel("Deposit : ");
        deposit.setBounds(30, 340, 150, 25);
        deposit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(deposit);

        depositfield = new JTextField();
        depositfield.setBounds(200, 340, 150, 25);
        depositfield.setBackground(Color.white);
        depositfield.setFont(new Font("Consolas", Font.PLAIN, 16));
        add(depositfield);

        add = new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setFont(new Font("Raleway", Font.BOLD, 16));
        add.setBounds(50, 400, 100, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(250, 400, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 800, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) idbox.getSelectedItem();
            String number = numberfield.getText();
            String name = namefield.getText();
            String gender = "";

            if (rmale.isSelected()) {
                gender = "Male";
            } else if (rfemale.isSelected()) {
                gender = "Female";
            }

            String country = countryfield.getText();
            String room = roomchoice.getSelectedItem();
            String checkin = checkintime.getText();
            String deposit = depositfield.getText();

            try {
                String query = "insert into customer values ('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + checkin + "','" + deposit + "')";
                String query1 = "update rooms set available='Occupied' where roono='" + room + "'";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
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
        new AddCustomer();
    }
}
