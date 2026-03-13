/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public abstract class Strategy {
    /**
     * Method to decide if a player will buy a property or not
     * @param p Player
     * @param cost the cost of the property
     * @return boolean
     */
    public abstract boolean buy(Player p,int cost);
}