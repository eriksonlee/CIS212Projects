
package assignment4;

import java.util.ArrayList;
import assignment4.utils.*;

public class DataOwner {

    private ArrayList<String> stringList;
    private ArrayList<Integer> integerList;

    public DataOwner() {

        stringList = new ArrayList<String>();
        integerList = new ArrayList<Integer>();

    }
    
    public void addString(String s) throws InvalidParameterException, AlreadyExistsException{
        
        synchronized(this){
        if (s.isEmpty()){
            throw new InvalidParameterException();
        }
        
        if(stringList.contains(s)){
            throw new AlreadyExistsException();
        }
        }
        
        stringList.add(s);
        
    }
    
    public void addInteger(Integer i) throws InvalidParameterException, AlreadyExistsException {

        synchronized(this){
        if (i.equals(null)){
            throw new InvalidParameterException();
        }
        
        if (integerList.contains(i)){
            throw new AlreadyExistsException();
        }
        
        integerList.add(i);
        }
    }

    public String toString() {

        return 
                "String list size: " + stringList.size() +
                "\nInteger list size: " + integerList.size();
    }

}
