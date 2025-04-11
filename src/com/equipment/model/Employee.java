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
    public String getRole()
    {
         return role;
    }
 
    public Employee(int id, String name, String role)
    {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public boolean login()
    {
         return "employee".equalsIgnoreCase(role);          
        //if credentials are valid, move on to next GUI
    }
    public void logout()
    {
         System.exit(0);
         //user selects the log out button
         //is allowed 3 attempts; if credentials are invalid, GUI system closes   
    }
    public boolean isAdmin() 
    {
        return "admin".equalsIgnoreCase(role);
    }
    public void approveRequest()
    {
        if (equipment.contains(id)){
          System.out.println("Tool successfully ordered.");
        }
        else{
           System.out.println("Tool not available.");
        }
    }
    //Getters and Setters
}
