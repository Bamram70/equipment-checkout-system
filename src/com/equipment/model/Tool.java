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
public class Tool extends Equipment
{
    public Tool(String equipName, int equipQuan, String equipCond, LocalDate returnDate)
    {
        super(equipName, Equipment.TOOL_TYPE, equipQuan, 
                equipCond, false, 0); //Default checkout and warehouseID
        this.returnDate = returnDate;
    }
    
    //Getters and Setters
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
        return super.toString() + " | Return Date:" + returnDate;
    }
}
