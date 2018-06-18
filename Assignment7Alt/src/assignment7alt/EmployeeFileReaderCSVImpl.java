/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7alt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author elee
 */
public class EmployeeFileReaderCSVImpl implements EmployeeFileReader {
    
    public HashMap<String, Employee> loadEmployees(String fileName) {
        // Create a temporary collection to store your objects (i.e., a HashMap<String, Employee>)
        HashMap<String, Employee> loadedEmps = new HashMap<>();
        try {
            // Open the CSV file with a Scanner object:
            Scanner scanner = new Scanner(new File(fileName));
            // Parse the individual records from the CSV file
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                if (values.length != 4) {
                    System.err.println("Improperly formatted line: " + line);
                    continue;
                }
                String id = values[0];
                String firstName = values[1];
                String lastName = values[2];
                double hourlyRate = Double.parseDouble(values[3]);

                // Create the domain objects and add to temporary collection
                Employee emp;
                try {
                    emp = new Employee(id, firstName, lastName, hourlyRate);
                    loadedEmps.put(id, emp);
                } catch (Exception ex) {
                    ex.toString();
                }
                
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        // Return the temporary collection:
        return loadedEmps;
    }
    
}
