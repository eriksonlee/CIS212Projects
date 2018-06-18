package example.domain;

import example.common.CannotFitException;
import example.common.InvalidDataException;
import example.common.Point3D;
import example.common.TruckImplFactory;
import example.truck.Truck;

public class ContainerTruck implements Truck {

    private Truck myTruck; // Delegate - will refer to some implementation object

    public ContainerTruck(double lX, double lY, double lZ, double dX, double dY, double dZ,
            double spd, double mxSpd, double mlw) throws InvalidDataException {
        myTruck = TruckImplFactory.createTruck(lX, lY, lZ, dX, dY, dZ, spd, mxSpd, mlw);
    }

    public ContainerTruck(Point3D loc, Point3D dest, double spd, double mxSpd, double mlw) throws InvalidDataException {
        this(loc.getX(), loc.getY(), loc.getZ(), dest.getX(), dest.getY(), dest.getZ(), spd, mxSpd, mlw);
    }

    private void verifyLoadValue(double amount) throws InvalidDataException {
        if (amount != getMaxLoadWeight()) {
            throw new InvalidDataException("A Container Truck can only be *fully* loaded (" + getMaxLoadWeight()
                    + ")- not partially loaded (" + amount + ")");
        }
    }

    @Override
    public void load(double amount) throws InvalidDataException, CannotFitException {
        verifyLoadValue(amount);
        setCurrentLoadWeight(amount);
    }

    @Override
    public void unLoad(double amount) throws InvalidDataException, CannotFitException {
        if (amount != getCurrentLoadWeight()) {
            throw new InvalidDataException("A Container Truck can only be *fully* unloaded (" + getMaxLoadWeight()
                    + ")- not partially unloaded (" + amount + ")");
        }
        setCurrentLoadWeight(0.0);
    }

    @Override
    public boolean atDestination() {
        return myTruck.atDestination();
    }

    @Override
    public Point3D getDestination() {
        return myTruck.getDestination();
    }

    @Override
    public double getDestinationX() {
        return myTruck.getDestinationX();
    }

    @Override
    public double getDestinationY() {
        return myTruck.getDestinationY();
    }

    @Override
    public double getDestinationZ() {
        return myTruck.getDestinationZ();
    }

    @Override
    public double getMaxSpeed() {
        return myTruck.getMaxSpeed();
    }

    @Override
    public double getSpeed() {
        return myTruck.getSpeed();
    }

    @Override
    public void setDestination(double x, double y, double z) throws InvalidDataException {
        myTruck.setDestination(x, y, z);
    }

    @Override
    public void setDestination(Point3D aPoint) throws InvalidDataException {
        myTruck.setDestination(aPoint);
    }

    @Override
    public void setMaxSpeed(double ms) throws InvalidDataException {
        myTruck.setMaxSpeed(ms);
    }

    @Override
    public void setSpeed(double s) throws InvalidDataException {
        myTruck.setSpeed(s);
    }

    @Override
    public double distance(Point3D loc) throws InvalidDataException {
        return myTruck.distance(loc);
    }

    @Override
    public double distance(double x, double y, double z) throws InvalidDataException {
        return myTruck.distance(x, y, z);
    }

    @Override
    public Point3D getLocation() {
        return myTruck.getLocation();
    }

    @Override
    public double getLocationX() {
        return myTruck.getLocationX();
    }

    @Override
    public double getLocationY() {
        return myTruck.getLocationY();
    }

    @Override
    public double getLocationZ() {
        return myTruck.getLocationZ();
    }

    @Override
    public void setLocation(Point3D loc) throws InvalidDataException {
        myTruck.setLocation(loc);
    }

    @Override
    public void setLocation(double x, double y, double z) throws InvalidDataException {
        myTruck.setLocation(x, y, z);
    }

    @Override
    public String getIdentifier() {
        return myTruck.getIdentifier();
    }

    @Override
    public double getMaxLoadWeight() {
        return myTruck.getMaxLoadWeight();
    }

    @Override
    public void setCurrentLoadWeight(double d) {
        myTruck.setCurrentLoadWeight(d);
    }

    @Override
    public double getCurrentLoadWeight() {
        return myTruck.getCurrentLoadWeight();
    }

    @Override
    public void update(double millis) throws InvalidDataException {
        myTruck.update(millis);
    }

    @Override
    public String toString() {
        try {
            return "I am ContainerTruck " + getIdentifier() + ".\n\tI am at "
                    + getLocation() + " and am heading to " + getDestination()
                    + ".\n\tMy load is " + getCurrentLoadWeight() + " and my max load is "
                    + getMaxLoadWeight() + ".\n\tDistance to my destination is "
                    + String.format("%4.2f", distance(getDestination())) + ". "
                    + (atDestination() ? "I am there!" : "I'm not there yet");
        } catch (InvalidDataException ex) {
            return ex.getMessage();
        }
    }

}
