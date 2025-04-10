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
    private int id;
    private String name;
    private String role; //"admin" or "employee"

    public int getID()
    {
         return id;
    }
    public String getName()
    {
         return name;
    }
    public int getRole()
    {
         return role;
    }
 
    public Employee(int id, String name, String role)
    {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    
    public boolean isAdmin() 
    {
        return "admin".equalsIgnoreCase(role);
    }
    
    //Getters and Setters
}
