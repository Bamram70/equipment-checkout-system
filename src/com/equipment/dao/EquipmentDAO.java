/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.dao;

import com.equipment.model.Equipment;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880
 */
public class EquipmentDAO
{
    public List<Equipment> getAllEquipment()
    {
        //Database Logic goes here
        return null;
    }
    
    public boolean addEquipment(Equipment equipment)
    {
        String query = "INSERT INTO equipment (equip_name, type, quantity, condition, checkout_status, warehouseID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, equipment.getEquipName());
            pstmt.setString(2, equipment.getEquipType());
            pstmt.setInt(3, equipment.getEquipQuan());
            pstmt.setString(4, equipment.getEquipCond());
            pstmt.setBoolean(5, equipment.getCheckOutStatus());
            pstmt.setInt(6, equipment.getWarehouseID());
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean removeEquipment(int equipmentID)
    {
        return false;
    }
}
