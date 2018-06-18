
import java.util.ArrayList;

public class Truck extends Vehicle {

    private int maxDeliveries;
    ArrayList<String> addresses = new ArrayList<String>();

    public Truck(String id, double max, int x, int y, int maxDeliveriesInput) throws InvalidParameterException {
        super(id, max, x, y);
        setMaxDeliveries(maxDeliveriesInput);
        addresses.ensureCapacity(maxDeliveriesInput);
    }

    public Truck(String id, double max, int maxDeliveriesInput) throws InvalidParameterException {
        super(id, max);
        setMaxDeliveries(maxDeliveriesInput);
        addresses.ensureCapacity(maxDeliveriesInput);
        
    }

    public int getMaxDeliveries() {
        return maxDeliveries;
    }

    private void setMaxDeliveries(int maxDeliveriesInput) throws InvalidParameterException {

        if (maxDeliveriesInput < 0) {
            throw new InvalidParameterException();
        } else {
            maxDeliveries = maxDeliveriesInput;
        }
    }

    public void addDestination(String destination) throws InvalidParameterException, ListFullException, AlreadyExistsException {

        if (destination.isEmpty()) {
            throw new InvalidParameterException();
        } 
        else if (addresses.size()>= maxDeliveries) {
            throw new ListFullException(destination);
        } 
        else if (addresses.contains(destination)) {
            throw new AlreadyExistsException(destination);
        } 
        else {
            addresses.add(destination);
        }
    }

    public void removeDestination(String destination) throws InvalidParameterException, DoesNotExistException {

        if (destination.isEmpty()) {
            throw new InvalidParameterException();
        } else if (!addresses.contains(destination)) {
            throw new DoesNotExistException(destination);
        } else {
            this.addresses.remove(destination);
        }

    }
    
    public String toString() {
        return String.format("%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n",
                            "Id:", getId(), "Speed:", getSpeed(), "Max Speed:", getMax(), "Location:", getLocation(), "Max Destinations:", maxDeliveries, "Destinations:", addresses.toString());
    }

}
