/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public abstract class Field {
    public int tile_index;
    public Field(int tile_index) {
        this.tile_index = tile_index;
    }
    /**
     * This method is called when a player is on this field.
     * @param p the player who is on this field
     * @param gm the game manager
     */
    public abstract void here(Player p, GameManager gm);

    public int getTile_index() {
        return tile_index;
    }

    public void setTile_index(int tile_index) {
        this.tile_index = tile_index;
    }
    
}
