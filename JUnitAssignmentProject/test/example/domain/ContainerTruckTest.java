/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.domain;

import example.common.InvalidDataException;
import example.common.Point3D;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elee
 */
public class ContainerTruckTest {

    private ContainerTruck testContainerTruck = null;
    public String testID = "testing ID";

    public ContainerTruckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testContainerTruck = new ContainerTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
    }

    @After
    public void tearDown() {
        testContainerTruck = null;
    }

    /**
     * Test of load method, of class ContainerTruck.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");

        double amount = 300.0;

        try {
            testContainerTruck.load(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testContainerTruck.getCurrentLoadWeight(), 0.0);

        amount = 0.0;

        try {
            testContainerTruck.load(amount);
            fail("Entered not full load");
        } catch (Exception ex) {
            assertEquals("A Container Truck can only be *fully* loaded (" + testContainerTruck.getMaxLoadWeight()
                    + ")- not partially loaded (" + amount + ")", ex.getMessage());
        }

        amount = 500.0;

        try {
            testContainerTruck.load(amount);
            fail("Entered load too large");
        } catch (Exception ex) {
            assertEquals("A Container Truck can only be *fully* loaded (" + testContainerTruck.getMaxLoadWeight()
                    + ")- not partially loaded (" + amount + ")", ex.getMessage());
        }

    }

    /**
     * Test of unLoad method, of class ContainerTruck.
     */
    @Test
    public void testUnLoad() throws Exception {
        System.out.println("unLoad");

        double amount = 300.0;

        testContainerTruck.load(amount);

        try {
            testContainerTruck.unLoad(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testContainerTruck.getCurrentLoadWeight(), amount);

        amount = 15.0;

        try {
            testContainerTruck.unLoad(amount);
            fail("Partial unload");
        } catch (Exception ex) {
            assertEquals("A Container Truck can only be *fully* unloaded (" + testContainerTruck.getMaxLoadWeight()
                    + ")- not partially unloaded (" + amount + ")", ex.getMessage());
        }

        amount = 500.0;

        try {
            testContainerTruck.unLoad(amount);
            fail("Over unload");
        } catch (Exception ex) {
            assertEquals("A Container Truck can only be *fully* unloaded (" + testContainerTruck.getMaxLoadWeight()
                    + ")- not partially unloaded (" + amount + ")", ex.getMessage());
        }

    }

    /**
     * Test of atDestination method, of class ContainerTruck.
     */
    @Test
    public void testAtDestination() {
        System.out.println("atDestination");

        boolean expResult = false;
        boolean result = testContainerTruck.atDestination();

        assertEquals(expResult, result);

        expResult = true;
        try {
            testContainerTruck.setLocation(testContainerTruck.getDestination());
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        result = testContainerTruck.atDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class ContainerTruck.
     */
    @Test
    public void testGetDestination() throws Exception {
        System.out.println("getDestination");

        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setDestination(testDestination);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination, testContainerTruck.getDestination());

    }

    /**
     * Test of getDestinationX method, of class ContainerTruck.
     */
    @Test
    public void testGetDestinationX() throws Exception {
        System.out.println("getDestinationX");

        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setDestination(testDestination);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getX(), testContainerTruck.getDestinationX(), 0.0);
    }

    /**
     * Test of getDestinationY method, of class ContainerTruck.
     */
    @Test
    public void testGetDestinationY() throws Exception {
        System.out.println("getDestinationY");

        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setDestination(testDestination);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getY(), testContainerTruck.getDestinationY(), 0.0);
    }

    /**
     * Test of getDestinationZ method, of class ContainerTruck.
     */
    @Test
    public void testGetDestinationZ() throws Exception {
        System.out.println("getDestinationZ");

        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setDestination(testDestination);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getZ(), testContainerTruck.getDestinationZ(), 0.0);
    }

    /**
     * Test of getMaxSpeed method, of class ContainerTruck.
     */
    @Test
    public void testGetMaxSpeed() throws Exception {
        System.out.println("getMaxSpeed");

        double maxSpd = 30.0;
        try {
            testContainerTruck.setMaxSpeed(maxSpd);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getMaxSpeed(), maxSpd, 0.0);

    }

    /**
     * Test of getSpeed method, of class ContainerTruck.
     */
    @Test
    public void testGetSpeed() throws Exception {
        System.out.println("getSpeed");

        double spd = 30.0;
        try {
            testContainerTruck.setSpeed(spd);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getSpeed(), spd, 0.0);

    }

    /**
     * Test of setDestination method, of class ContainerTruck.
     */
    @Test
    public void testSetDestination_3args() throws Exception {
        System.out.println("setDestination");

        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testContainerTruck.setDestination(x, y, z);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getDestinationX(), x, 0.0);
        assertEquals(testContainerTruck.getDestinationY(), y, 0.0);
        assertEquals(testContainerTruck.getDestinationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testContainerTruck.setDestination(x, y, z);
            fail("Negative x value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testContainerTruck.setDestination(x, y, z);
            fail("Negative y value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testContainerTruck.setDestination(x, y, z);
            fail("Negative z value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }
    }

    /**
     * Test of setDestination method, of class ContainerTruck.
     */
    @Test
    public void testSetDestination_Point3D() throws Exception {
        System.out.println("setDestination");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testContainerTruck.setDestination(aPoint);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getDestination(), aPoint);

        aPoint = new Point3D(-3, 4, 5);
        try {
            testContainerTruck.setDestination(aPoint);
            fail("negative x value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testContainerTruck.setDestination(aPoint);
            fail("negative y value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testContainerTruck.setDestination(aPoint);
            fail("negative z value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }
    }

    /**
     * Test of setMaxSpeed method, of class ContainerTruck.
     */
    @Test
    public void testSetMaxSpeed() throws InvalidDataException {
        System.out.println("setMaxSpeed");
        double ms = 500.0;

        try {
            testContainerTruck.setMaxSpeed(ms);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getMaxSpeed(), ms, 0.0);

        ms = -10.0;
        try {
            testContainerTruck.setMaxSpeed(ms);
            fail("negative max speed");
        } catch (InvalidDataException ex) {
            assertEquals("Negative maxSpeed sent to setMaxSpeed:" + ms, ex.getMessage());
        }

        ms = 10.0;
        try {
            testContainerTruck.setMaxSpeed(ms);
            fail("max less than speed");
        } catch (InvalidDataException ex) {
            assertEquals("Attempt to set maxSpeed less than speed in setMaxSpeed: " + ms, ex.getMessage());
        }
    }

    /**
     * Test of setSpeed method, of class ContainerTruck.
     */
    @Test
    public void testSetSpeed() throws Exception {
        System.out.println("setSpeed");
        double s = 30.0;

        try {
            testContainerTruck.setSpeed(s);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getSpeed(), s, 0.0);
        s = -10.0;
        try {
            testContainerTruck.setSpeed(s);
            fail("negative speed");
        } catch (InvalidDataException ex) {
            assertEquals("Negative speed sent to setSpeed:" + s, ex.getMessage());
        }

        s = 500.0;
        try {
            testContainerTruck.setSpeed(s);
            fail("greater than max speed");
        } catch (InvalidDataException ex) {
            assertEquals("Attempt to set speed (" + s + ") greater than maxSpeed (" + testContainerTruck.getMaxSpeed()
                    + ") in setSpeed", ex.getMessage());
        }

    }

    /**
     * Test of distance method, of class ContainerTruck.
     */
    @Test
    public void testDistance_Point3D() throws Exception {
        System.out.println("distance");

        Point3D loc = new Point3D(5, 5, 5);
        double expResult = loc.distance(testContainerTruck.getLocation());
        double result;

        result = testContainerTruck.distance(loc);
        assertEquals(expResult, result, 0.0);

        loc = null;

        try {
            result = testContainerTruck.distance(loc);
            fail("null location");
        } catch (InvalidDataException ex) {
            assertEquals("Null location sent to distance", ex.getMessage());
        }

    }

    /**
     * Test of distance method, of class ContainerTruck.
     */
    @Test
    public void testDistance_3args() throws Exception {
        System.out.println("distance");

        double x = 5.0;
        double y = 5.0;
        double z = 5.0;

        Point3D aPoint = new Point3D(x, y, z);
        double result = testContainerTruck.distance(aPoint.getX(), aPoint.getY(), aPoint.getZ());
        double expResult = testContainerTruck.distance(x, y, z);
        assertEquals(expResult, result, 0.0);

        x = -5.0;
        y = 5.0;
        z = 5.0;

        try {
            testContainerTruck.distance(x, y, z);
            fail("negative location coordinate");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = -5.0;
        z = 5.0;

        try {
            testContainerTruck.distance(x, y, z);
            fail("negative location coordinate");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = 5.0;
        z = -5.0;

        try {
            testContainerTruck.distance(x, y, z);
            fail("negative location coordinate");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of getLocation method, of class ContainerTruck.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");

        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setLocation(testLocation);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation, testContainerTruck.getLocation());
    }

    /**
     * Test of getLocationX method, of class ContainerTruck.
     */
    @Test
    public void testGetLocationX() {
        System.out.println("getLocationX");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setLocation(testLocation);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getX(), testContainerTruck.getLocationX(), 0.0);
    }

    /**
     * Test of getLocationY method, of class ContainerTruck.
     */
    @Test
    public void testGetLocationY() {
        System.out.println("getLocationY");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setLocation(testLocation);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getY(), testContainerTruck.getLocationY(), 0.0);
    }

    /**
     * Test of getLocationZ method, of class ContainerTruck.
     */
    @Test
    public void testGetLocationZ() {
        System.out.println("getLocationZ");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testContainerTruck.setLocation(testLocation);
        } catch (InvalidDataException ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getZ(), testContainerTruck.getLocationZ(), 0.0);
    }

    /**
     * Test of setLocation method, of class ContainerTruck.
     */
    @Test
    public void testSetLocation_Point3D() throws Exception {
        System.out.println("setLocation");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testContainerTruck.setLocation(aPoint);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getLocation(), aPoint);

        aPoint = null;
        try {
            testContainerTruck.setLocation(aPoint);
            fail("negative x value");
        } catch (InvalidDataException ex) {
            assertEquals("Null location sent to setLocation", ex.getMessage());
        }

        aPoint = new Point3D(-3, 4, 5);
        try {
            testContainerTruck.setLocation(aPoint);
            fail("negative x value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testContainerTruck.setLocation(aPoint);
            fail("negative y value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testContainerTruck.setLocation(aPoint);
            fail("negative z value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of setLocation method, of class ContainerTruck.
     */
    @Test
    public void testSetLocation_3args() throws Exception {
        System.out.println("setLocation");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testContainerTruck.setLocation(x, y, z);
        } catch (InvalidDataException ex) {
            fail(ex.getMessage());
        }
        assertEquals(testContainerTruck.getLocationX(), x, 0.0);
        assertEquals(testContainerTruck.getLocationY(), y, 0.0);
        assertEquals(testContainerTruck.getLocationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testContainerTruck.setLocation(x, y, z);
            fail("Negative x value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testContainerTruck.setLocation(x, y, z);
            fail("Negative y value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testContainerTruck.setLocation(x, y, z);
            fail("Negative z value");
        } catch (InvalidDataException ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }
    }

    /**
     * Test of getIdentifier method, of class ContainerTruck.
     */
    @Test
    public void testGetIdentifier() throws Exception {
        System.out.println("getIdentifier");
        ContainerTruck test = new ContainerTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testContainerTruck = test;
        String expResult = test.getIdentifier();
        String result = testContainerTruck.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxLoadWeight method, of class ContainerTruck.
     */
    @Test
    public void testGetMaxLoadWeight() {
        System.out.println("getMaxLoadWeight");
        ContainerTruck instance = testContainerTruck;
        double result = instance.getMaxLoadWeight();
        double expResult = testContainerTruck.getMaxLoadWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCurrentLoadWeight method, of class ContainerTruck.
     */
    @Test
    public void testSetCurrentLoadWeight() throws Exception {
        System.out.println("setCurrentLoadWeight");
        double amount = 300.0;

        try {
            testContainerTruck.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testContainerTruck.getCurrentLoadWeight(), 0.0);

        testContainerTruck.setCurrentLoadWeight(0);
        amount = 0.0;

        try {
            testContainerTruck.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount, testContainerTruck.getCurrentLoadWeight(), 0.0);
        testContainerTruck.setCurrentLoadWeight(0);
        amount = -50.0;

        try {
            testContainerTruck.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount, testContainerTruck.getCurrentLoadWeight(), 0.0);
        testContainerTruck.setCurrentLoadWeight(0);
        amount = 500.0;

        try {
            testContainerTruck.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount, testContainerTruck.getCurrentLoadWeight(), 0.0);
    }

    /**
     * Test of getCurrentLoadWeight method, of class ContainerTruck.
     */
    @Test
    public void testGetCurrentLoadWeight() {
        System.out.println("getCurrentLoadWeight");
        ContainerTruck instance = testContainerTruck;
        double result = instance.getCurrentLoadWeight();
        double expResult = testContainerTruck.getCurrentLoadWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of update method, of class ContainerTruck.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        double millis = System.currentTimeMillis();
        ContainerTruck aTruck = new ContainerTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testContainerTruck.update(millis);
        aTruck.update(millis);
        Point3D result = testContainerTruck.getLocation();
        Point3D expResult = aTruck.getLocation();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class ContainerTruck.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");

        assertEquals("I am ContainerTruck " + testContainerTruck.getIdentifier() + ".\n\tI am at "
                    + testContainerTruck.getLocation() + " and am heading to " + testContainerTruck.getDestination()
                    + ".\n\tMy load is " + testContainerTruck.getCurrentLoadWeight() + " and my max load is "
                    + testContainerTruck.getMaxLoadWeight() + ".\n\tDistance to my destination is "
                    + String.format("%4.2f", testContainerTruck.distance(testContainerTruck.getDestination())) + ". I'm not there yet", testContainerTruck.toString());
    }

}
