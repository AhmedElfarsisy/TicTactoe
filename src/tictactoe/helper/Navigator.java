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
import tictactoe.model.User;
import tictactoe.presenter.auth.register.RegisterController;
import tictactoe.presenter.auth.signin.SignInController;
import tictactoe.presenter.game.GameController;
import tictactoe.presenter.game.OnlineGameController;
import tictactoe.presenter.onlineplayers.OnlinePlayersController;
import tictactoe.presenter.recordedgames.RecordedGameController;

import tictactoe.presenter.home.HomeController;
import tictactoe.presenter.options.OptionsController;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;

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
            player1 = new Player("Player 1", Symbol.X);
            player2 = new Player("Computer", Symbol.O);  
        }else{
            player1 = new Player("Player 1", Symbol.X);
            player2 = new Player("Player 2", Symbol.O); 
        }
        
         Player [] players = {player1, player2};
         g = new Game(players,mode);
        
         TicTacToe.changeScene(new GameController(g));
    }
    
    public static void goToRecordedGame(Game game){
        game.setMode(PlayMode.RECORDED);
        GameController controller = new GameController(game);
        TicTacToe.changeScene(controller);
    }
    
    public static void goToOnlineGame(User user){
        Game game;
//        User currentUser = (User)UserDefaults.getInstance().get(DefaultKey.USER);
        
        Player player1 = new Player(Constants.currentUser, Symbol.X);
        Player player2 = new Player(user, Symbol.O); 
        Player [] players = {player1, player2};
        game = new Game(players, PlayMode.MULTIONLINE);
        OnlineGameController controller = new OnlineGameController(game);
        TicTacToe.changeScene(controller);
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
