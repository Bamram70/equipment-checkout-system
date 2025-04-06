/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.controller;

import com.equipment.dao.CheckoutDAO;
import com.equipment.model.CheckoutRecord;
import java.time.LocalDate;
import java.util.List;
/**
 *
  * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880
 */
public class CheckoutController
{
    private CheckoutDAO checkoutDAO = new CheckoutDAO();
    
    public boolean checkoutEquipment(int employeeID, int equipmentID) 
    {
        CheckoutRecord record = new CheckoutRecord(0, employeeID, equipmentID, LocalDate.now(), null);
        return checkoutDAO.addCheckoutRecord(record);
    }
    
    public boolean returnEquipment(int recordID) 
    {
        return checkoutDAO.updateReturnDate(recordID, LocalDate.now());
    }
}
