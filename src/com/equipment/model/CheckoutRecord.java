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
public class CheckoutRecord {
    // fields
    private int id;
    private int employeeID;
    private int equipmentID;
    private LocalDate checkoutDate;
    private LocalDate returnDate;

    // constructors
    public CheckoutRecord(int id, int employeeID, int equipmentID, LocalDate checkoutDate, LocalDate returnDate) {
        this.id = id;
        this.employeeID = employeeID;
        this.equipmentID = equipmentID;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    // Default constructor
    public CheckoutRecord() {
        this.id = 0;
        this.employeeID = 0;
        this.equipmentID = 0;
        this.checkoutDate = LocalDate.now();
        this.returnDate = null;
    }

    // Getters and Setters
}
