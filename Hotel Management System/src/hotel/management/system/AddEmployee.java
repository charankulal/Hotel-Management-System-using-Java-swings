package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField namefield, agefield, salaryfield, emailfield, phonefield, aadharfield;
    JRadioButton rmale, rfemale;
    JComboBox combobox;
    JButton submit, cancel;

    AddEmployee() {
        setLayout(null);

        JLabel name = new JLabel("NAME : ");
        name.setBounds(60, 30, 120, 30);
        name.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(name);

        namefield = new JTextField();
        namefield.setBounds(200, 30, 150, 30);
        namefield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(namefield);

        JLabel age = new JLabel("AGE : ");
        age.setBounds(60, 70, 120, 30);
        age.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(age);

        agefield = new JTextField();
        agefield.setBounds(200, 70, 150, 30);
        agefield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(agefield);

        JLabel gender = new JLabel("GENDER : ");
        gender.setBounds(60, 110, 120, 30);
        gender.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(gender);

        rmale = new JRadioButton("MALE");
        rmale.setBounds(200, 110, 70, 30);
        rmale.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(rmale);

        rfemale = new JRadioButton("FEMALE");
        rfemale.setBounds(290, 110, 90, 30);
        rfemale.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(rfemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rmale);
        genderGroup.add(rfemale);

        JLabel job = new JLabel("JOB : ");
        job.setBounds(60, 160, 120, 30);
        job.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(job);

        String str[] = {"Select a Role", "Front Desk Clerks", "Porters", "HouseKeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant", "Others"};
        combobox = new JComboBox(str);
        combobox.setBounds(200, 160, 200, 30);
        combobox.setBackground(Color.white);
        combobox.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(combobox);

        JLabel salary = new JLabel("SALARY : ");
        salary.setBounds(60, 200, 120, 30);
        salary.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(salary);

        salaryfield = new JTextField();
        salaryfield.setBounds(200, 200, 150, 30);
        salaryfield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(salaryfield);

        JLabel phone = new JLabel("PHONE NO. : ");
        phone.setBounds(60, 240, 120, 30);
        phone.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(phone);

        phonefield = new JTextField();
        phonefield.setBounds(200, 240, 150, 30);
        phonefield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(phonefield);

        JLabel email = new JLabel("EMAIL : ");
        email.setBounds(60, 280, 120, 30);
        email.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(email);

        emailfield = new JTextField();
        emailfield.setBounds(200, 280, 150, 30);
        emailfield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(emailfield);

        JLabel aadhar = new JLabel("AADHAR : ");
        aadhar.setBounds(60, 330, 120, 30);
        aadhar.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(aadhar);

        aadharfield = new JTextField();
        aadharfield.setBounds(200, 330, 150, 30);
        aadharfield.setFont(new Font("Consolas", Font.PLAIN, 17));
        add(aadharfield);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(40, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200, 430, 150, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = namefield.getText();
        String age = agefield.getText();
        String salary = salaryfield.getText();
        String phone = phonefield.getText();
        String email = emailfield.getText();
        String aadhar = aadharfield.getText();

        String gender = "";
        if (rmale.isSelected()) {
            gender = "Male";
        } else if (rfemale.isSelected()) {
            gender = "Female";
        }

        if (ae.getSource() == cancel) {
            setVisible(false);
            

        } else if (name.equals("") || name.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Name Cannot be Empty");
        } else {
            String job = (String) combobox.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            } catch (Exception e) {
                System.out.println(e);
            }
            setVisible(false);
            new AddEmployee();
        }
    }

    public static void main(String args[]) {
        new AddEmployee();
    }
}
