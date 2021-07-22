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
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;  
import javax.swing.*;
import javax.swing.JFrame;  
import javax.swing.JLabel;  
public class home implements ActionListener{
     JButton button1,button2;
     JTextField t1;
     JPasswordField value;
     JFrame frame;
     home()
     {
         frame = new JFrame("Chalkpad");  
        JPanel panel = new JPanel(); 
        value = new JPasswordField("");
        Font F=new Font("Verdana",Font.PLAIN,22);
        Font f=new Font("Calibri",Font.PLAIN,18);
        panel.setFont(F);
        JLabel label1 = new JLabel("CHITKARA UNIVERSITY");  
        JLabel label2 = new JLabel("PUNJAB");
        JLabel label3 = new JLabel("USERNAME");  
        JLabel label4 = new JLabel("PASSWORD");
        t1=new JTextField("");  
        panel.add(label1);  
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.setLayout(null);
        label1.setBounds(250,50,300,20);
        label1.setFont(F);
        label2.setBounds(320,80,100,60);
        label2.setFont(F);
        label3.setBounds(100,200,300,50);
        label3.setFont(f);
        label4.setBounds(100,300,300,50);
        label4.setFont(f);
        t1.setBounds(300,200,200,50);  
        frame.add(t1);  
        value.setBounds(300,300,200,50); 
        frame.add(value);
         button1 = new JButton(); 
         button2 = new JButton();  
         button1.setText("SUBMIT"); 
         button1.addActionListener(this);
         button2.addActionListener(this);
        button1.setBounds(100,500,100,20);
        button2.setText("RESET"); 
        button2.setBounds(500,500,100,20);
        panel.add(button1);   
        panel.add(button2);  
        frame.add(panel);  
        frame.setSize(800,800);   
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
    public void actionPerformed(ActionEvent b){
        if(b.getSource()==button2)
            System.exit(0);
        if(b.getSource()==button1)
        {
         String s1;
         s1=t1.getText();
         if(s1.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER USERNAME");
             return;
         }
         String s2;
         s2=new String(value.getPassword());
         System.out.println(s2);
         if(s2.length()==0)
         {
             JOptionPane.showMessageDialog(null,"ENTER PASSWORD");
             return;
         }
         try
 {
     int f=0;
     String n="";
			Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Kirti123");  
                        //String sql = "Select *  from record";
                        String sql = "Select *  from details where username='"+s1+"' and password='"+s2+"'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery( sql );
 
			while (rs.next())
			 {
                        //System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));		}
			 n=rs.getString(1);
			//stubt.setVisible(false);
                         f=1;
                         }
                         if (f==1)
                         {
                             frame.setVisible(false);
                             JOptionPane.showMessageDialog(null,"Welcome "+n);
                             mainmenu m=new mainmenu(n,s1);
                             
                         }
                         else 
                             JOptionPane.showMessageDialog(null,"Invalid Details");
             
             
                                 
			rs.close();
			stat.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

        }  
    }
    public static void main(String ar[])
    {
    
    
        new home();
    }
    }

 
