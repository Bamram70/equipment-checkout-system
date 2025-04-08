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
public class warehouse {
    
    private JFrame frame;
    private JPanel panel;
    private JLabel warehouseNumber;
    
    public void contactWarehouse(){
    
        frame = new JFrame();
        frame.setSize(350,200);
        warehouseNumber = new JLabel("Contact 888-245-3611");
        warehouseNumber.setBounds(10,20,80,25);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(warehouseNumber);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Contact Warehouse");
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
}
