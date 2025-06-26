package EmployeeManagement;

import java.awt.Image;

import javax.swing.*;


public class splash extends JFrame{

    //Creating Constructor;
    public splash() {

        //Giving a Title to the frame;
        setTitle("Employee Management System");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));

        //Now Scaling the i1 image;

        Image i2= i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);

        //Now setting image again ;

        ImageIcon i3=new ImageIcon(i2);

        //For adding image to the JFrame we use JLabel;

        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);

        setSize(1170,650);
        setLocation(100,50);
        setVisible(true);
        setLayout(null);


        //For Auto Closing the Front we use try block;

        try {

            //for giving the timing to front we use Threads;

            Thread.sleep(5000);
            setVisible(false);

            //for calling login page after splash page;
            new Login();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new splash();
    }

}

