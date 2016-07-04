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
public class Player2_Birds extends Player{
    Bird []birds;
    boolean winGame;
    public Player2_Birds(Location location1, Location location2, Location location3, Location location4){
        Bird bird1 = new Bird(location1);
        Bird bird2 = new Bird(location2);
        Bird bird3 = new Bird(location3);
        Bird bird4 = new Bird(location4);
        this.birds = new Bird[]{bird1,bird2,bird3,bird4};
        this.winGame = false;
    }
}
