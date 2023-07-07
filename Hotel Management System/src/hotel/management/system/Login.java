package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField username;
    JPasswordField password;
    Login()  {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel user=new JLabel("Username : ");
        user.setBounds(40,30,150,30);
        user.setFont(new Font("Raleway",Font.BOLD,20));
        add(user);
        
        username=new JTextField();
        username.setBounds(190,30,200,30);
        username.setFont(new Font("Consolas",Font.BOLD,20));
        add(username);
        
        JLabel pass=new JLabel("Password : ");
        pass.setBounds(40,80,150,30);
        pass.setFont(new Font("Raleway",Font.BOLD,20));
        add(pass);
        
        password=new JPasswordField();
        password.setBounds(190,80,200,30);
        password.setFont(new Font("Consolas",Font.BOLD,20));
        add(password);
        
        login=new JButton("LOGIN");
        login.setBounds(40,150,120,30);
        login.setFont(new Font("Raleway",Font.BOLD,20));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("CANCEL");
        cancel.setBounds(250,150,120,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,10,200,200);
        add(image);
        
        setBounds(500,200,600,300);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
         
        if(ae.getSource()==login){
            String user=username.getText();
            String pass=password.getText();
            
            try{
                Conn c=new Conn();
                String query="select * from login where username='"+user +"' and password='"+pass+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    MainDashboard mainDashboard = new MainDashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials: ");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
                setVisible(false);
             System.exit(0);
            }
            
        
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}
