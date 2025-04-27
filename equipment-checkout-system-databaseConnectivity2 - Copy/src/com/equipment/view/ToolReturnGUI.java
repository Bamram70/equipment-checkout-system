package com.equipment.view;

import javax.swing.*;

public class ToolReturnGUI extends JFrame {

    private JList<String> lstRentedItems;
    private JTextField txtCondition;
    private JButton btnReturn, btnCancel;

    public ToolReturnGUI(DefaultListModel<String> rentedItemsModel) {
        setTitle("Return Item");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lstRentedItems = new JList<>(rentedItemsModel);
        JScrollPane scrollPane = new JScrollPane(lstRentedItems);

        txtCondition = new JTextField();
        btnReturn = new JButton("Return");
        btnCancel = new JButton("Cancel");

        btnReturn.addActionListener(e -> {
            String selected = lstRentedItems.getSelectedValue();
            String condition = txtCondition.getText().trim();

            if (selected == null) {
                JOptionPane.showMessageDialog(this, "Please select an item to return.");
                return;
            }

            if (condition.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the item's condition.");
                return;
            }

            rentedItemsModel.removeElement(selected);
            JOptionPane.showMessageDialog(this, "Returned: " + selected + "\nCondition: " + condition);
            dispose();
        });

        btnCancel.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Select item to return:"));
        panel.add(scrollPane);
        panel.add(new JLabel("Condition:"));
        panel.add(txtCondition);
        panel.add(btnReturn);
        panel.add(btnCancel);

        add(panel);
    }
}
