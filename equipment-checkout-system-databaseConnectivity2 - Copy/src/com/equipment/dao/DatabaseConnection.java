/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880
 */
public class DatabaseConnection
{
    private static final String url = "jdbc:mysql://127.0.0.1:3306/ECS";
    private static final String user = "root";
    private static final String password = "viewtifulQuint_2025";
    
    public static Connection getConnection() throws SQLException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            throw new SQLException("MySQL JBDC Driver not found!", e);
        }
        
        return DriverManager.getConnection(url, user, password);
    }
}
