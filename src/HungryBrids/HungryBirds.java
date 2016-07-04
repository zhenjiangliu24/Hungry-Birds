/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HungryBrids;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author ZhenjiangLiu
 */
enum PlayMode{
    onePlayer, TwoPlayer, Unselected
}
enum OnePlayerModeRule{
    PlayerBeLarva, PlayerBeBirds, Unselected
}
public class HungryBirds extends javax.swing.JFrame {
    Player1_Lava player1;
    Player2_Birds player2;
    JLabel lavaLabel;
    JLabel bird1Label;
    JLabel bird2Label;
    JLabel bird3Label;
    JLabel bird4Label;
    Map<String,JLabel> labelMap;
    PlayMode playMode;
    boolean gameRunning;
    OnePlayerModeRule onePlayerMode;
    List<String> LarvaTempMove;
    List<String> BirdsTempMove;
    String larvaCurrentLocation;
    int birdIndexToMoved[];
    /**
     * Creates new form HungryBirds
     */
    public HungryBirds() {
        initComponents();
        initHashMap();
        initGame();
    }
    
    private void initHashMap()
    {
        this.labelMap = new HashMap<String, JLabel>();
        this.labelMap.put("A1_position", this.A1_position);
        this.labelMap.put("A2_position", this.A2_position);
        this.labelMap.put("A3_position", this.A3_position);
        this.labelMap.put("A4_position", this.A4_position);
        this.labelMap.put("A5_position", this.A5_position);
        this.labelMap.put("A6_position", this.A6_position);
        this.labelMap.put("A7_position", this.A7_position);
        this.labelMap.put("A8_position", this.A8_position);
        
        this.labelMap.put("B1_position", this.B1_position);
        this.labelMap.put("B2_position", this.B2_position);
        this.labelMap.put("B3_position", this.B3_position);
        this.labelMap.put("B4_position", this.B4_position);
        this.labelMap.put("B5_position", this.B5_position);
        this.labelMap.put("B6_position", this.B6_position);
        this.labelMap.put("B7_position", this.B7_position);
        this.labelMap.put("B8_position", this.B8_position);
        
        this.labelMap.put("C1_position", this.C1_position);
        this.labelMap.put("C2_position", this.C2_position);
        this.labelMap.put("C3_position", this.C3_position);
        this.labelMap.put("C4_position", this.C4_position);
        this.labelMap.put("C5_position", this.C5_position);
        this.labelMap.put("C6_position", this.C6_position);
        this.labelMap.put("C7_position", this.C7_position);
        this.labelMap.put("C8_position", this.C8_position);
        
        this.labelMap.put("D1_position", this.D1_position);
        this.labelMap.put("D2_position", this.D2_position);
        this.labelMap.put("D3_position", this.D3_position);
        this.labelMap.put("D4_position", this.D4_position);
        this.labelMap.put("D5_position", this.D5_position);
        this.labelMap.put("D6_position", this.D6_position);
        this.labelMap.put("D7_position", this.D7_position);
        this.labelMap.put("D8_position", this.D8_position);
        
        this.labelMap.put("E1_position", this.E1_position);
        this.labelMap.put("E2_position", this.E2_position);
        this.labelMap.put("E3_position", this.E3_position);
        this.labelMap.put("E4_position", this.E4_position);
        this.labelMap.put("E5_position", this.E5_position);
        this.labelMap.put("E6_position", this.E6_position);
        this.labelMap.put("E7_position", this.E7_position);
        this.labelMap.put("E8_position", this.E8_position);
        
        this.labelMap.put("F1_position", this.F1_position);
        this.labelMap.put("F2_position", this.F2_position);
        this.labelMap.put("F3_position", this.F3_position);
        this.labelMap.put("F4_position", this.F4_position);
        this.labelMap.put("F5_position", this.F5_position);
        this.labelMap.put("F6_position", this.F6_position);
        this.labelMap.put("F7_position", this.F7_position);
        this.labelMap.put("F8_position", this.F8_position);
        
        this.labelMap.put("G1_position", this.G1_position);
        this.labelMap.put("G2_position", this.G2_position);
        this.labelMap.put("G3_position", this.G3_position);
        this.labelMap.put("G4_position", this.G4_position);
        this.labelMap.put("G5_position", this.G5_position);
        this.labelMap.put("G6_position", this.G6_position);
        this.labelMap.put("G7_position", this.G7_position);
        this.labelMap.put("G8_position", this.G8_position);
        
        this.labelMap.put("H1_position", this.H1_position);
        this.labelMap.put("H2_position", this.H2_position);
        this.labelMap.put("H3_position", this.H3_position);
        this.labelMap.put("H4_position", this.H4_position);
        this.labelMap.put("H5_position", this.H5_position);
        this.labelMap.put("H6_position", this.H6_position);
        this.labelMap.put("H7_position", this.H7_position);
        this.labelMap.put("H8_position", this.H8_position);
    }
    
