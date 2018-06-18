/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.video;

import project.InvalidDataException;
import project.video.Video.Rating;

/**
 *
 * @author elee
 */
public class VideoFactory {
    
    private VideoFactory(){}
    
    public static Video makeVideo(String name, int duration, Rating rating, String fileName) throws InvalidDataException {
        
        return new VideoImpl(name, duration, rating, fileName);
        
    }
}
