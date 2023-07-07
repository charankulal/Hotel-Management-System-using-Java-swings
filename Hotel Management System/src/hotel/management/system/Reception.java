package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {

    JButton new1, rooms, dept, allemployees, customersinfo, managerinfo, checkout, pendingstat, roomstat, pickup, searchRoom, logout;

    Reception() {
        setLayout(null);

        new1 = new JButton("New Customer Form");
        new1.setBounds(10, 30, 200, 30);
        new1.setFont(new Font("Consolas", Font.BOLD, 16));
        new1.setBackground(Color.black);
        new1.setForeground(Color.white);
        new1.addActionListener(this);
        add(new1);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setFont(new Font("Consolas", Font.BOLD, 16));
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

        dept = new JButton("Department");
        dept.setBounds(10, 110, 200, 30);
        dept.setFont(new Font("Consolas", Font.BOLD, 16));
        dept.setBackground(Color.black);
        dept.setForeground(Color.white);
        dept.addActionListener(this);
        add(dept);

        allemployees = new JButton("All Employees");
        allemployees.setBounds(10, 150, 200, 30);
        allemployees.setFont(new Font("Consolas", Font.BOLD, 16));
        allemployees.setBackground(Color.black);
        allemployees.setForeground(Color.white);
        allemployees.addActionListener(this);
        add(allemployees);

        customersinfo = new JButton("Customer Info");
        customersinfo.setBounds(10, 190, 200, 30);
        customersinfo.setFont(new Font("Consolas", Font.BOLD, 16));
        customersinfo.setBackground(Color.black);
        customersinfo.setForeground(Color.white);
        customersinfo.addActionListener(this);
        add(customersinfo);

        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10, 230, 200, 30);
        managerinfo.setFont(new Font("Consolas", Font.BOLD, 16));
        managerinfo.setBackground(Color.black);
        managerinfo.setForeground(Color.white);
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setFont(new Font("Consolas", Font.BOLD, 16));
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);

        pendingstat = new JButton("Update Status");
        pendingstat.setBounds(10, 310, 200, 30);
        pendingstat.setFont(new Font("Consolas", Font.BOLD, 16));
        pendingstat.setBackground(Color.black);
        pendingstat.setForeground(Color.white);
        pendingstat.addActionListener(this);
        add(pendingstat);

        roomstat = new JButton("Update Room Status");
        roomstat.setBounds(10, 350, 200, 30);
        roomstat.setFont(new Font("Consolas", Font.BOLD, 16));
        roomstat.setBackground(Color.black);
        roomstat.setForeground(Color.white);
        roomstat.addActionListener(this);
        add(roomstat);

        pickup = new JButton("Pick Up Services");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setFont(new Font("Consolas", Font.BOLD, 16));
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setFont(new Font("Consolas", Font.BOLD, 16));
        searchRoom.setBackground(Color.black);
        searchRoom.setForeground(Color.white);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Log Out");
        logout.setBounds(10, 470, 200, 30);
        logout.setFont(new Font("Consolas", Font.BOLD, 16));
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 10, 500, 550);
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 800, 600);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == new1) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new AllRooms();
        } else if (ae.getSource() == dept) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == allemployees) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == managerinfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == customersinfo) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        }else if (ae.getSource() == pendingstat) {
            setVisible(false);
            new UpdateCheckout();
        }else if (ae.getSource() == roomstat) {
            setVisible(false);
            new UpdateRoom();
        }else if (ae.getSource() == pickup) {
            setVisible(false);
            new PickUp();
        }else if (ae.getSource() == checkout) {
            setVisible(false);
            new CheckOut();
        }else if (ae.getSource() == logout) {
            setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Reception();
    }
}
