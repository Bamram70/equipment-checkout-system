/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.model;

/**
 *
  * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880
 */
public class Employee
{
    private int empID;
    private String username;
    private String role; //"admin" or "employee"
    private String password;
    
    public Employee()
    {
        //no argument constructor
    }
        
    
    //Existing employee Constructor
    public Employee(int empID, String username, String role, String password)
    {
        this.empID = empID;
        this.username = username;
        this.role = role;
        this.password = password;
    }
    
    //New employee Constructor (database adds employeeID)
    public Employee(String username, String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }
    
    /*public boolean isAdmin() 
    {
        return "admin".equalsIgnoreCase(role);
    }
    */

    //Getters and Setters
    public int getEmpID() 
    {
        return empID;
    }
    public void setEmpID(int empID)
    {
        this.empID = empID;
    }
    
    public String getUsername() 
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getRole() 
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}
