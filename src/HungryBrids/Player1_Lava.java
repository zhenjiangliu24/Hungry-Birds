/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungryBrids;

/**
 *
 * @author ZhenjiangLiu
 */
public class Player1_Lava extends Player{
    Lava lava;
    boolean winGame;
    public Player1_Lava(Location location){
        this.lava = new Lava(location);
        this.winGame = false;
    }
    
}
