/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class edit implements ActionListener
{
    String m1,id;
    JButton b1,b2,b3,b4;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3;
    JFrame f= new JFrame("Edit Profile"); 
    Font F=new Font("Verdana",Font.PLAIN,26);
    Font FF=new Font("Verdana",Font.PLAIN,22);
    JLabel l1,l2,l3,l4,l5,l6; 
    edit(String m,String mid){
        m1=m;
        id=mid;
    l1=new JLabel("Name");  
    l1.setBounds(200,30,300,20);   
    l1.setFont(FF);
    f.add(l1); 
    l2=new JLabel("Stream");  
    l2.setBounds(200,120,300,20);   
    l2.setFont(FF);
    f.add(l2);
    l3=new JLabel("Semester");  
    l3.setBounds(200,220,300,20);   
    l3.setFont(FF);
    f.add(l3);
    l4=new JLabel("Gender");  
    l4.setBounds(200,320,300,20);   
    l4.setFont(FF);
    f.add(l4);
    l5=new JLabel("Address");  
    l5.setBounds(200,420,300,20);   
    l5.setFont(FF);
    f.add(l5);
    l6=new JLabel("Password");  
    l6.setBounds(200,520,300,20);   
    l6.setFont(FF);
    f.add(l6);
    t2=new JTextField(""); 
    t3=new JTextField("");  
    t1=new JTextField(m);  
    f.add(t1);
    t1.setBounds(400,30,300,50); 
    f.add(t2);
    t2.setBounds(400,420,300,50);  
    f.add(t3);
    t3.setBounds(400,520,300,50);  
    b1= new JButton(); 
    b2= new JButton();   
    b1.setText("Save"); 
    b1.setBounds(200,650,115,60);
    b2.setText("Exit"); 
    b2.setBounds(500,650,115,60);
    f.add(b1);
    b1.addActionListener(this);
    b2.addActionListener(this);
    f.add(b2); 
    c1=new JComboBox();  
        c1.setBounds(400,120,300,50);  
        c1.addItem("CSE");  
        c1.addItem("ECE");  
        c1.addItem("Mechanical");  
        c1.addItem("Civil");  
        c1.addItem("Robotics");  
        f.add(c1);
    c2=new JComboBox();  
        c2.setBounds(400,320,300,50);  
        c2.addItem("Male");  
        c2.addItem("Female");  
        c2.addItem("Prefer not to say");   
        f.add(c2);
    c3=new JComboBox();  
        c3.setBounds(400,220,300,50);  
        c3.addItem("1");  
        c3.addItem("2");  
        c3.addItem("3");  
        c3.addItem("4");  
        c3.addItem("5");  
        c3.addItem("6");  
        c3.addItem("7");  
        c3.addItem("8");  
        f.add(c3);
    f.setSize(800,800);  
    f.setLayout(null);  
    f.setVisible(true);
    String st="",sem="",gen="",add="",pas="";
     try
 {
			Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Kirti123");  
                        //String sql = "Select *  from record";
                        String sql = "Select * from details where name='"+m1+"'";
                        System.out.println("m1"+m1+"id"+id);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery( sql );
 
			while (rs.next())
			 {
                        //System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));		}
			 st=rs.getString(2);
			//stubt.setVisible(false);
                         sem=rs.getString(3);
                         gen=rs.getString(4);
                         add=rs.getString(5);
                         pas=rs.getString(7);
                         
                         }
                        
                         
			rs.close();
			stat.close();
                        c1.setSelectedItem(st);
                        c2.setSelectedItem(gen);
                        c3.setSelectedItem(sem);
			t2.setText(add);
                        t3.setText(pas);
                        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
                

}
public void actionPerformed(ActionEvent b){
       if(b.getSource()==b1)
       {
            String s1;
         s1=t1.getText();
         if(s1.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER NAME");
             return;
         }
         String s2;
         s2=t2.getText();
         if(s2.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER ADDRESS");
             return;
         }
         String s3;
         s3=t3.getText();
         if(s3.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER PASSWORD");
             return;
         }  
              try
 {
			Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Kirti123");  
                        //String sql = "Select *  from record";
                        String sql = "update details  set name='"+s1+"', stream='"+c1.getSelectedItem()+"',gender='"+c2.getSelectedItem()+"',semester='"+c3.getSelectedItem()+"', address='"+s2+"',password='"+s3+"'  where username='"+id+"'";
			Statement stat = con.createStatement();
                        JOptionPane.showMessageDialog(null,"Saved successfully");
			stat.executeUpdate( sql );
 }
              	catch(Exception e)
		{
			System.out.println(e);
		}


        }
       if(b.getSource()==b2)
           f.setVisible(false);
   }
 public static void main(String ar[]){  

  new edit("","");
}
}
    

 