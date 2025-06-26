package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    //Global Variable;
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;


    //Constructor;
    public Login() {
        //Adding a title to frame;
        setTitle("Login Page");

        //Creating label for UserName;
        JLabel username = new JLabel("Username:");
        username.setBounds(30,20,100,30);
        username.setFont(new Font("sarif",Font.BOLD,18));
        add(username);

        //Creating textFeild for userName;
        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        //Creating label for password;
        JLabel password = new JLabel("Password:");
        password.setBounds(30,70,100,30);
        password.setFont(new Font("sarif",Font.BOLD,18));
        add(password);

        //Creating textFeild for password;
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        //Creating login button;
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //Creating back button;
        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //Creating image in front of textFeild;
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);

        //Creating Background image;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setSize(600,300);
        setLocation(350,200);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){

            //for getting the data from database;
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);

                    //for calling main class page after login page;
                    new Main_class();
                }else {

                    //for pop-up a dialog box if userName,pass is wrong;
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource() == back) {
            System.exit(10);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}

