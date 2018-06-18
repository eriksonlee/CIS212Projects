/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.logging.Level;
import java.util.logging.Logger;
import assignment4.utils.*;

public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numThreads = 4;
        DataOwner dOwner = new DataOwner(); // Create a DataOwner
        for (int i = 0; i < numThreads; i++) {
            try {
                new Thread(new DataWorker(dOwner)).start(); // Create and start threads
            } catch (InvalidParameterException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Results:");
        System.out.println(dOwner);
    }

}
