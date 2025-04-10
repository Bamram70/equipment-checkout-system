/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class Tool extends Equipment{
    
    private String condition;
    
    public String getCondition()
    {
        return condition;
    }
    public Tool(int equipmentID, String equipmentName, String equipmentType, String condition)
    {
        super(equipmentID, equipmentName, "Material");
        this.condition=condition;
    }
}
