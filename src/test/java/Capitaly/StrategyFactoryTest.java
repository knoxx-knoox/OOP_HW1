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
public class StrategyFactoryTest {
    
    public StrategyFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of createStrategy method, of class StrategyFactory.
     */
    @Test
    public void testCreateStrategy() {
        System.out.println("createStrategy");
        StrategyFactory instance = new StrategyFactory();
        
        Strategy result1 = instance.createStrategy("CAREFUL");
        assertTrue(result1 instanceof Careful);
        
        Strategy result2 = instance.createStrategy("GREEDY");
        assertTrue(result2 instanceof Greedy);
        
        Strategy result3 = instance.createStrategy("TACTICAL");
        assertTrue(result3 instanceof Tactical);
        
        try {
            instance.createStrategy("RANDOM");
            fail("Expected IllegalArgumentException for RANDOM strategy type");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
    
}
