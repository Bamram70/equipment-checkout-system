/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class Material extends Equipment{
    
    private int materialQuantity;
    
    public int getMaterialQuantity()
    {
        return materialQuantity;
    }
    
    public Material(int equipmentID, String equipmentName, String equipmentType, int materialQuantity)
    {
        super(equipmentID, equipmentName, "Material");
        this.materialQuantity=materialQuantity;
    }
}
