/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public class Service extends Field {
    private int _money;
    public Service(int title_index, int money){
        super(title_index);
        this._money = money;
    }

    public int getMoney() {
        return _money;
    }

    public int getTile_index() {
        return tile_index;
    }

    public void setMoney(int _money) {
        this._money = _money;
    }

    public void setTile_index(int tile_index) {
        this.tile_index = tile_index;
    }
    /**
     * Player pays money to bank
     * @param p Player
     * @param gm GameManager
     */
    @Override
    public void here(Player p, GameManager gm) {
        if(p.isActive()){
            if(p.p2bank(this._money, gm)){
                System.out.println(p.getName() + " paid service " + this._money + " to bank");
            }
        }
    }
}