/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import javafx.scene.Parent;
import javafx.scene.Scene;
import tictactoe.presenter.home.HomeViewBase;
import tictactoe.TicTacToe;
import tictactoe.presenter.game.GameController;
import tictactoe.presenter.game.GameViewBase;
import tictactoe.presenter.onlineplayers.OnlinePlayersController;
import tictactoe.presenter.recordedgames.RecordedGameController;
import tictactoe.presenter.home.HomeController;
import tictactoe.presenter.options.OptionsController;

/**
 *
 * @author yasmineghazy
 */
public class Navigator {
    public static void goToGame(){
       TicTacToe.changeScene(new GameController());
    }
    
    public static void goToHome(){
        TicTacToe.changeScene(new HomeController());
    }
    public static void goToOnlinePlayers(){
        TicTacToe.changeScene(new OnlinePlayersController());
    }
    public static void goToRecordedGame(){
        TicTacToe.changeScene(new RecordedGameController());
    }
    
    //1. Creating navigation method
//    public static void goToLogin(){
//       TicTacToe.changeScene(new LoginController());
//    }
    
   
    
  
    //1. Creating navigation method
//    public static void goToLogin(){
//       TicTacToe.changeScene(new LoginController());
//    }

    public static void goToOptions() {
       TicTacToe.changeScene(new OptionsController());

    }
    
    
}
