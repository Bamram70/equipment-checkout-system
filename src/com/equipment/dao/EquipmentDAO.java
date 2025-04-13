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
import com.equipment.model.Material;
import com.equipment.model.Tool;
import java.time.LocalDate;
import java.sql.Date;

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
        List<Equipment> equipList = new ArrayList<>();
        String query = "SELECT * FROM equipment";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                int equipID = rs.getInt("equip_ID");
                String equipName = rs.getString("equip_name");
                String equipType = rs.getString("type");
                int equipQuan = rs.getInt("quantity");
                String equipCond = rs.getString("condition");
                boolean checkOutStatus = rs.getBoolean("is_checked_out");
                int warehouseID = rs.getInt("warehouse_id");
                Date returnDateSql = rs.getDate("return_date");
                LocalDate returnDate = returnDateSql != null ? returnDateSql.toLocalDate() : null;
                
                Equipment item;
                
                if(equipType.equalsIgnoreCase("tool"))
                {
                    item = new Tool(equipID, equipName, equipType, equipQuan,
                        equipCond, checkOutStatus, warehouseID, returnDate);
                }
                else
                {
                    item = new Material(equipID, equipName, equipQuan,
                        equipCond, checkOutStatus, warehouseID);
                }
                
                equipList.add(item);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return equipList;
    }
    
    
    public boolean addEquipment(Equipment equipment)
    {
        String query = "INSERT INTO equipment (equip_name, type, quantity, `condition`, is_checked_out, warehouse_id, return_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, equipment.getEquipName());
            pstmt.setString(2, equipment.getEquipType());
            pstmt.setInt(3, equipment.getEquipQuan());
            pstmt.setString(4, equipment.getEquipCond());
            pstmt.setBoolean(5, equipment.getCheckOutStatus());
            pstmt.setInt(6, equipment.getWarehouseID());
            if (equipment.getReturnDate() != null) 
            {
                pstmt.setDate(7, java.sql.Date.valueOf(equipment.getReturnDate()));
            } 
            else 
            {
                pstmt.setNull(7, java.sql.Types.DATE);
            }
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
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
