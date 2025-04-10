/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class Warehouse {
    
    private int warehouseID;
    private String location;
    
    public int getWarehouseID()
    {
        return warehouseID;
    }
    public String getLocation()
    {
        return location;
    }
    public Warehouse(int warehouseID, String location)
    {
        this.warehouseID = warehouseID;
        this.location = location;
        
    }
}
