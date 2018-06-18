/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7alt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elee
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            System.out.println("Initial Employee Count: "
                    + EmployeeService.getInstance().getEmployeeCount() + "\n");
            EmployeeService.getInstance().loadEmployeesFromFile("EmployeeData.xml");
            System.out.println("Employee Count after loading XML file: "
                    + EmployeeService.getInstance().getEmployeeCount() + "\n");
            EmployeeService.getInstance().loadEmployeesFromFile("EmployeeData.csv");
            System.out.println("Employee Count after loading CSV file: "
                    + EmployeeService.getInstance().getEmployeeCount() + "\n");

            System.out.println("Employee List:\n" + EmployeeService.getInstance());
            EmployeeService.saveToFile("EmployeeService.ser");
            System.out.println("Employee Count after serializing: "
                    + EmployeeService.getInstance().getEmployeeCount() + "\n");
            EmployeeService.resetInstance();
            System.out.println("Employee Count after reset: "
                    + EmployeeService.getInstance().getEmployeeCount() + "\n");
            EmployeeService.loadFromFile("EmployeeService.ser");
            System.out.println("Employee Count after loading serialized file: "
                    + EmployeeService.getInstance().getEmployeeCount() + "\n");

            System.out.println("Employee List:\n" + EmployeeService.getInstance());
        } catch (UnknownFormatException ex) {
            ex.printStackTrace();
        } 

    }

}
