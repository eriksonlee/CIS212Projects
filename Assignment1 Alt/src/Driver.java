
public class Driver {

    public static void main(String[] args) {
        Truck testTruck;
// Create a truck 
        System.out.println("1) Create Truck:");
     
        try {
            testTruck = new Truck("ABC123", 80.0, 10, 22, 2);
            System.out.println(testTruck);
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
            return;
        }
// Set Speed 
        System.out.println("\n2) Set Speed:");
        try {
            testTruck.setSpeed(45.5);
            System.out.println(testTruck);
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
            return;
        }
//Add address #1 
        System.out.println("\n3) Add address #1:");
        try {
            testTruck.addDestination("200 W Wacker Dr, #1404");
            System.out.println(testTruck);
        } catch (AlreadyExistsException | InvalidParameterException | ListFullException ex) {
            System.out.println(ex.getMessage());
            return;
        }
//Add duplicate address #1 
        System.out.println("\n4) Add duplicate address #1:");
        try {
            testTruck.addDestination("200 W Wacker Dr, #1404");
            System.out.println(testTruck);
        } catch (AlreadyExistsException | InvalidParameterException | ListFullException ex) {
            System.out.println(ex.getMessage());
        }
//Add address #2 
        System.out.println("\n5) Add address #2:");
        try {
            testTruck.addDestination("320 N Morgan St, #600");
            System.out.println(testTruck);
        } catch (AlreadyExistsException | InvalidParameterException | ListFullException ex) {
            System.out.println(ex.getMessage());
        }
//Add address #3 
        System.out.println("\n6) Try to add address #3:");
        try {
            testTruck.addDestination("875 N Michigan Ave, #3300");
            System.out.println(testTruck);
        } catch (AlreadyExistsException | InvalidParameterException | ListFullException ex) {
            System.out.println(ex.getMessage());
        }
//Remove address #1 
        System.out.println("\n7) Remove address #1:");
        try {
            testTruck.removeDestination("200 W Wacker Dr, #1404");
            System.out.println(testTruck);
        } catch (DoesNotExistException | InvalidParameterException ex) {
            System.out.println(ex.getMessage());
        }
//Update Location 
        System.out.println("\n8) Update Location:");
        try {
            testTruck.updateLocation(14, 32);
            System.out.println(testTruck);
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
