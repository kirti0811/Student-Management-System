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
public class fee implements ActionListener {
    String m1,id;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7; 
    JTextField t1,t2,t3,t4,t5,t6;
    JFrame f= new JFrame("FEE DEPOSITION"); 
    Font F=new Font("Verdana",Font.PLAIN,32);
    Font FF=new Font("Verdana",Font.PLAIN,22);
   fee(String m,String mid){
        m1=m;
        id=mid;
    l1=new JLabel("Fee Deposition");  
    l1.setBounds(300,20,400,100);   
    l1.setFont(F);
    f.add(l1); 
    l2=new JLabel("Name");  
    l2.setBounds(200,100,100,100);   
    l2.setFont(FF);
    f.add(l2);
    l3=new JLabel("User id");  
    l3.setBounds(200,200,100,100);   
    l3.setFont(FF);
    f.add(l3);
    l4=new JLabel("Date");  
    l4.setBounds(200,300,100,100);   
    l4.setFont(FF);
    f.add(l4);
    l5=new JLabel("Amount");  
    l5.setBounds(200,400,100,100);   
    l5.setFont(FF);
    f.add(l5);
    l6=new JLabel("Card/Cheque");  
    l6.setBounds(200,500,300,100);   
    l6.setFont(FF);
    f.add(l6);
    l7=new JLabel("Bank Details");  
    l7.setBounds(200,600,300,100);   
    l7.setFont(FF);
    f.add(l7);
    t1=new JTextField(m); 
    t2=new JTextField(id);  
    t3=new JTextField("");  
    t4=new JTextField(""); 
    t5=new JTextField(""); 
    t6=new JTextField(""); 
    t1.setBounds(400,120,200,50); 
    f.add(t1);
    t2.setBounds(400,220,200,50);  
    f.add(t2);
    t3.setBounds(400,320,200,50);  
    f.add(t3);
    t4.setBounds(400,420,200,50); 
    f.add(t4);
    t5.setBounds(400,520,200,50);  
    f.add(t5);
    t6.setBounds(400,620,200,50);  
    f.add(t6);
    b1= new JButton(); 
    b1.setText("Save"); 
    b1.setBounds(200,750,150,80);
    f.add(b1);
    b1.addActionListener(this);
    b2= new JButton(); 
    b2.setText("Exit"); 
    b2.setBounds(450,750,150,80);
    f.add(b2);
    b2.addActionListener(this);
    f.setSize(800,800);  
    f.setLayout(null);  
    f.setVisible(true);
     
}
    public void actionPerformed(ActionEvent b){
   if(b.getSource()==b1)
        {
         String s1,s2,s3,s4,s5,s6;
         s1=t1.getText();
         if(s1.length()==0)
         {
             JOptionPane.showMessageDialog(null,"Enter Name");
             return;
         }
          s2=t2.getText();
         if(s2.length()==0)
         {
             JOptionPane.showMessageDialog(null,"Enter user id");
             return;
         }
          s3=t3.getText();
         if(s3.length()==0)
         {
             JOptionPane.showMessageDialog(null,"Enter Date");
             return;
         }
          s4=t4.getText();
         if(s4.length()==0)
         {
             JOptionPane.showMessageDialog(null,"Enter Amount");
             return;
         }
          s5=t5.getText();
         if(s5.length()==0)
         {
             JOptionPane.showMessageDialog(null,"Enter Mode of payment");
             return;
         }
          s6=t6.getText();
         if(s6.length()==0)
         {
             JOptionPane.showMessageDialog(null,"Enter your bank details");
             return;
         }
    
    try
 {
			Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Kirti123");  
                        //String sql = "Select *  from record";
                        String sql = "insert into fee values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
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
            System.exit(0);


   }

public static void main(String ar[])
{  

  new fee("","");
}
}

