package com.equipment.view;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import com.equipment.controller.EmployeeController;
import com.equipment.dao.EmployeeDAO;
import com.equipment.model.Employee;
import java.util.List;
import com.equipment.model.Equipment;
import com.equipment.dao.EquipmentDAO;
import com.equipment.controller.EquipmentController;
import java.time.LocalDate;
import com.equipment.model.Tool;
import com.equipment.model.Material;

/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template*/

/**@author(s) 
 * 
 * Jayden Lyons
 *  jlyons30@my.devry.edu
 * 
 * Brendan McGalliard
 *  b.mcgalliard.dev@outlook.com
 *  +1(517)575-5880
 */

 


public class AdminGUI extends javax.swing.JFrame {
    
    private String username;
    private DefaultListModel<String> employeeListModel;
    private DefaultListModel<String> inventoryModel = new DefaultListModel<>();
    
    private EmployeeController employeeController = new EmployeeController();
    private EquipmentController equipmentController = new EquipmentController();

    
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
        
        //call updateEmployeeList to populate the employee list on startup
        updateEmployeeList();
    }
   

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

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

        lstOverdue.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Tool 1", "Tool 2", "Tool 3", "Tool 4", "Tool 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jpn_rentedtools.setViewportView(lstOverdue);

        removeEmployee.setText("Remove Employee");

        jLabel1.setText("Overdue Tool reports");

        jLabel2.setText("Tools/Materials");

        btnReports.setText("Generate Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnReportsActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
                            .addComponent(jLabel1)
                            .addComponent(jpn_rentedtools, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogout)
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(editInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(removeEmployee))
                                    .addComponent(btnReports))
                                .addGap(70, 70, 70)
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
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogout)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jpn_rentedtools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
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
    String name = JOptionPane.showInputDialog(this, "Enter employee name:");
    if (name == null || name.trim().isEmpty()) return;

    String role = JOptionPane.showInputDialog(this, "Enter role (admin or employee):");
    if (role == null || (!role.equalsIgnoreCase("admin") && !role.equalsIgnoreCase("employee"))) {
        JOptionPane.showMessageDialog(this, "Invalid role. Must be 'admin' or 'employee'.");
        return;
    }
    String password = JOptionPane.showInputDialog(this, "Enter password for the new employee:");
    if (password == null || password.trim().isEmpty()) return;
    
   
    String formattedEntry = name + " (" + role + ")";
    
    JOptionPane.showMessageDialog(this, "Employee '" + formattedEntry + "' added successfully.");
    

    //Convert role to ENUM values for db
    role = role.toLowerCase();
    
    //System.out.println("Adding user with role: " + role);
    //Add employee to the database.
    employeeController.addEmployee(new Employee(name, password, role));
    
    //Update the list from the database
    updateEmployeeList();
    
    
}
//logic for removing employees
private void removeEmployee() {
    String selected = lstEmployees.getSelectedValue();
    if (selected == null) {
        JOptionPane.showMessageDialog(this, "Please select an employee from the list to remove.");
        return;
    }
    
    //Extract the employeeID from the selected string
    String[] parts = selected.split(" \\(");
    String empUsername = parts[0];
    
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove:\n" + selected + "?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        
        //Call EmployeeController to remove selected employee from the database
        employeeController.removeEmployee(empUsername);
        
        //Remove name from list in GUI
        employeeListModel.removeElement(selected);
        
        //Update list to database
        updateEmployeeList();
        
        //Inform user that employee was deleted successfully
        
        JOptionPane.showMessageDialog(this, "Removed: " + selected);
    }
}



