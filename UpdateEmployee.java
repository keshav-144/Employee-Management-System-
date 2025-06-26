package EmployeeManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener{

    //Making Global variable;
    JTextField teducation,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempid;
    JButton add,back;
    String number;


    //Creating Constructor;
    public UpdateEmployee(String number){

        //For passing the same id;
        this.number=number;

        //Frame Title;
        setTitle("Upadating Employee Detail");

        //Setting Background color using new color property;
        getContentPane().setBackground(new Color(163,255,138));

        //Adding a Label => (Adding Employee Detail) to it;
        JLabel heading=new JLabel("Updating Employee Detail");
        heading.setBounds(250,30,500,50);
        heading.setFont(new Font("sarif",Font.BOLD,25));
        add(heading);

        //Adding a Label =>(Name) to it;
        JLabel name=new JLabel("Name: ");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(name);

        //Adding Label for Name because name can not be change;
        JLabel tname=new JLabel();
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

        //Adding again a Label for "Date of Brith";
        JLabel tdob=new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
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


//        //Adding textField for Email;
         teducation=new JTextField();
         teducation.setBounds(600,300,150,30);
         teducation.setBackground(new Color(177,252,197));
         add(teducation);

        //Adding a Label =>(AAdhar) to it;
        JLabel aadhar=new JLabel("Aadhar Number: ");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        add(aadhar);

        //Adding textField for AAdhar;
        JLabel tAadhar=new JLabel();
        tAadhar.setBounds(600,350,150,30);
        tAadhar.setBackground(new Color(177,252,197));
        add(tAadhar);

        //Adding a Label =>(Employee ID) to it;
        JLabel empid=new JLabel("Employee ID: ");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        //Adding Label for Empolyee Id;
        tempid=new JLabel();
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

        //Now Exratinc Data to according that (Employee id);
        try{

            conn c=new conn();
            String query="select * from employee where empid='"+number+"'";
            ResultSet rs=c.statement.executeQuery(query);
            //For gettin full data;
            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                tdesignation.setText(rs.getString("designation"));
                tempid.setText(rs.getString("empid"));
                tAadhar.setText(rs.getString("aadhar"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //Adding a button=>(Update Details) to it;
        add=new JButton("Update Details");
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

    //Making Functioning;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add) {
            //To Update the data which is change;
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            //for update that data into database we use try and catch;
            try {

                conn c = new conn();
                String query = "update employee set fname='" + fname + "', salary='" + salary + "', address='" + address + "', " +
                        "phone='" + phone + "', email='" + email + "', education='" + education + "', designation='" + designation + "'" +
                        " where empid='" + number + "'";
                c.statement.executeUpdate(query);

                //If infromation update we see a pop-up using JOptionPane;
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                setVisible(false);

                //After update all we retrun back to our main_class;
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
       }
        else{
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
       new UpdateEmployee("");
    }
}
