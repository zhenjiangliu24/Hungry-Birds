/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungryBrids;
import java.util.*;
/**
 *
 * @author ZhenjiangLiu
 */


public class Location {
    public Coordinate coordinate;
    public boolean isLegal;
    public Location(String input){
        String []xRange = {"A","B","C","D","E","F","G","H"};
        String X = input.substring(0, 1);
        String Y = input.substring(1);
        if(Arrays.asList(xRange).contains(X) && isYValid(Y)){
            String XY = X+Y;
            this.coordinate = Coordinate.valueOf(XY);
            this.isLegal = true;
        }else{
            this.coordinate = null;
            this.isLegal = false;
            System.out.println("The location input is not correct");
        }
    }
    
    public static boolean isYValid(String Y){
        int tempY = Integer.parseInt(Y);
        boolean isValid = false;
        int []yRange = {0,1,2,3,4,5,6,7,8};
        for(int i : yRange){
            if(tempY==i){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
    
    
    @Override
    public String toString(){
        return this.coordinate.toString();
    }
}
