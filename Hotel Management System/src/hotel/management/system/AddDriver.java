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

public class AddDriver extends JFrame implements ActionListener {

    JTextField namefield, agefield, carfield, modelfield, locfield;
    JComboBox bedbox, genderbox, availbox;
    JButton add, cancel;

    AddDriver() {
        setLayout(null);

        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(375, 20, 250, 30);
        add(heading);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        name.setBounds(50, 80, 150, 30);
        add(name);

        namefield = new JTextField();
        namefield.setFont(new Font("Consolas", Font.PLAIN, 16));
        namefield.setBounds(200, 80, 200, 30);
        add(namefield);

        JLabel age = new JLabel("Age : ");
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        age.setBounds(50, 130, 150, 30);
        add(age);

        agefield = new JTextField();
        agefield.setBounds(200, 130, 200, 30);
        agefield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(agefield);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gender.setBounds(50, 170, 150, 30);
        add(gender);

        String cleanOptions[] = {"Male", "Female"};

        genderbox = new JComboBox(cleanOptions);
        genderbox.setBackground(Color.white);
        genderbox.setBounds(200, 170, 200, 30);
        add(genderbox);

        JLabel car = new JLabel("Car Company : ");
        car.setFont(new Font("Tahoma", Font.PLAIN, 16));
        car.setBounds(50, 210, 150, 30);
        add(car);

        carfield = new JTextField();
        carfield.setFont(new Font("Consolas", Font.PLAIN, 16));
        carfield.setBounds(200, 210, 200, 30);
        add(carfield);

        JLabel model = new JLabel("Car Model : ");
        model.setFont(new Font("Tahoma", Font.PLAIN, 16));
        model.setBounds(50, 250, 150, 30);
        add(model);

        modelfield = new JTextField();
        modelfield.setFont(new Font("Consolas", Font.PLAIN, 16));
        modelfield.setBounds(200, 250, 200, 30);
        add(modelfield);

        JLabel avail = new JLabel("Available : ");
        avail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        avail.setBounds(50, 290, 150, 30);
        add(avail);

        String availOptions[] = {"Available", "Busy"};
        availbox = new JComboBox(availOptions);
        availbox.setBackground(Color.white);
        availbox.setBounds(200, 290, 200, 30);
        add(availbox);

        JLabel location = new JLabel("Location : ");
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        location.setBounds(50, 340, 150, 30);
        add(location);

        locfield = new JTextField();
        locfield.setBounds(200, 340, 200, 30);
        locfield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(locfield);

        add = new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add.setBounds(50, 390, 100, 30);
        add(add);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(280, 390, 100, 30);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 60, 520, 370);
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = namefield.getText();
            String age = agefield.getText();
            String gender = (String) genderbox.getSelectedItem();
            String company = carfield.getText();
            String model = (String) modelfield.getText();
            String available = (String) availbox.getSelectedItem();
            String location = locfield.getText();
            try {
                Conn c = new Conn();
                String query = "Insert into driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + model + "','" + available + "','" + location + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);

        }
    }

    public static void main(String args[]) {
        new AddDriver();
    }
}
