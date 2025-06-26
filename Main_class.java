package EmployeeManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_class extends JFrame{

    //Creating Constructor;
    public Main_class(){

        //Adding Title to Frame;
        setTitle("Main Class");

        //Setting Background image;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        //Adding a heading to it;
        JLabel heading=new JLabel("Empoyee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);

        //Creating Button =>Add Employee;
        JButton add=new JButton("Add Employee");
        add.setBounds(330,250,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);

        //Making a function for this button;
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Full working given in different class =>(AddEmployee.java);
                new AddEmployee();
                setVisible(false);
            }
        });
        image.add(add);

        //Creating Button =>View Employee;
        JButton view=new JButton("View Employee");
        view.setBounds(520,250,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);

        //Making a function for this button;
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Full working given in different class =>(ViewEmployee.java);
                new ViewEmployee();
                setVisible(false);
            }
        });
        image.add(view);

        //Creating Button =>Remove Employee;
        JButton remove=new JButton("Remove Employee");
        remove.setBounds(430,345,150,40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.BLACK);

        //Making a function for this button;
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Full working given in different class =>(ViewEmployee.java);
                new RemoveEmployee();
                setVisible(false);
            }
        });
        image.add(remove);


        setSize(1120,630);
        setLocation(100,50);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}

