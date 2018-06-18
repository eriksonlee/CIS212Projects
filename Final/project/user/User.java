/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.user;

import java.io.Serializable;
import project.video.Video;

/**
 *
 * @author elee
 */
public interface User extends Serializable {
    
    Video.Rating getRatingLevel();
    
    double getVideoStartTime(String currentVideo);
    
    boolean hasPassword(String pswdIn);
    
    void setLastLogin();
    
    void updateVideoRecord(String currentVideo, double seconds);
    
    
    
}
