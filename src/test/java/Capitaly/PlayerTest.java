/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Capitaly;

import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author knoxy
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Player instance = new Player("TestPlayer", "Careful");
        int steps = 25;
        int boardSize = 10;
        int initialPosition = instance.getPosition();
        instance.move(steps, boardSize);
        int expectedPosition = (initialPosition + steps) % boardSize;
        assertEquals(expectedPosition, instance.getPosition());
    }
    /**
     * Test of p2bank method, of class Player.
     */
    @Test
    public void testP2bank() {
        System.out.println("p2bank");
        Player instance = new Player("TestPlayer", "Careful");
        int cost = 500;
        GameManager gm = null; // GameManager is not needed for this test
        int initialMoney = instance.getMoney();
        boolean result = instance.p2bank(cost, gm);
        assertTrue(result);
        assertEquals(initialMoney - cost, instance.getMoney());
    }

    /**
     * Test of p2p method, of class Player.
     */
    @Test
    public void testP2p() {
        System.out.println("p2p");
        int cost = 300;
        GameManager gm = null; // GameManager is not needed for this test
        Player payer = new Player("Payer", "Careful");
        Player payee = new Player("Payee", "Greedy");
        int initialPayerMoney = payer.getMoney();
        int initialPayeeMoney = payee.getMoney();
        boolean result = payer.p2p(cost, payee, gm);
        assertTrue(result);
        assertEquals(initialPayerMoney - cost, payer.getMoney());
        assertEquals(initialPayeeMoney + cost, payee.getMoney());
    }

    /**
     * Test of bank2p method, of class Player.
     */
    @Test
    public void testBank2p() {
        System.out.println("bank2p");
        int amount = 400;
        Player instance = new Player("TestPlayer", "Careful");
        int initialMoney = instance.getMoney();
        instance.bank2p(amount, null); // GameManager is not needed for this test
        assertEquals(initialMoney + amount, instance.getMoney());

    }

    /**
     * Test of addMoney method, of class Player.
     */
    @Test
    public void testAddMoney() {
        System.out.println("addMoney");
        Player instance = new Player("TestPlayer", "Careful");
        int initialMoney = instance.getMoney();
        int amount = 200;
        instance.addMoney(amount);
        assertEquals(initialMoney + amount, instance.getMoney());
    }

    /**
     * Test of addProperty method, of class Player.
     */
    @Test
    public void testAddProperty() {
        System.out.println("addProperty");
        Property p = new Property(1, 1000);
        Player instance = new Player("TestPlayer", "Careful");
        instance.addProperty(p);
        List<Property> properties = instance.getProperties();
        assertTrue(properties.contains(p));
        assertEquals(1, properties.size());
    }

    /**
     * Test of removeProperty method, of class Player.
     */
    @Test
    public void testRemoveProperty() {
        System.out.println("removeProperty");
        Property p = new Property(1, 1000);
        Player instance = new Player("TestPlayer", "Careful");
        instance.addProperty(p);
        instance.removeProperty(p);
        List<Property> properties = instance.getProperties();
        assertFalse(properties.contains(p));
        assertEquals(0, properties.size());
    }

    /**
     * Test of print_this_each_round method, of class Player.
     */
    @Test
    public void testPrint_this_each_round() {
        System.out.println("print_this_each_round");
        String playerName = "TestPlayer";
        Player instance = new Player(playerName, "Careful");
        instance.addMoney(1500);
        Property p1 = new Property(1, 1000);
        Property p2 = new Property(2, 1500);
        instance.addProperty(p1);
        instance.addProperty(p2);
        String result = instance.print_this_each_round();
        String expectedSubstring = "Player: " + playerName + " Money: 11500 Properties: 1, 2, ";
        assertEquals(expectedSubstring, result);
    }
    
}
