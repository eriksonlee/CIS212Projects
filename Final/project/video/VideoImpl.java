/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.video;

import java.text.SimpleDateFormat;
import java.util.Date;
import project.InvalidDataException;

/**
 *
 * @author elee
 */
public final class VideoImpl implements Video {
    
    private final String name;
    
    private final int durationSec; // holds the duration of the video (in whole number seconds), greater than zero.
    private final Rating rating; // holds the rating of the video (see the enum above).
    private final String filename; // holds the file name for the video, not null or empty.

    public VideoImpl(String name, int durationSec, Rating rating, String filename) throws InvalidDataException {
        this.name = setName(name);
        this.durationSec = setDuration(durationSec);
        this.rating = rating;
        this.filename = setFileName(filename);
    }


    private int setDuration(int inputDuration) throws InvalidDataException {
        
        if (inputDuration <= 0){
            throw new InvalidDataException("Duration cannot be 0 or negative.");
        }
        return inputDuration;
    }
    public int getDurationSec() {
        return durationSec;
    }

    public String getDurationString() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        return sdf.format((durationSec*1000));
    }

    private String setFileName(String inputFileName) throws InvalidDataException {
        if (inputFileName.isEmpty()){
            throw new InvalidDataException("File name cannot be null or empty");
        }
        return inputFileName;
    }

    public String getFileName() {
        return filename;
    }

    private String setName(String inputName) throws InvalidDataException {
        if (inputName.isEmpty()){
            throw new InvalidDataException("Movie name cannot be null or empty");
        }
        return inputName;
    }
  
    public String getName() {
        return name;
    }
    
    public Rating getRating() {
        return rating;
    }
    
    public String toString(){
        return String.format("%-35s%-35s%-35s%-35s%n", name, rating.toString(), getDurationString(),filename);
    }
}
