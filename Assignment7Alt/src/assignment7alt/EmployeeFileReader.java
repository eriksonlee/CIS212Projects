/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7alt;

import java.util.HashMap;

/**
 *
 * @author elee
 */
public interface EmployeeFileReader {
    
    HashMap<String, Employee> loadEmployees(String fileName);
    
}
