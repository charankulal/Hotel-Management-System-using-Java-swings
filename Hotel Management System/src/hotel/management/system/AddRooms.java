package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener {

    JTextField roomfield, pricefield;
    JComboBox availbox, cleanbox, bedbox;
    JButton add, cancel;

    AddRooms() {
        setLayout(null);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(375, 20, 250, 30);
        add(heading);

        JLabel roomno = new JLabel("Room Number : ");
        roomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        roomno.setBounds(50, 80, 150, 30);
        add(roomno);

        roomfield = new JTextField();
        roomfield.setFont(new Font("Consolas", Font.PLAIN, 16));
        roomfield.setBounds(200, 80, 200, 30);
        add(roomfield);

        JLabel avail = new JLabel("Available : ");
        avail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        avail.setBounds(50, 130, 150, 30);
        add(avail);

        String availOptions[] = {"Available", "Occupied", "Reserved"};
        availbox = new JComboBox(availOptions);
        availbox.setBackground(Color.white);
        availbox.setBounds(200, 130, 200, 30);
        add(availbox);

        JLabel clean = new JLabel("Cleaning Status : ");
        clean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        clean.setBounds(50, 170, 150, 30);
        add(clean);

        String cleanOptions[] = {"Cleaned", "Not Cleaned"};

        cleanbox = new JComboBox(cleanOptions);
        cleanbox.setBackground(Color.white);
        cleanbox.setBounds(200, 170, 200, 30);
        add(cleanbox);

        JLabel price = new JLabel("Price : ");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(50, 210, 150, 30);
        add(price);

        pricefield = new JTextField();
        pricefield.setFont(new Font("Consolas", Font.PLAIN, 16));
        pricefield.setBounds(200, 210, 200, 30);
        add(pricefield);

        JLabel bed = new JLabel("Bed Type : ");
        bed.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bed.setBounds(50, 250, 150, 30);
        add(bed);

        String bedOptions[] = {"Single Bed", "Double Bed"};

        bedbox = new JComboBox(bedOptions);
        bedbox.setBackground(Color.white);
        bedbox.setBounds(200, 250, 200, 30);
        add(bedbox);

        add = new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add.setBounds(50, 350, 100, 30);
        add(add);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(280, 350, 100, 30);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 950, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomno = roomfield.getText();
            String availability = (String) availbox.getSelectedItem();
            String cleanstat = (String) cleanbox.getSelectedItem();
            String price = pricefield.getText();
            String bedtype = (String) bedbox.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "Insert into rooms values('" + roomno + "','" + availability + "','" + cleanstat + "','" + price + "','" + bedtype + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");

            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            setVisible(false);

        }
    }

    public static void main(String args[]) {
        new AddRooms();
    }
}
