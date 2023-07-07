package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {

    JTable table;
    JButton back,submit;
    Choice cartypebox;
    JCheckBox available;
    PickUp() {
        setLayout(null);

        JLabel text=new JLabel("Pickup Services");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400, 10, 150, 30);
        add(text);
        
        JLabel cartype=new JLabel("Type of Car : ");
        cartype.setFont(new Font("Tahoma",Font.PLAIN,16));
        cartype.setBounds(50, 100, 100, 20);
        add(cartype);
        
        cartypebox=new Choice();
        cartypebox.setFont(new Font("Consolas",Font.PLAIN,14));
        cartypebox.setBounds(150, 100, 200, 20);
        cartypebox.setBackground(Color.white);
        add(cartypebox);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                cartypebox.add(rs.getString("model"));
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        available=new JCheckBox("Show Only Available");
        available.setFont(new Font("Consolas",Font.PLAIN,14));
        available.setBounds(850, 100, 200, 20);
        available.setBackground(Color.white);
        add(available);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(10, 180, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(160, 180, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(310, 180, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 180, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(610, 180, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(760, 180, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(910, 180, 100, 20);
        add(l7);

        table = new JTable();
        table.setBounds(0, 210, 1050, 400);
        add(table);

        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("Consolas", Font.BOLD, 14));
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(750, 700, 100, 30);
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(300, 700, 100, 30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.white);
        setBounds(220, 50, 1050, 800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit)
        {
            try{
                String query1="Select * from driver where model='"+cartypebox.getSelectedItem()+"'";
                String query2="select * from driver where availability='Available' AND model='"+cartypebox.getSelectedItem()+"' ";
                
                Conn c=new Conn();
                ResultSet rs;
                if(available.isSelected())
                {
                    rs=c.s.executeQuery(query2);
                }else{
                    rs=c.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("Consolas", Font.BOLD, 14));
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
        new Reception();
        }
    }

    public static void main(String args[]) {
        new PickUp();
    }
}
