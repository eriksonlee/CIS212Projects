/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.video;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import project.user.UserService;

/**
 *
 * @author elee
 */
public class VideoService implements Serializable {

    private volatile static VideoService thisVideoService;
    private HashMap<String, Video> thisVideoMap;
    private static final String mediaBase = "media";
    private static final String fileName = "VideoLibrary.xml";

    private VideoService() {
        loadVideos();
    }

    public static synchronized VideoService getInstance() {
        if (thisVideoService == null) {
            synchronized (VideoService.class) {
                if (thisVideoService == null) {
                    thisVideoService = new VideoService();
                }
            }
        }
        return thisVideoService;
    }

    public void loadVideos(){
        
        thisVideoMap = VideoLoader.loadVideoXml(fileName);
        
    }
    
    public static void reset(VideoService vidSvc){
        
        thisVideoService = vidSvc;
    }
    
    public ArrayList<String> getSelections(String userName){
        ArrayList<String> movieNames = new ArrayList<String>();
        Map<String, Video> treeMap = new TreeMap<String, Video>(thisVideoMap);
        for (Map.Entry<String, Video> entry: treeMap.entrySet()){
            if (entry.getValue().getRating().compareTo(UserService.getInstance().getRatingLevel(userName))<0)
                movieNames.add(entry.getKey());
        }
        
        
        Collections.sort(movieNames);
        return movieNames;
    }
    
    public String getFile(String videoName){
        
        return mediaBase + File.separator + thisVideoMap.get(videoName).getFileName();
    }
    
    public String getSummary(String videoName){
        String summary;
        StringBuilder sb = new StringBuilder();
        sb.append(thisVideoMap.get(videoName).getName() + " ");
        sb.append("(" + thisVideoMap.get(videoName).getRating() + ")");
        return sb.toString();
    }
    
    public String getDurationString(String selection){
        return thisVideoMap.get(selection).getDurationString();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Map<String, Video> treeMap = new TreeMap<String, Video>(thisVideoMap);
        for (Map.Entry<String, Video> entry : treeMap.entrySet()) {
            sb.append(entry.getValue().toString());
        }
        return sb.toString();
    }
}
