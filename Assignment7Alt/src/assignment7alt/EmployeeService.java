/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7alt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author elee
 */
public final class EmployeeService implements Serializable {

    private volatile static EmployeeService thisEmployeeService;
    private transient EmployeeFileReader thisReader;
    private HashMap<String, Employee> thisMap;

    public static synchronized EmployeeService getInstance() {

        if (thisEmployeeService == null) {
            thisEmployeeService = new EmployeeService();

        }
        return thisEmployeeService;
    }

    private EmployeeService() {
        thisMap = new HashMap<String, Employee>();
        thisReader = null;
    }

    public int getEmployeeCount() {
        return thisMap.size();
    }
    
    public String getReaderName(){
        String readerName;
        if(thisReader == null){
            return "None";
        }
        readerName = thisReader.getClass().getSimpleName();
        return readerName;
    }

    public void loadEmployeesFromFile(String filename) throws UnknownFormatException {
        thisReader = EmployeeFileReaderFactory.makeReader(filename);
        HashMap<String, Employee> tempMap = thisReader.loadEmployees(filename);
        thisMap.putAll(tempMap);
    }
    
    public static void resetInstance(){
        thisEmployeeService = null;
    }
    
    public static void saveToFile(String fileName) {

        try {
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(thisEmployeeService);
            out.close();
            fileOut.close();
        } catch (Exception i) {
            i.printStackTrace();
        }

    }
    
    public static void loadFromFile(String fileName){
        
        thisEmployeeService = null; 
        
        try {
         FileInputStream fileIn = new FileInputStream(fileName);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         thisEmployeeService = (EmployeeService) in.readObject();
         in.close();
         fileIn.close();
        }catch(IOException i) {
         i.printStackTrace();
        }catch(ClassNotFoundException c) {
         System.out.println("EmployeeService class not found");
         c.printStackTrace();
      }
        
        
    }
    
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Employee> entry : thisMap.entrySet()){
            sb.append(entry.getValue().toString());
        }
        
        return String.format("%-35s%-35s%n"
                           + "%-35s%-35s%n"
                           + "%-35s%n%-35s%n",
                            "EmployeeService: ", "(" + getEmployeeCount() +") Employees",
                            "Current Reader: ", getReaderName(),
                            "Current Employees:", sb.toString());
        
        
    }
}
