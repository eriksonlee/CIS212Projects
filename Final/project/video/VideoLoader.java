/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.video;

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
import project.video.Video.Rating;

/**
 *
 * @author elee
 */
public class VideoLoader {
    
    
    
    public static HashMap<String, Video> loadVideoXml(String fileName){
        
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
        // Create a temporary collection to store your objects (i.e., a HashMap<String, Video>)
        HashMap<String, Video> videoMap = new HashMap<>();
        // Parse the individual records from the XML file
        for (int i = 0; i < entries.getLength(); i++) {
            if (entries.item(i).getNodeType() == Node.TEXT_NODE) {
                continue;
            }
            String entryName = entries.item(i).getNodeName();
            if (!entryName.equals("Video")) {
                System.err.println("Unexpected node found: " + entryName);
                continue;
            }

            // Get a named nodes
            Element elem = (Element) entries.item(i);
            String name = elem.getElementsByTagName("Name").item(0).getTextContent();
            Integer duration = Integer.parseInt(elem.getElementsByTagName("Duration").item(0).getTextContent());
            String rating = elem.getElementsByTagName("Rating").item(0).getTextContent();
            String nameFile = elem.getElementsByTagName("FileName").item(0).getTextContent();
            // Create the domain objects and add to temporary collection
            
            Video vid;
            try {
                vid = VideoFactory.makeVideo(name, duration, Rating.valueOf(rating), nameFile);
                videoMap.put(name, vid);
            } catch (Exception ex) {
                ex.toString();
            }
            
        }
        // Return the temporary collection:
        return videoMap;
    }
}
