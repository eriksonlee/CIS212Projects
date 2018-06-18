/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author elee
 */
public interface Shape extends Comparable<Shape>{

    double calculateSurfaceArea();

    double calculateVolume();

}

//Math.pow(x,2);
//Math.PI;

//Requirement 3. HashSet<Shape> hm = new HashSet<Shapes>;
//hm.add(x);
//hm.remove(x);
//hm.contains(x);

//HashSet<Shape> myShapes = new HashSet<Shape>;
//ArrayList<Shape> A = new ArrayList<Shape>(myShapes); (using this to create sorts)
//Collections.sort(A);
//return A;