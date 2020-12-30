/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import tictactoe.TicTacToe;
import tictactoe.model.Game;
import tictactoe.model.PlayMode;
import tictactoe.model.Player;
import tictactoe.model.Symbol;
import tictactoe.presenter.auth.register.RegisterController;
import tictactoe.presenter.auth.signin.SignInController;
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
    
    public static void goToGame(PlayMode mode){
        Game g;
        Player player1;
        Player player2;
        
        if(mode == PlayMode.SINGLE){//Play with Computer
            player1 = new Player("You", Symbol.X);
            player2 = new Player("Computer", Symbol.O);  
        }else{
            player1 = new Player("Player 1", Symbol.X);
            player2 = new Player("Player 2", Symbol.O); 
        }
        
         Player [] players = {player1, player2};
         g = new Game(players,mode);
        
         TicTacToe.changeScene(new GameController(g));
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
    
 

    public static void goToLogin(){
       TicTacToe.changeScene(new SignInController());
    }
   

    public static void goToOptions() {
       TicTacToe.changeScene(new OptionsController());
    }

    public static void goToRegister() {
         TicTacToe.changeScene(new RegisterController());
    }
    
      public static void goToAvailablePlayer() {
         TicTacToe.changeScene(new OnlinePlayersController());
    }
      
}
