/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

import java.util.*;

/**
 *
 * @author knoxy
 */
public class Player {
    private String _name;
    private int _money = 10000;
    private int _position = 0;
    private Strategy _strategy;
    private List<Property> _properties = new ArrayList<>();
    private boolean _active = true;
    public Player(String name, String strategy) {
        this._name = name;
        this._strategy = new StrategyFactory().createStrategy(strategy);
    }

    public String getName() {
        return _name;
    }

    public int getMoney() {
        return _money;
    }

    public int getPosition() {
        return _position;
    }

    public Strategy getStrategy() {
        return _strategy;
    }

    public List<Property> getProperties() {
        return _properties;
    }

    public boolean isActive() {
        return _active;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setMoney(int _money) {
        this._money = _money;
    }

    public void setPosition(int _position) {
        this._position = _position;
    }

    public void setStrategy(Strategy _strategy) {
        this._strategy = _strategy;
    }

    public void setProperties(List<Property> _properties) {
        this._properties = _properties;
    }

    public void setActive(boolean _active) {
        this._active = _active;
    }
    public void move(int steps, int boardSize) {
        if (!_active){
            return;
        }
        _position = (_position + steps) % boardSize;
    }
    /**
     * Decides whether the player buys a property, building or not
     * @param cost
     * @return true if the player buys the property/building, false otherwise
     * @see _strategy
     */
    public boolean buy(int cost){
        if (!_active){
            return false;
        }
        else if(_strategy.buy(this, cost)){
            return true;
        }
        return false;
    }
    /**
     * Handles payment from player to bank
     * If the player goes bankrupt, sets _active to false, _money to 0 and clears _properties
     * @param cost the amount to pay
     * @param gm GameManager
     * @return false if the player goes bankrupt, true otherwise
     */
    public boolean p2bank(int cost, GameManager gm){
        _money -= cost;
        if (_money < 0){
            _active = false;
            _money = 0;
            for (Property p : _properties){
                p.setOwner(null);
            }
            _properties.clear();
            System.out.println(this._name + " has gone bankrupt!");
            return false;
        }
        return true;
    }
    /**
     * Handles payment from player to another player
     * If the player goes bankrupt, sets _active to false, _money to 0 and clears _properties
     * @param cost the amount to pay
     * @param other the player to pay
     * @param gm GameManager
     * @return false if the player goes bankrupt, true otherwise
     */
    public boolean p2p(int cost, Player other, GameManager gm){
        _money -= cost;
        other._money += cost;
        if (_money < 0){
            _active = false;
            _money = 0;
            for (Property p : _properties){
                p.setOwner(null);
            }
            _properties.clear();
            System.out.println(this._name + " has gone bankrupt!");
            return false;
        }
        return true;
    }
    /**
     * Handles payment from bank to player
     * @param cost the amount to pay
     * @param gm GameManager
     * @return true
     */
    public boolean bank2p(int cost, GameManager gm){
        _money += cost;
        return true;
    }
    /**
     * Adds money to the player
     * @param amount the amount to add
     */
    public void addMoney(int amount){
        _money += amount;
    }
    /**
     * Subtracts money from the player
     * @param amount the amount to subtract
     */
    public void addProperty(Property p){
        _properties.add(p);
    }
    /**
     * Removes a property from the player
     * @param p the property to remove
     */
    public void removeProperty(Property p){
        _properties.remove(p);
    }
    /**
     * Prints the player's status each round
     * @return a string with the player's name, money and properties
     */
    public String print_this_each_round(){
        String rtrn;
        rtrn = "Player: "+this._name+" Money: "+this._money+" Properties: ";
        if(this._properties.isEmpty()){
            rtrn = rtrn + "None";
        }
        else{
            for (Property p : _properties){
                rtrn = rtrn + p.getTile_index() + ", ";
            }
        }
        return rtrn;
    }
}
