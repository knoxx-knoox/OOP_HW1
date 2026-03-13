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
public class TacticalTest {
    
    public TacticalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of buy method, of class Tactical.
     */
    @Test
    public void testBuy() {
        System.out.println("buy");
        Player p = new Player("test","tactical");
        p.setMoney(1000);
        int cost = 400;
        Tactical instance = new Tactical();
        boolean expResult = true;
        boolean result = instance.buy(p, cost);
        assertEquals(expResult, result);
        cost = 600;
        expResult = false;
        result = instance.buy(p, cost);
        assertEquals(expResult, result);
    }
    
}
