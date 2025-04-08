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
public class adminiStrator implements ActionListener {
    
    
    private JFrame frame;
    private JPanel panel;
    private JButton buttona;
    private JButton buttonb;
    private JButton buttonc;
    private JButton buttond;
    private JTextField employeeText;
    private JLabel toolLabel;

    
    public void admin(){
    
        frame = new JFrame();
        frame.setSize(350,200);
        
        buttona = new JButton("View tools");
        buttona.setBounds(10,20,140,25);
        buttona.addActionListener(this);
        
        buttonb = new JButton("Add employee");
        buttonb.setBounds(10,50,140,25);
        buttonb.addActionListener(this);
        
        buttonc = new JButton("Remove Employee");
        buttonc.setBounds(10,80,140,25);
        buttonc.addActionListener(this);
        
        buttond = new JButton("Contact Warehouse");
        buttond.setBounds(10,110,140,25);
        buttond.addActionListener(this);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(buttona);
        panel.add(buttonb);
        panel.add(buttonc);
        panel.add(buttond);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Administrator Options");
        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {    
    if(e.getSource()==buttona){
            employee Ad;
            Ad = new employee();
            Ad.Emp(); 
        } else if(e.getSource()==buttonb) {
      
            Management person1;
            person1 = new Management();
            person1.manage();
        }   else if(e.getSource()==buttonc) {
            
            Management person2;
            person2 = new Management();
            person2.manage();
        } else  {
            
            warehouse call;
            call = new warehouse();
            call.contactWarehouse();
        }
        
    }
    
}
