package com.equipment.view;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/* @author Jayden Lyons
 * jlyons30@my.devry.edu*/

public class MainGUI extends javax.swing.JFrame {
    
    private String username;
    private DefaultListModel<String> rentedModel = new DefaultListModel<>();
    
     /*Creates new form MainGUI*/
    public MainGUI(String username) {
        this.username = username;
        initComponents();
        btnRequest.addActionListener(e -> requestTool());
        btnRequestMat.addActionListener(e -> requestMaterial());
        lstRented.setModel(rentedModel);
        setLocationRelativeTo(null);
        lblWelcome.setText("Welcome " + username);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbTools = new javax.swing.JComboBox<>();
        jcbMaterials = new javax.swing.JComboBox<>();
        btnRequest = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jpn_rentedtools = new javax.swing.JScrollPane();
        listRentedtools = new javax.swing.JList<>();
        btnLogout = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        btnRequestMat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRented = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcbTools.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tool 1", "Tool 2", "Tool 3", "Tool 4" }));

        jcbMaterials.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Material 1", "Material 2", "Material 3", "Material 4" }));

        btnRequest.setText("Request Tool");

        btnReturn.setText("Return Tool");

        listRentedtools.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tool 1", "Tool 2", "Tool 3", "Tool 4", "Tool 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jpn_rentedtools.setViewportView(listRentedtools);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnRequestMat.setText("Request Material");

        jScrollPane1.setViewportView(lstRented);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpn_rentedtools)
                    .addComponent(jcbTools, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbMaterials, 0, 98, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(btnRequest))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnRequestMat)))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(lblWelcome)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblWelcome)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTools, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpn_rentedtools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnRequestMat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new LoginGUI().setVisible(true);
        this.dispose(); // Close current window
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
    
// logic to request tools
private void requestTool() {
    String selectedTool = (String) jcbTools.getSelectedItem();
    if (selectedTool == null || selectedTool.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a tool to request.");
        return;
    }

    rentedModel.addElement("Tool - " + selectedTool);
    JOptionPane.showMessageDialog(this, "Tool '" + selectedTool + "' has been requested.");
}
// logic to request materials
private void requestMaterial() {
    String selectedMaterial = (String) jcbMaterials.getSelectedItem();
    if (selectedMaterial == null || selectedMaterial.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a material to request.");
        return;
    }

    rentedModel.addElement("Material - " + selectedMaterial);
    JOptionPane.showMessageDialog(this, "Material '" + selectedMaterial + "' has been requested.");
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnRequestMat;
    private javax.swing.JButton btnReturn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbMaterials;
    private javax.swing.JComboBox<String> jcbTools;
    private javax.swing.JScrollPane jpn_rentedtools;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<String> listRentedtools;
    private javax.swing.JList<String> lstRented;
    // End of variables declaration//GEN-END:variables
}
