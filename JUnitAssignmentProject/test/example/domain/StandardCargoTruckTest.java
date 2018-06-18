/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.domain;

import example.common.Point3D;
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
public class StandardCargoTruckTest {

    private StandardCargoTruck testSCT;

    public StandardCargoTruckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testSCT = new StandardCargoTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
    }

    @After
    public void tearDown() {
        testSCT = null;
    }

    /**
     * Test of load method, of class StandardCargoTruck.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        double amount = 10.0;

        try {
            testSCT.load(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testSCT.getCurrentLoadWeight(), 0.0);

        double amount2 = 30.0;

        try {
            testSCT.load(amount2);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount + amount2, testSCT.getCurrentLoadWeight(), 0.0);

        amount = -10.0;

        try {
            testSCT.load(amount);
            fail("negative load amount");
        } catch (Exception ex) {
            assertEquals("Negative load amount: " + amount, ex.getMessage());
        }

        amount = 500.0;
        try {
            testSCT.load(amount);
            fail("negative load amount");
        } catch (Exception ex) {
            assertEquals("Additional load of " + amount + " will make the load weight "
                    + (testSCT.getCurrentLoadWeight() + amount) + " which exceeds the max load weight of " + testSCT.getMaxLoadWeight(), ex.getMessage());
        }

    }

    /**
     * Test of unLoad method, of class StandardCargoTruck.
     */
    @Test
    public void testUnLoad() throws Exception {
        System.out.println("unLoad");

        double amount = 300.0;

        testSCT.load(amount);

        try {
            testSCT.unLoad(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testSCT.getCurrentLoadWeight(), amount);

        amount = -15.0;

        try {
            testSCT.unLoad(amount);
            fail("Partial unload");
        } catch (Exception ex) {
            assertEquals("Negative unLoad amount: " + amount, ex.getMessage());
        }

        amount = 500.0;

        try {
            testSCT.unLoad(amount);
            fail("Over unload");
        } catch (Exception ex) {
            assertEquals("UnLoading " + amount + " will make the load weight negative: "
                    + (testSCT.getCurrentLoadWeight() + amount), ex.getMessage());
        }

    }

    /**
     * Test of atDestination method, of class StandardCargoTruck.
     */
    @Test
    public void testAtDestination() {
        System.out.println("atDestination");

        boolean expResult = false;
        boolean result = testSCT.atDestination();

        assertEquals(expResult, result);

        expResult = true;
        try {
            testSCT.setLocation(testSCT.getDestination());
        } catch (Exception ex) {
            fail(ex.toString());
        }
        result = testSCT.atDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class StandardCargoTruck.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testSCT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination, testSCT.getDestination());
    }

    /**
     * Test of getDestinationX method, of class StandardCargoTruck.
     */
    @Test
    public void testGetDestinationX() {
        System.out.println("getDestinationX");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testSCT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getX(), testSCT.getDestinationX(), 0.0);
    }

    /**
     * Test of getDestinationY method, of class StandardCargoTruck.
     */
    @Test
    public void testGetDestinationY() {
        System.out.println("getDestinationY");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testSCT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getY(), testSCT.getDestinationY(), 0.0);
    }

    /**
     * Test of getDestinationZ method, of class StandardCargoTruck.
     */
    @Test
    public void testGetDestinationZ() {
        System.out.println("getDestinationZ");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testSCT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getZ(), testSCT.getDestinationZ(), 0.0);
    }

    /**
     * Test of getMaxSpeed method, of class StandardCargoTruck.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        double maxSpd = 30.0;
        try {
            testSCT.setMaxSpeed(maxSpd);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getMaxSpeed(), maxSpd, 0.0);
    }

    /**
     * Test of getSpeed method, of class StandardCargoTruck.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        double spd = 30.0;
        try {
            testSCT.setSpeed(spd);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getSpeed(), spd, 0.0);
    }

    /**
     * Test of setDestination method, of class StandardCargoTruck.
     */
    @Test
    public void testSetDestination_3args() throws Exception {
        System.out.println("setDestination");

        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testSCT.setDestination(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getDestinationX(), x, 0.0);
        assertEquals(testSCT.getDestinationY(), y, 0.0);
        assertEquals(testSCT.getDestinationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testSCT.setDestination(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testSCT.setDestination(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testSCT.setDestination(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }
    }

    /**
     * Test of setDestination method, of class StandardCargoTruck.
     */
    @Test
    public void testSetDestination_Point3D() throws Exception {
        System.out.println("setDestination");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testSCT.setDestination(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getDestination(), aPoint);

        aPoint = new Point3D(-3, 4, 5);
        try {
            testSCT.setDestination(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testSCT.setDestination(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testSCT.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = null;
        try {
            testSCT.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Null Point3D sent to setDestination(Point3D)", ex.getMessage());
        }
    }

    /**
     * Test of setMaxSpeed method, of class StandardCargoTruck.
     */
    @Test
    public void testSetMaxSpeed() throws Exception {
        System.out.println("setMaxSpeed");
        double ms = 500.0;

        try {
            testSCT.setMaxSpeed(ms);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getMaxSpeed(), ms, 0.0);

        ms = -10.0;
        try {
            testSCT.setMaxSpeed(ms);
            fail("negative max speed");
        } catch (Exception ex) {
            assertEquals("Negative maxSpeed sent to setMaxSpeed:" + ms, ex.getMessage());
        }

        ms = 10.0;
        try {
            testSCT.setMaxSpeed(ms);
            fail("max less than speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set maxSpeed less than speed in setMaxSpeed: " + ms, ex.getMessage());
        }
    }

    /**
     * Test of setSpeed method, of class StandardCargoTruck.
     */
    @Test
    public void testSetSpeed() throws Exception {
        System.out.println("setSpeed");
        double s = 30.0;

        try {
            testSCT.setSpeed(s);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getSpeed(), s, 0.0);
        s = -10.0;
        try {
            testSCT.setSpeed(s);
            fail("negative speed");
        } catch (Exception ex) {
            assertEquals("Negative speed sent to setSpeed:" + s, ex.getMessage());
        }

        s = 500.0;
        try {
            testSCT.setSpeed(s);
            fail("greater than max speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set speed (" + s + ") greater than maxSpeed (" + testSCT.getMaxSpeed()
                    + ") in setSpeed", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class StandardCargoTruck.
     */
    @Test
    public void testDistance_Point3D() throws Exception {
        System.out.println("distance");

        Point3D loc = new Point3D(5, 5, 5);
        double expResult = loc.distance(testSCT.getLocation());
        double result;

        result = testSCT.distance(loc);
        assertEquals(expResult, result, 0.0);

        loc = null;

        try {
            result = testSCT.distance(loc);
            fail("null location");
        } catch (Exception ex) {
            assertEquals("Null location sent to distance", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class StandardCargoTruck.
     */
    @Test
    public void testDistance_3args() throws Exception {
        System.out.println("distance");

        double x = 5.0;
        double y = 5.0;
        double z = 5.0;

        Point3D aPoint = new Point3D(x, y, z);
        double result = testSCT.distance(aPoint.getX(), aPoint.getY(), aPoint.getZ());
        double expResult = testSCT.distance(x, y, z);
        assertEquals(expResult, result, 0.0);

        x = -5.0;
        y = 5.0;
        z = 5.0;

        try {
            testSCT.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = -5.0;
        z = 5.0;

        try {
            testSCT.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = 5.0;
        z = -5.0;

        try {
            testSCT.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of getLocation method, of class StandardCargoTruck.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testSCT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation, testSCT.getLocation());
    }

    /**
     * Test of getLocationX method, of class StandardCargoTruck.
     */
    @Test
    public void testGetLocationX() {
        System.out.println("getLocationX");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testSCT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getX(), testSCT.getLocationX(), 0.0);
    }

    /**
     * Test of getLocationY method, of class StandardCargoTruck.
     */
    @Test
    public void testGetLocationY() {
        System.out.println("getLocationY");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testSCT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getY(), testSCT.getLocationY(), 0.0);
    }

    /**
     * Test of getLocationZ method, of class StandardCargoTruck.
     */
    @Test
    public void testGetLocationZ() {
        System.out.println("getLocationZ");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testSCT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getZ(), testSCT.getLocationZ(), 0.0);
    }

    /**
     * Test of setLocation method, of class StandardCargoTruck.
     */
    @Test
    public void testSetLocation_Point3D() throws Exception {
        System.out.println("setLocation");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testSCT.setLocation(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getLocation(), aPoint);

        aPoint = null;
        try {
            testSCT.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Null location sent to setLocation", ex.getMessage());
        }

        aPoint = new Point3D(-3, 4, 5);
        try {
            testSCT.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testSCT.setLocation(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testSCT.setLocation(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of setLocation method, of class StandardCargoTruck.
     */
    @Test
    public void testSetLocation_3args() throws Exception {
        System.out.println("setLocation");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testSCT.setLocation(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testSCT.getLocationX(), x, 0.0);
        assertEquals(testSCT.getLocationY(), y, 0.0);
        assertEquals(testSCT.getLocationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testSCT.setLocation(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testSCT.setLocation(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testSCT.setLocation(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }
    }

    /**
     * Test of getIdentifier method, of class StandardCargoTruck.
     */
    @Test
    public void testGetIdentifier() throws Exception {
        System.out.println("getIdentifier");
        StandardCargoTruck test = new StandardCargoTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testSCT = test;
        String expResult = test.getIdentifier();
        String result = testSCT.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxLoadWeight method, of class StandardCargoTruck.
     */
    @Test
    public void testGetMaxLoadWeight() {
        System.out.println("getMaxLoadWeight");
        StandardCargoTruck instance = testSCT;
        double result = instance.getMaxLoadWeight();
        double expResult = testSCT.getMaxLoadWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCurrentLoadWeight method, of class StandardCargoTruck.
     */
    @Test
    public void testSetCurrentLoadWeight() {
        System.out.println("setCurrentLoadWeight");
        double amount = 300.0;

        try {
            testSCT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testSCT.getCurrentLoadWeight(), 0.0);

        testSCT.setCurrentLoadWeight(0);
        amount = 0.0;

        try {
            testSCT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount, testSCT.getCurrentLoadWeight(), 0.0);
        testSCT.setCurrentLoadWeight(0);
        amount = -50.0;

        try {
            testSCT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            assertEquals("Negative unLoad amount: " + amount, ex.getMessage());
        }
        testSCT.setCurrentLoadWeight(0);
        amount = 500.0;

        try {
            testSCT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            assertEquals("Additional load of " + amount + " will make the load weight "
                    + (testSCT.getCurrentLoadWeight() + amount) + " which exceeds the max load weight of " + testSCT.getMaxLoadWeight(), ex.getMessage());
        }
    }

    /**
     * Test of getCurrentLoadWeight method, of class StandardCargoTruck.
     */
    @Test
    public void testGetCurrentLoadWeight() {
        System.out.println("getCurrentLoadWeight");
        StandardCargoTruck instance = testSCT;
        double result = instance.getCurrentLoadWeight();
        double expResult = testSCT.getCurrentLoadWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of update method, of class StandardCargoTruck.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        double millis = System.currentTimeMillis();
        StandardCargoTruck aTruck = new StandardCargoTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testSCT.update(millis);
        aTruck.update(millis);
        Point3D result = testSCT.getLocation();
        Point3D expResult = aTruck.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class StandardCargoTruck.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        assertEquals("I am StandardCargoTruck " + testSCT.getIdentifier() + ".\n\tI am at "
                + testSCT.getLocation() + " and am heading to " + testSCT.getDestination()
                + ".\n\tMy load is " + testSCT.getCurrentLoadWeight() + " and my max load is "
                + testSCT.getMaxLoadWeight() + ".\n\tDistance to my destination is "
                + String.format("%4.2f", testSCT.distance(testSCT.getDestination())) + ". "
                + (testSCT.atDestination() ? "I am there!" : "I'm not there yet"), testSCT.toString());
    }

}
