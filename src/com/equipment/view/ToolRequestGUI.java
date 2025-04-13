package com.equipment.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author(s)
 * Jayden Lyons - jlyons30@my.devry.edu
 */
public class ToolRequestGUI extends JFrame {

    private JList<String> lstAvailableTools;
    private JList<String> lstAvailableMaterials;
    private DefaultListModel<String> toolsModel;
    private DefaultListModel<String> materialsModel;
    private JButton btnRequest;
    private JButton btnCancel;

    public ToolRequestGUI(String username) {
        setTitle("Request Tool or Material - " + username);
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //temporary list of tools and materials to select from
        toolsModel = new DefaultListModel<>();
        toolsModel.addElement("Hammer");
        toolsModel.addElement("Screwdriver");
        toolsModel.addElement("Wrench");
        toolsModel.addElement("Drill");

        materialsModel = new DefaultListModel<>();
        materialsModel.addElement("Wood Plank");
        materialsModel.addElement("Screws");
        materialsModel.addElement("Glue");
        materialsModel.addElement("Tape");

        lstAvailableTools = new JList<>(toolsModel);
        lstAvailableMaterials = new JList<>(materialsModel);
        btnRequest = new JButton("Request");
        btnCancel = new JButton("Cancel");

        btnRequest.addActionListener(e -> {
            String selectedTool = lstAvailableTools.getSelectedValue();
            String selectedMaterial = lstAvailableMaterials.getSelectedValue();

            if (selectedTool != null && selectedMaterial != null) {
                JOptionPane.showMessageDialog(this, "Please select only one item.");
                return;
            }

            if (selectedTool != null) {
                JOptionPane.showMessageDialog(this, "Tool requested: " + selectedTool);
                dispose();
            } else if (selectedMaterial != null) {
                JOptionPane.showMessageDialog(this, "Material requested: " + selectedMaterial);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item to request.");
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
}
