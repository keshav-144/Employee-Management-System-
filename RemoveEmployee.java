package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener{

    //Global Variable;
    Choice choiceEmp;
    JButton delete,back;

    //Creating Constructor;
    public RemoveEmployee() {

        //Creatin a Title for Frame;
        setTitle("Remove Employee");

        //Creating a Label for it;
        JLabel search=new JLabel("Removing Employee According To Their Id ");
        search.setBounds(100,50,500,30);
        search.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(search);

        //Creating a label=>(Employee ID:);
        JLabel label = new JLabel("Employee ID:");
        label.setBounds(50, 150, 100, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        //for see all id in dropDown;
        choiceEmp = new Choice();
        choiceEmp.setBounds(180, 155, 150, 30);
        add(choiceEmp);

        //For fatching data from table we use try and catch;
        try{
            conn c=new conn();
            String query="select * from employee";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next()){
                choiceEmp.add(rs.getString("empid"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Creating labels for Name;
        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(50, 200, 100, 30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(180, 200, 100, 30);
        add(textName);

        //Creating labels for Phone number;
        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(50, 250, 100, 30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(180, 250, 100, 30);
        add(textPhone);

        //Creating labels for Email;
        JLabel labelEmail = new JLabel("Email:");
        labelEmail .setBounds(50, 300, 100, 30);
        labelEmail .setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelEmail );

        JLabel textEmail = new JLabel();
        textEmail.setBounds(180, 300, 500, 30);
        add(textEmail);

        //For see again the data of above label we use try and catch;
        try{
            conn c=new conn();
            String query="select * from employee where empid='"+choiceEmp.getSelectedItem()+"'";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next()){
                textName.setText(rs.getString("name"));
                textPhone.setText(rs.getString("phone"));
                textEmail.setText(rs.getString("email"));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        //For selecting the data according to id we use ItemListener;
        choiceEmp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    String query="select * from employee where empid='"+choiceEmp.getSelectedItem()+"'";
                    ResultSet rs=c.statement.executeQuery(query);
                    while(rs.next()){
                        textName.setText(rs.getString("name"));
                        textPhone.setText(rs.getString("phone"));
                        textEmail.setText(rs.getString("email"));
                    }

                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Creating Button =>(Remove Employee);
        delete=new JButton("Remove Employee");
        delete.setBounds(70, 360, 150, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        //Creating Button =>(Back);
        back=new JButton("Back");
        back.setBounds(240, 360, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //Adding a image to Frame;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600, 150, 200, 200);
        add(image);

        //Adding a backgroundimage to Frame;
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22=i11.getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imagee = new JLabel(i33);
        imagee.setBounds(0, 0, 1000, 500);
        add(imagee);



        setSize(850,500);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==delete){
            //There are chance to come Exceptions;
            try{

                conn c = new conn();
                String query = "delete from employee where empId = '"+choiceEmp.getSelectedItem()+"'";
                c.statement.executeUpdate(query);

                //If data is delete Successfully then we show a pop-up using JOptionPane;
                JOptionPane.showMessageDialog(null,"Employee Delete Successfully");

                //Now for going back to main page;
                setVisible(false);
                new Main_class();
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Main_class();
        }
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
