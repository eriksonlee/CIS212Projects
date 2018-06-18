/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author elee
 */
public class FileWriter {

    public static void writeFile(String newFileName, FileContent fc, int lineWidth) throws Exception {

        File file = new File(newFileName);
        
        //Copy file contents
        ArrayList<String> lines = fc.getContent();
        //New array for newly formatted strings
        ArrayList<String> newLines = new ArrayList<>();
        // Store the current line
        String currentLine = ""; 
        //Loop through content lines, reformat size.
        for (String s : lines) {

            if (s.isEmpty()) {
                newLines.add(currentLine);
                newLines.add("");
                currentLine = "";
                continue;
            }

            currentLine += s;
            while (currentLine.length() > lineWidth) {
                int end = lineWidth;
                char c = currentLine.charAt(end);

                while (Character.isAlphabetic(c)) {
                    end--;
                    c = currentLine.charAt(end);
                }
                newLines.add(currentLine.substring(0, end + 1));
                currentLine = currentLine.substring(end + 1);

            }
        }
        newLines.add(currentLine);

        
        //Write newly formatted lines to file
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file), "ISO-8859-1"));

            for (int i = 0; i < newLines.size(); i++) {
                bufferedWriter.write(newLines.get(i));
                if (i < newLines.size()-1)
                    bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

}
}
