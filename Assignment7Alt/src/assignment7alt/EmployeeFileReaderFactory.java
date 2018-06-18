/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7alt;

/**
 *
 * @author elee
 */
public class EmployeeFileReaderFactory {
    
    public static EmployeeFileReader makeReader(String filename) throws UnknownFormatException {
        
        if (filename.endsWith(".xml")){
        
            EmployeeFileReaderXMLImpl XMLReader = new EmployeeFileReaderXMLImpl();
            return XMLReader;
            
        }
        if (filename.endsWith(".csv")){
            
            EmployeeFileReaderCSVImpl CSVReader = new EmployeeFileReaderCSVImpl();
            return CSVReader;
            
        }
        else {
            throw new UnknownFormatException("Unknown file format. XML or CSV only.");
        }
        
    }
    
}
