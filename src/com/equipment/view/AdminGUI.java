package com.equipment.view;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template*/

/**@author Jayden Lyons
 * jlyons30@my.devry.edu*/


public class AdminGUI extends javax.swing.JFrame {
    
    private String username;
    private DefaultListModel<String> employeeListModel;
    private DefaultListModel<String> inventoryModel = new DefaultListModel<>();

    
     /*Creates new form AdminGUI*/
    public AdminGUI(String username) {
        this.username = username;
        initComponents();
        addEmployee.addActionListener(e -> addEmployee()); //listens for when "Add employee" button is clicked
        removeEmployee.addActionListener(e -> removeEmployee()); //listens for when "Remove employee" button is clicked
        employeeListModel = new DefaultListModel<>();
        lstEmployees.setModel(employeeListModel);  //Employee list
        lstInventory.setModel(inventoryModel);
        editInventory.addActionListener(e -> openInventoryEditor());
        setLocationRelativeTo(null);
        lblWelcome.setText("Welcome " + username);
    }
   

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editInventory = new javax.swing.JButton();
        addEmployee = new javax.swing.JButton();
        jpn_rentedtools = new javax.swing.JScrollPane();
        lstOverdue = new javax.swing.JList<>();
        removeEmployee = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnReports = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmployees = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstInventory = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editInventory.setText("Edit Inventory");

        addEmployee.setText("Add Employee");

        lstOverdue.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tool 1", "Tool 2", "Tool 3", "Tool 4", "Tool 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jpn_rentedtools.setViewportView(lstOverdue);

        removeEmployee.setText("Remove Employee");

        jLabel1.setText("Overdue Tool reports");

        jLabel2.setText("Tools/Materials");

        btnReports.setText("Generate Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstEmployees);

        jLabel3.setText("Employee List");

        jScrollPane2.setViewportView(lstInventory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(lblWelcome)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpn_rentedtools, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLogout)
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(editInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(removeEmployee))
                                    .addComponent(btnReports))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(33, 33, 33))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(129, 129, 129))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 30, Short.MAX_VALUE)
                                        .addComponent(jLabel3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(removeEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 63, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))))
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpn_rentedtools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new LoginGUI().setVisible(true);
        this.dispose(); // Close current window
    }//GEN-LAST:event_btnLogoutActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGUI("admin1").setVisible(true);
            }
        });
    }
    
//logic for adding employees
private void addEmployee() {
    String idStr = JOptionPane.showInputDialog(this, "Enter new employee ID:");
    if (idStr == null || idStr.trim().isEmpty()) return;

    String name = JOptionPane.showInputDialog(this, "Enter employee name:");
    if (name == null || name.trim().isEmpty()) return;

    String role = JOptionPane.showInputDialog(this, "Enter role (admin or employee):");
    if (role == null || (!role.equalsIgnoreCase("admin") && !role.equalsIgnoreCase("employee"))) {
        JOptionPane.showMessageDialog(this, "Invalid role. Must be 'admin' or 'employee'.");
        return;
    }

    String formattedEntry = name + " (" + idStr + ") - " + role.toUpperCase();
    employeeListModel.addElement(formattedEntry);

    JOptionPane.showMessageDialog(this, "Employee '" + formattedEntry + "' added successfully.");
    // Future: Hook to EmployeeController.addEmployee()
}
//logic for removing employees
private void removeEmployee() {
    String selected = lstEmployees.getSelectedValue();
    if (selected == null) {
        JOptionPane.showMessageDialog(this, "Please select an employee from the list to remove.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove:\n" + selected + "?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        employeeListModel.removeElement(selected);
        JOptionPane.showMessageDialog(this, "Removed: " + selected);
        // Future: Hook to EmployeeController.removeEmployee()
    }
}



private void openInventoryEditor() {
    javax.swing.JPanel panel = new javax.swing.JPanel();
    javax.swing.JList<String> popupList = new javax.swing.JList<>(inventoryModel);
    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(popupList);
    scroll.setPreferredSize(new java.awt.Dimension(250, 150));

    javax.swing.JButton addBtn = new javax.swing.JButton("Add Item");
    javax.swing.JButton removeBtn = new javax.swing.JButton("Remove Selected");

    addBtn.addActionListener(e -> {
        String itemName = JOptionPane.showInputDialog(this, "Enter item name:");
        if (itemName == null || itemName.trim().isEmpty()) return;

        String type = JOptionPane.showInputDialog(this, "Enter type (Tool/Material):");
        if (type == null || (!type.equalsIgnoreCase("tool") && !type.equalsIgnoreCase("material"))) {
            JOptionPane.showMessageDialog(this, "Type must be 'Tool' or 'Material'.");
            return;
        }

        String quantityStr = JOptionPane.showInputDialog(this, "Enter quantity:");
        if (quantityStr == null || !quantityStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid quantity.");
            return;
        }

        String formatted = itemName + " (" + type.toUpperCase() + ") x" + quantityStr;
        inventoryModel.addElement(formatted);
    });

    removeBtn.addActionListener(e -> {
        String selected = popupList.getSelectedValue();
        if (selected != null) {
            inventoryModel.removeElement(selected);
            JOptionPane.showMessageDialog(this, "Removed: " + selected);
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to remove.");
        }
    });

    panel.setLayout(new java.awt.BorderLayout());
    panel.add(scroll, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel btnPanel = new javax.swing.JPanel();
    btnPanel.add(addBtn);
    btnPanel.add(removeBtn);
    panel.add(btnPanel, java.awt.BorderLayout.SOUTH);

    JOptionPane.showMessageDialog(this, panel, "Edit Inventory", JOptionPane.PLAIN_MESSAGE);
}


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployee;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton editInventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jpn_rentedtools;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<String> lstEmployees;
    private javax.swing.JList<String> lstInventory;
    private javax.swing.JList<String> lstOverdue;
    private javax.swing.JButton removeEmployee;
    // End of variables declaration//GEN-END:variables
}
