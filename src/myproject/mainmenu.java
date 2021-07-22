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
public class mainmenu implements ActionListener{
    String m,id;
   JButton b1,b2,b3,b4;
    
    mainmenu(String n,String mid)
     {
     m=n;
     id=mid;
    JFrame f= new JFrame("Main Menu"); 
    Font F=new Font("Verdana",Font.PLAIN,26);
    Font FF=new Font("Verdana",Font.PLAIN,22);
    JLabel l1,l2;  
    l1=new JLabel("MAIN MENU");  
    l1.setBounds(300,50,300,20);   
    l1.setFont(F);
    f.add(l1); 
    l2=new JLabel("Welcome "+n +" !!");  
    l2.setBounds(300,120,300,20);   
    l2.setFont(FF);
    f.add(l2);
    b1= new JButton(); 
    b2= new JButton();  
    b3= new JButton(); 
    b4= new JButton();  
    b1.setText("Edit Profile"); 
    b1.setBounds(300,200,115,60); 
    b1.addActionListener(this);
    b2.setText("Update Profile");  
    b2.setBounds(300,300,115,60); 
    b2.addActionListener(this);
    b3.setText("Fee Deposit");  
    b3.setBounds(300,400,115,60);
    b3.addActionListener(this);
    b4.setText("Exit");  
    b4.setBounds(300,500,115,60);
    b4.addActionListener(this);
    f.add(b1); 
    f.add(b2); 
    f.add(b3); 
    f.add(b4); 
    f.setSize(800,800);  
    f.setLayout(null);  
    f.setVisible(true);  
}
     
   public void actionPerformed(ActionEvent b){
       if(b.getSource()==b1)
       {
        new edit(m,id);   
       }
       if(b.getSource()==b2)
       {
        new update(m,id);   
       }
        if(b.getSource()==b3)
       {
        new fee(m,id);   
       }
       if(b.getSource()==b4)
            System.exit(0);
   }
    public static void main(String ar[])
    {
    
    
        new mainmenu("","");
    }
}
