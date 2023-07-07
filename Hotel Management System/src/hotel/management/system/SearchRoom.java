package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back,submit;
    JComboBox bedbox;
    JCheckBox available;
    SearchRoom() {
        setLayout(null);

        JLabel text=new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400, 10, 150, 30);
        add(text);
        
        JLabel bed=new JLabel("Bed Type : ");
        bed.setFont(new Font("Tahoma",Font.PLAIN,16));
        bed.setBounds(50, 100, 100, 20);
        add(bed);
        
        bedbox=new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedbox.setFont(new Font("Consolas",Font.PLAIN,14));
        bedbox.setBounds(150, 100, 120, 20);
        bedbox.setBackground(Color.white);
        add(bedbox);
        
        available=new JCheckBox("Show Only Available");
        available.setFont(new Font("Consolas",Font.PLAIN,14));
        available.setBounds(850, 100, 200, 20);
        available.setBackground(Color.white);
        add(available);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 180, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(220, 180, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(430, 180, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(640, 180, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(850, 180, 100, 20);
        add(l5);

        table = new JTable();
        table.setBounds(0, 200, 1050, 400);
        add(table);

        

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
                String query1="Select * from rooms where bed_type='"+bedbox.getSelectedItem()+"'";
                String query2="select * from rooms where available='Available' AND bed_type='"+bedbox.getSelectedItem()+"' ";
                
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
        new SearchRoom();
    }
}
