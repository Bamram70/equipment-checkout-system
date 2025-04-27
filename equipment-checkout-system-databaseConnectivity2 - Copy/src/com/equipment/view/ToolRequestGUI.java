package com.equipment.view;

import com.equipment.controller.EquipmentController;
import com.equipment.dao.DatabaseConnection;
import com.equipment.dao.EquipmentDAO;
import com.equipment.model.Equipment;
import com.equipment.model.Material;
import com.equipment.model.Tool;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author(s)
 * Jayden Lyons - jlyons30@my.devry.edu
 */
public class ToolRequestGUI extends JFrame {

    private JList<Tool> lstAvailableTools = new JList<>();
    private JList<Material> lstAvailableMaterials;
    private DefaultListModel<Tool> toolsModel = new DefaultListModel<>();
    private DefaultListModel<Material> materialsModel = new DefaultListModel<>();
    private JButton btnRequest;
    private JButton btnCancel;
    
    private EquipmentController equipmentController = new EquipmentController();
    
    private EquipmentDAO equipmentDAO = new EquipmentDAO();

    public ToolRequestGUI(String username) {
        setTitle("Request Tool or Material - " + username);
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //temporary list of tools and materials to select from
        
        
        //toolsModel = new DefaultListModel<>();
        //toolsModel.addElement("Hammer");
        //toolsModel.addElement("Screwdriver");
        //toolsModel.addElement("Wrench");
        //toolsModel.addElement("Drill");

        //materialsModel = new DefaultListModel<>();
        //materialsModel.addElement("Wood Plank");
        //materialsModel.addElement("Screws");
        //materialsModel.addElement("Glue");
        //materialsModel.addElement("Tape");

//        List<Equipment> allEquipment = equipmentDAO.getAllEquipment();
        
        lstAvailableTools = new JList<>(toolsModel);
        lstAvailableMaterials = new JList<>(materialsModel);
        btnRequest = new JButton("Request");
        btnCancel = new JButton("Cancel");
        JScrollPane scrollPane1 = new JScrollPane(lstAvailableTools);
        JScrollPane scrollPane2 = new JScrollPane(lstAvailableMaterials);
        add(scrollPane1, BorderLayout.CENTER);
        add(scrollPane2, BorderLayout.CENTER);
        
        
        
        loadEquipmentNames();

       btnRequest.addActionListener(e -> {
    Tool selectedTool = lstAvailableTools.getSelectedValue();
    
    if (selectedTool != null) {
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        
        String returnDate = equipmentDAO.requestTool(selectedTool.getEquipID());

        if (returnDate != null) {
            JOptionPane.showMessageDialog(null, 
                "Request successful!\nReturn by: " + returnDate);
            loadEquipmentNames(); // Reload updated list
        } else {
            JOptionPane.showMessageDialog(null, "Tool is unavailable!");
        }
    }
});




    
        btnCancel.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Available Tools:"));
        panel.add(new JScrollPane(lstAvailableTools));
        panel.add(new JLabel("Available Materials:"));
        panel.add(new JScrollPane(lstAvailableMaterials));
        panel.add(btnRequest);
        panel.add(btnCancel);

        add(panel);
    }
    
    private void loadEquipmentNames() {
    List<Tool> equipmentNames = fetchEquipmentNamesFromDatabase();
    toolsModel.clear(); // Important to clear first!

    for (Tool tool : equipmentNames) {
        toolsModel.addElement(tool); // adding Tool object directly
    }

    lstAvailableTools.setModel(toolsModel);
}

    public List<Tool> fetchEquipmentNamesFromDatabase() {
    List<Tool> tools = new ArrayList<>();

    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT equip_ID, equip_name FROM equipment WHERE quantity > 0")) {

        while (rs.next()) {
            int id = rs.getInt("equip_ID");
            String name = rs.getString("equip_name");

            Tool tool = new Tool(id, name); // Create Tool object
            tools.add(tool);                // Add Tool to list
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tools;
}
    
    
    public void checkoutTool(int equipmentID, int quantity) {
    EquipmentDAO equipmentDAO = new EquipmentDAO();
    
    if (equipmentDAO.setCheckoutRecord(equipmentID, quantity)) {
        System.out.println("Tool checked out successfully!");
    } else {
        System.out.println("Failed to check out tool. Make sure quantity is 0.");
    }
}




    private void handleRequest(Equipment equipment) {}
    
        
        
         
  }




    

