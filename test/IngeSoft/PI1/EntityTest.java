/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngeSoft.PI1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pippo
 */
public class EntityTest {
    
    public EntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setNome method, of class Entity.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String _nome = "";
        Entity instance = new Entity();
        instance.setNome(_nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodice method, of class Entity.
     */
    @Test
    public void testSetCodice() {
        System.out.println("setCodice");
        String _codice = "";
        Entity instance = new Entity();
        instance.setCodice(_codice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Nome method, of class Entity.
     */
    @Test
    public void testNome() {
        System.out.println("Nome");
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Codice method, of class Entity.
     */
    @Test
    public void testCodice() {
        System.out.println("Codice");
        Entity instance = new Entity();
        String expResult = "";
        String result = instance.getCodice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Entity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Entity instance = new Entity();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
