/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7alt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author elee
 */
public class EmployeeFileReaderXMLImpl implements EmployeeFileReader {

    public HashMap<String, Employee> loadEmployees(String fileName) {

        // Load and parse the XML file:
        NodeList entries;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File xml = new File(fileName); // Here, fileName is a String file name
            if (!xml.exists()) {
                System.err.println("**** XML File '" + fileName + "' cannot be found");
                System.exit(-1);
            }
            Document doc = db.parse(xml);
            doc.getDocumentElement().normalize();
            entries = doc.getDocumentElement().getChildNodes();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
        // Create a temporary collection to store your objects (i.e., a HashMap<String, Employee>)
        HashMap<String, Employee> loadedEmps = new HashMap<>();
        // Parse the individual records from the XML file
        for (int i = 0; i < entries.getLength(); i++) {
            if (entries.item(i).getNodeType() == Node.TEXT_NODE) {
                continue;
            }
            String entryName = entries.item(i).getNodeName();
            if (!entryName.equals("Employee")) {
                System.err.println("Unexpected node found: " + entryName);
                continue;
            }

            // Get a named nodes
            Element elem = (Element) entries.item(i);
            String id = elem.getElementsByTagName("Id").item(0).getTextContent();
            String firstName = elem.getElementsByTagName("FirstName").item(0).getTextContent();
            String lastName = elem.getElementsByTagName("LastName").item(0).getTextContent();
            double hourlyRate = Double.parseDouble(
                    elem.getElementsByTagName("HourlyRate").item(0).getTextContent());
            // Create the domain objects and add to temporary collection
            Employee emp;
            try {
                emp = new Employee(id, firstName, lastName, hourlyRate);
                loadedEmps.put(id, emp);
            } catch (Exception ex) {
                ex.toString();
            }

        }
        // Return the temporary collection:
        return loadedEmps;

    }

}
