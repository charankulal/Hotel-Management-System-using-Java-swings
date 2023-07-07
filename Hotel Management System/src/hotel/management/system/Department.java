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

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Department() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dept.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 0, 500, 500);
        add(image);
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Budget");
        l2.setBounds(260,10,100,20);
        add(l2);
        
        
        
        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("Consolas",Font.BOLD,14));
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(200, 500, 100, 30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);
        setBounds(250, 200, 1050, 600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String args[]) {
        new Department();
    }
}