    private void initChessBoard()
    {
        Component []chessBoardElements = this.ChessBoard.getComponents();
        for (Component chessBoardElement : chessBoardElements) {
            JLabel temp = (JLabel) chessBoardElement;
            Border border = LineBorder.createGrayLineBorder();
            temp.setText("");
            temp.setBorder(border);
            temp.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
    
    private void startGame()
    {
        if(!this.TwoPlayerSelection.isSelected() && !this.OnePlayerSelection.isSelected()){
            JOptionPane.showMessageDialog(null, "You need to select a play mode","WARNING",JOptionPane.WARNING_MESSAGE);
        }else if(this.gameRunning){
            JOptionPane.showMessageDialog(null, "The game is already running!","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            if(this.TwoPlayerSelection.isSelected()){
                this.playMode = PlayMode.TwoPlayer;
                this.Player1MoveButton.setEnabled(true);
                this.gameRunning = true;
            }else if(this.OnePlayerSelection.isSelected()){
                if(!this.PlayerLarvaRadio.isSelected() && !this.PlayerBirdsRadio.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please select Larva or Birds!","WARNING",JOptionPane.WARNING_MESSAGE);
                }else{
                    this.playMode = PlayMode.onePlayer;
                    this.gameRunning = true;
                    if(this.PlayerLarvaRadio.isSelected()){
                        this.Player1MoveButton.setEnabled(true);
                        this.onePlayerMode = OnePlayerModeRule.PlayerBeLarva;
                        
                    }else if(this.PlayerBirdsRadio.isSelected()){
                        //this.Player2MoveButton.setEnabled(true);
                        this.onePlayerMode = OnePlayerModeRule.PlayerBeBirds;
                        this.larvaCurrentLocation = "D2";
                        this.larvaAutoPlay();
                    }
                    
                }

            }
            
        }
        
    }
    
    private void initMarkLabel()
    {
        this.markLabel1.setText("1");
        this.markLabel2.setText("2");
        this.markLabel3.setText("3");
        this.markLabel4.setText("4");
        this.markLabel5.setText("5");
        this.markLabel6.setText("6");
        this.markLabel7.setText("7");
        this.markLabel8.setText("8");
        
    }
    
    private void initGame()
    {
        Location lavaLocation = new Location("D2");
        this.player1 = new Player1_Lava(lavaLocation);
        Location bird1Location = new Location("A1");
        Location bird2Location = new Location("C1");
        Location bird3Location = new Location("E1");
        Location bird4Location = new Location("G1");
        this.player2 = new Player2_Birds(bird1Location,bird2Location,bird3Location,bird4Location);
        drawBoard();
        this.Player1MoveButton.setEnabled(false);
        this.Player2MoveButton.setEnabled(false);
        this.gameRunning = false;
        this.Player1FromTextField.setText("");
        this.Player1ToTextField.setText("");
        this.Player2FromTextField.setText("");
        this.Player2ToTextField.setText("");
        this.buttonGroup.clearSelection();
        this.buttonGroup2.clearSelection();
        this.playMode = PlayMode.Unselected;
        this.onePlayerMode = OnePlayerModeRule.Unselected;
        this.LarvaTempMove = new ArrayList<>();
        this.BirdsTempMove = new ArrayList<>();
        
        this.birdIndexToMoved = new int[20];
    }
    
    private void drawBoard()
    {
        initChessBoard();
        initMarkLabel();
        String lavaLabelString = this.player1.lava.location.toString()+"_position";
        this.lavaLabel = this.labelMap.get(lavaLabelString);
        this.lavaLabel.setText("L");
        
        String bird1LabelString = this.player2.birds[0].location.toString()+"_position";
        String bird2LabelString = this.player2.birds[1].location.toString()+"_position";
        String bird3LabelString = this.player2.birds[2].location.toString()+"_position";
        String bird4LabelString = this.player2.birds[3].location.toString()+"_position";
        this.bird1Label = this.labelMap.get(bird1LabelString);
        this.bird2Label = this.labelMap.get(bird2LabelString);
        this.bird3Label = this.labelMap.get(bird3LabelString);
        this.bird4Label = this.labelMap.get(bird4LabelString);
        
        this.bird1Label.setText("B");
        this.bird2Label.setText("B");
        this.bird3Label.setText("B");
        this.bird4Label.setText("B");
        
    }
    
    private boolean destinationOccupied(String location)
    {
        boolean isOccupied = false;
        Bird []birds = this.player2.birds;
        for(Bird bird : birds){
            if(bird.location.toString().equals(location)){
                isOccupied = true;
                break;
            }
        }
        return isOccupied;
    }
    
    List<String> generateLarvaNextMove()
    {
        List<String> nextMove = new ArrayList<>();
        String currentX = this.player1.lava.location.toString().substring(0, 1);
        int currentY = Integer.parseInt(this.player1.lava.location.toString().substring(1));
        switch(currentX){
            case "A":
                if(currentY == 8){
                    if(!destinationOccupied("B7")){
                        nextMove.add("B7");
                    }
                }else if(currentY == 1){
                    if(!destinationOccupied("B2")){
                        nextMove.add("B2");
                    }
                }else{
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String larvaPossibleDest1 = "A"+ possibleY1;
                    String larvaPossibleDest2 = "A"+ possibleY2;
                    if(!destinationOccupied(larvaPossibleDest1)){
                        nextMove.add(larvaPossibleDest1);
                    }
                    if(!destinationOccupied(larvaPossibleDest2)){
                        nextMove.add(larvaPossibleDest2);
                    }
                }
                break;
            case "B":
                if(currentY == 8){
                    String possibleDest1 = "A7";
                    String possibleDest2 = "C7";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else if(currentY == 1){
                    String possibleDest1 = "A2";
                    String possibleDest2 = "C2";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else{
                    String possibleX1 = "A";
                    String possibleX2 = "C";
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String pLocation1 = possibleX1+possibleY1;
                    String pLocation2 = possibleX1+possibleY2;
                    String pLocation3 = possibleX2+possibleY1;
                    String pLocation4 = possibleX2+possibleY2;
                    if(!destinationOccupied(pLocation1)){
                        nextMove.add(pLocation1);
                    }
                    if(!destinationOccupied(pLocation2)){
                        nextMove.add(pLocation2);
                    }
                    if(!destinationOccupied(pLocation3)){
                        nextMove.add(pLocation3);
                    }
                    if(!destinationOccupied(pLocation4)){
                        nextMove.add(pLocation4);
                    }
                }
                break;
            case "C":
                if(currentY == 8){
                    String possibleDest1 = "B7";
                    String possibleDest2 = "D7";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else if(currentY == 1){
                    String possibleDest1 = "B2";
                    String possibleDest2 = "D2";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else{
                    String possibleX1 = "B";
                    String possibleX2 = "D";
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String pLocation1 = possibleX1+possibleY1;
                    String pLocation2 = possibleX1+possibleY2;
                    String pLocation3 = possibleX2+possibleY1;
                    String pLocation4 = possibleX2+possibleY2;
                    if(!destinationOccupied(pLocation1)){
                        nextMove.add(pLocation1);
                    }
                    if(!destinationOccupied(pLocation2)){
                        nextMove.add(pLocation2);
                    }
                    if(!destinationOccupied(pLocation3)){
                        nextMove.add(pLocation3);
                    }
                    if(!destinationOccupied(pLocation4)){
                        nextMove.add(pLocation4);
                    }
                }
                break;
            case "D":
                if(currentY == 8){
                    String possibleDest1 = "C7";
                    String possibleDest2 = "E7";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else if(currentY == 1){
                    String possibleDest1 = "C2";
                    String possibleDest2 = "E2";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else{
                    String possibleX1 = "C";
                    String possibleX2 = "E";
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String pLocation1 = possibleX1+possibleY1;
                    String pLocation2 = possibleX1+possibleY2;
                    String pLocation3 = possibleX2+possibleY1;
                    String pLocation4 = possibleX2+possibleY2;
                    if(!destinationOccupied(pLocation1)){
                        nextMove.add(pLocation1);
                    }
                    if(!destinationOccupied(pLocation2)){
                        nextMove.add(pLocation2);
                    }
                    if(!destinationOccupied(pLocation3)){
                        nextMove.add(pLocation3);
                    }
                    if(!destinationOccupied(pLocation4)){
                        nextMove.add(pLocation4);
                    }
                }
                break;
            case "E":
                if(currentY == 8){
                    String possibleDest1 = "D7";
                    String possibleDest2 = "F7";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else if(currentY == 1){
                    String possibleDest1 = "D2";
                    String possibleDest2 = "F2";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else{
                    String possibleX1 = "D";
                    String possibleX2 = "F";
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String pLocation1 = possibleX1+possibleY1;
                    String pLocation2 = possibleX1+possibleY2;
                    String pLocation3 = possibleX2+possibleY1;
                    String pLocation4 = possibleX2+possibleY2;
                    if(!destinationOccupied(pLocation1)){
                        nextMove.add(pLocation1);
                    }
                    if(!destinationOccupied(pLocation2)){
                        nextMove.add(pLocation2);
                    }
                    if(!destinationOccupied(pLocation3)){
                        nextMove.add(pLocation3);
                    }
                    if(!destinationOccupied(pLocation4)){
                        nextMove.add(pLocation4);
                    }
                }
                break;
            case "F":
                if(currentY == 8){
                    String possibleDest1 = "E7";
                    String possibleDest2 = "G7";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else if(currentY == 1){
                    String possibleDest1 = "E2";
                    String possibleDest2 = "G2";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else{
                    String possibleX1 = "E";
                    String possibleX2 = "G";
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String pLocation1 = possibleX1+possibleY1;
                    String pLocation2 = possibleX1+possibleY2;
                    String pLocation3 = possibleX2+possibleY1;
                    String pLocation4 = possibleX2+possibleY2;
                    if(!destinationOccupied(pLocation1)){
                        nextMove.add(pLocation1);
                    }
                    if(!destinationOccupied(pLocation2)){
                        nextMove.add(pLocation2);
                    }
                    if(!destinationOccupied(pLocation3)){
                        nextMove.add(pLocation3);
                    }
                    if(!destinationOccupied(pLocation4)){
                        nextMove.add(pLocation4);
                    }
                }
                break;
            case "G":
                if(currentY == 8){
                    String possibleDest1 = "F7";
                    String possibleDest2 = "H7";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else if(currentY == 1){
                    String possibleDest1 = "F2";
                    String possibleDest2 = "H2";
                    if(!destinationOccupied(possibleDest1)){
                        nextMove.add(possibleDest1);
                    }
                    if(!destinationOccupied(possibleDest2)){
                        nextMove.add(possibleDest2);
                    }
                }else{
                    String possibleX1 = "F";
                    String possibleX2 = "H";
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String pLocation1 = possibleX1+possibleY1;
                    String pLocation2 = possibleX1+possibleY2;
                    String pLocation3 = possibleX2+possibleY1;
                    String pLocation4 = possibleX2+possibleY2;
                    if(!destinationOccupied(pLocation1)){
                        nextMove.add(pLocation1);
                    }
                    if(!destinationOccupied(pLocation2)){
                        nextMove.add(pLocation2);
                    }
                    if(!destinationOccupied(pLocation3)){
                        nextMove.add(pLocation3);
                    }
                    if(!destinationOccupied(pLocation4)){
                        nextMove.add(pLocation4);
                    }
                }
                break;
            case "H":
                if(currentY == 8){
                    if(!destinationOccupied("G7")){
                        nextMove.add("G7");
                    }
                }else if(currentY == 1){
                    if(!destinationOccupied("G2")){
                        nextMove.add("G2");
                    }
                }else{
                    int possibleY1 = currentY+1;
                    int possibleY2 = currentY-1;
                    String larvaPossibleDest1 = "G"+ possibleY1;
                    String larvaPossibleDest2 = "G"+ possibleY2;
                    if(!destinationOccupied(larvaPossibleDest1)){
                        nextMove.add(larvaPossibleDest1);
                    }
                    if(!destinationOccupied(larvaPossibleDest2)){
                        nextMove.add(larvaPossibleDest2);
                    }
                }
                break;
        }
        return nextMove;
    }
    
    public List<String> birdNextPossibleMove(String birdLocation)
    {
        List<String> birdNextMove = new ArrayList<>();
        String currentX = birdLocation.substring(0, 1);
        int currentY = Integer.parseInt(birdLocation.substring(1));
        switch(currentX){
            case "A":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation = "B"+ nextPossibleY;
                    if(!possibleLocation.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation)){
                        birdNextMove.add(possibleLocation);
                    }
                }
                break;
            case "B":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation1 = "A"+ nextPossibleY;
                    String possibleLocation2 = "C"+ nextPossibleY;
                    if(!possibleLocation1.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation1)){
                        birdNextMove.add(possibleLocation1);
                    }
                    if(!possibleLocation2.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation2)){
                        birdNextMove.add(possibleLocation2);
                    }
                }
                break;
            case "C":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation1 = "B"+ nextPossibleY;
                    String possibleLocation2 = "D"+ nextPossibleY;
                    if(!possibleLocation1.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation1)){
                        birdNextMove.add(possibleLocation1);
                    }
                    if(!possibleLocation2.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation2)){
                        birdNextMove.add(possibleLocation2);
                    }
                }
                break;
            case "D":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation1 = "C"+ nextPossibleY;
                    String possibleLocation2 = "E"+ nextPossibleY;
                    if(!possibleLocation1.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation1)){
                        birdNextMove.add(possibleLocation1);
                    }
                    if(!possibleLocation2.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation2)){
                        birdNextMove.add(possibleLocation2);
                    }
                }
                break;
            case "E":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation1 = "D"+ nextPossibleY;
                    String possibleLocation2 = "F"+ nextPossibleY;
                    if(!possibleLocation1.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation1)){
                        birdNextMove.add(possibleLocation1);
                    }
                    if(!possibleLocation2.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation2)){
                        birdNextMove.add(possibleLocation2);
                    }
                }
                break;
            case "F":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation1 = "E"+ nextPossibleY;
                    String possibleLocation2 = "G"+ nextPossibleY;
                    if(!possibleLocation1.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation1)){
                        birdNextMove.add(possibleLocation1);
                    }
                    if(!possibleLocation2.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation2)){
                        birdNextMove.add(possibleLocation2);
                    }
                }
                break;
            case "G":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation1 = "F"+ nextPossibleY;
                    String possibleLocation2 = "H"+ nextPossibleY;
                    if(!possibleLocation1.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation1)){
                        birdNextMove.add(possibleLocation1);
                    }
                    if(!possibleLocation2.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation2)){
                        birdNextMove.add(possibleLocation2);
                    }
                }
                break;
            case "H":
                if(currentY != 8){
                    int nextPossibleY = currentY+1;
                    String possibleLocation = "G"+ nextPossibleY;
                    if(!possibleLocation.equals(this.player1.lava.location.toString()) 
                            && !destinationOccupied(possibleLocation)){
                        birdNextMove.add(possibleLocation);
                    }
                }
                break;
        }
        return birdNextMove;
    }
    
    public Map<String,String> generateBirdsNextMove()
    {
        Map<String,String> nextMove = new HashMap<>();
        Bird[] birds = this.player2.birds;
        int index = 0;
        for(Bird bird : birds){
            List<String> birdNextMove = this.birdNextPossibleMove(bird.location.toString());
            if(!birdNextMove.isEmpty()){
                int moveIndex = 0;
                for(String next : birdNextMove){
                    String temp = index+""+moveIndex;
                    nextMove.put(temp+bird.location.toString(), next);
                    moveIndex++;
                }
            }
            index++;
        }
        return nextMove;
    }
    
    public boolean canLarvaMove()
    {
        boolean canMove = true;
        List<String> larvaNext = this.generateLarvaNextMove();
        if(larvaNext.isEmpty()){
            canMove = false;
        }
        return canMove;
    }
    
    public void birdsAutoPlay()
    {
        int depth = 5;
        //String[] output = this.minMax(depth, this.player2);
        String[] output = this.minMaxAlphaBeta(depth, this.player2,Integer.MIN_VALUE,Integer.MAX_VALUE);

        String birdMovedPre = this.player2.birds[this.birdIndexToMoved[depth]].location.toString();
        this.Player2FromTextField.setText(birdMovedPre);
        
        this.player2.birds[this.birdIndexToMoved[depth]].moveToLocation(output[1]);
        drawBoard();
        System.out.println("The chosen bird is number:"+this.birdIndexToMoved[depth]+" moving from "+birdMovedPre
            +" to location: "+output[1]);
        System.out.println(Arrays.toString(output));
        this.Player2ToTextField.setText(output[1]);
        this.Player1MoveButton.setEnabled(true);
        if (!canLarvaMove()) {//larva can not move anymore
            JOptionPane.showMessageDialog(null, "The Birds win the game!");
            initGame();
        }
    }
    
    public void larvaAutoPlay()
    {
        
        this.Player1FromTextField.setText(this.player1.lava.location.toString());
        String larvaCurrent = this.player1.lava.location.toString();
        int depthInput = 5;
        int depth;
        if(Integer.parseInt(larvaCurrent.substring(1))<depthInput){
            depth = Integer.parseInt(larvaCurrent.substring(1));
        }else{
            depth = 5;
        }
        
        
        List<String> larvaNextMove = new ArrayList<>();
        larvaNextMove = this.generateLarvaNextMove();
        String judgeMove = "";
        for(String move : larvaNextMove){
            if(Integer.parseInt(move.substring(1))==1){
                judgeMove = move;
                break;
            }
        }
        if(judgeMove!=""){
            this.player1.lava.moveToLocation(judgeMove);
            drawBoard();

            this.Player1ToTextField.setText(judgeMove);
            System.out.println("Larva moving from " + larvaCurrent + " to " + judgeMove);
        }else{
            String[] output = this.minMaxAlphaBeta(depth, this.player1, Integer.MIN_VALUE, Integer.MAX_VALUE);
            this.player1.lava.moveToLocation(output[1]);
            drawBoard();

            this.Player1ToTextField.setText(output[1]);
            System.out.println("Larva moving from " + larvaCurrent + " to " + output[1]);
            System.out.println(Arrays.toString(output));
        }
        //String[] output = this.minMax(depth, this.player1);
        
        this.Player2MoveButton.setEnabled(true);
        int currentLevel = Integer.parseInt(this.player1.lava.location.toString().substring(1));
        Map<String, String> birdsNextPossibleMove = this.generateBirdsNextMove();
        if (currentLevel == 1 || birdsNextPossibleMove.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The Lava wins the game!");
            initGame();
        }
    }
    
    public String[] minMax(int depth, Player player)
    {
        int bestScore;
        String bestMove = "";
        if(player.getClass() == Player1_Lava.class){
            List<String> larvaNextMove = new ArrayList<>();
            larvaNextMove = this.generateLarvaNextMove();
            bestScore = Integer.MIN_VALUE;
            if(larvaNextMove.isEmpty() || depth==0){
                bestScore = this.Heuristic(this.player1.lava.location.toString(),
                        this.player2.birds[0].location.toString(),
                        this.player2.birds[1].location.toString(),
                        this.player2.birds[2].location.toString(),
                        this.player2.birds[3].location.toString());
                bestMove = this.player1.lava.location.toString();
            }else{
                for(String move : larvaNextMove){
                    String lavarCurrent = this.player1.lava.location.toString();
                    this.player1.lava.setLarvaLocation(move);
                    String[] output = minMax(depth-1,this.player2);
                    int score = Integer.parseInt(output[0]);
                    System.out.println("depth is: "+depth+" ;score is: "+score+" ;move is: "+move);
                    if(score>bestScore){
                        bestScore = score;
                        bestMove = move;
                    }
                    this.player1.lava.setLarvaLocation(lavarCurrent);
                }
            }
            return new String[]{bestScore+"",bestMove};
            
        }else if(player.getClass() == Player2_Birds.class){
            Map<String, String> birdsNextMove = this.generateBirdsNextMove();
            bestScore = Integer.MAX_VALUE;
            if(birdsNextMove.isEmpty() || depth==0){
                bestScore = this.Heuristic(this.player1.lava.location.toString(),
                        this.player2.birds[0].location.toString(),
                        this.player2.birds[1].location.toString(),
                        this.player2.birds[2].location.toString(),
                        this.player2.birds[3].location.toString());
                
            }else{
                for (Map.Entry<String, String> entry : birdsNextMove.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    int birdIndex = Integer.parseInt(key.substring(0, 1));
                    int moveNum = Integer.parseInt(key.substring(1, 2));
                    String birdLocation = key.substring(2);
                    String[] birdCurrent = new String[4];
                    birdCurrent[birdIndex] = birdLocation;
                    
                    this.player2.birds[birdIndex].setLocation(value);
                    String[] output = minMax(depth-1,this.player1);
                    int score = Integer.parseInt(output[0]);
                    System.out.println("depth is: "+depth+" ;bird is "+birdIndex+" ;score is: "+score+" ;move is: "+value);
                    if(score<bestScore){
                        bestScore = score;
                        bestMove = value;
                        this.birdIndexToMoved[depth] = birdIndex;
                    }
                    this.player2.birds[birdIndex].setLocation(birdCurrent[birdIndex]);
                }
            }
            return new String[]{bestScore+"",bestMove};
        }else{
            return null;
        }
        
    }
    
    public String[] minMaxAlphaBeta(int depth, Player player, int alpha, int beta)
    {
        int bestScore;
        String bestMove = "";
        if(player.getClass() == Player1_Lava.class){
            List<String> larvaNextMove = new ArrayList<>();
            larvaNextMove = this.generateLarvaNextMove();
            bestScore = Integer.MIN_VALUE;
            if(larvaNextMove.isEmpty() || depth==0){
                bestScore = this.Heuristic(this.player1.lava.location.toString(),
                        this.player2.birds[0].location.toString(),
                        this.player2.birds[1].location.toString(),
                        this.player2.birds[2].location.toString(),
                        this.player2.birds[3].location.toString());
                bestMove = this.player1.lava.location.toString();
            }else{
                for(String move : larvaNextMove){
                    String lavarCurrent = this.player1.lava.location.toString();
                    this.player1.lava.setLarvaLocation(move);
                    String[] output = minMaxAlphaBeta(depth-1,this.player2,alpha,beta);
                    int score = Integer.parseInt(output[0]);
                    System.out.println("depth is: "+depth+" ;score is: "+score+" ;move is: "+move);
                    if(score>alpha){
                        alpha = score;
                        bestScore = score;
                        bestMove = move;
                    }
                    this.player1.lava.setLarvaLocation(lavarCurrent);
                    if(alpha>=beta){
                        System.out.println("Alpha beta prunning the rest");
                        break;
                    }
                }
            }
            return new String[]{bestScore+"",bestMove};
            
        }else if(player.getClass() == Player2_Birds.class){
            Map<String, String> birdsNextMove = this.generateBirdsNextMove();
            bestScore = Integer.MAX_VALUE;
            if(birdsNextMove.isEmpty() || depth==0){
                bestScore = this.Heuristic(this.player1.lava.location.toString(),
                        this.player2.birds[0].location.toString(),
                        this.player2.birds[1].location.toString(),
                        this.player2.birds[2].location.toString(),
                        this.player2.birds[3].location.toString());
                
            }else{
                for (Map.Entry<String, String> entry : birdsNextMove.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    int birdIndex = Integer.parseInt(key.substring(0, 1));
                    int moveNum = Integer.parseInt(key.substring(1, 2));
                    String birdLocation = key.substring(2);
                    String[] birdCurrent = new String[4];
                    birdCurrent[birdIndex] = birdLocation;
                    
                    this.player2.birds[birdIndex].setLocation(value);
                    String[] output = minMaxAlphaBeta(depth-1,this.player1,alpha,beta);
                    int score = Integer.parseInt(output[0]);
                    System.out.println("depth is: "+depth+" ;bird is "+birdIndex+" ;score is: "+score+" ;move is: "+value);
                    if(score<beta){
                        beta = score;
                        bestScore = score;
                        bestMove = value;
                        this.birdIndexToMoved[depth] = birdIndex;
                    }
                    this.player2.birds[birdIndex].setLocation(birdCurrent[birdIndex]);
                    if(alpha>=beta){
                        System.out.println("Alpha beta prunning the rest");
                        break;
                    }
                }
            }
            return new String[]{bestScore+"",bestMove};
        }else{
            return null;
        }
        
    }
    
    public int Heuristic(String larva, String bird1, String bird2, String bird3, String bird4)
    {
        int score = naiveH(larva)
                -naiveH(bird1)
                -naiveH(bird2)
                -naiveH(bird3)
                -naiveH(bird4);
        int larvaX = larva.substring(0,1).charAt(0)-'@';
        int bird1X = bird1.substring(0,1).charAt(0)-'@';
        int bird2X = bird2.substring(0,1).charAt(0)-'@';
        int bird3X = bird3.substring(0,1).charAt(0)-'@';
        int bird4X = bird4.substring(0,1).charAt(0)-'@';
        int addition = Math.abs(larvaX-bird1X)+Math.abs(larvaX-bird2X)+Math.abs(larvaX-bird3X)+Math.abs(larvaX-bird4X);
        score = score+addition;
        int larvaY = Integer.parseInt(larva.substring(1));
        int bird1Y = Integer.parseInt(bird1.substring(1));
        int bird2Y = Integer.parseInt(bird2.substring(1));
        int bird3Y = Integer.parseInt(bird3.substring(1));
        int bird4Y = Integer.parseInt(bird4.substring(1));
        int additionY = Math.abs(larvaY-bird1Y)+Math.abs(larvaY-bird2Y)+Math.abs(larvaY-bird3Y)+Math.abs(larvaY-bird4Y);
        score = score+addition;
        
        double toEdge1 = larvaY/(Math.abs(larvaX-7.5));
        double toEdge2 = larvaY/(Math.abs(larvaX-0.5));
        int addition2 = (int)((toEdge1+toEdge2)*additionY/(addition+0.1));
        score = score+addition2;
        return score;
    }
    
    public int naiveH(String location)
    {
        String currentX = location.substring(0, 1);
        int currentY = Integer.parseInt(location.substring(1));
        int temp = 8-currentY;
        char x = currentX.charAt(0);
        int addition = x - '@';
        return temp*8+addition;
    }
    
    private int locationEqualToBirds(String location)
    {
        int isPartOfBirds = -1;
        Bird []birds = this.player2.birds;
        for(int i = 0; i<birds.length; i++){
            if(birds[i].location.toString().equals(location)){
                isPartOfBirds = i;
                break;
            }
        }
        return isPartOfBirds;
    }
    
    private void changeTurn()
    {
        this.Player1MoveButton.setEnabled(!this.Player1MoveButton.isEnabled());
        this.Player2MoveButton.setEnabled(!this.Player2MoveButton.isEnabled());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        ChessBoard = new javax.swing.JPanel();
        A8_position = new javax.swing.JLabel();
        B8_position = new javax.swing.JLabel();
        C8_position = new javax.swing.JLabel();
        D8_position = new javax.swing.JLabel();
        E8_position = new javax.swing.JLabel();
        F8_position = new javax.swing.JLabel();
        G8_position = new javax.swing.JLabel();
        H8_position = new javax.swing.JLabel();
        markLabel8 = new javax.swing.JLabel();
        A7_position = new javax.swing.JLabel();
        B7_position = new javax.swing.JLabel();
        C7_position = new javax.swing.JLabel();
        D7_position = new javax.swing.JLabel();
        E7_position = new javax.swing.JLabel();
        F7_position = new javax.swing.JLabel();
        G7_position = new javax.swing.JLabel();
        H7_position = new javax.swing.JLabel();
        markLabel7 = new javax.swing.JLabel();
        A6_position = new javax.swing.JLabel();
        B6_position = new javax.swing.JLabel();
        C6_position = new javax.swing.JLabel();
        D6_position = new javax.swing.JLabel();
        E6_position = new javax.swing.JLabel();
        F6_position = new javax.swing.JLabel();
        G6_position = new javax.swing.JLabel();
        H6_position = new javax.swing.JLabel();
        markLabel6 = new javax.swing.JLabel();
        A5_position = new javax.swing.JLabel();
        B5_position = new javax.swing.JLabel();
        C5_position = new javax.swing.JLabel();
        D5_position = new javax.swing.JLabel();
        E5_position = new javax.swing.JLabel();
        F5_position = new javax.swing.JLabel();
        G5_position = new javax.swing.JLabel();
        H5_position = new javax.swing.JLabel();
        markLabel5 = new javax.swing.JLabel();
        A4_position = new javax.swing.JLabel();
        B4_position = new javax.swing.JLabel();
        C4_position = new javax.swing.JLabel();
        D4_position = new javax.swing.JLabel();
        E4_position = new javax.swing.JLabel();
        F4_position = new javax.swing.JLabel();
        G4_position = new javax.swing.JLabel();
        H4_position = new javax.swing.JLabel();
        markLabel4 = new javax.swing.JLabel();
        A3_position = new javax.swing.JLabel();
        B3_position = new javax.swing.JLabel();
        C3_position = new javax.swing.JLabel();
        D3_position = new javax.swing.JLabel();
        E3_position = new javax.swing.JLabel();
        F3_position = new javax.swing.JLabel();
        G3_position = new javax.swing.JLabel();
        H3_position = new javax.swing.JLabel();
        markLabel3 = new javax.swing.JLabel();
        A2_position = new javax.swing.JLabel();
        B2_position = new javax.swing.JLabel();
        C2_position = new javax.swing.JLabel();
        D2_position = new javax.swing.JLabel();
        E2_position = new javax.swing.JLabel();
        F2_position = new javax.swing.JLabel();
        G2_position = new javax.swing.JLabel();
        H2_position = new javax.swing.JLabel();
        markLabel2 = new javax.swing.JLabel();
        A1_position = new javax.swing.JLabel();
        B1_position = new javax.swing.JLabel();
        C1_position = new javax.swing.JLabel();
        D1_position = new javax.swing.JLabel();
        E1_position = new javax.swing.JLabel();
        F1_position = new javax.swing.JLabel();
        G1_position = new javax.swing.JLabel();
        H1_position = new javax.swing.JLabel();
        markLabel1 = new javax.swing.JLabel();
        MessagePanel = new javax.swing.JPanel();
        startGameButton = new javax.swing.JButton();
        TwoPlayerSelection = new javax.swing.JRadioButton();
        OnePlayerSelection = new javax.swing.JRadioButton();
        newGameButton = new javax.swing.JButton();
        PlayerLarvaRadio = new javax.swing.JRadioButton();
        PlayerBirdsRadio = new javax.swing.JRadioButton();
        ControlPanel = new javax.swing.JPanel();
        Player1ControlPanel = new javax.swing.JPanel();
        Player1Title = new javax.swing.JLabel();
        Player1FromLabel = new javax.swing.JLabel();
        Player1FromTextField = new javax.swing.JTextField();
        Player1ToLabel = new javax.swing.JLabel();
        Player1ToTextField = new javax.swing.JTextField();
        Player1MoveButton = new javax.swing.JButton();
        Player2ControlPanel = new javax.swing.JPanel();
        Player2Title = new javax.swing.JLabel();
        Player2FromLabel = new javax.swing.JLabel();
        Player2FromTextField = new javax.swing.JTextField();
        Player2ToLabel = new javax.swing.JLabel();
        Player2ToTextField = new javax.swing.JTextField();
        Player2MoveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hungry Birds");
        setMinimumSize(new java.awt.Dimension(400, 400));
        setSize(new java.awt.Dimension(500, 800));
        getContentPane().setLayout(new java.awt.GridLayout(3, 0));

        ChessBoard.setMinimumSize(new java.awt.Dimension(200, 200));
        ChessBoard.setLayout(new java.awt.GridLayout(8, 9));

        A8_position.setText("A8");
        ChessBoard.add(A8_position);

        B8_position.setText("B8");
        ChessBoard.add(B8_position);

        C8_position.setText("C8");
        ChessBoard.add(C8_position);

        D8_position.setText("D8");
        ChessBoard.add(D8_position);

        E8_position.setText("E8");
        ChessBoard.add(E8_position);

        F8_position.setText("F8");
        ChessBoard.add(F8_position);

        G8_position.setText("G8");
        ChessBoard.add(G8_position);

        H8_position.setText("H8");
        ChessBoard.add(H8_position);

        markLabel8.setText("8");
        ChessBoard.add(markLabel8);

        A7_position.setText("A7");
        ChessBoard.add(A7_position);

        B7_position.setText("B7");
        ChessBoard.add(B7_position);

        C7_position.setText("C7");
        ChessBoard.add(C7_position);

        D7_position.setText("D7");
        ChessBoard.add(D7_position);

        E7_position.setText("E7");
        ChessBoard.add(E7_position);

        F7_position.setText("F7");
        ChessBoard.add(F7_position);

        G7_position.setText("G7");
        ChessBoard.add(G7_position);

        H7_position.setText("H7");
        ChessBoard.add(H7_position);

        markLabel7.setText("7");
        ChessBoard.add(markLabel7);

        A6_position.setText("A6");
        ChessBoard.add(A6_position);

        B6_position.setText("B6");
        ChessBoard.add(B6_position);

        C6_position.setText("C6");
        ChessBoard.add(C6_position);

        D6_position.setText("D6");
        ChessBoard.add(D6_position);

        E6_position.setText("E6");
        ChessBoard.add(E6_position);

        F6_position.setText("F6");
        ChessBoard.add(F6_position);

        G6_position.setText("G6");
        ChessBoard.add(G6_position);

        H6_position.setText("H6");
        ChessBoard.add(H6_position);

        markLabel6.setText("6");
        ChessBoard.add(markLabel6);

        A5_position.setText("A5");
        ChessBoard.add(A5_position);

        B5_position.setText("B5");
        ChessBoard.add(B5_position);

        C5_position.setText("C5");
        ChessBoard.add(C5_position);

        D5_position.setText("D5");
        ChessBoard.add(D5_position);

        E5_position.setText("E5");
        ChessBoard.add(E5_position);

        F5_position.setText("F5");
        ChessBoard.add(F5_position);

        G5_position.setText("G5");
        ChessBoard.add(G5_position);

        H5_position.setText("H5");
        ChessBoard.add(H5_position);

        markLabel5.setText("5");
        ChessBoard.add(markLabel5);

        A4_position.setText("A4");
        ChessBoard.add(A4_position);

        B4_position.setText("B4");
        ChessBoard.add(B4_position);

        C4_position.setText("C4");
        ChessBoard.add(C4_position);

        D4_position.setText("D4");
        ChessBoard.add(D4_position);

        E4_position.setText("E4");
        ChessBoard.add(E4_position);

        F4_position.setText("F4");
        ChessBoard.add(F4_position);

        G4_position.setText("G4");
        ChessBoard.add(G4_position);

        H4_position.setText("H4");
        ChessBoard.add(H4_position);

        markLabel4.setText("4");
        ChessBoard.add(markLabel4);

        A3_position.setText("A3");
        ChessBoard.add(A3_position);

        B3_position.setText("B3");
        ChessBoard.add(B3_position);

        C3_position.setText("C3");
        ChessBoard.add(C3_position);

        D3_position.setText("D3");
        ChessBoard.add(D3_position);

        E3_position.setText("E3");
        ChessBoard.add(E3_position);

        F3_position.setText("F3");
        ChessBoard.add(F3_position);

        G3_position.setText("G3");
        ChessBoard.add(G3_position);

        H3_position.setText("H3");
        ChessBoard.add(H3_position);

        markLabel3.setText("3");
        ChessBoard.add(markLabel3);

        A2_position.setText("A2");
        ChessBoard.add(A2_position);

        B2_position.setText("B2");
        ChessBoard.add(B2_position);

        C2_position.setText("C2");
        ChessBoard.add(C2_position);

        D2_position.setText("D2");
        ChessBoard.add(D2_position);

        E2_position.setText("E2");
        ChessBoard.add(E2_position);

        F2_position.setText("F2");
        ChessBoard.add(F2_position);

        G2_position.setText("G2");
        ChessBoard.add(G2_position);

        H2_position.setText("H2");
        ChessBoard.add(H2_position);

        markLabel2.setText("2");
        ChessBoard.add(markLabel2);

        A1_position.setText("A1");
        ChessBoard.add(A1_position);

        B1_position.setText("B1");
        ChessBoard.add(B1_position);

        C1_position.setText("C1");
        ChessBoard.add(C1_position);

        D1_position.setText("D1");
        ChessBoard.add(D1_position);

        E1_position.setText("E1");
        ChessBoard.add(E1_position);

        F1_position.setText("F1");
        ChessBoard.add(F1_position);

        G1_position.setText("G1");
        ChessBoard.add(G1_position);

        H1_position.setText("H1");
        ChessBoard.add(H1_position);

        markLabel1.setText("1");
        ChessBoard.add(markLabel1);

        getContentPane().add(ChessBoard);

        MessagePanel.setSize(new java.awt.Dimension(0, 100));

        startGameButton.setText("Start Game");
        startGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startGameButtonMouseClicked(evt);
            }
        });

        buttonGroup.add(TwoPlayerSelection);
        TwoPlayerSelection.setText("Two players");
        TwoPlayerSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwoPlayerSelectionActionPerformed(evt);
            }
        });

        buttonGroup.add(OnePlayerSelection);
        OnePlayerSelection.setText("One player");
        OnePlayerSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnePlayerSelectionActionPerformed(evt);
            }
        });

        newGameButton.setText("New Game");
        newGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newGameButtonMouseClicked(evt);
            }
        });

        buttonGroup2.add(PlayerLarvaRadio);
        PlayerLarvaRadio.setText("Player be Larva");

        buttonGroup2.add(PlayerBirdsRadio);
        PlayerBirdsRadio.setText("Player be Birds");
        PlayerBirdsRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerBirdsRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MessagePanelLayout = new javax.swing.GroupLayout(MessagePanel);
        MessagePanel.setLayout(MessagePanelLayout);
        MessagePanelLayout.setHorizontalGroup(
            MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlayerBirdsRadio)
                    .addComponent(PlayerLarvaRadio)
                    .addGroup(MessagePanelLayout.createSequentialGroup()
                        .addGroup(MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TwoPlayerSelection)
                            .addComponent(OnePlayerSelection))
                        .addGap(70, 70, 70)
                        .addComponent(startGameButton)
                        .addGap(40, 40, 40)
                        .addComponent(newGameButton)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        MessagePanelLayout.setVerticalGroup(
            MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagePanelLayout.createSequentialGroup()
                .addGroup(MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MessagePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(TwoPlayerSelection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OnePlayerSelection))
                    .addGroup(MessagePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startGameButton)
                            .addComponent(newGameButton))))
                .addGap(70, 70, 70)
                .addComponent(PlayerLarvaRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlayerBirdsRadio)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(MessagePanel);

        ControlPanel.setLayout(new java.awt.GridLayout(1, 2));

        Player1Title.setText("Player 1 Lava");

        Player1FromLabel.setText("From:");

        Player1FromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1FromTextFieldActionPerformed(evt);
            }
        });

        Player1ToLabel.setText("To:");

        Player1ToTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1ToTextFieldActionPerformed(evt);
            }
        });

        Player1MoveButton.setText("Move");
        Player1MoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player1MoveButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Player1ControlPanelLayout = new javax.swing.GroupLayout(Player1ControlPanel);
        Player1ControlPanel.setLayout(Player1ControlPanelLayout);
        Player1ControlPanelLayout.setHorizontalGroup(
            Player1ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player1ControlPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(Player1ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player1FromLabel)
                    .addComponent(Player1ToLabel))
                .addGap(26, 26, 26)
                .addGroup(Player1ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player1MoveButton)
                    .addComponent(Player1Title)
                    .addGroup(Player1ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Player1FromTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addComponent(Player1ToTextField)))
                .addGap(48, 48, 48))
        );
        Player1ControlPanelLayout.setVerticalGroup(
            Player1ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player1ControlPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Player1Title)
                .addGap(18, 18, 18)
                .addGroup(Player1ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player1FromLabel)
                    .addComponent(Player1FromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Player1ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player1ToLabel)
                    .addComponent(Player1ToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Player1MoveButton)
                .addContainerGap())
        );

        ControlPanel.add(Player1ControlPanel);

        Player2Title.setText("Player 2 Birds");

        Player2FromLabel.setText("From:");

        Player2ToLabel.setText("To:");

        Player2MoveButton.setText("Move");
        Player2MoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Player2MoveButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Player2ControlPanelLayout = new javax.swing.GroupLayout(Player2ControlPanel);
        Player2ControlPanel.setLayout(Player2ControlPanelLayout);
        Player2ControlPanelLayout.setHorizontalGroup(
            Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player2ControlPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Player2ControlPanelLayout.createSequentialGroup()
                        .addGroup(Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Player2ToLabel)
                            .addComponent(Player2FromLabel))
                        .addGap(23, 23, 23)
                        .addGroup(Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Player2MoveButton)
                            .addComponent(Player2ToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Player2Title)
                        .addComponent(Player2FromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        Player2ControlPanelLayout.setVerticalGroup(
            Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player2ControlPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Player2Title)
                .addGap(18, 18, 18)
                .addGroup(Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player2FromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Player2FromLabel))
                .addGap(18, 18, 18)
                .addGroup(Player2ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player2ToLabel)
                    .addComponent(Player2ToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(Player2MoveButton)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        ControlPanel.add(Player2ControlPanel);

        getContentPane().add(ControlPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Player1FromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player1FromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player1FromTextFieldActionPerformed

    private void Player1ToTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player1ToTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Player1ToTextFieldActionPerformed

    private void TwoPlayerSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwoPlayerSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TwoPlayerSelectionActionPerformed

    private void startGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startGameButtonMouseClicked
        // TODO add your handling code here:
        startGame();
    }//GEN-LAST:event_startGameButtonMouseClicked

    private void Player1MoveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player1MoveButtonMouseClicked
        // TODO add your handling code here:
        if(this.playMode == PlayMode.TwoPlayer || ((this.playMode == PlayMode.onePlayer) && (this.onePlayerMode==OnePlayerModeRule.PlayerBeLarva))){
            String lavaFromInput = this.Player1FromTextField.getText().toUpperCase();
            Location from = new Location(lavaFromInput);
            String lavaToInput = this.Player1ToTextField.getText().toUpperCase();
            Location to = new Location(lavaToInput);
            if (!from.isLegal) {
                JOptionPane.showMessageDialog(null, "Illegal input Laval from location", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                if (!lavaFromInput.equals(this.player1.lava.location.toString())) {
                    JOptionPane.showMessageDialog(null, "The Lava is now at position:" + this.player1.lava.location.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);;
                } else {//correct input of Lava from
                    if (!to.isLegal) {
                        JOptionPane.showMessageDialog(null, "Illegal input Laval to location", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (destinationOccupied(lavaToInput)) {
                        JOptionPane.showMessageDialog(null, "Location occupied at location: " + lavaToInput, "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else if (!this.player1.lava.moveToLocation(lavaToInput)) {
                        JOptionPane.showMessageDialog(null, "You cannot move lava to location: " + lavaToInput, "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {
                        drawBoard();
                        int currentLevel = Integer.parseInt(this.player1.lava.location.toString().substring(1));
                        Map<String,String> birdNextPossibleMove = this.generateBirdsNextMove();
                        if (currentLevel == 1 || birdNextPossibleMove.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "The Lava wins the game!");
                            initGame();
                        } else {
                            if(this.onePlayerMode==OnePlayerModeRule.PlayerBeLarva){
                                this.Player1MoveButton.setEnabled(false);
                                this.birdsAutoPlay();
                            }else{
                                changeTurn();
                            }
                        }
                    }
                }
            }
        }else if(this.playMode == PlayMode.onePlayer){
            
        }
        
    }//GEN-LAST:event_Player1MoveButtonMouseClicked

    private void Player2MoveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Player2MoveButtonMouseClicked
        // TODO add your handling code here:
        if(this.playMode == PlayMode.TwoPlayer ||((this.playMode == PlayMode.onePlayer)&&(this.onePlayerMode == OnePlayerModeRule.PlayerBeBirds))){
            String birdFromInput = this.Player2FromTextField.getText().toUpperCase();
            Location from = new Location(birdFromInput);
            String birdToInput = this.Player2ToTextField.getText().toUpperCase();
            Location to = new Location(birdToInput);
            if (!from.isLegal) {
                JOptionPane.showMessageDialog(null, "Illegal input bird from location", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else if (locationEqualToBirds(birdFromInput) < 0) {
                JOptionPane.showMessageDialog(null, "Please select correct bird location", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {//correct input of from bird input
                if (!to.isLegal) {
                    JOptionPane.showMessageDialog(null, "Illegal input Laval to location", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else if (destinationOccupied(birdToInput)) {
                    JOptionPane.showMessageDialog(null, "Destination occupied!", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else if (this.player1.lava.location.toString().equals(birdToInput)) {
                    JOptionPane.showMessageDialog(null, "Destination occupied, bird cannot eat larva!", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    int birdIndexChoose = locationEqualToBirds(birdFromInput);
                    if (!this.player2.birds[birdIndexChoose].moveToLocation(birdToInput)) {
                        JOptionPane.showMessageDialog(null, "You cannot move bird to location: " + birdToInput, "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {
                        drawBoard();
                        if (!canLarvaMove()) {//larva can not move anymore
                            JOptionPane.showMessageDialog(null, "The Birds win the game!");
                            initGame();
                        } else {
                            if(this.onePlayerMode== OnePlayerModeRule.PlayerBeBirds){
                                this.Player2MoveButton.setEnabled(false);
                                this.larvaAutoPlay();
                            }else{
                                changeTurn();
                            }
                        }
                    }
                }

            }
        }else if(this.playMode == PlayMode.onePlayer){
            if(this.onePlayerMode == OnePlayerModeRule.PlayerBeLarva){
                
            }
        }
    }//GEN-LAST:event_Player2MoveButtonMouseClicked

    private void newGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameButtonMouseClicked
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(null, "Are you sure to restart the game?", "New Game", JOptionPane.YES_NO_OPTION);
        if(input==0){
            initGame();
        }
    }//GEN-LAST:event_newGameButtonMouseClicked

    private void PlayerBirdsRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerBirdsRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayerBirdsRadioActionPerformed

    private void OnePlayerSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnePlayerSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OnePlayerSelectionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HungryBirds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HungryBirds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HungryBirds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HungryBirds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HungryBirds().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A1_position;
    private javax.swing.JLabel A2_position;
    private javax.swing.JLabel A3_position;
    private javax.swing.JLabel A4_position;
    private javax.swing.JLabel A5_position;
    private javax.swing.JLabel A6_position;
    private javax.swing.JLabel A7_position;
    private javax.swing.JLabel A8_position;
    private javax.swing.JLabel B1_position;
    private javax.swing.JLabel B2_position;
    private javax.swing.JLabel B3_position;
    private javax.swing.JLabel B4_position;
    private javax.swing.JLabel B5_position;
    private javax.swing.JLabel B6_position;
    private javax.swing.JLabel B7_position;
    private javax.swing.JLabel B8_position;
    private javax.swing.JLabel C1_position;
    private javax.swing.JLabel C2_position;
    private javax.swing.JLabel C3_position;
    private javax.swing.JLabel C4_position;
    private javax.swing.JLabel C5_position;
    private javax.swing.JLabel C6_position;
    private javax.swing.JLabel C7_position;
    private javax.swing.JLabel C8_position;
    private javax.swing.JPanel ChessBoard;
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JLabel D1_position;
    private javax.swing.JLabel D2_position;
    private javax.swing.JLabel D3_position;
    private javax.swing.JLabel D4_position;
    private javax.swing.JLabel D5_position;
    private javax.swing.JLabel D6_position;
    private javax.swing.JLabel D7_position;
    private javax.swing.JLabel D8_position;
    private javax.swing.JLabel E1_position;
    private javax.swing.JLabel E2_position;
    private javax.swing.JLabel E3_position;
    private javax.swing.JLabel E4_position;
    private javax.swing.JLabel E5_position;
    private javax.swing.JLabel E6_position;
    private javax.swing.JLabel E7_position;
    private javax.swing.JLabel E8_position;
    private javax.swing.JLabel F1_position;
    private javax.swing.JLabel F2_position;
    private javax.swing.JLabel F3_position;
    private javax.swing.JLabel F4_position;
    private javax.swing.JLabel F5_position;
    private javax.swing.JLabel F6_position;
    private javax.swing.JLabel F7_position;
    private javax.swing.JLabel F8_position;
    private javax.swing.JLabel G1_position;
    private javax.swing.JLabel G2_position;
    private javax.swing.JLabel G3_position;
    private javax.swing.JLabel G4_position;
    private javax.swing.JLabel G5_position;
    private javax.swing.JLabel G6_position;
    private javax.swing.JLabel G7_position;
    private javax.swing.JLabel G8_position;
    private javax.swing.JLabel H1_position;
    private javax.swing.JLabel H2_position;
    private javax.swing.JLabel H3_position;
    private javax.swing.JLabel H4_position;
    private javax.swing.JLabel H5_position;
    private javax.swing.JLabel H6_position;
    private javax.swing.JLabel H7_position;
    private javax.swing.JLabel H8_position;
    private javax.swing.JPanel MessagePanel;
    private javax.swing.JRadioButton OnePlayerSelection;
    private javax.swing.JPanel Player1ControlPanel;
    private javax.swing.JLabel Player1FromLabel;
    private javax.swing.JTextField Player1FromTextField;
    private javax.swing.JButton Player1MoveButton;
    private javax.swing.JLabel Player1Title;
    private javax.swing.JLabel Player1ToLabel;
    private javax.swing.JTextField Player1ToTextField;
    private javax.swing.JPanel Player2ControlPanel;
    private javax.swing.JLabel Player2FromLabel;
    private javax.swing.JTextField Player2FromTextField;
    private javax.swing.JButton Player2MoveButton;
    private javax.swing.JLabel Player2Title;
    private javax.swing.JLabel Player2ToLabel;
    private javax.swing.JTextField Player2ToTextField;
    private javax.swing.JRadioButton PlayerBirdsRadio;
    private javax.swing.JRadioButton PlayerLarvaRadio;
    private javax.swing.JRadioButton TwoPlayerSelection;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel markLabel1;
    private javax.swing.JLabel markLabel2;
    private javax.swing.JLabel markLabel3;
    private javax.swing.JLabel markLabel4;
    private javax.swing.JLabel markLabel5;
    private javax.swing.JLabel markLabel6;
    private javax.swing.JLabel markLabel7;
    private javax.swing.JLabel markLabel8;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton startGameButton;
    // End of variables declaration//GEN-END:variables
}
