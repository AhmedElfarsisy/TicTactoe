/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import tictactoe.TicTacToe;
import tictactoe.presenter.auth.register.RegisterController;
import tictactoe.presenter.auth.signin.SignInController;
import tictactoe.presenter.game.GameController;
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
    
    //1. Creating navigation method
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
         //TicTacToe.changeScene(new RegisterController());
    }
}
