
package assignment4;

import assignment4.utils.*;
import java.util.Objects;

public class DataWorker implements Runnable {
    
    private DataOwner owner;
    
    public DataWorker(DataOwner inputOwner) throws InvalidParameterException{
        setDataOwner(inputOwner);
    }
    private void setDataOwner(DataOwner inputOwner) throws InvalidParameterException{
        if(inputOwner.equals(null)){
            throw new InvalidParameterException();
        }
        owner = inputOwner;
    }
    public void run(){
        
        for (int i = 0; i < 5000; i++){
            
            
            String tempString = i + "" + Thread.currentThread().getName();
            int tempInt = i + hashCode();
            
            
            try {
                
                owner.addString(tempString);
                
            } catch (InvalidParameterException ex) {
                ex.printStackTrace();
            } catch (AlreadyExistsException ex) {
                ex.printStackTrace();
            }
        

            try {
                
                owner.addInteger(tempInt);
                
            } catch (InvalidParameterException ex) {
                ex.printStackTrace();
            } catch (AlreadyExistsException ex) {
                ex.printStackTrace();
            }
            
        
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(Thread.currentThread().getName()) * Objects.hashCode(this.owner);
        return hash;
    }


   


    
    
}