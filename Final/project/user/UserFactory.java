/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.user;

import project.InvalidDataException;
import project.video.Video.Rating;

/**
 *
 * @author elee
 */
public class UserFactory {
    
    public static User makeUser(String uname, String pswd, Rating rating) throws InvalidDataException {
        
        return new UserImpl(uname, pswd, rating);
    }
}
