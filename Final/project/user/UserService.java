/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import project.video.Video;
import project.video.Video.Rating;

/**
 *
 * @author elee
 */
public class UserService implements Serializable {

    private volatile static UserService thisUserService;
    private HashMap<String, User> thisUserMap;
    private static final String fileName = "Users.xml";

    private UserService() {
        loadUsers();
    }

    public static synchronized UserService getInstance() {
        if (thisUserService == null) {
            synchronized (UserService.class) {
                if (thisUserService == null) {
                    thisUserService = new UserService();
                }
            }
        }
        return thisUserService;
    }

    public void loadUsers() {
        thisUserMap = UserLoader.loadUserXml(fileName);
    }

    public static void reset(UserService usrSvc) {
        thisUserService = usrSvc;
    }

    public boolean validateCredentials(String uname, String pswd) {
        if (thisUserMap.containsKey(uname) && thisUserMap.get(uname).hasPassword(pswd)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateVideoRecord(String uname, String vidName, double seconds) {
        thisUserMap.get(uname).updateVideoRecord(vidName, seconds);
    }

    public double getVideoStartTime(String uname, String vidName) {
        return thisUserMap.get(uname).getVideoStartTime(vidName);
    }

    public Rating getRatingLevel(String uname) {
        return thisUserMap.get(uname).getRatingLevel();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Map<String, User> treeMap = new TreeMap<String, User>(thisUserMap);
        for (Map.Entry<String, User> entry : treeMap.entrySet()) {
            sb.append(entry.getValue().toString());
        }
        return sb.toString();
    }
}
