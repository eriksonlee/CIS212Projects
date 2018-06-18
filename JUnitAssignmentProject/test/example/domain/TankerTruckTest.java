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
public class TankerTruckTest {

    private TankerTruck testTT;

    public TankerTruckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testTT = new TankerTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
    }

    @After
    public void tearDown() {
        testTT = null;
    }

    /**
     * Test of load method, of class TankerTruck.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        double amount = 10.0;

        try {
            testTT.load(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testTT.getCurrentLoadWeight(), 0.0);

        double amount2 = 30.0;

        try {
            testTT.load(amount2);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount + amount2, testTT.getCurrentLoadWeight(), 0.0);

        amount = -10.0;

        try {
            testTT.load(amount);
            fail("negative load amount");
        } catch (Exception ex) {
            assertEquals("Negative load amount: " + amount, ex.getMessage());
        }

        amount = 500.0;
        try {
            testTT.load(amount);
            fail("over max load");
        } catch (Exception ex) {
            assertEquals("Additional load of " + amount + " will make the load weight "
                    + (testTT.getCurrentLoadWeight() + amount) + " which exceeds the max load weight of " + testTT.getMaxLoadWeight(), ex.getMessage());
        }

        amount = 3000.0;
        try {
            testTT.load(amount);
            fail("over max load rate");
        } catch (Exception ex) {
            assertEquals("Loading " + amount + " at one time exceeds the TankerTruck load rate limit of " + 2000.0 + " at a time.", ex.getMessage());
        }
    }

    /**
     * Test of unLoad method, of class TankerTruck.
     */
    @Test
    public void testUnLoad() throws Exception {
        System.out.println("unLoad");
        double amount = 300.0;

        testTT.load(amount);

        try {
            testTT.unLoad(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testTT.getCurrentLoadWeight(), amount);

        amount = -15.0;

        try {
            testTT.unLoad(amount);
            fail("Negative unload");
        } catch (Exception ex) {
            assertEquals("Negative unLoad amount: " + amount, ex.getMessage());
        }

        amount = 500.0;

        try {
            testTT.unLoad(amount);
            fail("Over unload");
        } catch (Exception ex) {
            assertEquals("UnLoading " + amount + " will make the load weight negative: "
                    + (testTT.getCurrentLoadWeight() + amount), ex.getMessage());
        }
    }

    /**
     * Test of atDestination method, of class TankerTruck.
     */
    @Test
    public void testAtDestination() {
        System.out.println("atDestination");

        boolean expResult = false;
        boolean result = testTT.atDestination();

        assertEquals(expResult, result);

        expResult = true;
        try {
            testTT.setLocation(testTT.getDestination());
        } catch (Exception ex) {
            fail(ex.toString());
        }
        result = testTT.atDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class TankerTruck.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testTT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination, testTT.getDestination());
    }

    /**
     * Test of getDestinationX method, of class TankerTruck.
     */
    @Test
    public void testGetDestinationX() {
        System.out.println("getDestinationX");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testTT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getX(), testTT.getDestinationX(), 0.0);
    }

    /**
     * Test of getDestinationY method, of class TankerTruck.
     */
    @Test
    public void testGetDestinationY() {
        System.out.println("getDestinationY");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testTT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getY(), testTT.getDestinationY(), 0.0);
    }

    /**
     * Test of getDestinationZ method, of class TankerTruck.
     */
    @Test
    public void testGetDestinationZ() {
        System.out.println("getDestinationZ");
        Point3D testDestination = new Point3D(2, 2, 2);
        try {
            testTT.setDestination(testDestination);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testDestination.getZ(), testTT.getDestinationZ(), 0.0);
    }

    /**
     * Test of getMaxSpeed method, of class TankerTruck.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        double maxSpd = 30.0;
        try {
            testTT.setMaxSpeed(maxSpd);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getMaxSpeed(), maxSpd, 0.0);
    }

    /**
     * Test of getSpeed method, of class TankerTruck.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        double spd = 30.0;
        try {
            testTT.setSpeed(spd);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getSpeed(), spd, 0.0);
    }

    /**
     * Test of setDestination method, of class TankerTruck.
     */
    @Test
    public void testSetDestination_3args() throws Exception {
        System.out.println("setDestination");

        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testTT.setDestination(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getDestinationX(), x, 0.0);
        assertEquals(testTT.getDestinationY(), y, 0.0);
        assertEquals(testTT.getDestinationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testTT.setDestination(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testTT.setDestination(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testTT.setDestination(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }
    }

    /**
     * Test of setDestination method, of class TankerTruck.
     */
    @Test
    public void testSetDestination_Point3D() throws Exception {
        System.out.println("setDestination");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testTT.setDestination(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getDestination(), aPoint);

        aPoint = new Point3D(-3, 4, 5);
        try {
            testTT.setDestination(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testTT.setDestination(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testTT.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = null;
        try {
            testTT.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Null Point3D sent to setDestination(Point3D)", ex.getMessage());
        }
    }

    /**
     * Test of setMaxSpeed method, of class TankerTruck.
     */
    @Test
    public void testSetMaxSpeed() throws Exception {
        System.out.println("setMaxSpeed");
        double ms = 500.0;

        try {
            testTT.setMaxSpeed(ms);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getMaxSpeed(), ms, 0.0);

        ms = -10.0;
        try {
            testTT.setMaxSpeed(ms);
            fail("Negative max speed");
        } catch (Exception ex) {
            assertEquals("Negative maxSpeed sent to setMaxSpeed:" + ms, ex.getMessage());
        }

        ms = 10.0;
        try {
            testTT.setMaxSpeed(ms);
            fail("max speed less than speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set maxSpeed less than speed in setMaxSpeed: " + ms, ex.getMessage());
        }
    }

    /**
     * Test of setSpeed method, of class TankerTruck.
     */
    @Test
    public void testSetSpeed() throws Exception {
        System.out.println("setSpeed");
        double s = 30.0;

        try {
            testTT.setSpeed(s);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getSpeed(), s, 0.0);
        s = -10.0;
        try {
            testTT.setSpeed(s);
            fail("negative speed");
        } catch (Exception ex) {
            assertEquals("Negative speed sent to setSpeed:" + s, ex.getMessage());
        }

        s = 500.0;
        try {
            testTT.setSpeed(s);
            fail("over max speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set speed (" + s + ") greater than maxSpeed (" + testTT.getMaxSpeed()
                    + ") in setSpeed", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class TankerTruck.
     */
    @Test
    public void testDistance_Point3D() throws Exception {
        System.out.println("distance");
        Point3D loc = new Point3D(5, 5, 5);
        double expResult = loc.distance(testTT.getLocation());
        double result;

        result = testTT.distance(loc);
        assertEquals(expResult, result, 0.0);

        loc = null;

        try {
            result = testTT.distance(loc);
            fail("null location");
        } catch (Exception ex) {
            assertEquals("Null location sent to distance", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class TankerTruck.
     */
    @Test
    public void testDistance_3args() throws Exception {
        System.out.println("distance");
        double x = 5.0;
        double y = 5.0;
        double z = 5.0;

        Point3D aPoint = new Point3D(x, y, z);
        double result = testTT.distance(aPoint.getX(), aPoint.getY(), aPoint.getZ());
        double expResult = testTT.distance(x, y, z);
        assertEquals(expResult, result, 0.0);

        x = -5.0;
        y = 5.0;
        z = 5.0;

        try {
            testTT.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = -5.0;
        z = 5.0;

        try {
            testTT.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = 5.0;
        z = -5.0;

        try {
            testTT.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of getLocation method, of class TankerTruck.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testTT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation, testTT.getLocation());
    }

    /**
     * Test of getLocationX method, of class TankerTruck.
     */
    @Test
    public void testGetLocationX() {
        System.out.println("getLocationX");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testTT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getX(), testTT.getLocationX(), 0.0);
    }

    /**
     * Test of getLocationY method, of class TankerTruck.
     */
    @Test
    public void testGetLocationY() {
        System.out.println("getLocationY");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testTT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getY(), testTT.getLocationY(), 0.0);
    }

    /**
     * Test of getLocationZ method, of class TankerTruck.
     */
    @Test
    public void testGetLocationZ() {
        System.out.println("getLocationZ");
        Point3D testLocation = new Point3D(2, 2, 2);
        try {
            testTT.setLocation(testLocation);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(testLocation.getZ(), testTT.getLocationZ(), 0.0);
    }

    /**
     * Test of setLocation method, of class TankerTruck.
     */
    @Test
    public void testSetLocation_Point3D() throws Exception {
        System.out.println("setLocation");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testTT.setLocation(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getLocation(), aPoint);

        aPoint = null;
        try {
            testTT.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Null location sent to setLocation", ex.getMessage());
        }

        aPoint = new Point3D(-3, 4, 5);
        try {
            testTT.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testTT.setLocation(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testTT.setLocation(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of setLocation method, of class TankerTruck.
     */
    @Test
    public void testSetLocation_3args() throws Exception {
        System.out.println("setLocation");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testTT.setLocation(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTT.getLocationX(), x, 0.0);
        assertEquals(testTT.getLocationY(), y, 0.0);
        assertEquals(testTT.getLocationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testTT.setLocation(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testTT.setLocation(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testTT.setLocation(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }
    }

    /**
     * Test of getIdentifier method, of class TankerTruck.
     */
    @Test
    public void testGetIdentifier() throws Exception {
        System.out.println("getIdentifier");
        TankerTruck test = new TankerTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testTT = test;
        String expResult = test.getIdentifier();
        String result = testTT.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxLoadWeight method, of class TankerTruck.
     */
    @Test
    public void testGetMaxLoadWeight() {
        System.out.println("getMaxLoadWeight");
        System.out.println("getMaxLoadWeight");
        TankerTruck instance = testTT;
        double result = instance.getMaxLoadWeight();
        double expResult = testTT.getMaxLoadWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCurrentLoadWeight method, of class TankerTruck.
     */
    @Test
    public void testSetCurrentLoadWeight() {
        System.out.println("setCurrentLoadWeight");
        double amount = 300.0;

        try {
            testTT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testTT.getCurrentLoadWeight(), 0.0);

        testTT.setCurrentLoadWeight(0);
        amount = 0.0;

        try {
            testTT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount, testTT.getCurrentLoadWeight(), 0.0);
        testTT.setCurrentLoadWeight(0);
        amount = -50.0;

        try {
            testTT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            assertEquals("Negative unLoad amount: " + amount, ex.getMessage());
        }
        testTT.setCurrentLoadWeight(0);
        amount = 500.0;

        try {
            testTT.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            assertEquals("Additional load of " + amount + " will make the load weight "
                    + (testTT.getCurrentLoadWeight() + amount) + " which exceeds the max load weight of " + testTT.getMaxLoadWeight(), ex.getMessage());
        }
    }

    /**
     * Test of getCurrentLoadWeight method, of class TankerTruck.
     */
    @Test
    public void testGetCurrentLoadWeight() {
        System.out.println("getCurrentLoadWeight");
        TankerTruck instance = testTT;
        double result = instance.getCurrentLoadWeight();
        double expResult = testTT.getCurrentLoadWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of update method, of class TankerTruck.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        double millis = System.currentTimeMillis();
        TankerTruck aTruck = new TankerTruck(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testTT.update(millis);
        aTruck.update(millis);
        Point3D result = testTT.getLocation();
        Point3D expResult = aTruck.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class TankerTruck.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        assertEquals("I am TankerTruck " + testTT.getIdentifier() + ".\n\tI am at "
                    + testTT.getLocation() + " and am heading to " + testTT.getDestination()
                    + ".\n\tMy load is " + testTT.getCurrentLoadWeight() + " and my max load is "
                    + testTT.getMaxLoadWeight() + ".\n\tDistance to my destination is "
                    + String.format("%4.2f", testTT.distance(testTT.getDestination())) + ". "
                    + (testTT.atDestination() ? "I am there!" : "I'm not there yet"),testTT.toString());
    }

}
