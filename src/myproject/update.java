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
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class update implements ActionListener{ 
    String m1,id;
    JFrame f= new JFrame("Edit Profile");
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2,r3,r4;
    Font F=new Font("Verdana",Font.PLAIN,32);
    Font FF=new Font("Verdana",Font.PLAIN,22);
    Font FFF=new Font("Verdana",Font.PLAIN,24);

    update(String m,String mid) 
    {
        m1=m;
        id=mid;
    l1=new JLabel("EDUCATIONAL DETAILS");  
    l1.setBounds(500,30,500,200);   
    l1.setFont(F);
    f.add(l1); 
    l2=new JLabel("Matriculation");  
    l2.setBounds(200,300,300,20);   
    l2.setFont(FF);
    f.add(l2);
    l3=new JLabel("10+2");  
    l3.setBounds(200,400,300,20);   
    l3.setFont(FF);
    f.add(l3);
    l4=new JLabel("Year");  
    l4.setBounds(450,220,300,20);   
    l4.setFont(FF);
    f.add(l4);
    l5=new JLabel("CGPA/%age");  
    l5.setBounds(600,220,350,20);   
    l5.setFont(FF);
    f.add(l5);
    l6=new JLabel("Board");  
    l6.setBounds(850,220,300,20);   
    l6.setFont(FF);
    f.add(l6);
    l7=new JLabel("Extra Activities:-");  
    l7.setBounds(200,550,300,100);   
    l7.setFont(FF);
    f.add(l7);
    t1=new JTextField(""); 
    t2=new JTextField("");  
    t3=new JTextField("");  
    t4=new JTextField(""); 
    t5=new JTextField(""); 
    t6=new JTextField(""); 
    t1.setBounds(400,300,150,50); 
    f.add(t1);
    t2.setBounds(600,300,150,50);  
    f.add(t2);
    t3.setBounds(800,300,150,50);  
    f.add(t3);
    t4.setBounds(400,400,150,50); 
    f.add(t4);
    t5.setBounds(600,400,150,50);  
    f.add(t5);
    t6.setBounds(800,400,150,50);  
    f.add(t6);
    b1= new JButton(); 
    b2= new JButton();   
    b1.setText("Save"); 
    b1.setBounds(500,750,115,60);
    b1.addActionListener(this);
    b2.setText("Exit"); 
    b2.setBounds(700,750,115,60);
    b2.addActionListener(this);
    f.add(b1);
    f.add(b2);    
    r1=new JRadioButton("Singing");    
    r2=new JRadioButton("Dancing"); 
    r3=new JRadioButton("Anchoring");    
    r4=new JRadioButton("Acting"); 
    r1.setBounds(400,600,100,100);    
    r2.setBounds(500,600,100,100);  
    r3.setBounds(600,600,100,100);    
    r4.setBounds(700,600,100,100);  
    ButtonGroup bg=new ButtonGroup();    
    bg.add(r1);
    bg.add(r2);
    bg.add(r3);  
    bg.add(r4); 
    f.add(r1);
    f.add(r2);
    f.add(r3);
    f.add(r4);
    f.setSize(800,800);  
    f.setLayout(null);  
    f.setVisible(true);
    }
    public void actionPerformed(ActionEvent b){
        if(b.getSource()==b2)
            System.exit(0);
        if(b.getSource()==b1)
        {
         String s1,s2,s3,s4,s5,s6,s7="";
         s1=t1.getText();
         if(s1.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER MATRICULATION YEAR");
             return;
         }
          s2=t2.getText();
         if(s2.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER MATRICULATION CGPA OR %AGE");
             return;
         }
          s3=t3.getText();
         if(s3.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER MATRICULATION BOARD");
             return;
         }
          s4=t4.getText();
         if(s4.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER 10+2 YEAR");
             return;
         }
          s5=t5.getText();
         if(s5.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER 10+2 CGPA OR %AGE");
             return;
         }
          s6=t6.getText();
         if(s6.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER 10+2 BOARD");
             return;
         }
         if(r1.isSelected())
             s7=s7+" Singing";
         if(r2.isSelected())
             s7=s7+" Dancing";
         if(r3.isSelected())
             s7=s7+" Anchoring";
         if(r4.isSelected())
             s7=s7+" Acting";
         
         try
 {
			Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Kirti123");  
                        String sql = "insert into stu values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+id+"')";
			Statement stat = con.createStatement();
                        JOptionPane.showMessageDialog(null,"Saved successfully");
			stat.executeUpdate( sql );
 }
              	catch(Exception e)
		{
			System.out.println(e);
		}


        }
    
        }
    
    public static void main(String ar[]){  

  new update("","");
}
}