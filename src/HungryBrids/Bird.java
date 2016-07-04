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
public class Bird {
    Location location;
    public Bird(Location location){
        this.location = location;
    }
    
    public void setLocation(String location)
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
        if (currentY == 8) {
            moveSuccess = false;
        } else {
            switch (currentX) {
                case "A":
                    if (moveX.equals("B") && moveY==currentY+1) {
                        Location newLocation = new Location(location);
                        this.location = newLocation;
                        moveSuccess = true;
                    }
                    break;
                case "B":
                    if(moveX.equals("A")||moveX.equals("C")){
                        if(moveY==currentY+1){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                    break;
                case "C":
                    if(moveX.equals("B")||moveX.equals("D")){
                        if(moveY==currentY+1){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                    break;
                case "D":
                    if(moveX.equals("C")||moveX.equals("E")){
                        if(moveY==currentY+1){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                    break;
                case "E":
                    if(moveX.equals("D")||moveX.equals("F")){
                        if(moveY==currentY+1){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                    break;
                case "F":
                    if(moveX.equals("E")||moveX.equals("G")){
                        if(moveY==currentY+1){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                    break;
                case "G":
                    if(moveX.equals("F")||moveX.equals("H")){
                        if(moveY==currentY+1){
                            Location newLocation = new Location(location);
                            this.location = newLocation;
                            moveSuccess = true;
                        }
                    }
                    break;
                case "H":
                    if (moveX.equals("G") && moveY==currentY+1) {
                        Location newLocation = new Location(location);
                        this.location = newLocation;
                        moveSuccess = true;
                    }
                    break;
            }
        }
        
        return moveSuccess;
    }
}
