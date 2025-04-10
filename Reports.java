/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class Reports {
    
    private int reportID;
    private int empID;
    private int equipmentID;
    private int warehouseID;
    private String checkoutDate;
    private String returnDate;
    private String status;
    
    
    public int getReportID()
    {
        return reportID;  
    }
    public int getEMPID()
    {
        return empID;
    }
    public int getEquipmentID()
    {
        return equipmentID;
    }
    public int getWarehouseID()
    {
        return warehouseID;
    }
    public String getCheckoutDate()
    {
        return checkoutDate;
    }
    public String getReturnDate()
    {
        return returnDate;
    }
    public String getStatus()
    {
        return status;
    }
    public void setReportStats(int reportID, int empID, int equipmentID, int warehouseID, String checkoutDate, String returnDate, 
            String status)
    {
        this.reportID=reportID;
        this.empID=empID;
        this.equipmentID=equipmentID;
        this.warehouseID=warehouseID;
        this.checkoutDate=checkoutDate;
        this.returnDate=returnDate;
    }
}
