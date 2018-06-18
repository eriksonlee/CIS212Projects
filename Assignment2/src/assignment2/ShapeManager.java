/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author elee
 */
public class ShapeManager {
    
    private static final HashMap<String, Shape> shapeHold = new HashMap<>();
    
    public static void addShape(Shape input) throws AlreadyExistsException {
        if (shapeHold.containsValue(input)){
            throw new AlreadyExistsException("Shape already exists:\n" + input.toString());
        }
        shapeHold.put(input.toString(), input);
    }
    
    public static void removeShape(Shape input) throws DoesNotExistException {
        if (!shapeHold.containsValue(input)){
            throw new DoesNotExistException("Shape does not exist:\n" + input.toString());
        }
        shapeHold.remove(input);
    }
    
    public static List<Shape> getContents() {
        ArrayList<Shape> sortedList = new ArrayList<Shape>(shapeHold.values());
        Collections.sort(sortedList);
        return sortedList;
                
    }
}
