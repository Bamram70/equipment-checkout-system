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
    private int quantity;
    
    public Material(int id, String name, int quantity){
        super(id, name, "Material");
        this.quantity = quantity;
    }
    
    //Getters and Setters
}
    
