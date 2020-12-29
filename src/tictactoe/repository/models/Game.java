/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.repository.models;

import java.io.Serializable;

/**
 *
 * @author A.Elfarsisy
 */
public class Game implements Serializable{
    String PlayerOneName; 
    String PlayerTwoName; 
    String GameState; 

    public Game(String PlayerOneName, String PlayerTwoName, String GameState) {
        this.PlayerOneName = PlayerOneName;
        this.PlayerTwoName = PlayerTwoName;
        this.GameState = GameState;
    }

    public String getPlayerOneName() {
        return PlayerOneName;
    }

    public void setPlayerOneName(String PlayerOneName) {
        this.PlayerOneName = PlayerOneName;
    }

    public String getPlayerTwoName() {
        return PlayerTwoName;
    }

    public void setPlayerTwoName(String PlayerTwoName) {
        this.PlayerTwoName = PlayerTwoName;
    }

    public String getGameState() {
        return GameState;
    }

    public void setGameState(String GameState) {
        this.GameState = GameState;
    }
    
}
