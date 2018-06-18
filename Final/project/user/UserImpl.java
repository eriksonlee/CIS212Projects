/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.user;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.RowFilter.Entry;
import project.InvalidDataException;
import project.video.Video.Rating;

/**
 *
 * @author elee
 */
public class UserImpl implements User {

    private final String username;
    private final String pswd;
    private final HashMap<String, Double> videoRecords;
    private String lastLogin;
    private final Rating ratingLevel;

    public UserImpl(String username, String pswd, Rating ratingLevel) throws InvalidDataException {
        this.username = setUsername(username);
        this.pswd = setPassword(pswd);
        this.ratingLevel = setRatingLevel(ratingLevel);
        this.videoRecords = new HashMap<String, Double>();
        this.lastLogin = "Never";
    }

    private String setUsername(String inputUsername) throws InvalidDataException {
        if (inputUsername.isEmpty()) {
            throw new InvalidDataException("Username cannot be null or empty");
        }
        return inputUsername;
    }

    private String setPassword(String inputPswd) throws InvalidDataException {
        if (inputPswd.isEmpty()) {
            throw new InvalidDataException("Password cannot be null or empty");
        }
        return inputPswd;
    }

    private Rating setRatingLevel(Rating inputRating) throws InvalidDataException {
        if (inputRating == null) {
            throw new InvalidDataException("Rating level cannot be null");
        }
        if (inputRating.toString().isEmpty()) {
            throw new InvalidDataException("Rating level cannot be empty");
        }
        return inputRating;
    }

    @Override
    public Rating getRatingLevel() {
        return this.ratingLevel;
    }

    @Override
    public double getVideoStartTime(String currentVideo) {
        double startTime;
        if (!videoRecords.containsKey(currentVideo)) {
            return 0.0;
        }
        startTime = videoRecords.get(currentVideo);
        return startTime;
    }

    @Override
    public boolean hasPassword(String pswdIn) {
        boolean result = false;

        if (!this.pswd.equals(pswdIn)) {
            result = false;
            return result;
        }
        if (this.pswd.equals(pswdIn)) {
            result = true;
            return result;
        }
        return result;
    }

    @Override
    public void setLastLogin() {

        long ms = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        this.lastLogin = sdf.format(ms);

    }

    @Override
    public void updateVideoRecord(String currentVideo, double seconds) {

        videoRecords.put(currentVideo, seconds);

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(username + " Last Login: " + this.lastLogin + "\n");
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        for (Map.Entry<String, Double> entry : videoRecords.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            sb.append(key +" "+sdf.format(value*1000));
            sb.append("\n");
        }
        
        return sb.toString();
    }

}
