package assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class FileReader {
    
    public static FileContent loadFile(String fName) throws Exception {
        ArrayList<String> linesFromFile = new ArrayList<>();
        
        BufferedReader bufferedReader;
        try {
            File file = new File(fName);
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                linesFromFile.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
        FileContent content = new FileContent(fName, linesFromFile);
        return content;
    }
    
}
