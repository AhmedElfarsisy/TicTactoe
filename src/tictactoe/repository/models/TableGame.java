/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.repository.models;

import java.io.Serializable;
import java.util.Date;
import tictactoe.model.Game;

/**
 *
 * @author A.Elfarsisy
 */
public class TableGame implements Serializable {

    String PlayerOneName;
    String PlayerTwoName;
    String GameState;
    Date date;

    public TableGame(String PlayerOneName, String PlayerTwoName, String GameState) {
        this.PlayerOneName = PlayerOneName;
        this.PlayerTwoName = PlayerTwoName;
        this.GameState = GameState;
    }

    public TableGame(Game game) {
        this.PlayerOneName = game.getPlayerName(0);
        this.PlayerTwoName = game.getPlayerName(1);
        this.GameState = game.getWinner() == 0 ? "win" : "lose";
        this.date = game.getDate();

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
