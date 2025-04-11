/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class Administrator {
    
    private String employeeList;
    private String equipmentReport;
    
    public String getEmployeeList()
    {
        return employeeList;
    }
    public String getEquipmentReport()
    {
        return equipmentReport;
    }
    public Administrator(String employeeList, String equipmentReport)
    {
        this.employeeList = employeeList;
        this.equipmentReport = equipmentReport;
        //void setEmployeeStats
    }
}
