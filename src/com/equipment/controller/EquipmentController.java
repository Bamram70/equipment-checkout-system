/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.controller;

import com.equipment.dao.EquipmentDAO;
import com.equipment.model.Equipment;
import java.util.List;
/**
 *
 * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880t
 */
public class EquipmentController
{
    private EquipmentDAO equipmentDAO = new EquipmentDAO();
    
    public List<Equipment> getAllEquipment()
    {
        return equipmentDAO.getAllEquipment();
    }
    
    public boolean addEquipment(Equipment equipment)
    {
        return equipmentDAO.addEquipment(equipment);
    }
    
    public boolean removeEquipment(int equipmentID)
    {
        return equipmentDAO.removeEquipment(equipmentID);
    }
}
