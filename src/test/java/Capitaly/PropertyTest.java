/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Capitaly;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author knoxy
 */
public class PropertyTest {
    
    public PropertyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of isHasHause method, of class Property.
     */
    @Test
    public void testIsHasHause() {
        System.out.println("isHasHause");
        Property instance = new Property(0, 100);
        boolean expResult = false;
        boolean result = instance.isHasHause();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOwner method, of class Property.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        Property instance = new Property(0, 100);
        Player owner = new Player("TestPlayer","Careful");
        instance.setOwner(owner);
        assertEquals(owner, instance.getOwner());
    }

    /**
     * Test of setHasHause method, of class Property.
     */
    @Test
    public void testSetHasHause() {
        System.out.println("setHasHause");
        Property instance = new Property(0, 100);
        instance.setHasHause(true);
        assertEquals(true, instance.isHasHause());
    }

    /**
     * Test of clear method, of class Property.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Property instance = new Property(0,100);
        instance.clear();
        assertEquals(100, instance.getMoney());
        assertEquals(null, instance.getOwner());
        assertEquals(false, instance.isHasHause());
        assertEquals(0, instance.getTile_index());
    }
}
