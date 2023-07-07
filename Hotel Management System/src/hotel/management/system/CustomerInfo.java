package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    CustomerInfo() {
        setLayout(null);

        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("ID Number");
        l2.setBounds(190, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(370, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(550, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(730, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Allocated Room");
        l6.setBounds(910, 10, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Date & Time");
        l7.setBounds(1100, 10, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Deposited Amount");
        l8.setBounds(1280, 10, 150, 20);
        add(l8);

        table = new JTable();
        table.setBounds(0, 40, 1440, 480);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("Consolas", Font.BOLD, 10));
        } catch (Exception e) {
            System.out.println(e);
        }

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(700, 530, 100, 30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);
        setBounds(50, 200, 1450, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String args[]) {
        new CustomerInfo();
    }
}
