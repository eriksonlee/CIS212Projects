/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7alt;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author elee
 */
public class Employee implements Serializable  {

    private final String identifier; // not null, must be 6 characters, should not be changed once initially set.
    private final String fName; //not null or empty, should not be changed once initially set.
    private final String lName; //not null or empty, should not be changed once initially set.
    private double rate; // not zero or negative, can be changed

    public Employee(String inputId, String inputFName, String inputLName, double inputRate) throws InvalidDataException {

        identifier = setIdentifier(inputId);
        fName = setFName(inputFName);
        lName = setLName(inputLName);
        rate = setRate(inputRate);

    }

    private String setIdentifier(String inputId) throws InvalidDataException {

        if (inputId.isEmpty()) {
            throw new InvalidDataException("Identifer cannot be null. Identifier must be 6 characters long.");
        }
        if (inputId.length() != 6) {
            throw new InvalidDataException("Identifier must be 6 characters long.");
        }
        return inputId;
    }

    public String getIdentifier() {
        return identifier;
    }

    private String setFName(String inputFName) throws InvalidDataException {

        if (inputFName.isEmpty()) {
            throw new InvalidDataException("First name cannot be null or empty.");
        }
        return inputFName;
    }

    public String getFName() {
        return fName;
    }

    private String setLName(String inputLName) throws InvalidDataException {

        if (inputLName.isEmpty()) {
            throw new InvalidDataException("Last name cannot be null or empty.");
        }
        return inputLName;
    }

    public String getLName() {
        return lName;
    }

    public double setRate(double inputRate) throws InvalidDataException {

        if (inputRate <= 0) {
            throw new InvalidDataException("Rate cannot be 0 or negative.");
        }
        return inputRate;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.identifier);
        hash = 97 * hash + Objects.hashCode(this.fName);
        hash = 97 * hash + Objects.hashCode(this.lName);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.rate) ^ (Double.doubleToLongBits(this.rate) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.rate)) {
            return false;
        }
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("%-35s%-35s%n"+
                            "%-35s%-35s%n"+
                            "%-35s%-35s%n"+
                            "%-35s%-35s%n"+
                            "%-35s%-35.2f%n%n",
     
                            "Employee:", "", "Identifier:", identifier, "First Name:", fName, "Last Name:", lName, "Hourly Rate", rate);
    }
}
