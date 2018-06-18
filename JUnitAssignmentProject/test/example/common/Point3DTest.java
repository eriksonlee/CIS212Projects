/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.common;

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
public class Point3DTest {

    private Point3D testPoint;
    public double testX = 0.0;
    public double testY = 0.0;
    public double testZ = 0.0;

    public Point3DTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testPoint = new Point3D(testX,testY,testZ);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getZ method, of class Point3D.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        assertEquals(testZ,testPoint.getZ(),0.0);
    }

    /**
     * Test of setLocation method, of class Point3D, passing a point object.
     */
    @Test
    public void testSetLocation_Point3D() {
        System.out.println("setLocation, point object");
        Point3D aPoint = new Point3D(0, 0, 0);
        Point3D instance = new Point3D();
        instance.setLocation(aPoint);
        assertEquals(instance.getX(), aPoint.getX(), 0.0);
        assertEquals(instance.getY(), aPoint.getY(), 0.0);
        assertEquals(instance.getZ(), aPoint.getZ(), 0.0);
    }

    /**
     * Test of setLocation method, of class Point3D, passing 3 coordinates.
     */
    @Test
    public void testSetLocation_3args() {
        System.out.println("setLocation, 3 args");
        double xIn = 0.0;
        double yIn = 0.0;
        double zIn = 0.0;
        Point3D instance = new Point3D();
        instance.setLocation(xIn, yIn, zIn);
        assertEquals(instance.getX(), xIn, 0.0);
        assertEquals(instance.getY(), yIn, 0.0);
        assertEquals(instance.getZ(), zIn, 0.0);
    }

    /**
     * Test of setCoordinates method, of class Point3D, passing a point object.
     */
    @Test
    public void testSetCoordinates_Point3D() {
        System.out.println("setCoordinates, point object");
        double xIn = 10.0;
        double yIn = 5.0;
        double zIn = 7.0;
        Point3D aPoint = new Point3D(xIn, yIn, zIn);
        Point3D instance = new Point3D();
        instance.setCoordinates(aPoint);
        assertEquals(instance.getX(), xIn, 0.0);
        assertEquals(instance.getY(), yIn, 0.0);
        assertEquals(instance.getZ(), zIn, 0.0);

    }

    /**
     * Test of setCoordinates method, of class Point3D, passing 3 coordinate
     * args.
     */
    @Test
    public void testSetCoordinates_3args() {
        System.out.println("setCoordinates, 3 args");
        double xIn = 10.0;
        double yIn = 5.0;
        double zIn = 7.0;
        Point3D instance = new Point3D();
        instance.setCoordinates(xIn, yIn, zIn);
        assertEquals(instance.getX(), xIn, 0.0);
        assertEquals(instance.getY(), yIn, 0.0);
        assertEquals(instance.getZ(), zIn, 0.0);

    }

    /**
     * Test of toString method, of class Point3D, passing coordinates.
     */
    @Test
    public void testToStringCoord() {
        System.out.println("toString, coordinates");
        Point3D instance = new Point3D(3, 4, 5);
        String expResult = "[3.00, 4.00, 5.00]";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Point3D, passing, point object.
     */
    @Test
    public void testToStringObject() {
        System.out.println("toString, point object");
        Point3D aPoint = new Point3D(3, 4, 5);
        Point3D instance = new Point3D(aPoint);
        String expResult = "[3.00, 4.00, 5.00]";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of distance method, of class Point3D, passing 3 args.
     */
    @Test
    public void testDistance_3args() {
        System.out.println("distance, 3 args");
        double xIn = 4.0;
        double yIn = 2.0;
        double zIn = 8.0;
        Point3D instance = new Point3D();
        double expResult = Math.sqrt(xIn * xIn + yIn * yIn + zIn * zIn);
        double result = instance.distance(xIn, yIn, zIn);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of distance method, of class Point3D, passing a point object.
     */
    @Test
    public void testDistance_Point3D() {
        System.out.println("distance, point object");
        Point3D aPoint = new Point3D(12, 10005, 3);
        Point3D instance = new Point3D();
        double expResult = Math.sqrt(aPoint.getX() * aPoint.getX() + aPoint.getY() * aPoint.getY() + aPoint.getZ() * aPoint.getZ());
        double result = instance.distance(aPoint);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of equals method, of class Point3D, false case.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Point3D aPoint3D = new Point3D(3, 4, 5);
        Point3D instance = new Point3D(1, 2, 3);
        boolean expResult = false;
        boolean result = instance.equals(aPoint3D);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

}
