/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.dao;

import com.equipment.model.Employee;
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
public class EmployeeDAO
{
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
    
    // Method to get user role (employee or admin)
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
    
    //Method to add a new employee/user
    public boolean addEmployee(Employee employee)
    {
        String query = "INSERT INTO systemuser (user_name, user_pswrd, user_role) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setString(1, employee.getUsername());
            pstmt.setString(2, employee.getRole());
            pstmt.setString(3, employee.getPassword());
            
            //debugger for adding employees
            /*System.out.println("DEBUG: Adding user to DB: "
            + "Username='" + employee.getUsername() + "', "
            + "Password='" + employee.getPassword() + "', "
            + "Role='" + employee.getRole() + "'");*/
            
            int rowsAffected = pstmt.executeUpdate();
            
            return rowsAffected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean removeEmployee(String empUsername)
    {
        String query = "DELETE FROM systemuser WHERE user_name = ?";
        
       try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query))
       {
           pstmt.setString(1, empUsername);
           int rowsAffected = pstmt.executeUpdate();
           
           if(rowsAffected > 0)
           {
               return true; //Employee successfully removed
           }
           else
           {
               return false; // No employee found under this username
           }
       }
       catch (SQLException e)
       {
           e.printStackTrace();
           return false;
       }
    }
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM systemuser";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Employee employee = new Employee();
                employee.setEmpID(rs.getInt("user_ID"));
                employee.setUsername(rs.getString("user_name"));
                employee.setPassword(rs.getString("user_pswrd"));
                employee.setRole(rs.getString("user_role"));
                employees.add(employee);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return employees;
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
