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
public class Tool extends Equipment
{
    private String condition;
    
    public Tool(int id, String name, String condition){
        super(id, name, "Tool");
        this.condition = condition;
    }
    public boolean isRepairable()
    {
        return condition;
    }
    public String updateCondition()
    {
        System.out.println("The tool's condition is"+" "+condition+".");
    }
    //Getters and Setters
}
