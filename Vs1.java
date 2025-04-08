/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vs1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
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

public class Vs1 implements ActionListener {
    
    private JFrame frame;
    private JPanel panel;
    private JButton button1;
    private JTextField userText;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordText;

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    public void login() {
        frame = new JFrame();
        frame.setSize(350, 200);
        
        userLabel = new JLabel("Username");
        userLabel.setBounds(10,20,80,25);
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25 );
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        
        button1 = new JButton("Log In");
        button1.setBounds(10,80,80,25);
        button1.addActionListener(this);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(userLabel);
        panel.add(userText);
        panel.add(button1);
        panel.add(passwordLabel);
        panel.add(passwordText);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ECS");
        
        frame.setVisible(true);
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = passwordText.getText();
        System.out.println(username+","+password);
        if(password.equals("teamE")){
            System.out.println("Admin");
            adminiStrator boss;
            boss = new adminiStrator();
            boss.admin();
        }
        else if(password.equals("GBM2025")){
            System.out.println("Emp");
            employee emp;
            emp = new employee();
            emp.Emp();
            
        }
        else{
            System.out.println("Error");
            System.exit(0);
        }
    }
            
    
}
//panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 30, 30));
        //panel.setLayout(new GridLayout(0, 1));
//frame.pack();