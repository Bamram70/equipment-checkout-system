/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.controller;

import com.equipment.dao.EquipmentDAO;
import com.equipment.model.Equipment;
import java.util.List;
import java.time.LocalDate;

/**
 *
 * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880t
 */
public class EquipmentController
{
    private EquipmentDAO equipmentDAO;
    
    public EquipmentController()
    {
        equipmentDAO = new EquipmentDAO();
    }
    
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
    
    public boolean updateEquipment(int equipID, String name, String type, int quantity,
                               String condition, boolean isCheckedOut, int warehouseID, LocalDate returnDate) {
    return equipmentDAO.updateEquipment(equipID, name, type, quantity, condition, isCheckedOut, warehouseID, returnDate);
}

}
