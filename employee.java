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
public class employee implements ActionListener{
    
    private JFrame frame;
    private JPanel panel;
    private JButton buttona;
    private JButton buttonb;
    private JTextField employeeText;
    private JLabel toolLabel;
    
    public void Emp(){
        frame = new JFrame();
        frame.setSize(350, 200);
        
        toolLabel = new JLabel("Available Tools");
        toolLabel.setBounds(10,10,100,25);
        buttona = new JButton("screw driver");
        buttona.setBounds(10,40,100,25);
        buttona.addActionListener(this);
        
        buttonb = new JButton("hammer");
        buttonb.setBounds(10,80,100,25);
        buttonb.addActionListener(this);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(buttona);
        panel.add(buttonb);
        panel.add(toolLabel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Employee");
        frame.add(panel);
        frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        checkOut equipment;
        equipment = new checkOut();
        equipment.tool();
    }
}
//employeeLabel = new JLabel("Username");
        //employeeLabel.setBounds(10,20,80,25);
        //employeeText = new JTextField(20);
        //employeeText.setBounds(100,20,165,25 );