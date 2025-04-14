/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipment.controller;

import com.equipment.dao.EmployeeDAO;
import com.equipment.model.Employee;
import java.util.List;
/**
 *
  * @author Brendan McGalliard
 *         b.mcgalliard.dev@outlook.com
 *         +1(517)575-5880
 */
public class EmployeeController
{

    private EmployeeDAO employeeDAO;
    
    public EmployeeController()
    {
        employeeDAO = new EmployeeDAO();
    }
    
    public boolean addEmployee(Employee employee) 
    {
        return employeeDAO.addEmployee(employee);
    }
    
    public boolean login(String username, String password)
    {
        return employeeDAO.login(username, password);
    }
    
    public List<Employee> listAllEmployees()
    {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        return employeeDAO.getAllEmployees();
    }
    public boolean removeEmployee(String empUsername)
    {
        return employeeDAO.removeEmployee(empUsername);
    }
    
    /*public boolean isAdmin(int employeeID)

    {
        Employee employee = employeeDAO.getEmployeeByID(employeeID);
        return employee != null && employee.isAdmin();
    }
    
    public boolean addEmployee(Employee currentUser, Employee newEmployee)
    {
        if(!currentUser.isAdmin()) return false;
        return employeeDAO.addEmployee(newEmployee);
    }
    
    public boolean removeEmployee(Employee currentUser, int employeeID)
    {
        if (!currentUser.isAdmin()) return false;
        return employeeDAO.removeEmployee(employeeID);
    }

    */

}
