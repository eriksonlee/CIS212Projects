/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author elee
 */
public class Driver {

    public static void main(String[] args) {
        try {
            FileContent fc = FileReader.loadFile("alice.txt");

            System.out.println(fc.generateReport());
            FileWriter.writeFile("Output.txt", fc, 90);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
