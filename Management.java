/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vs1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author quint
 */
public class Management implements ActionListener{
    
     private JFrame frame;
    private JPanel panel;
    private JButton buttona;
    private JButton buttonb;
    
    private JTextField nameText;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JTextField empID;
    
    public void manage(){
    
        frame = new JFrame();
        frame.setSize(350,200);
        
        nameLabel = new JLabel("Employee name");
        nameLabel.setBounds(10,20,110,25);
        nameText = new JTextField(20);
        nameText.setBounds(100,20,165,25 );
        
        idLabel = new JLabel("Employee ID");
        idLabel.setBounds(10,50,80,25);
        empID = new JTextField(20);
        empID.setBounds(100,50,165,25 );
        
        buttona = new JButton("Add employee");
        buttona.setBounds(10,80,140,25);
        buttona.addActionListener(this);
        
        buttonb = new JButton("Remove employee");
        buttonb.setBounds(10,100,140,25);
        buttonb.addActionListener(this);
        
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(buttona);
        panel.add(buttonb);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(idLabel);
        panel.add(empID);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Manage Employees");
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
    
       String employeeName = nameText.getText();
       String employeeID = empID.getText();
       System.out.println(employeeName+" "+employeeID);
       if(e.getSource()==buttona){          
           
           System.out.println(employeeName+" "+"added.");
           System.exit(0);
       }
       else {
           
           System.out.println(employeeName+" "+"removed.");
           System.exit(0);
       }
    }
}
