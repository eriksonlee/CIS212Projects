/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.location;

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
public class LocatableImplTest {

    private LocatableImpl testLocImp;
    public Point3D testPoint = new Point3D(1, 2, 3);

    public LocatableImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testLocImp = new LocatableImpl(testPoint);
    }

    @After
    public void tearDown() {
        testLocImp = null;
    }

    /**
     * Test of getLocation method, of class LocatableImpl.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        assertEquals(testLocImp.getLocation(), testPoint);
    }

    /**
     * Test of getLocationX method, of class LocatableImpl.
     */
    @Test
    public void testGetLocationX() {
        System.out.println("getLocationX");
        assertEquals(testLocImp.getLocationX(), testPoint.getX(), 0.0);
    }

    /**
     * Test of getLocationY method, of class LocatableImpl.
     */
    @Test
    public void testGetLocationY() {
        System.out.println("getLocationY");
        assertEquals(testLocImp.getLocationY(), testPoint.getY(), 0.0);
    }

    /**
     * Test of getLocationZ method, of class LocatableImpl.
     */
    @Test
    public void testGetLocationZ() {
        System.out.println("getLocationZ");
        assertEquals(testLocImp.getLocationZ(), testPoint.getZ(), 0.0);
    }

    /**
     * Test of setLocation method, of class LocatableImpl.
     */
    @Test
    public void testSetLocation_Point3D() throws Exception {
        System.out.println("setLocation");
        Point3D aPoint = new Point3D(3, 4, 5);

        try {
            testLocImp.setLocation(aPoint);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testLocImp.getLocation(), aPoint);

        aPoint = null;
        try {
            testLocImp.setLocation(aPoint);
            fail("null pointer");
        } catch (Exception ex) {
            assertEquals("Null location sent to setLocation", ex.getMessage());
        }

        aPoint = new Point3D(-3, 4, 5);
        try {
            testLocImp.setLocation(aPoint);
            fail("negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, -4, 5);
        try {
            testLocImp.setLocation(aPoint);
            fail("negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }

        aPoint = new Point3D(3, 4, -5);
        try {
            testLocImp.setLocation(aPoint);
            fail("negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());
        }
    }

    /**
     * Test of setLocation method, of class LocatableImpl.
     */
    @Test
    public void testSetLocation_3args() throws Exception {
        System.out.println("setLocation");
        double x = 3.0;
        double y = 4.0;
        double z = 5.0;

        try {
            testLocImp.setLocation(x, y, z);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertEquals(testLocImp.getLocationX(), x, 0.0);
        assertEquals(testLocImp.getLocationY(), y, 0.0);
        assertEquals(testLocImp.getLocationZ(), z, 0.0);

        x = -1.0;
        y = 4.0;
        z = 5.0;

        try {
            testLocImp.setLocation(x, y, z);
            fail("Negative x value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = -4.0;
        z = 5.0;

        try {
            testLocImp.setLocation(x, y, z);
            fail("Negative y value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }

        x = 1.0;
        y = 4.0;
        z = -5.0;

        try {
            testLocImp.setLocation(x, y, z);
            fail("Negative z value");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to setLocation(x,y,z)", ex.getMessage());

        }
    }

    /**
     * Test of distance method, of class LocatableImpl.
     */
    @Test
    public void testDistance_Point3D() throws Exception {
        System.out.println("distance");
        Point3D loc = new Point3D(5, 5, 5);
        double expResult = loc.distance(testLocImp.getLocation());
        double result;

        result = testLocImp.distance(loc);
        assertEquals(expResult, result, 0.0);

        loc = null;

        try {
            result = testLocImp.distance(loc);
            fail("null location");
        } catch (Exception ex) {
            assertEquals("Null location sent to distance", ex.getMessage());
        }
    }

    /**
     * Test of distance method, of class LocatableImpl.
     */
    @Test
    public void testDistance_3args() throws Exception {
        System.out.println("distance");
        double x = 5.0;
        double y = 5.0;
        double z = 5.0;

        Point3D aPoint = new Point3D(x, y, z);
        double result = testLocImp.distance(aPoint.getX(), aPoint.getY(), aPoint.getZ());
        double expResult = testLocImp.distance(x, y, z);
        assertEquals(expResult, result, 0.0);

        x = -5.0;
        y = 5.0;
        z = 5.0;

        try {
            testLocImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = -5.0;
        z = 5.0;

        try {
            testLocImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }

        x = 5.0;
        y = 5.0;
        z = -5.0;

        try {
            testLocImp.distance(x, y, z);
            fail("negative location coordinate");
        } catch (Exception ex) {
            assertEquals("Invalid X,Y,Z point sent to distance(x,y,z)", ex.getMessage());
        }
    }

}
