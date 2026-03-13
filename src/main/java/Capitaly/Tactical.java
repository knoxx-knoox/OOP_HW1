/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public class Tactical extends Strategy {
    private boolean _switch = true;
    /**
     * Override the buy method to implement the tactical strategy as described.
     * @param p Player
     * @param cost the cost of the property
     * @return true if the player can buy the property, false otherwise
     * @see _switch to alternate between buying and not buying
     */
    @Override
    public boolean buy(Player p, int cost) {
        if(_switch == false){
            _switch = true;
            return false;
        }
        else{
            _switch = false;
            return p.getMoney() >= cost;
        }
    }
}
