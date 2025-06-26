package EmployeeManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{

    //Generating random number for employee id;
    Random ran=new Random();
    int number=ran.nextInt(100);

    //Making Global variable;
    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox teducation;
    JButton add,back;

    //Creating Constructor;
    public AddEmployee() {

        //Frame Title;
        setTitle("Adding Employee Detail");

        //Setting Background color using new color property;
        getContentPane().setBackground(new Color(163,255,138));

        //Adding a Label => (Adding Employee Detail) to it;
        JLabel heading=new JLabel("Adding Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("sarif",Font.BOLD,25));
        add(heading);

        //Adding a Label =>(Name) to it;
        JLabel name=new JLabel("Name: ");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(name);

        //Adding textField for Name;
        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        //Adding a Label =>(Father's Name) to it;
        JLabel fname=new JLabel("Father's Name: ");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        //Adding textField for Father Name;
        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        //Adding a Label =>(Date of Birth) to it;
        JLabel dob=new JLabel("Date of Birth: ");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        //Adding textField for Date of Birth;
        tdob=new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        //Adding a Label =>(Salary) to it;
        JLabel salary=new JLabel("Salary: ");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        //Adding textField for Salary;
        tsalary=new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        //Adding a Label =>(Address) to it;
        JLabel address=new JLabel("Address: ");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        //Adding textField for Address;
        taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        //Adding a Label =>(Phone Number) to it;
        JLabel phone=new JLabel("Phone Number: ");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        add(phone);

        //Adding textField for Phone Number;
        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        //Adding a Label =>(Email) to it;
        JLabel email=new JLabel("Email: ");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        //Adding textField for Email;
        temail=new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        //Adding a Label =>(Education) to it;
        JLabel education=new JLabel("Education: ");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        //Creating a Drop down for Education;
        String items[]= {"BBA","B.TECH","BCA","BA","BSC","B.COM","MBA","MCA","MA","M.TECH","MSC","PHD"};
        teducation =new JComboBox(items);
        teducation.setBounds(600,300,150,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);

        //Adding a Label =>(AAdhar) to it;
        JLabel aadhar=new JLabel("Aadhar Number: ");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        add(aadhar);

        //Adding textField for AAdhar;
        taadhar=new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        //Adding a Label =>(Employee ID) to it;
        JLabel empid=new JLabel("Employee ID: ");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        //Adding Label for Empolyee Id;
        tempid=new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        //Adding a Label =>(Designation) to it;
        JLabel designation=new JLabel("Designation: ");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        //Adding textField for Designation;
        tdesignation=new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        //Adding a button=>(Add Employee) to it;
        add=new JButton("Add Employee");
        add.setBounds(250,480,150,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);

        //Adding a button=>(Back) to it;
        back=new JButton("Back");
        back.setBounds(450,480,150,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(200,20);
        setVisible(true);
    }

    //Giving functionality for add or back buttons;
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == add) {
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=(String) teducation.getSelectedItem();
            String designation=tdesignation.getText();
            String empid=tempid.getText();
            String aadhar=taadhar.getText();

            //For Store all data into database;
            try {

                conn c=new conn();
                String query="insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+empid+"', '"+aadhar+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);

                //For Returning to the main page;
                new Main_class();
            }
            catch(Exception E) {
                E.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Main_class();
        }

    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}

