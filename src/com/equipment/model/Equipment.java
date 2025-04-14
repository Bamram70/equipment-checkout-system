/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.model;

import java.time.LocalDate;

/**
 *
 * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880
 */
public class Equipment
{
    protected int equipID;
    protected String equipName;
    protected String equipType; //tool or material
    protected int equipQuan;
    protected String equipCond; //New, Worn, Damaged, Broken(not repairable)
    protected boolean checkOutStatus;
    protected int warehouseID;
    protected LocalDate returnDate;
    
    public static final String TOOL_TYPE = "Tool";
    public static final String MATERIAL_TYPE = "Material";
    
    //Default Constructor
    public Equipment()
    {
        
    }
    
    //Constructor for New Equipment
    public Equipment(String equipName, String equipType, int equipQuan, 
            String equipCond, boolean checkOutStatus, int warehouseID, LocalDate returnDate)
    {
        this.equipName = equipName;
        this.equipType = equipType;
        this.equipQuan = equipQuan;
        this.equipCond = equipCond;
        this.checkOutStatus = checkOutStatus;
        this.warehouseID = warehouseID;
        this.returnDate = returnDate;
    }
    
    //Parameterized Constructor
    public Equipment(int equipID, String equipName, String equipType, 
            int equipQuan, String equipCond, boolean checkOutStatus, int warehouseID, LocalDate returnDate) 
    {
        this.equipID = equipID;
        this.equipName = equipName;
        this.equipType = equipType;
        this.equipQuan = equipQuan;
        this.equipCond = equipCond;
        this.checkOutStatus = checkOutStatus;
        this.warehouseID = warehouseID;
        this.returnDate = returnDate;
    }
    
    //Getters and Setters
    public int getEquipID()
    {
        return equipID;
    }
    public void setEquipID(int equipID)
    {
        this.equipID = equipID;
    }
    
    public String getEquipName()
    {
        return equipName;
    }
    public void setEquipName(String equipName)
    {
        this.equipName = equipName;
    }
    
    public String getEquipType()
    {
        return equipType;
    }
    public void setEquipType(String equipType)
    {
        this.equipType = equipType;
    }
    
    public int getEquipQuan()
    {
        return equipQuan;
    }
    public void setEquipQuan(int equipQuan)
    {
        this.equipQuan = equipQuan;
    }
    
    public String getEquipCond()
    {
        return equipCond;
    }
    public void setEquipCond(String equipCond)
    {
        this.equipCond = equipCond;
    }
    
    public boolean getCheckOutStatus()
    {
        return checkOutStatus;
    }
    public void setCheckOutStatus(boolean checkOutStatus)
    {
        this.checkOutStatus = checkOutStatus;
    }
    
    public int getWarehouseID()
    {
        return warehouseID;
    }
    public void setWarehouseID(int warehouseID)
    {
        this.warehouseID = warehouseID;
    }
    
    public LocalDate getReturnDate()
    {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate)
    {
        this.returnDate = returnDate;
    }
            
    
    @Override
    public String toString() 
    {
        return equipName + " (" + equipType + ") - Qty: " + equipQuan;
    }
    
}
