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
public class Lava {
    Location location;
    public Lava(Location location){
        this.location = location;
    }
    
    public void setLarvaLocation(String location)
    {
        Location newLocation = new Location(location);
        this.location = newLocation;
    }
    
    public boolean moveToLocation(String location)
    {
        boolean moveSuccess = false;
        String moveX = location.substring(0, 1);
        int moveY = Integer.parseInt(location.substring(1));
        String currentX = this.location.toString().substring(0, 1);
        int currentY = Integer.parseInt(this.location.toString().substring(1));
        switch(currentX){
            case "A":
                if(currentY == 8){
                    if(moveX.equals("B") && moveY==7){
                        Location newLocation = new Location(location);
                        this.location = newLocation;
                        moveSuccess = true;
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("B0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("B")){
                        if(((currentY+1 == moveY)||(currentY-1 == moveY))){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
            case "B":
                if(currentY == 8){
                    if(moveX.equals("A")||moveX.equals("C")){
                        if(currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("A0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("A")||moveX.equals("C")){
                        if(currentY+1 == moveY || currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
            case "C":
                if(currentY == 8){
                    if(moveX.equals("B")||moveX.equals("D")){
                        if(currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("B0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("B")||moveX.equals("D")){
                        if(currentY+1 == moveY || currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
            case "D":
                if(currentY == 8){
                    if(moveX.equals("C")||moveX.equals("E")){
                        if(currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("C0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("C")||moveX.equals("E")){
                        if(currentY+1 == moveY || currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
            case "E":
                if(currentY == 8){
                    if(moveX.equals("D")||moveX.equals("F")){
                        if(currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("D0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("D")||moveX.equals("F")){
                        if(currentY+1 == moveY || currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
            case "F":
                if(currentY == 8){
                    if(moveX.equals("E")||moveX.equals("G")){
                        if(currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("E0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("E")||moveX.equals("G")){
                        if(currentY+1 == moveY || currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
            case "G":
                if(currentY == 8){
                    if(moveX.equals("F")||moveX.equals("H")){
                        if(currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("F0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("F")||moveX.equals("H")){
                        if(currentY+1 == moveY || currentY-1 == moveY){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
            case "H":
                if(currentY == 8){
                    if(moveX.equals("G") && moveY==7){
                        Location newLocation = new Location(location);
                        this.location = newLocation;
                        moveSuccess = true;
                    }
                }else if(currentY == 1){
                    Location newLocation = new Location("B0");
                    this.location = newLocation;
                    moveSuccess = true;
                }else{
                    if(moveX.equals("G")){
                        if(((currentY+1 == moveY)||(currentY-1 == moveY))){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                }
                break;
        }
        
        return moveSuccess;
    }
}
