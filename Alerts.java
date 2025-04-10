/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classes_getters_and_setters;

/**
 *
 * @author quint
 */
public class Alerts {
    
    private int alertID;
    private String alertType;
    private String dateGenerated;
    
    public int getAlertID()
    {
        return alertID;
    }
    public String getAlertType()
    {
        return alertType;
    }
    public String getDateGenerated()
    {
        return dateGenerated;
    }
    public Alerts(int alertID, String alertType, String dateGenerated)
    {
        this.alertID = alertID;
        this.alertType = alertType;
        this.dateGenerated = dateGenerated;
    }
}
