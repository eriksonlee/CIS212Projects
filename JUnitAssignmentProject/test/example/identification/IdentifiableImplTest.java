/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.identification;

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
public class IdentifiableImplTest {
    
    private String testId = "testID";
    private IdentifiableImpl testIdImp;
    
    public IdentifiableImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        testIdImp = new IdentifiableImpl(testId);
    }
    
    @After
    public void tearDown() {
        testIdImp = null;
    }

    /**
     * Test of getIdentifier method, of class IdentifiableImpl.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        assertEquals(testId, testIdImp.getIdentifier());
        
    }

    /**
     * Test of setIdentifier method, of class IdentifiableImpl.
     */
    @Test
    public void testSetIdentifier() throws Exception {
        System.out.println("setIdentifier");
        String id = "testID";
        try{
            testIdImp.setIdentifier(id);
        }
        catch(Exception ex){
            fail(ex.getMessage());
        }
        assertEquals(id,testIdImp.getIdentifier());
        
        id = "";
        try{
            testIdImp.setIdentifier(id);
            fail("empty identifier");
        }
        catch(Exception ex){
            assertEquals("Null or empty ID passed to setIdentifier",ex.getMessage());
        }
        
        
        
        id = null;
        try{
            testIdImp.setIdentifier(id);
            fail("null identifier");
        }
        catch(Exception ex){
            assertEquals("Null or empty ID passed to setIdentifier",ex.getMessage());
        }
    }
    
}
