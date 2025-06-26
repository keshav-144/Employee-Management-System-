package EmployeeManagement;

import net.proteanit.sql.DbUtils;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewEmployee extends JFrame implements ActionListener{

    //Global Variable;
    Choice choiceEmp;
    JTable table;
    JButton searchbtn,print,update,back;

    public ViewEmployee() {

        //Setting Title to frame;
        setTitle("ViewEmployee Class");

        //Setting background to the frame;
        getContentPane().setBackground(new Color(255,131,122));

        //Creating a Label for it;
        JLabel search=new JLabel("Employee id: ");
        search.setBounds(20,20,150,30);
        search.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(search);

        //Creating a Drop-down for searching id;
        choiceEmp=new Choice();
        choiceEmp.setBounds(200,25,150,30);
        add(choiceEmp);

        //Getting employee id inside drop-down we take it from database;
        try {

            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("select * from employee");
            while(rs.next()) {
                choiceEmp.add(rs.getString("empid"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        //For taking the full data from database we use JTable;
        table=new JTable();
        try {
            conn c=new conn();
            ResultSet rs=c.statement.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        //If we Lot of data we use JScrollPane;
        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        //Adding search Button;
        searchbtn=new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        //Adding Print Button;
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        //Adding Update Button;
        update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        //Adding Back Button;
        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(180,18);
        setVisible(true);
    }

    //Giving Functioning to button;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchbtn) {

            //Search according to id so have to make connection again with database;
            String query="select * from employee where empid='"+choiceEmp.getSelectedItem()+"'";

            //For handle some execption we use try and catch;
            try{
                conn c=new conn();
                ResultSet rs=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource() == print) {

            //there are some chance to come some execption so we again use try and catch;
            try{
                    table.print();
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource() == update) {
            setVisible(false);
            //For sending same Employee Id to (UpdateEmployee.java);
            new UpdateEmployee(choiceEmp.getSelectedItem());

        }
        else {
           setVisible(false);
           new Main_class();
        }

    }
    public static void main(String[] args) {
        new ViewEmployee();
    }

}

