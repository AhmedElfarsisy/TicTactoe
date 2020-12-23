/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.tictactoe.presenter.game;

import tictactoe.tictactoe.presenter.game.*;
import tictactoe.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

/**
 *
 * @author A.Elfarsisy
 */
public class GameController implements Initializable {
    
    @FXML
    private GameViewBase gameView ;
    
    public GameController(){
          gameView = new GameViewBase();
        
          for(Object ch: gameView.gameBoardGP.getChildren()){
            ((Button) ch).setOnAction((ActionEvent event) -> {
            ((Button) event.getSource()).setText("X");
        });
        }
          
          
          gameView.playAgainBtn.setOnAction((ActionEvent event) -> {
              
              for(Object ch: gameView.gameBoardGP.getChildren()){
                    ((Button) ch).setText("");
              }
          });
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }  
    
    public GameViewBase getGameView(){
        // TODO
        return  gameView;
    }   
    
}
