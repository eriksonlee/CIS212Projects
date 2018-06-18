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
public class Torus implements Shape {

    private double RR; //Ring 
    private double CSR; //Cross section radius
    private double vol; //Volume
    private double surfaceArea; //SurfaceArea

    public Torus(double RR, double CSR) throws InvalidParameterException {

        setRingRadius(RR);
        setCrossSectionRadius(CSR);
        setVol();
        setSurfaceArea();
 
    }

    private final void setRingRadius(double RingRadius) throws InvalidParameterException {
        if (RingRadius <= 0){
            throw new InvalidParameterException("Invalid 'Ring Radius' argument: " + RingRadius);
        }
        RR = RingRadius;
    }

    public double getRingRadius() {
        return RR;
    }

    private final void setCrossSectionRadius(double crossSectionRadius) throws InvalidParameterException {
        if (crossSectionRadius <=0){
            throw new InvalidParameterException("Invalid 'Cross Section Radius' argument: " + crossSectionRadius);
        }
        CSR = crossSectionRadius;
    }

    public double getCrossSectionRadius() {
        return CSR;
    }

    private final void setVol() {
        vol = calculateVolume();
    }

    public double getVol() {
        return vol;
    }

    private final void setSurfaceArea() {
        surfaceArea = calculateSurfaceArea();
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double calculateSurfaceArea() {
        return (2*Math.PI*CSR)*(2*Math.PI*RR);
    }

    public double calculateVolume() {
        return (Math.PI*Math.pow(RR, 2)*(2*Math.PI*CSR));
    }

    public int compareTo(Shape in) {
        if (calculateVolume() == in.calculateVolume()) {
            return 0;
        }
        if (getVol() < in.calculateVolume()) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString() {
        return String.format("%-35s%-35s%n%-35s%-35.1f%n%-35s%-35.1f%n%-35s%-35.1f%n%-35s%-35.1f%n",
                            "Torus:", "", "Ring Radius:", RR, "Cross-section Radius:", CSR, "Volume:", vol, "Surface Area:", surfaceArea);
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.RR) ^ (Double.doubleToLongBits(this.RR) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.CSR) ^ (Double.doubleToLongBits(this.CSR) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.vol) ^ (Double.doubleToLongBits(this.vol) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.surfaceArea) ^ (Double.doubleToLongBits(this.surfaceArea) >>> 32));
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
        final Torus other = (Torus) obj;
        if (Double.doubleToLongBits(this.RR) != Double.doubleToLongBits(other.RR)) {
            return false;
        }
        if (Double.doubleToLongBits(this.CSR) != Double.doubleToLongBits(other.CSR)) {
            return false;
        }
        if (Double.doubleToLongBits(this.vol) != Double.doubleToLongBits(other.vol)) {
            return false;
        }
        if (Double.doubleToLongBits(this.surfaceArea) != Double.doubleToLongBits(other.surfaceArea)) {
            return false;
        }
        return true;
    }


}
