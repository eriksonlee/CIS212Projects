/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.video;

import java.io.Serializable;

/**
 *
 * @author elee
 */
public interface Video extends Serializable {
    
    public enum Rating {
        G, PG, PG13, R, NC17
    }
    
    public int getDurationSec();
    public String getDurationString();
    public String getFileName();
    public String getName();
    public Rating getRating();
    
}
