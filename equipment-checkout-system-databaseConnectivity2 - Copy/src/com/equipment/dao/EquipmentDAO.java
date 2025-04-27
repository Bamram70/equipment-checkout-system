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
import static com.mysql.cj.telemetry.TelemetryAttribute.DB_USER;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
                // Debug: Print the equipment being retrieved
                System.out.println("Fetched from DB: " + equipName);
                
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
    String query = "DELETE FROM equipment WHERE equip_ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, equipmentID);
            int rowsAffected = pstmt.executeUpdate();
        
            return rowsAffected > 0; // Returns true if something was deleted
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateEquipment(int equipID, String name, String type, int quantity,
                               String condition, boolean isCheckedOut, int warehouseID, LocalDate returnDate) 
    {
    String query = "UPDATE equipment SET equip_name=?, type=?, quantity=?, `condition`=?, is_checked_out=?, warehouse_ID=?, return_date=? WHERE equip_ID=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, type);
            pstmt.setInt(3, quantity);
            pstmt.setString(4, condition);
            pstmt.setBoolean(5, isCheckedOut);
            pstmt.setInt(6, warehouseID);
            if (returnDate != null) {
                pstmt.setDate(7, java.sql.Date.valueOf(returnDate));
            } else {
                pstmt.setNull(7, java.sql.Types.DATE);
            }
            pstmt.setInt(8, equipID);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean decrementEquipmentQuantity(int equipmentID) {
    String query = "UPDATE equipment SET quantity = quantity - 1 WHERE equip_ID = ? AND quantity > 0";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, equipmentID);
        int rowsAffected = pstmt.executeUpdate();

        return rowsAffected > 0; // Returns true if a row was actually updated

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean setCheckoutRecord(int equipmentID, int quantity) {
    String query = "UPDATE equipment SET is_checked_out = is_checked_out = 1 WHERE equip_ID = ? AND quantity = 0";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, equipmentID);
        pstmt.setInt(2, quantity);
        int rowsAffected = pstmt.executeUpdate();

        return rowsAffected > 0; // Returns true if a row was actually updated

    } catch (SQLException e) {
    e.printStackTrace(); // <-- semicolon, not period
    return false;
}

    }
    
    


public String requestTool(int equipmentID) {
    String selectQuery = "SELECT quantity FROM equipment WHERE equip_ID = ?";
    String updateQuantityQuery = "UPDATE equipment SET quantity = quantity - 1 WHERE equip_ID = ?";
    String updateReturnDateQuery = "UPDATE equipment SET return_date = ? WHERE equip_ID = ?";
    String setCheckedOutQuery = "UPDATE equipment SET is_checked_out = 1 WHERE equip_ID = ?";
    String unsetCheckedOutQuery = "UPDATE equipment SET is_checked_out = 0 WHERE equip_ID = ?";

    try (Connection conn = DatabaseConnection.getConnection()) {
        PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
        selectStmt.setInt(1, equipmentID);
        ResultSet rs = selectStmt.executeQuery();

        if (rs.next()) {
            int quantity = rs.getInt("quantity");

            if (quantity > 0) {
                // Step 1: Decrease quantity
                PreparedStatement updateStmt = conn.prepareStatement(updateQuantityQuery);
                updateStmt.setInt(1, equipmentID);
                updateStmt.executeUpdate();

                // Step 2: Generate a random return date 3–7 days from today
                Random rand = new Random();
                int randomDays = rand.nextInt(5) + 3; // Random number between 3 and 7
                LocalDate returnDate = LocalDate.now().plusDays(randomDays);

                // Step 3: Update the return_date in the database
                PreparedStatement updateReturnDateStmt = conn.prepareStatement(updateReturnDateQuery);
                updateReturnDateStmt.setDate(1, java.sql.Date.valueOf(returnDate));
                updateReturnDateStmt.setInt(2, equipmentID);
                updateReturnDateStmt.executeUpdate();

                // Step 4: Handle is_checked_out status
                PreparedStatement checkNewQuantityStmt = conn.prepareStatement(selectQuery);
                checkNewQuantityStmt.setInt(1, equipmentID);
                ResultSet newRs = checkNewQuantityStmt.executeQuery();

                if (newRs.next()) {
                    int newQuantity = newRs.getInt("quantity");

                    if (newQuantity == 0) {
                        PreparedStatement checkoutStmt = conn.prepareStatement(setCheckedOutQuery);
                        checkoutStmt.setInt(1, equipmentID);
                        checkoutStmt.executeUpdate();
                    } else {
                        PreparedStatement unCheckoutStmt = conn.prepareStatement(unsetCheckedOutQuery);
                        unCheckoutStmt.setInt(1, equipmentID);
                        unCheckoutStmt.executeUpdate();
                    }
                }
                
                // Step 5: Return the return date as a string
                return returnDate.toString();
            } else {
                return null; // Tool unavailable
            }
        } else {
            return null; // No such equipment
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}



}
