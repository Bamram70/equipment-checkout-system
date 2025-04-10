/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.dao;

import com.equipment.model.Employee;
import java.util.List;
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
public class EmployeeDAO
{
    //Method to add a new employee/user
    public boolean createUser(String username, String password, String role)
    {
        String query = "INSERT INTO systemuser (user_name, user_pswrd, user_role) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            int rowsAffected = pstmt.executeUpdate();
            
            return rowsAffected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    //Method to check if the username and password match for login
    public boolean login(String username, String password)
    {
        String query = "SELECT * FROM systemuser WHERE user_name = ? AND user_pswrd = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            
            return resultSet.next();//if we get a result, login is successful
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    // Method to get user role (Employee or Administrator)
    public String getUserRole(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT user_role FROM SystemUser WHERE user_name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return rs.getString("user_role");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no role is found
    }
    
    /*public Employee getEmployeeByID(int id)
    {
        return null;
    }
    
    public boolean addEmployee(Employee employee) 
    {
        return false;
    }
    
    public boolean removeEmployee(int employeeID)
    {
        return false;
    }
    
    public List<Employee> getAllEmployees()
    {
        return null;
    }
    */
}
