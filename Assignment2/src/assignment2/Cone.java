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
public class Cone implements Shape {

    private double H; //Height
    private double R; //Radius
    private double vol; //Volume
    private double surfaceArea; //SurfaceArea

    public Cone(double R, double H) throws InvalidParameterException {

        setRadius(R);
        setHeight(H);
        setVol();
        setSurfaceArea();

    }

    private final void setHeight(double Height) throws InvalidParameterException {
        if (Height <= 0){
            throw new InvalidParameterException("Invalid 'Height' argument: " + Height);
        }
        H = Height;
    }

    public double getHeight() {
        return H;
    }

    private final void setRadius(double Radius) throws InvalidParameterException {
        if (Radius <=0){
            throw new InvalidParameterException("Invalid 'Radius' argument: " + Radius);
        }
        R = Radius;
    }

    public double getRadius() {
        return R;
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
        return Math.PI*R*(R+Math.sqrt(Math.pow(H,2)+Math.pow(R,2)));
    }

    public double calculateVolume() {
        return Math.PI*Math.pow(R, 2)*(H/3);
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
                            "Cone:", "", "Height:", H, "Radius:", R, "Volume:", vol, "Surface Area:", surfaceArea);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.H) ^ (Double.doubleToLongBits(this.H) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.R) ^ (Double.doubleToLongBits(this.R) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.vol) ^ (Double.doubleToLongBits(this.vol) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.surfaceArea) ^ (Double.doubleToLongBits(this.surfaceArea) >>> 32));
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
        final Cone other = (Cone) obj;
        if (Double.doubleToLongBits(this.H) != Double.doubleToLongBits(other.H)) {
            return false;
        }
        if (Double.doubleToLongBits(this.R) != Double.doubleToLongBits(other.R)) {
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
