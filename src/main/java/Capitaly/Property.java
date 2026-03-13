/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitaly;

/**
 *
 * @author knoxy
 */
public class Property extends Field{
    private int _money;
    private Player _owner;
    private boolean _hasHause;

    public Property(int tile_index,int money) {
        super(tile_index);
        this._money = money;
        this._owner = null;
        this._hasHause = false;
    }

    public int getMoney() {
        return _money;
    }

    public Player getOwner() {
        return _owner;
    }

    public boolean isHasHause() {
        return _hasHause;
    }

    public int getTile_index() {
        return tile_index;
    }

    public void setMoney(int _money) {
        this._money = _money;
    }

    public void setOwner(Player _owner) {
        this._owner = _owner;
    }

    public void setHasHause(boolean _hasHause) {
        this._hasHause = _hasHause;
    }

    public void setTile_index(int tile_index) {
        this.tile_index = tile_index;
    }
    
    public void clear(){
        if(this._owner!=null){
            this._owner.removeProperty(this);
        }
        this._owner=null;
        this._hasHause=false;
    }
    /**
     * Method that is called when a player lands on this field.
     * We check if the player is active, if the property has an owner, if the player can buy the property,
     * if the player can build a house, or if the player needs to pay rent.
     * @param p Player
     * @param gm GameManager
     * @throws IllegalStateException if there is a bug in the logic.
     */
    @Override
    public void here(Player p,GameManager gm){
        if(p.isActive()==false){
            return;
        }
        if(this._owner==null){
            if(p.buy(this._money)){
                if(p.p2bank(this._money,gm)){
                    this._owner=p;
                    p.addProperty(this);
                    System.out.println(p.getName()+" got property "+this.tile_index);
                }
            }
        }
        else if (this._owner == p &&  this._hasHause==false){
            if(p.buy(this._money*4)){
                if(p.p2bank(this._money*4,gm)){
                    this._hasHause=true;
                    System.out.println(p.getName()+" built hause on property "+this.tile_index);
                }
            }
        }
        else if(this._owner != p){
            int rent;
            if(this._hasHause==true){
                rent=this._money*2;
            }
            else{
                rent=this._money/2;
            }
            if(p.p2p(rent,this._owner,gm)){
                System.out.println(p.getName()+" paid "+rent+" to "+this._owner.getName()+" on property "+this.tile_index);
            }
        }
        else if (this._owner == p &&  this._hasHause==true){
            return;
        }
        else{
            throw new IllegalStateException("There is a bug in Property.java");
        }
    }
}