private void openInventoryEditor() {
    javax.swing.JPanel panel = new javax.swing.JPanel();
    javax.swing.JList<String> popupList = new javax.swing.JList<>(inventoryModel);
    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(popupList);
    scroll.setPreferredSize(new java.awt.Dimension(250, 150));
    loadInventory();

    javax.swing.JButton addBtn = new javax.swing.JButton("Add Item");
    javax.swing.JButton removeBtn = new javax.swing.JButton("Remove Selected");
    javax.swing.JButton editBtn = new javax.swing.JButton("Edit Item");

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

    String condition = JOptionPane.showInputDialog(this, "Enter condition (New, Worn, Damaged, Broken):");
    if (condition == null || condition.trim().isEmpty()) return;

    String checkOutStr = JOptionPane.showInputDialog(this, "Is it checked out? (true/false):");
    boolean isCheckedOut = Boolean.parseBoolean(checkOutStr); // Default false if invalid

    String warehouseIDStr = JOptionPane.showInputDialog(this, "Enter warehouse ID (number):");
    if (warehouseIDStr == null || !warehouseIDStr.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid warehouse ID.");
        return;
    }

    String returnDateStr = null;
    if (type.equalsIgnoreCase("tool")) {
        returnDateStr = JOptionPane.showInputDialog(this, "Enter return date (yyyy-MM-dd), or leave blank:");
        if (returnDateStr != null && !returnDateStr.isEmpty()) {
            try {
                java.time.LocalDate.parse(returnDateStr); // Validates the date
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd.");
                return;
            }
        }
    }

    String formatted = itemName + " (" + type.toUpperCase() + ") x" + quantityStr + 
        " | Cond: " + condition + 
        " | Checked Out: " + isCheckedOut +
        " | WH ID: " + warehouseIDStr +
        (returnDateStr != null && !returnDateStr.isEmpty() ? " | Return: " + returnDateStr : "");
    
    int quantity = Integer.parseInt(quantityStr);
    int warehouseID = Integer.parseInt(warehouseIDStr);
    LocalDate returnDate = null;
    if (returnDateStr != null && !returnDateStr.isEmpty()) 
    {
        returnDate = LocalDate.parse(returnDateStr);
    }
    
    Equipment newEquip = new Equipment(
            itemName,
            type,
            quantity,
            condition,
            isCheckedOut,
            warehouseID,
            returnDate
    );
    
    EquipmentDAO equipmentDAO = new EquipmentDAO();
    boolean success = equipmentDAO.addEquipment(newEquip);
    
    if(success)
    {
        inventoryModel.addElement(formatted);
        JOptionPane.showMessageDialog(this, "Item successfully added to database.");
    }
    else
    {
        JOptionPane.showMessageDialog(this, "Failed to add item to the database.");
    }
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
    
    editBtn.addActionListener(e -> {
    String selected = popupList.getSelectedValue();
    if (selected == null) {
        JOptionPane.showMessageDialog(this, "Select an item to edit.");
        return;
    }

    // Attempt to split the data you added previously
    String[] parts = selected.split(" \\(|\\) x| \\| Cond: | \\| Checked Out: | \\| WH ID: | \\| Return: ");
    String oldName = parts[0];
    String oldType = parts[1];
    String oldQuan = parts[2];
    String oldCond = parts[3];
    String oldCheckedOut = parts[4];
    String oldWarehouseID = parts[5];
    String oldReturnDate = (parts.length >= 7) ? parts[6] : "";

    String newName = JOptionPane.showInputDialog(this, "Edit item name:", oldName);
    if (newName == null || newName.trim().isEmpty()) return;

    String newType = JOptionPane.showInputDialog(this, "Edit type (Tool/Material):", oldType);
    if (newType == null || (!newType.equalsIgnoreCase("Tool") && !newType.equalsIgnoreCase("Material"))) {
        JOptionPane.showMessageDialog(this, "Type must be 'Tool' or 'Material'.");
        return;
    }

    String newQuan = JOptionPane.showInputDialog(this, "Edit quantity:", oldQuan);
    if (newQuan == null || !newQuan.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid quantity.");
        return;
    }

    String newCond = JOptionPane.showInputDialog(this, "Edit condition (New, Worn, Damaged, Broken):", oldCond);
    if (newCond == null || newCond.trim().isEmpty()) return;

    String newCheckedOut = JOptionPane.showInputDialog(this, "Is it checked out? (true/false):", oldCheckedOut);
    boolean isCheckedOut = Boolean.parseBoolean(newCheckedOut);

    String newWarehouseID = JOptionPane.showInputDialog(this, "Edit warehouse ID (number):", oldWarehouseID);
    if (newWarehouseID == null || !newWarehouseID.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid warehouse ID.");
        return;
    }

    String newReturnDate = "";
    if (newType.equalsIgnoreCase("Tool")) {
        newReturnDate = JOptionPane.showInputDialog(this, "Edit return date (yyyy-MM-dd):", oldReturnDate);
        if (newReturnDate != null && !newReturnDate.isEmpty()) {
            try {
                java.time.LocalDate.parse(newReturnDate); // Validates format
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd.");
                return;
            }
        }
    }

    String updated = newName + " (" + newType.toUpperCase() + ") x" + newQuan +
        " | Cond: " + newCond +
        " | Checked Out: " + isCheckedOut +
        " | WH ID: " + newWarehouseID +
        (newReturnDate != null && !newReturnDate.isEmpty() ? " | Return: " + newReturnDate : "");

    inventoryModel.setElementAt(updated, popupList.getSelectedIndex());
});
    
    panel.setLayout(new java.awt.BorderLayout());
    panel.add(scroll, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel btnPanel = new javax.swing.JPanel();
    btnPanel.add(addBtn);
    btnPanel.add(removeBtn);
    btnPanel.add(editBtn);
    panel.add(btnPanel, java.awt.BorderLayout.SOUTH);

    JOptionPane.showMessageDialog(this, panel, "Edit Inventory", JOptionPane.PLAIN_MESSAGE);
}

    public void updateEmployeeList()
    {
        employeeListModel.clear();
        
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.getAllEmployees();
        
        for (Employee employee : employees)
        {
            String formattedEntry = employee.getUsername() + 
                    " ("+ employee.getEmpID() + ") - " +
                    employee.getRole().toUpperCase();
            employeeListModel.addElement(formattedEntry);
        }
    }
    public void loadInventory(){
            inventoryModel.clear(); // Clear any stale data

            List<Equipment> allEquipment = equipmentController.getAllEquipment();
            for (Equipment e : allEquipment) {
                String display = e.getEquipName() + " (" + e.getEquipType().toUpperCase() + ") x" + e.getEquipQuan() +
                    " | Cond: " + e.getEquipCond() +
                    " | Checked Out: " + e.getCheckOutStatus() +
                    " | WH ID: " + e.getWarehouseID();

            if (e instanceof Tool) {
                LocalDate returnDate = ((Tool) e).getReturnDate();
                if (returnDate != null) {
                    display += " | Return: " + returnDate;
                }
            }
            
            inventoryModel.addElement(display);
        }
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
