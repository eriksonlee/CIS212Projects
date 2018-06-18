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
public class Pyramid implements Shape {

    private double L; //Length
    private double W; //Width
    private double A; //Apex
    private double vol; //Volume
    private double surfaceArea; //SurfaceArea

    public Pyramid(double L, double W, double A) throws InvalidParameterException {

        setLength(L);
        setWidth(W);
        setApex(A);
        setVol();
        setSurfaceArea();

    }

    private final void setLength(double Length) throws InvalidParameterException {
        if (Length <= 0){
            throw new InvalidParameterException("Invalid 'Length' argument: " + Length);
        }
        L = Length;
    }

    public double getLength() {
        return L;
    }

    private final void setWidth(double Width) throws InvalidParameterException {
        if (Width <=0){
            throw new InvalidParameterException("Invalid 'Width' argument: " + Width);
        }
        W = Width;
    }

    public double getWidth() {
        return W;
    }

    private final void setApex(double Apex) throws InvalidParameterException {
        if (Apex <=0){
            throw new InvalidParameterException("Invalid 'Apex' argument: " + Apex);
        }        
        A = Apex;
    }

    public double getApex() {
        return A;
    }

    private final void setVol(){
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
        return (L * W) + (L * Math.sqrt(Math.pow((W / 2), 2) + Math.pow(A, 2))) + (W * Math.sqrt(Math.pow((W / 2), 2) + Math.pow(A, 2)));
    }

    public double calculateVolume() {
        return (L*W*A)/3;
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
        return String.format("%-35s%-35s%n%-35s%-35.1f%n%-35s%-35.1f%n%-35s%-35.1f%n%-35s%-35.1f%n%-35s%-35.1f%n",
                            "Pyramid:", "", "Length:", L, "Width:", W, "Apex:", A, "Volume:", vol, "Surface Area:", surfaceArea);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.L) ^ (Double.doubleToLongBits(this.L) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.W) ^ (Double.doubleToLongBits(this.W) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.A) ^ (Double.doubleToLongBits(this.A) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.vol) ^ (Double.doubleToLongBits(this.vol) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.surfaceArea) ^ (Double.doubleToLongBits(this.surfaceArea) >>> 32));
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
        final Pyramid other = (Pyramid) obj;
        if (Double.doubleToLongBits(this.L) != Double.doubleToLongBits(other.L)) {
            return false;
        }
        if (Double.doubleToLongBits(this.W) != Double.doubleToLongBits(other.W)) {
            return false;
        }
        if (Double.doubleToLongBits(this.A) != Double.doubleToLongBits(other.A)) {
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
