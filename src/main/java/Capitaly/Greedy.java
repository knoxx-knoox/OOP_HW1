/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public class Greedy extends Strategy {
    /**
     * Override the buy method to implement the greedy strategy as described.
     * @param p Player
     * @param cost the cost of the property
     * @return true if the player can buy the property, false otherwise
     */
    @Override
    public boolean buy(Player p, int cost) {
        if (p.getMoney() >= cost) {
            return true;
        }
        return false;
    }
}
