/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.truck;

import example.common.Point3D;
import example.identification.IdentifiableImpl;
import example.movement.MovableImpl;
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
public class TruckImplTest {

    private TruckImpl testTruckImp;
    public double testMaxLoadWeight = 300.0;
    public double testCurrentLoadWeight = 0.0;
    public Point3D testLoc = new Point3D(0, 0, 0);
    public Point3D testDest = new Point3D(1, 1, 1);
    public double testSpeed = 12.0;
    public double testMaxSpd = 150.0;
    public MovableImpl testMovable;
    public IdentifiableImpl testIdentity;

    public TruckImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

        testTruckImp = new TruckImpl(testLoc, testDest, testSpeed, testMaxSpd, testMaxLoadWeight);
    }

    @After
    public void tearDown() {
        testTruckImp = null;
    }

    /**
     * Test of load method, of class TruckImpl.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        double amount = 10.0;

        try {
            testTruckImp.load(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testTruckImp.getCurrentLoadWeight(), 0.0);
        assertEquals()
        double amount2 = 30.0;

        try {
            testTruckImp.load(amount2);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount + amount2, testTruckImp.getCurrentLoadWeight(), 0.0);

        amount = -10.0;

        try {
            testTruckImp.load(amount);
            fail("negative load amount");
        } catch (Exception ex) {
            assertEquals("Negative load amount: " + amount, ex.getMessage());
        }

        amount = 500.0;
        try {
            testTruckImp.load(amount);
            fail("negative load amount");
        } catch (Exception ex) {
            assertEquals("Additional load of " + amount + " will make the load weight "
                    + (testTruckImp.getCurrentLoadWeight() + amount) + " which exceeds the max load weight of " + testTruckImp.getMaxLoadWeight(), ex.getMessage());
        }
    }

    /**
     * Test of unLoad method, of class TruckImpl.
     */
    @Test
    public void testUnLoad() throws Exception {
        System.out.println("unLoad");
        double amount = 300.0;

        testTruckImp.load(amount);

        try {
            testTruckImp.unLoad(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testTruckImp.getCurrentLoadWeight(), amount);

        amount = -15.0;

        try {
            testTruckImp.unLoad(amount);
            fail("Partial unload");
        } catch (Exception ex) {
            assertEquals("Negative unLoad amount: " + amount, ex.getMessage());
        }

        amount = 500.0;

        try {
            testTruckImp.unLoad(amount);
            fail("Over unload");
        } catch (Exception ex) {
            assertEquals("UnLoading " + amount + " will make the load weight negative: "
                    + (testTruckImp.getCurrentLoadWeight() + amount), ex.getMessage());
        }
    }

    /**
     * Test of atDestination method, of class TruckImpl.
     */
    @Test
    public void testAtDestination() {
        System.out.println("atDestination");
        boolean expResult = false;
        boolean result = testTruckImp.atDestination();

        assertEquals(expResult, result);

        expResult = true;
        try {
            testTruckImp.setLocation(testTruckImp.getDestination());
        } catch (Exception ex) {
            fail(ex.toString());
        }
        result = testTruckImp.atDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class TruckImpl.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        assertEquals(testDest, testTruckImp.getDestination());
    }

    /**
     * Test of getDestinationX method, of class TruckImpl.
     */
    @Test
    public void testGetDestinationX() {
        System.out.println("getDestinationX");
        assertEquals(testDest.getX(), testTruckImp.getDestinationX(), 0.0);
    }

    /**
     * Test of getDestinationY method, of class TruckImpl.
     */
    @Test
    public void testGetDestinationY() {
        System.out.println("getDestinationY");
        assertEquals(testDest.getY(), testTruckImp.getDestinationY(), 0.0);
    }

    /**
     * Test of getDestinationZ method, of class TruckImpl.
     */
    @Test
    public void testGetDestinationZ() {
        System.out.println("getDestinationZ");
        assertEquals(testDest.getZ(), testTruckImp.getDestinationZ(), 0.0);
    }

    /**
     * Test of getMaxSpeed method, of class TruckImpl.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        assertEquals(testMaxSpd, testTruckImp.getMaxSpeed(), 0.0);
    }

    /**
     * Test of getSpeed method, of class TruckImpl.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        assertEquals(testSpeed, testTruckImp.getSpeed(), 0.0);
    }

    /**
     * Test of setDestination method, of class TruckImpl.
     */
    @Test
    public void testSetDestination_3args() throws Exception {
        System.out.println("setDestination");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testTruckImp.setDestination(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTruckImp.getDestinationX(), x, 0.0);
        assertEquals(testTruckImp.getDestinationY(), y, 0.0);
        assertEquals(testTruckImp.getDestinationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testTruckImp.setDestination(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testTruckImp.setDestination(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testTruckImp.setDestination(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }
    }

    /**
     * Test of setDestination method, of class TruckImpl.
     */
    @Test
    public void testSetDestination_Point3D() throws Exception {
        System.out.println("setDestination");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testTruckImp.setDestination(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTruckImp.getDestination(), aPoint);

        aPoint = new Point3D(-3, 4, 5);
        try {
            testTruckImp.setDestination(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testTruckImp.setDestination(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testTruckImp.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = null;
        try {
            testTruckImp.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Null Point3D sent to setDestination(Point3D)", ex.getMessage());
        }
    }

    /**
     * Test of setMaxSpeed method, of class TruckImpl.
     */
    @Test
    public void testSetMaxSpeed() throws Exception {
        System.out.println("setMaxSpeed");
        double ms = 500.0;

        try {
            testTruckImp.setMaxSpeed(ms);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTruckImp.getMaxSpeed(), ms, 0.0);

        ms = -10.0;
        try {
            testTruckImp.setMaxSpeed(ms);
            fail("negative max speed");
        } catch (Exception ex) {
            assertEquals("Negative maxSpeed sent to setMaxSpeed:" + ms, ex.getMessage());
        }

        ms = 10.0;
        try {
            testTruckImp.setMaxSpeed(ms);
            fail("max less than speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set maxSpeed less than speed in setMaxSpeed: " + ms, ex.getMessage());
        }
    }

    /**
     * Test of setSpeed method, of class TruckImpl.
     */
    @Test
    public void testSetSpeed() throws Exception {
        System.out.println("setSpeed");
        double s = 30.0;

        try {
            testTruckImp.setSpeed(s);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTruckImp.getSpeed(), s, 0.0);
        s = -10.0;
        try {
            testTruckImp.setSpeed(s);
            fail("negative speed");
        } catch (Exception ex) {
            assertEquals("Negative speed sent to setSpeed:" + s, ex.getMessage());
        }

        s = 500.0;
        try {
            testTruckImp.setSpeed(s);
            fail("greater than max speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set speed (" + s + ") greater than maxSpeed (" + testTruckImp.getMaxSpeed()
                    + ") in setSpeed", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class TruckImpl.
     */
    @Test
    public void testDistance_Point3D() throws Exception {
        System.out.println("distance");
        Point3D loc = new Point3D(5, 5, 5);
        double expResult = loc.distance(testTruckImp.getLocation());
        double result;

        result = testTruckImp.distance(loc);
        assertEquals(expResult, result, 0.0);

        loc = null;

        try {
            result = testTruckImp.distance(loc);
            fail("null location");
        } catch (Exception ex) {
            assertEquals("Null location sent to distance", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class TruckImpl.
     */
    @Test
    public void testDistance_3args() throws Exception {
        System.out.println("distance");
        double x = 5.0;
        double y = 5.0;
        double z = 5.0;

        Point3D aPoint = new Point3D(x, y, z);
        double result = testTruckImp.distance(aPoint.getX(), aPoint.getY(), aPoint.getZ());
        double expResult = testTruckImp.distance(x, y, z);
        assertEquals(expResult, result, 0.0);

        x = -5.0;
        y = 5.0;
        z = 5.0;

        try {
            testTruckImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = -5.0;
        z = 5.0;

        try {
            testTruckImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = 5.0;
        z = -5.0;

        try {
            testTruckImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of getLocation method, of class TruckImpl.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        assertEquals(testLoc,testTruckImp.getLocation());
    }

    /**
     * Test of getLocationX method, of class TruckImpl.
     */
    @Test
    public void testGetLocationX() {
        System.out.println("getLocationX");
        assertEquals(testLoc.getX(),testTruckImp.getLocationX(),0.0);
    }

    /**
     * Test of getLocationY method, of class TruckImpl.
     */
    @Test
    public void testGetLocationY() {
        System.out.println("getLocationY");
        assertEquals(testLoc.getY(),testTruckImp.getLocationY(),0.0);
    }

    /**
     * Test of getLocationZ method, of class TruckImpl.
     */
    @Test
    public void testGetLocationZ() {
        System.out.println("getLocationZ");
        assertEquals(testLoc.getZ(),testTruckImp.getLocationZ(),0.0);
    }

    /**
     * Test of setLocation method, of class TruckImpl.
     */
    @Test
    public void testSetLocation_Point3D() throws Exception {
        System.out.println("setLocation");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testTruckImp.setLocation(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTruckImp.getLocation(), aPoint);

        aPoint = null;
        try {
            testTruckImp.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Null location sent to setLocation", ex.getMessage());
        }

        aPoint = new Point3D(-3, 4, 5);
        try {
            testTruckImp.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testTruckImp.setLocation(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testTruckImp.setLocation(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of setLocation method, of class TruckImpl.
     */
    @Test
    public void testSetLocation_3args() throws Exception {
        System.out.println("setLocation");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testTruckImp.setLocation(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testTruckImp.getLocationX(), x, 0.0);
        assertEquals(testTruckImp.getLocationY(), y, 0.0);
        assertEquals(testTruckImp.getLocationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testTruckImp.setLocation(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testTruckImp.setLocation(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testTruckImp.setLocation(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }
    }

    /**
     * Test of getMaxLoadWeight method, of class TruckImpl.
     */
    @Test
    public void testGetMaxLoadWeight() {
        System.out.println("getMaxLoadWeight");
        assertEquals(testMaxLoadWeight,testTruckImp.getMaxLoadWeight(),0.0);
    }

    /**
     * Test of setCurrentLoadWeight method, of class TruckImpl.
     */
    @Test
    public void testSetCurrentLoadWeight() {
        System.out.println("setCurrentLoadWeight");
        double amount = 300.0;

        try {
            testTruckImp.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());
        }
        assertEquals(amount, testTruckImp.getCurrentLoadWeight(), 0.0);

        testTruckImp.setCurrentLoadWeight(0);
        amount = 0.0;

        try {
            testTruckImp.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            fail(ex.toString());;
        }
        assertEquals(amount, testTruckImp.getCurrentLoadWeight(), 0.0);
        testTruckImp.setCurrentLoadWeight(0);
        amount = -50.0;

        try {
            testTruckImp.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            assertEquals("Negative unLoad amount: " + amount, ex.getMessage());
        }
        testTruckImp.setCurrentLoadWeight(0);
        amount = 500.0;

        try {
            testTruckImp.setCurrentLoadWeight(amount);
        } catch (Exception ex) {
            assertEquals("Additional load of " + amount + " will make the load weight "
                    + (testTruckImp.getCurrentLoadWeight() + amount) + " which exceeds the max load weight of " + testTruckImp.getMaxLoadWeight(), ex.getMessage());
        }
    }

    /**
     * Test of getCurrentLoadWeight method, of class TruckImpl.
     */
    @Test
    public void testGetCurrentLoadWeight() {
        System.out.println("getCurrentLoadWeight");
        assertEquals(testCurrentLoadWeight,testTruckImp.getCurrentLoadWeight(),0.0);
    }

    /**
     * Test of getIdentifier method, of class TruckImpl.
     */
    @Test
    public void testGetIdentifier() throws Exception {
        System.out.println("getIdentifier");
        TruckImpl test = new TruckImpl(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testTruckImp = test;
        String expResult = test.getIdentifier();
        String result = testTruckImp.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class TruckImpl.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        double millis = System.currentTimeMillis();
        TruckImpl aTruck = new TruckImpl(0, 0, 0, 1, 1, 1, 12.0, 150.0, 300.0);
        testTruckImp.update(millis);
        aTruck.update(millis);
        Point3D result = testTruckImp.getLocation();
        Point3D expResult = aTruck.getLocation();
        assertEquals(expResult, result);
    }

}
