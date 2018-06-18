
public class Vehicle {

    private String id;
    private double speed;
    private double max;
    private Point point;

    public Vehicle(String id, double max, int x, int y) throws InvalidParameterException {

        setId(id);
        setMax(max);
        point = new Point(x,y);
    }

    public Vehicle(String id, double max) throws InvalidParameterException {

        setId(id);
        setMax(max);
        point = new Point(0,0);
    }

    public String getId() {
        return id;
    }

    private void setId(String idInput) throws InvalidParameterException {

        if (idInput.isEmpty()) {
            throw new InvalidParameterException(idInput);
        } else {
            id = idInput;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speedInput) throws InvalidParameterException {
        if (speedInput < 0 || speedInput > max) {
            throw new InvalidParameterException(speedInput, max);
        } else {
            speed = speedInput;
        }
    }

    public double getMax() {
        return max;
    }

    private void setMax(double maxInput) throws InvalidParameterException {
        if (maxInput < 0) {
            throw new InvalidParameterException(maxInput);
        } else {
            max = maxInput;
        }
    }

    public void updateLocation(int x, int y) throws InvalidParameterException {
        this.point.setX(x);
        this.point.setY(y);
    }
    
    public String getLocation(){
        return point.toString();
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n",
                            "Id:", id, "Speed:", speed, "Max Speed:", max, "Location:", point.toString());
    }

}
