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
public class checkOut implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JButton buttona;
    private JButton buttonb;
    private JTextField employeeText;
    private JLabel employeeLabel;
    
    public void tool(){
        frame = new JFrame();
        frame.setSize(300,150);
        
        buttona = new JButton("check-out");
        buttona.setBounds(10,20,100,25);
        buttona.addActionListener(this);
        
        buttonb = new JButton("check-in");
        buttonb.setBounds(10,50,100,25);
        buttonb.addActionListener(this);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(buttona);
        panel.add(buttonb);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Get/Return Tool");
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Transaction Log created");
        System.exit(0);
    }
}
