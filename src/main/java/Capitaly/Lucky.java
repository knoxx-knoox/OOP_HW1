/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public class Lucky extends Field {
    private int _money;
    public Lucky(int title_index, int money){
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
     * When a player lands on this field, they receive a certain amount of money from the bank.
     * @param p Player
     * @param gm GameManager
     */
    @Override
    public void here(Player p, GameManager gm) {
        if(p.isActive()){
            if(p.bank2p(this._money, gm)){
                System.out.println(p.getName() + " got paid lucky " + this._money + " from bank");
            }
        }
    }
}
