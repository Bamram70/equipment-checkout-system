/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class Equipment {
    private int equipmentID;
    private String equipmentName;
    private String equipmentType;
    private String assignedTo;
    private String equipment[];
    
    public int getEquipmentID()
    {
        return equipmentID;
    }
        
    public String getEquipmentName()
    {
        return equipmentName;
    }
    public String getEquipmentType()
    {
        return equipmentType;
    }
    public Equipment(int equipmentID, String equipmentName, String equipmentType)
    {
        this.equipmentID=equipmentID;
        this.equipmentName = equipmentName;
        this.equipmentType=equipmentType;
        
    }
}
