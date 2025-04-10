/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class SystemUser {

    private int empID;
    private String name;
    private String role;
    private String password;
    
    public int getID()
    {
        return empID;
    }
    public String getName()
    {
        return name;
    }
    public String getRole()
    {
        return role;
    }
    
    public String getPassword()
    {
        return password;
    }
    public SystemUser(int empID, String name, String role)
    {
        this.empID = empID;
        this.name = name;
        this.role = role;    
        //setCredentials
    }
    
    public void login()
    {
        
    }
    public boolean isAdmin(){
    
        return "admin".equalsIgnoreCase(role);
    }
    
    public static void main(String[] args) {
        System.out.println("Team E...");
    }
    
            
}
