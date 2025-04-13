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
public class Material extends Equipment
{
    public Material(String equipName, int equipQuan, String equipCond)
    {
        super(equipName, Equipment.MATERIAL_TYPE, 
                equipQuan, equipCond, false, 0); //Default checkout and warehouseID
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " | Consumable";
    }
}
