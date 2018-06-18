/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.movement;

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
public class MovableImplTest {

    private MovableImpl testMoveImp;
    public Point3D testLoc = new Point3D(0, 0, 0);
    public Point3D testDest = new Point3D(1, 1, 1);
    public double testSpeed = 12.0;
    public double testMax = 150.0;

    public MovableImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testMoveImp = new MovableImpl(testLoc, testDest, testSpeed, testMax);

    }

    @After
    public void tearDown() {
        testMoveImp = null;
    }

    /**
     * Test of getDestination method, of class MovableImpl.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        assertEquals(testDest, testMoveImp.getDestination());
    }

    /**
     * Test of getDestinationX method, of class MovableImpl.
     */
    @Test
    public void testGetDestinationX() {
        System.out.println("getDestinationX");
        assertEquals(testDest.getX(), testMoveImp.getDestinationX(), 0.0);
    }

    /**
     * Test of getDestinationY method, of class MovableImpl.
     */
    @Test
    public void testGetDestinationY() {
        System.out.println("getDestinationY");
        assertEquals(testDest.getY(), testMoveImp.getDestinationY(), 0.0);
    }

    /**
     * Test of getDestinationZ method, of class MovableImpl.
     */
    @Test
    public void testGetDestinationZ() {
        System.out.println("getDestinationZ");
        assertEquals(testDest.getZ(), testMoveImp.getDestinationZ(), 0.0);
    }

    /**
     * Test of setDestination method, of class MovableImpl.
     */
    @Test
    public void testSetDestination_3args() throws Exception {
        System.out.println("setDestination");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testMoveImp.setDestination(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testMoveImp.getDestinationX(), x, 0.0);
        assertEquals(testMoveImp.getDestinationY(), y, 0.0);
        assertEquals(testMoveImp.getDestinationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testMoveImp.setDestination(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testMoveImp.setDestination(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testMoveImp.setDestination(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + x + "," + y + "," + z + ")", ex.getMessage());

        }
    }

    /**
     * Test of setDestination method, of class MovableImpl.
     */
    @Test
    public void testSetDestination_Point3D() throws Exception {
        System.out.println("setDestination");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testMoveImp.setDestination(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testMoveImp.getDestination(), aPoint);

        aPoint = new Point3D(-3, 4, 5);
        try {
            testMoveImp.setDestination(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testMoveImp.setDestination(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testMoveImp.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setDestination(x,y,z): (" + aPoint.getX() + "," + aPoint.getY() + "," + aPoint.getZ() + ")", ex.getMessage());
        }

        aPoint = null;
        try {
            testMoveImp.setDestination(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Null Point3D sent to setDestination(Point3D)", ex.getMessage());
        }
    }

    /**
     * Test of getSpeed method, of class MovableImpl.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        assertEquals(testSpeed,testMoveImp.getSpeed(),0.0);
    }

    /**
     * Test of setSpeed method, of class MovableImpl.
     */
    @Test
    public void testSetSpeed() throws Exception {
        System.out.println("setSpeed");
        double s = 30.0;

        try {
            testMoveImp.setSpeed(s);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testMoveImp.getSpeed(), s, 0.0);
        s = -10.0;
        try {
            testMoveImp.setSpeed(s);
            fail("negative speed");
        } catch (Exception ex) {
            assertEquals("Negative speed sent to setSpeed:" + s, ex.getMessage());
        }

        s = 500.0;
        try {
            testMoveImp.setSpeed(s);
            fail("over max speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set speed (" + s + ") greater than maxSpeed (" + testMoveImp.getMaxSpeed()
                    + ") in setSpeed", ex.getMessage());
        }
    }

    /**
     * Test of getMaxSpeed method, of class MovableImpl.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        assertEquals(testMax,testMoveImp.getMaxSpeed(),0.0);
    }

    /**
     * Test of setMaxSpeed method, of class MovableImpl.
     */
    @Test
    public void testSetMaxSpeed() throws Exception {
        System.out.println("setMaxSpeed");
        double ms = 500.0;

        try {
            testMoveImp.setMaxSpeed(ms);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testMoveImp.getMaxSpeed(), ms, 0.0);

        ms = -10.0;
        try {
            testMoveImp.setMaxSpeed(ms);
            fail("Negative max speed");
        } catch (Exception ex) {
            assertEquals("Negative maxSpeed sent to setMaxSpeed:" + ms, ex.getMessage());
        }

        ms = 10.0;
        try {
            testMoveImp.setMaxSpeed(ms);
            fail("max speed less than speed");
        } catch (Exception ex) {
            assertEquals("Attempt to set maxSpeed less than speed in setMaxSpeed: " + ms, ex.getMessage());
        }
    }

    /**
     * Test of atDestination method, of class MovableImpl.
     */
    @Test
    public void testAtDestination() {
        System.out.println("atDestination");
        boolean expResult = false;
        boolean result = testMoveImp.atDestination();

        assertEquals(expResult, result);

        expResult = true;
        try {
            testMoveImp.setLocation(testMoveImp.getDestination());
        } catch (Exception ex) {
            fail(ex.toString());
        }
        result = testMoveImp.atDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of distance method, of class MovableImpl.
     */
    @Test
    public void testDistance_Point3D() throws Exception {
        System.out.println("distance");
        Point3D loc = new Point3D(5, 5, 5);
        double expResult = loc.distance(testMoveImp.getLocation());
        double result;

        result = testMoveImp.distance(loc);
        assertEquals(expResult, result, 0.0);

        loc = null;

        try {
            result = testMoveImp.distance(loc);
            fail("null location");
        } catch (Exception ex) {
            assertEquals("Null location sent to distance", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class MovableImpl.
     */
    @Test
    public void testDistance_3args() throws Exception {
        System.out.println("distance");
        double x = 5.0;
        double y = 5.0;
        double z = 5.0;

        Point3D aPoint = new Point3D(x, y, z);
        double result = testMoveImp.distance(aPoint.getX(), aPoint.getY(), aPoint.getZ());
        double expResult = testMoveImp.distance(x, y, z);
        assertEquals(expResult, result, 0.0);

        x = -5.0;
        y = 5.0;
        z = 5.0;

        try {
            testMoveImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = -5.0;
        z = 5.0;

        try {
            testMoveImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = 5.0;
        z = -5.0;

        try {
            testMoveImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of getLocation method, of class MovableImpl.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        assertEquals(testLoc,testMoveImp.getLocation());
    }

    /**
     * Test of getLocationX method, of class MovableImpl.
     */
    @Test
    public void testGetLocationX() {
        System.out.println("getLocationX");
        assertEquals(testLoc.getX(),testMoveImp.getLocationX(),0.0);
    }

    /**
     * Test of getLocationY method, of class MovableImpl.
     */
    @Test
    public void testGetLocationY() {
        System.out.println("getLocationY");
        assertEquals(testLoc.getY(),testMoveImp.getLocationY(),0.0);
    }

    /**
     * Test of getLocationZ method, of class MovableImpl.
     */
    @Test
    public void testGetLocationZ() {
        System.out.println("getLocationZ");
        assertEquals(testLoc.getZ(),testMoveImp.getLocationZ(),0.0);
    }

    /**
     * Test of setLocation method, of class MovableImpl.
     */
    @Test
    public void testSetLocation_Point3D() throws Exception {
        System.out.println("setLocation");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testMoveImp.setLocation(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testMoveImp.getLocation(), aPoint);

        aPoint = null;
        try {
            testMoveImp.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Null location sent to setLocation", ex.getMessage());
        }

        aPoint = new Point3D(-3, 4, 5);
        try {
            testMoveImp.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testMoveImp.setLocation(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testMoveImp.setLocation(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of setLocation method, of class MovableImpl.
     */
    @Test
    public void testSetLocation_3args() throws Exception {
        System.out.println("setLocation");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testMoveImp.setLocation(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testMoveImp.getLocationX(), x, 0.0);
        assertEquals(testMoveImp.getLocationY(), y, 0.0);
        assertEquals(testMoveImp.getLocationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testMoveImp.setLocation(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testMoveImp.setLocation(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testMoveImp.setLocation(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }
    }

    /**
     * Test of update method, of class MovableImpl.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        double millis = System.currentTimeMillis();
        MovableImpl aMove = new MovableImpl(testLoc,testDest,testSpeed,testMax);
        testMoveImp.update(millis);
        aMove.update(millis);
        Point3D result = testMoveImp.getLocation();
        Point3D expResult = aMove.getLocation();
        assertEquals(expResult, result);
    }

}
