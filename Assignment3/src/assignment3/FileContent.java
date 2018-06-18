/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author elee
 */
public class FileContent {
    
    private String fileName;
    private int lineCounter;
    private int wordCounter;
    private int charCounter;
    private ArrayList<String> content = new ArrayList<>();
    private HashMap<Character, Integer> charCounts = new HashMap<>();
    private HashMap<String, Integer> wordCounts = new HashMap<>();
    private final int numOutputColumns = 5;
    
    
    
    public FileContent(String fileName, ArrayList<String> linesFromFile){
        
        setFileName(fileName);
        setLineCounter(0);
        setWordCounter(0);
        setCharCounter(0);
        for (String line: linesFromFile){
            
            //Add line from file to content 
            content.add(line);
            //Count Lines
            setLineCounter(getLineCounter()+1);
            //Count Characters
            for (int i = 0; i < line.length(); i++) {

                Character character = line.charAt(i);

                if (!charCounts.containsKey(character)) {
                    charCounts.put(character, 1);
                } else {
                    int value = charCounts.get(character) + 1;
                    charCounts.put(character, value);
                }
                setCharCounter(getCharCounter()+1);
            }
            //Count Words
            line = line.toLowerCase();
            line = line.replaceAll("[()';\",!.?]", "");
            String[] words = line.split("[- ]");

            for (String word : words) {

                if (!wordCounts.containsKey(word)) {
                    wordCounts.put(word, 1);
                } else {
                    int value = wordCounts.get(word) + 1;
                    wordCounts.put(word, value);
                }
                setWordCounter(getWordCounter()+1);
            }
            
        }

        
        
        
    }
    
    public ArrayList<String> getContent(){
        return content;
    }

    private void setFileName(String inputFileName) {
        fileName = inputFileName;
    }
    
    public String getFileName(){
        return fileName;
    }

    private void setLineCounter(int inputLineCounter) {
        lineCounter = inputLineCounter;
    }

    public int getLineCounter(){
        return lineCounter;
    }
    
    private void setWordCounter(int inputWordCounter) {
        wordCounter = inputWordCounter;
    }
    
    public int getWordCounter(){
        return wordCounter;
    }

    private void setCharCounter(int inputCharCounter) {
        charCounter = inputCharCounter;
    }
    
    public int getCharCounter(){
        return charCounter;
    }
    
    public String generateReport(){
        
        StringBuilder sb = new StringBuilder();
        //Report Begins
        sb.append("File Name: " + getFileName() + "\n");
        sb.append("Line Count: " + getLineCounter() + "\n");                 
        sb.append("Word Count: " + getWordCounter() + "\n");                 
        sb.append("Char Count: " + getCharCounter() + "\n");
        sb.append("\n");
        
        //Character report
        sb.append("Character Report: ");
        sb.append("\n\n");
        
        ArrayList<Character> sortedChars = new ArrayList<>(charCounts.keySet());
        Collections.sort(sortedChars);

        int charNum = 0;
        int lowCharNum = 0;
        
        Character highChar = (char) 0;
        Character lowChar = (char) 0;
        
        int count = 0;
        
        for (Character chr : sortedChars) {
            sb.append(String.format("'%s': %-5d", chr, charCounts.get(chr)));

            if (charCounts.get(chr) > charNum) {
                charNum = charCounts.get(chr);
                highChar = chr;
            }

            count++;
            if (count >= numOutputColumns) {
                sb.append("\n");
                count = 0;
            }
        }
        
        lowCharNum = Collections.min(charCounts.values());
        for (Character Low : charCounts.keySet()){
            if (charCounts.get(Low).equals(lowCharNum)){
                lowChar = Low;
            }
        }
        sb.append("\n\nHigh Char: '" + highChar + "' (" + charNum + ")");
        sb.append("\nLow Char: '" + lowChar + "' (" + lowCharNum + ")");
        
        sb.append("\n");
                       
        // Word Report
        sb.append("\nWord Report: ");
        sb.append("\n");
        
        ArrayList<String> sortedWords = new ArrayList<>(wordCounts.keySet());
        Collections.sort(sortedWords);

        int wordNum = 0;
        int lowWordNum = 0;
        String highWord = "";
        String lowWord = "";

        count = 0;
        for (String word : sortedWords) {
            sb.append(String.format("%-15s: %-8d", word, wordCounts.get(word)));

            if (wordCounts.get(word) > wordNum) {
                wordNum = wordCounts.get(word);
                highWord = word;
            }

            count++;
            if (count >= numOutputColumns) {
                sb.append("\n");
                count = 0;
            }
        }
        
        sb.append("\nHigh Word: " + highWord + " (" + wordNum + ")");

        return sb.toString();
    }

  
    
    
}
