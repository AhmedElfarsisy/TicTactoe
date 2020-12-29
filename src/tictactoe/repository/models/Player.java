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
public class Player implements Serializable{
    String name; 
    int Score; 

    public Player(String name, int Score) {
        this.name = name;
        this.Score = Score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }
    
    
}
