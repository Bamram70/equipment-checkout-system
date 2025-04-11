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
public class Equipment
{
    protected int id;
    protected String name;
    protected String type; //tool or material
    private List<String> equipment;

    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String type()
    {
        return type;
    }
    public String equipment()
    {
        return this.employee;
    }
    
    public Equipment(int id, String name, String type, List<String> equipment) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.equipment = equipment;
    }
    
    //Getters and Setters
}
